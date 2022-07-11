package com.biliaryatresia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import com.biliaryatresia.entity.Image;
import com.biliaryatresia.mapper.ImageMapper;
import com.biliaryatresia.service.ImageService;
/**
 * 上传图片;(image)表服务实现类
 * @author : GyberPunk
 * @date : 2022-7-11
 */
@Service
public class ImageServiceImpl implements ImageService{
    @Autowired
    private ImageMapper imageMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param imgId 主键
     * @return 实例对象
     */
    public Image queryById(Integer imgId){
        return imageMapper.queryById(imgId);
    }

    /**
     * 分页查询
     *
     * @param image 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    public Page<Image> paginQuery(Image image, PageRequest pageRequest){
        long total = imageMapper.count(image);
        return new PageImpl<>(imageMapper.queryAllByLimit(image, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param image 实例对象
     * @return 实例对象
     */
    public Image insert(Image image){
        imageMapper.insert(image);
        return image;
    }

    /**
     * 更新数据
     *
     * @param image 实例对象
     * @return 实例对象
     */
    public Image update(Image image){
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