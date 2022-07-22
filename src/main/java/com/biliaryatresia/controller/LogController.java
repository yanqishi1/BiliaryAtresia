package com.biliaryatresia.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.biliaryatresia.entity.Log;
import com.biliaryatresia.service.LogService;

/**
 * 日志管理;(Log)表控制层
 * @author : yanqishi1
 * @date : 2022-7-11
 */
@Api(tags = "日志管理对象功能接口")
@RestController
@RequestMapping("/log")
public class LogController{
    @Autowired
    private LogService logService;

    /**
     * 通过ID查询单条数据
     *
     * @param logId 主键
     * @return 实例对象
     */
    @ApiOperation("通过ID查询单条数据")
    @GetMapping("{logid}")
    public ResponseEntity<Log> queryById(Integer logId){
        return ResponseEntity.ok(logService.queryById(logId));
    }

    /**
     * 分页查询
     *
     * @param log 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @ApiOperation("分页查询")
    @GetMapping
    public ResponseEntity<Page<Log>> paginQuery(Log log, PageRequest pageRequest){
        return ResponseEntity.ok(logService.paginQuery(log, pageRequest));
    }

    /**
     * 新增数据
     *
     * @param log 实例对象
     * @return 实例对象
     */
    @ApiOperation("新增数据")
    @PostMapping
    public ResponseEntity<Log> add(Log log){
        return ResponseEntity.ok(logService.insert(log));
    }

    /**
     * 更新数据
     *
     * @param log 实例对象
     * @return 实例对象
     */
    @ApiOperation("更新数据")
    @PutMapping
    public ResponseEntity<Log> edit(Log log){
        return ResponseEntity.ok(logService.update(log));
    }

    /**
     * 通过主键删除数据
     *
     * @param logId 主键
     * @return 是否成功
     */
    @ApiOperation("通过主键删除数据")
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer logId){
        return ResponseEntity.ok(logService.deleteById(logId));
    }
}