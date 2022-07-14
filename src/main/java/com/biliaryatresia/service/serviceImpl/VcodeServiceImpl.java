package com.biliaryatresia.service.serviceImpl;


import com.biliaryatresia.listener.ApplicationConstants;
import com.biliaryatresia.service.VcodeService;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;


import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

@Service("vcodeService")
public class VcodeServiceImpl implements VcodeService {


    /**
     * 读取配置文件
     * @return 配置文件内容
     */
    public Properties getProperties(String filepath) {
        Properties properties = new Properties();
        try {
            //获取文件路径
            String path = this.getClass().getResource(filepath).toURI().getPath();
            //加载属性文件
            properties.load(new FileInputStream(new File(path)));
            //将属性文件中的键值对儿打印到控制台
            properties.list(System.out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return properties;
    }

    /**
     * 读取信息模板
     * @param path 模板路径
     * @return 消息字符串
     * @throws Exception
     */
    public String getMessage(String path) throws Exception{
        //定义一个file对象，用来初始化FileReader
//        String filepath = this.getClass().getResource(path).toURI().getPath();
        System.out.println(path);
        File file = new File(path);
        //定义一个fileReader对象，用来初始化BufferedReader
        FileReader reader = new FileReader(file);
        //new一个BufferedReader对象，将文件内容读取到缓存
        BufferedReader bReader = new BufferedReader(reader);
        //定义一个字符串缓存，将字符串存放缓存中
        StringBuilder sb = new StringBuilder();

        String s = "";
        //逐行读取文件内容，不读取换行符和末尾的空格
        while ((s =bReader.readLine()) != null) {
            //将读取的字符串添加换行符后累加存放在缓存中
            sb.append(s + "\n");
            System.out.println(s);
        }

        bReader.close();
        return sb.toString();
    }


    @Override
    public Boolean sendMail(String addredss,String code){
        try {
            Properties account = getProperties("/config/account.properties");

            //创建定义整个应用程序所需的环境信息的 Session 对象
            Session session = Session.getInstance(account);

            //设置调试信息在控制台打印出来
            session.setDebug(true);

            //创建一封邮件的实例对象
            MimeMessage msg = new MimeMessage(session);
            //设置发件人地址
            msg.setFrom(new InternetAddress((String)account.getProperty("senderAddress")));

            /**
             * 设置收件人地址（可以增加多个收件人、抄送、密送），即下面这一行代码书写多行
             * MimeMessage.RecipientType.TO:发送
             * MimeMessage.RecipientType.CC：抄送
             * MimeMessage.RecipientType.BCC：密送
             */
            msg.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(addredss));

            //设置邮件主题
            msg.setSubject("速录云数据账号验证","UTF-8");

            //设置邮件正文
            String model = getMessage(ApplicationConstants.projectPath+"view/email.html");
            Document doc = Jsoup.parse(model);
            Element strong = doc.getElementById("message");
            strong.append(code);

            msg.setContent(doc.toString(), "text/html;charset=utf-8");

            //设置邮件的发送时间,默认立即发送
            msg.setSentDate(new Date());

            //根据session对象获取邮件传输对象Transport
            Transport transport = session.getTransport();
            //设置发件人的账户名和密码
            transport.connect((String)account.getProperty("senderAccount"),(String)account.getProperty("senderPassword"));

            //发送邮件，并发送到所有收件人地址，message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
            transport.sendMessage(msg,msg.getAllRecipients());

            //5、关闭邮件连接
            transport.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        VcodeServiceImpl service = new VcodeServiceImpl();
        service.sendMail("1004623577@qq.com","1234");
    }



    @Override
    public Boolean sendPhoneMessage(String tel,String code){
        try {
            String content = "速录云数据验证码:"+code;

            HttpClient client = new HttpClient();
            PostMethod post = new PostMethod("http://utf8.api.smschinese.cn");
            post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");
            NameValuePair[] data ={ new NameValuePair("Uid", "yanqishi1"),new NameValuePair("Key", "d41d8cd98f00b204e980"),new NameValuePair("smsMob",tel),new NameValuePair("smsText",content)};
            post.setRequestBody(data);

            client.executeMethod(post);
            Header[] headers = post.getResponseHeaders();
            int statusCode = post.getStatusCode();
            System.out.println("statusCode:"+statusCode);
            for(Header h : headers)
            {
                System.out.println(h.toString());
            }
            String result = new String(post.getResponseBodyAsString().getBytes("utf-8"));
            System.out.println(result);

            post.releaseConnection();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 检查验证码是否正确
     * @param vcode 服务器中的验证码
     * @param checkcode 前端传过来的验证码
     * @return
     */
    @Override
    public Integer  check(String vcode,String checkcode){
        if(vcode.equals(checkcode)){
            return 0;
        }else{
            return 1;
        }
    }


    public final char[] CHARS = {'2','3','4','5','6','7','8',
            '9','A','B','C','D','E','F','G','H','J','K','L','M','N','P',
            'Q','R','S','T','U','V','W','X','Y','Z'};

    public static Random random = new Random();

    //验证码的长度
    public int codeLength = 4;

    /**
     * 得到一个随机字符串
     */
    @Override
    public String getRandomString(){
        StringBuffer buffer = new StringBuffer();
        for(int i=0;i<codeLength;++i){
            buffer.append(CHARS[random.nextInt(CHARS.length)]);
        }
        return buffer.toString();
    }

    /**
     * 返回一个随机颜色
     * @return
     */
    public Color getRandomColor(){
        return new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
    }

    /*
    返回一个颜色的反色
     */
    public Color getReverseColor(Color c){
        return new Color(255-c.getRed(),255-c.getGreen(),255-c.getBlue());
    }


    @Override
    public  BufferedImage getImage(String randomString){
        //图片的长宽
        int width = 100;
        int height = 30;

        Color color = getRandomColor();
        Color reverse = getReverseColor(color);

        //创建一个彩色图片
        BufferedImage bi = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //获取绘图对象
        Graphics2D g = bi.createGraphics();
        //设置字体
        g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));


        g.setColor(color);
        g.fillRect(0,0,width,height);
        g.setColor(reverse);
        g.drawString(randomString,18,20);

        //创建干扰像素点
        int n =random.nextInt(100);
        for(int i=0;i<n;++i){
            g.drawRect(random.nextInt(width),random.nextInt(height),1,1);
        }

        return bi;
    }

}

