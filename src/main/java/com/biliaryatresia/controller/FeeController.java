package com.biliaryatresia.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.biliaryatresia.entity.Fee;
import com.biliaryatresia.service.FeeService;

/**
 * 缴费管理;(fee)表控制层
 * @author : yanqishi1
 * @date : 2022-7-11
 */
@Api(tags = "缴费管理对象功能接口")
@RestController
@RequestMapping("/fee")
public class FeeController{
    @Autowired
    private FeeService feeService;

    /**
     * 通过ID查询单条数据
     *
     * @param fId 主键
     * @return 实例对象
     */
    @ApiOperation("通过ID查询单条数据")
    @GetMapping("{fid}")
    public ResponseEntity<Fee> queryById(Integer fId){
        return ResponseEntity.ok(feeService.queryById(fId));
    }

    /**
     * 分页查询
     *
     * @param fee 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @ApiOperation("分页查询")
    @GetMapping
    public ResponseEntity<Page<Fee>> paginQuery(Fee fee, PageRequest pageRequest){
        return ResponseEntity.ok(feeService.paginQuery(fee, pageRequest));
    }

    /**
     * 新增数据
     *
     * @param fee 实例对象
     * @return 实例对象
     */
    @ApiOperation("新增数据")
    @PostMapping
    public ResponseEntity<Fee> add(Fee fee){
        return ResponseEntity.ok(feeService.insert(fee));
    }

    /**
     * 更新数据
     *
     * @param fee 实例对象
     * @return 实例对象
     */
    @ApiOperation("更新数据")
    @PutMapping
    public ResponseEntity<Fee> edit(Fee fee){
        return ResponseEntity.ok(feeService.update(fee));
    }

    /**
     * 通过主键删除数据
     *
     * @param fId 主键
     * @return 是否成功
     */
    @ApiOperation("通过主键删除数据")
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer fId){
        return ResponseEntity.ok(feeService.deleteById(fId));
    }
}