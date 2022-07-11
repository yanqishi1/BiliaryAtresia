package com.biliaryatresia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import com.biliaryatresia.entity.Patient;
import com.biliaryatresia.mapper.PatientMapper;
import com.biliaryatresia.service.PatientService;
/**
 * 患者;(patient)表服务实现类
 * @author : GyberPunk
 * @date : 2022-7-11
 */
@Service
public class PatientServiceImpl implements PatientService{
    @Autowired
    private PatientMapper patientMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param pId 主键
     * @return 实例对象
     */
    public Patient queryById(Integer pId){
        return patientMapper.queryById(pId);
    }

    /**
     * 分页查询
     *
     * @param patient 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    public Page<Patient> paginQuery(Patient patient, PageRequest pageRequest){
        long total = patientMapper.count(patient);
        return new PageImpl<>(patientMapper.queryAllByLimit(patient, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param patient 实例对象
     * @return 实例对象
     */
    public Patient insert(Patient patient){
        patientMapper.insert(patient);
        return patient;
    }

    /**
     * 更新数据
     *
     * @param patient 实例对象
     * @return 实例对象
     */
    public Patient update(Patient patient){
        patientMapper.update(patient);
        return queryById(patient.getPId());
    }

    /**
     * 通过主键删除数据
     *
     * @param pId 主键
     * @return 是否成功
     */
    public boolean deleteById(Integer pId){
        int total = patientMapper.deleteById(pId);
        return total > 0;
    }
}