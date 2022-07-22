package com.biliaryatresia.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.biliaryatresia.entity.Prescription;
import com.biliaryatresia.service.PrescriptionService;

/**
 * 处方;(prescription)表控制层
 * @author : yanqishi1
 * @date : 2022-7-11
 */
@Api(tags = "处方对象功能接口")
@RestController
@RequestMapping("/prescription")
public class PrescriptionController{
    @Autowired
    private PrescriptionService prescriptionService;

    /**
     * 通过ID查询单条数据
     *
     * @param preId 主键
     * @return 实例对象
     */
    @ApiOperation("通过ID查询单条数据")
    @GetMapping("{preid}")
    public ResponseEntity<Prescription> queryById(Integer preId){
        return ResponseEntity.ok(prescriptionService.queryById(preId));
    }

    /**
     * 分页查询
     *
     * @param prescription 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @ApiOperation("分页查询")
    @GetMapping
    public ResponseEntity<Page<Prescription>> paginQuery(Prescription prescription, PageRequest pageRequest){
        return ResponseEntity.ok(prescriptionService.paginQuery(prescription, pageRequest));
    }

    /**
     * 新增数据
     *
     * @param prescription 实例对象
     * @return 实例对象
     */
    @ApiOperation("新增数据")
    @PostMapping
    public ResponseEntity<Prescription> add(Prescription prescription){
        return ResponseEntity.ok(prescriptionService.insert(prescription));
    }

    /**
     * 更新数据
     *
     * @param prescription 实例对象
     * @return 实例对象
     */
    @ApiOperation("更新数据")
    @PutMapping
    public ResponseEntity<Prescription> edit(Prescription prescription){
        return ResponseEntity.ok(prescriptionService.update(prescription));
    }

    /**
     * 通过主键删除数据
     *
     * @param preId 主键
     * @return 是否成功
     */
    @ApiOperation("通过主键删除数据")
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer preId){
        return ResponseEntity.ok(prescriptionService.deleteById(preId));
    }
}