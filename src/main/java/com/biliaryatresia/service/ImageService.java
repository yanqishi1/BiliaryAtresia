package com.biliaryatresia.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import com.biliaryatresia.entity.Image;

/**
 * 上传图片;(image)表服务接口
 * @author : GyberPunk
 * @date : 2022-7-11
 */
public interface ImageService{
    /**
     * 通过ID查询单条数据
     *
     * @param imgId 主键
     * @return 实例对象
     */
    Image queryById(Integer imgId);
    /**
     * 分页查询
     *
     * @param image 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Image> paginQuery(Image image, PageRequest pageRequest);
    /**
     * 新增数据
     *
     * @param image 实例对象
     * @return 实例对象
     */
    Image insert(Image image);
    /**
     * 更新数据
     *
     * @param image 实例对象
     * @return 实例对象
     */
    Image update(Image image);
    /**
     * 通过主键删除数据
     *
     * @param imgId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer imgId);
}