package com.biliaryatresia.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.biliaryatresia.entity.Dept;
import com.biliaryatresia.service.DeptService;

/**
 * 科室;(dept)表控制层
 * @author : GyberPunk
 * @date : 2022-7-11
 */
@Api(tags = "科室对象功能接口")
@RestController
@RequestMapping("/dept")
public class DeptController{
    @Autowired
    private DeptService deptService;

    /**
     * 通过ID查询单条数据
     *
     * @param deptId 主键
     * @return 实例对象
     */
    @ApiOperation("通过ID查询单条数据")
    @GetMapping("{deptid}")
    public ResponseEntity<Dept> queryById(Integer deptId){
        return ResponseEntity.ok(deptService.queryById(deptId));
    }

    /**
     * 分页查询
     *
     * @param dept 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @ApiOperation("分页查询")
    @GetMapping
    public ResponseEntity<Page<Dept>> paginQuery(Dept dept, PageRequest pageRequest){
        return ResponseEntity.ok(deptService.paginQuery(dept, pageRequest));
    }

    /**
     * 新增数据
     *
     * @param dept 实例对象
     * @return 实例对象
     */
    @ApiOperation("新增数据")
    @PostMapping
    public ResponseEntity<Dept> add(Dept dept){
        return ResponseEntity.ok(deptService.insert(dept));
    }

    /**
     * 更新数据
     *
     * @param dept 实例对象
     * @return 实例对象
     */
    @ApiOperation("更新数据")
    @PutMapping
    public ResponseEntity<Dept> edit(Dept dept){
        return ResponseEntity.ok(deptService.update(dept));
    }

    /**
     * 通过主键删除数据
     *
     * @param deptId 主键
     * @return 是否成功
     */
    @ApiOperation("通过主键删除数据")
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer deptId){
        return ResponseEntity.ok(deptService.deleteById(deptId));
    }
}
