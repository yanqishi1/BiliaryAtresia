package com.biliaryatresia.controller;


import com.biliaryatresia.entity.Reserve;
import com.biliaryatresia.service.ReserveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 挂号;(reserve)表控制层
 * @author : GyberPunk
 * @date : 2022-7-11
 */
@Api(tags = "挂号对象功能接口")
@RestController
@RequestMapping("/reserve")
public class ReserveController{
    @Autowired
    private ReserveService reserveService;

    /**
     * 通过ID查询单条数据
     *
     * @param rId 主键
     * @return 实例对象
     */
    @ApiOperation("通过ID查询单条数据")
    @GetMapping("{rid}")
    public ResponseEntity<Reserve> queryById(Integer rId){
        return ResponseEntity.ok(reserveService.queryById(rId));
    }

    /**
     * 分页查询
     *
     * @param reserve 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @ApiOperation("分页查询")
    @GetMapping
    public ResponseEntity<Page<Reserve>> paginQuery(Reserve reserve, PageRequest pageRequest){
        return ResponseEntity.ok(reserveService.paginQuery(reserve, pageRequest));
    }

    /**
     * 新增数据
     *
     * @param reserve 实例对象
     * @return 实例对象
     */
    @ApiOperation("新增数据")
    @PostMapping
    public ResponseEntity<Reserve> add(Reserve reserve){
        return ResponseEntity.ok(reserveService.insert(reserve));
    }

    /**
     * 更新数据
     *
     * @param reserve 实例对象
     * @return 实例对象
     */
    @ApiOperation("更新数据")
    @PutMapping
    public ResponseEntity<Reserve> edit(Reserve reserve){
        return ResponseEntity.ok(reserveService.update(reserve));
    }

    /**
     * 通过主键删除数据
     *
     * @param rId 主键
     * @return 是否成功
     */
    @ApiOperation("通过主键删除数据")
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer rId){
        return ResponseEntity.ok(reserveService.deleteById(rId));
    }
}
