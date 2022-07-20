package com.biliaryatresia.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.biliaryatresia.entity.ImageLog;
import com.biliaryatresia.service.ImageService;

/**
 * 上传图片;(image)表控制层
 * @author : GyberPunk
 * @date : 2022-7-11
 */
@Api(tags = "上传图片对象功能接口")
@RestController
@RequestMapping("/image")
public class ImageController{
    @Autowired
    private ImageService imageService;

    /**
     * 通过ID查询单条数据
     *
     * @param imgId 主键
     * @return 实例对象
     */
    @ApiOperation("通过ID查询单条数据")
    @GetMapping("{imgid}")
    public ResponseEntity<ImageLog> queryById(Integer imgId){
        return ResponseEntity.ok(imageService.queryById(imgId));
    }

    /**
     * 分页查询
     *
     * @param image 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @ApiOperation("分页查询")
    @GetMapping
    public ResponseEntity<Page<ImageLog>> paginQuery(ImageLog image, PageRequest pageRequest){
        return ResponseEntity.ok(imageService.paginQuery(image, pageRequest));
    }

    /**
     * 新增数据
     *
     * @param image 实例对象
     * @return 实例对象
     */
    @ApiOperation("新增数据")
    @PostMapping
    public ResponseEntity<ImageLog> add(ImageLog image){
        return ResponseEntity.ok(imageService.insert(image));
    }

    /**
     * 更新数据
     *
     * @param image 实例对象
     * @return 实例对象
     */
    @ApiOperation("更新数据")
    @PutMapping
    public ResponseEntity<ImageLog> edit(ImageLog image){
        return ResponseEntity.ok(imageService.update(image));
    }

    /**
     * 通过主键删除数据
     *
     * @param imgId 主键
     * @return 是否成功
     */
    @ApiOperation("通过主键删除数据")
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer imgId){
        return ResponseEntity.ok(imageService.deleteById(imgId));
    }
}