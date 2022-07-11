package com.biliaryatresia.controller;

import java.util.List;

import com.biliaryatresia.entity.Patient;
import com.biliaryatresia.service.PatientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<PageImpl<Patient>> paginQuery(Patient patient, PageRequest pageRequest){
        //1.分页参数
        long current = pageRequest.getPageNumber();
        long size = pageRequest.getPageSize();
        //2.分页查询
        /*把Mybatis的分页对象做封装转换，MP的分页对象上有一些SQL敏感信息，还是通过spring的分页模型来封装数据吧*/
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Patient> pageResult = patientService.paginQuery(patient, current,size);
        //3. 分页结果组装
        List<Patient> dataList = pageResult.getRecords();
        long total = pageResult.getTotal();
        PageImpl<Patient> retPage = new PageImpl<Patient>(dataList,pageRequest,total);
        return ResponseEntity.ok(retPage);
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
