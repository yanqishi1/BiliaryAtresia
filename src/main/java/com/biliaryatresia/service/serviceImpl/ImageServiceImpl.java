package com.biliaryatresia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import com.biliaryatresia.entity.ImageLog;
import com.biliaryatresia.mapper.ImageLogMapper;
import com.biliaryatresia.service.ImageService;
/**
 * 上传图片;(image)表服务实现类
 * @author : yanqishi1
 * @date : 2022-7-11
 */
@Service
public class ImageServiceImpl implements ImageService{
    @Autowired
    private ImageLogMapper imageMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param imgId 主键
     * @return 实例对象
     */
    public ImageLog queryById(Integer imgId){
        return imageMapper.queryById(imgId);
    }

    /**
     * 分页查询
     *
     * @param image 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    public Page<ImageLog> paginQuery(ImageLog image, PageRequest pageRequest){
        long total = imageMapper.count(image);
        return new PageImpl<>(imageMapper.queryAllByLimit(image, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param image 实例对象
     * @return 实例对象
     */
    public ImageLog insert(ImageLog image){
        imageMapper.insert(image);
        return image;
    }

    /**
     * 更新数据
     *
     * @param image 实例对象
     * @return 实例对象
     */
    public ImageLog update(ImageLog image){
        imageMapper.update(image);
        return queryById(image.getImgId());
    }

    /**
     * 通过主键删除数据
     *
     * @param imgId 主键
     * @return 是否成功
     */
    public boolean deleteById(Integer imgId){
        int total = imageMapper.deleteById(imgId);
        return total > 0;
    }
}