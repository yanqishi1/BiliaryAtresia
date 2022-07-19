package com.biliaryatresia.service.serviceImpl;

import ai.djl.MalformedModelException;
import ai.djl.Model;
import ai.djl.inference.Predictor;
import ai.djl.modality.Classifications;
import ai.djl.modality.cv.Image;
import ai.djl.modality.cv.ImageFactory;
import ai.djl.modality.cv.util.NDImageUtils;
import ai.djl.ndarray.NDArray;
import ai.djl.ndarray.NDList;
import ai.djl.ndarray.NDManager;
import ai.djl.ndarray.types.Shape;
import ai.djl.translate.Batchifier;
import ai.djl.translate.Translator;
import ai.djl.translate.TranslatorContext;
import com.biliaryatresia.entity.Patient;
import com.biliaryatresia.listener.ApplicationConstants;
import com.biliaryatresia.service.DetectService;
import com.biliaryatresia.util.Msg;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class DetectServiceImpl implements DetectService {

    final String [] results = {"严重异常","异常","可疑","正常","识别出错"};
    final float [] means = {(float) 0.15618113, (float) 0.5503065, (float) 0.27378935};
    final float [] stds = {(float) 0.14181986, (float) 0.19359604, (float) 0.2126395};

    //首先创建一个模型
    Model model = null;
    Translator<Image, Classifications> translator = null;
    @PostConstruct
    public void init(){
        try {
            model = Model.newInstance("CoAtNet");
            model.load(Paths.get("/home/kali/JAVAWEB/BiliaryAtresia/src/main/resources/static/model.pt"));
            translator = new Translator<Image, Classifications>() {
                @Override
                public NDList processInput(TranslatorContext ctx, Image input) {
                    // Convert Image to NDArray
                    NDArray array = input.toNDArray(ctx.getNDManager(), Image.Flag.COLOR);
                    array = NDImageUtils.resize(array, 128);
                    array = ToHLS(ctx.getNDManager(), array);
                    array = NDImageUtils.toTensor(array);
                    array = NDImageUtils.normalize(array, means, stds);
                    return new NDList(array);
                }

                @Override
                public Classifications processOutput(TranslatorContext ctx, NDList list) {
                    // Create a Classifications with the output probabilities
                    NDArray probabilities = list.singletonOrThrow().softmax(0);
                    List<String> classNames = IntStream.range(0, 10).mapToObj(String::valueOf).collect(Collectors.toList());
                    return new Classifications(classNames, probabilities);
                }

                @Override
                public Batchifier getBatchifier() {
                    // The Batchifier describes how to combine a batch together
                    // Stacking, the most common batchifier, takes N [X1, X2, ...] arrays to a single [N, X1, X2, ...] array
                    return Batchifier.STACK;
                }
            };
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (MalformedModelException e) {
            throw new RuntimeException(e);
        }
    }
    public static float[] RGBToHLS(float r, float g, float b)
    {
        float dr = r/255;
        float dg = g/255;
        float db = b/255;
        float cmax = Math.max(dr, Math.max(dg, db));
        float cmin = Math.min(dr, Math.min(dg, db));
        float cdes = cmax - cmin;
        float hh, ll, ss;

        ll = (cmax+cmin)/2;
        if(cdes>0){
            if(ll <= 0.5)
                ss = (cmax-cmin)/(cmax+cmin);
            else
                ss = (cmax-cmin)/(2-cmax-cmin);

            if(cmax == dr)
                hh = (0+(dg-db)/cdes)*60;
            else if(cmax == dg)
                hh = (2+(db-dr)/cdes)*60;
            else// if(cmax == b)
                hh = (4+(dr-dg)/cdes)*60;
            if(hh<0)
                hh+=360;
        }else
            hh = ss = 0;
        hh = Math.round(255*hh/360);
        ll = Math.round(255*ll);
        ss = Math.round(255*ss);

        return new float[]{hh, ll, ss};
    }
    public static NDArray ToHLS(NDManager manager, NDArray array){
        float[] arr = array.toFloatArray();
        Shape shape_ = array.getShape();
        long[] shape = shape_.getShape();
        long w = shape[0];
        long h = shape[1];
        long total = w*h;
        for (int i = 0; i < total; i++) {
            int r = i;
            int g = i+(int)total;
            int b = i+(int)total*2;
            float[] convert = RGBToHLS(arr[r], arr[g], arr[b]);
            arr[r] = convert[0];
            arr[g] = convert[1];
            arr[b] = convert[2];
        }
        try{
            NDArray nd = manager.create(arr);

            return nd.reshape(shape);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public int detect(String path){
        int re = 4;
        try {
            Image img = ImageFactory.getInstance().fromFile(Paths.get(path));
            Predictor<Image, Classifications> predictor = model.newPredictor(translator);
            Classifications predict = predictor.predict(img);
            re = Integer.parseInt(predict.best().getClassName());
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return re;
    }

    @Override
    public Msg detectBA(MultipartFile file, Patient patient) {
        Msg pager = new Msg();
        //检查pid文件夹是否存在
        try {
            String folder = ApplicationConstants.projectPath+"upload"+File.separator+patient.getPId();
            File dir = new File(folder);
            if(!dir.exists()){
                dir.mkdirs();
            }

            String p = folder+ File.separator+file.getOriginalFilename();
            File sf = new File(p);
            file.transferTo(sf);
            //检测
            pager.setCode(200);
            pager.setMsg(results[detect(p)]);
        } catch (IOException e) {
            pager.setCode(500);
            pager.setMsg("File IO Error");
            throw new RuntimeException(e);
        }
        return pager;
    }
}
