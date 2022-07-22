package com.biliaryatresia.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.biliaryatresia.entity.Admin;
import com.biliaryatresia.service.AdminService;

/**
 * 管理员;(Admin)表控制层
 * @author : yanqishi1
 * @date : 2022-7-11
 */
@Api(tags = "管理员对象功能接口")
@RestController
@RequestMapping("/admin")
public class AdminController{
    @Autowired
    private AdminService adminService;

    /**
     * 通过ID查询单条数据
     *
     * @param adminId 主键
     * @return 实例对象
     */
    @ApiOperation("通过ID查询单条数据")
    @GetMapping("{adminid}")
    public ResponseEntity<Admin> queryById(Integer adminId){
        return ResponseEntity.ok(adminService.queryById(adminId));
    }

    /**
     * 分页查询
     *
     * @param admin 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @ApiOperation("分页查询")
    @GetMapping
    public ResponseEntity<Page<Admin>> paginQuery(Admin admin, PageRequest pageRequest){
        return ResponseEntity.ok(adminService.paginQuery(admin, pageRequest));
    }

    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    @ApiOperation("新增数据")
    @PostMapping
    public ResponseEntity<Admin> add(Admin admin){
        return ResponseEntity.ok(adminService.insert(admin));
    }

    /**
     * 更新数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    @ApiOperation("更新数据")
    @PutMapping
    public ResponseEntity<Admin> edit(Admin admin){
        return ResponseEntity.ok(adminService.update(admin));
    }

    /**
     * 通过主键删除数据
     *
     * @param adminId 主键
     * @return 是否成功
     */
    @ApiOperation("通过主键删除数据")
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer adminId){
        return ResponseEntity.ok(adminService.deleteById(adminId));
    }
}