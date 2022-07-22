package com.biliaryatresia.controller;


import com.biliaryatresia.entity.Doctor;
import com.biliaryatresia.service.DoctorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 医生;(doctor)表控制层
 * @author : yanqishi1
 * @date : 2022-7-11
 */
@Api(tags = "医生对象功能接口")
@RestController
@RequestMapping("/doctor")
public class DoctorController{
    @Autowired
    private DoctorService doctorService;

    /**
     * 通过ID查询单条数据
     *
     * @param docId 主键
     * @return 实例对象
     */
    @ApiOperation("通过ID查询单条数据")
    @GetMapping("{docid}")
    public ResponseEntity<Doctor> queryById(Integer docId){
        return ResponseEntity.ok(doctorService.queryById(docId));
    }

    /**
     * 分页查询
     *
     * @param doctor 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @ApiOperation("分页查询")
    @GetMapping
    public ResponseEntity<Page<Doctor>> paginQuery(Doctor doctor, PageRequest pageRequest){
        return ResponseEntity.ok(doctorService.paginQuery(doctor, pageRequest));
    }

    /**
     * 新增数据
     *
     * @param doctor 实例对象
     * @return 实例对象
     */
    @ApiOperation("新增数据")
    @PostMapping
    public ResponseEntity<Doctor> add(Doctor doctor){
        return ResponseEntity.ok(doctorService.insert(doctor));
    }

    /**
     * 更新数据
     *
     * @param doctor 实例对象
     * @return 实例对象
     */
    @ApiOperation("更新数据")
    @PutMapping
    public ResponseEntity<Doctor> edit(Doctor doctor){
        return ResponseEntity.ok(doctorService.update(doctor));
    }

    /**
     * 通过主键删除数据
     *
     * @param docId 主键
     * @return 是否成功
     */
    @ApiOperation("通过主键删除数据")
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer docId){
        return ResponseEntity.ok(doctorService.deleteById(docId));
    }
}
