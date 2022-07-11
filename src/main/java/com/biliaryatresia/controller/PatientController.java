package com.biliaryatresia.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.biliaryatresia.entity.Patient;
import com.biliaryatresia.service.PatientService;

/**
 * 患者;(patient)表控制层
 * @author : GyberPunk
 * @date : 2022-7-11
 */
@Api(tags = "患者对象功能接口")
@RestController
@RequestMapping("/patient")
public class PatientController{
    @Autowired
    private PatientService patientService;

    /**
     * 通过ID查询单条数据
     *
     * @param pId 主键
     * @return 实例对象
     */
    @ApiOperation("通过ID查询单条数据")
    @GetMapping("{pid}")
    public ResponseEntity<Patient> queryById(Integer pId){
        return ResponseEntity.ok(patientService.queryById(pId));
    }

    /**
     * 分页查询
     *
     * @param patient 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @ApiOperation("分页查询")
    @GetMapping
    public ResponseEntity<Page<Patient>> paginQuery(Patient patient, PageRequest pageRequest){
        return ResponseEntity.ok(patientService.paginQuery(patient, pageRequest));
    }

    /**
     * 新增数据
     *
     * @param patient 实例对象
     * @return 实例对象
     */
    @ApiOperation("新增数据")
    @PostMapping
    public ResponseEntity<Patient> add(Patient patient){
        return ResponseEntity.ok(patientService.insert(patient));
    }

    /**
     * 更新数据
     *
     * @param patient 实例对象
     * @return 实例对象
     */
    @ApiOperation("更新数据")
    @PutMapping
    public ResponseEntity<Patient> edit(Patient patient){
        return ResponseEntity.ok(patientService.update(patient));
    }

    /**
     * 通过主键删除数据
     *
     * @param pId 主键
     * @return 是否成功
     */
    @ApiOperation("通过主键删除数据")
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer pId){
        return ResponseEntity.ok(patientService.deleteById(pId));
    }
}