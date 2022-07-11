package com.biliaryatresia.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import com.biliaryatresia.entity.Patient;

/**
 * 患者;(patient)表服务接口
 * @author : GyberPunk
 * @date : 2022-7-11
 */
public interface PatientService{
    /**
     * 通过ID查询单条数据
     *
     * @param pId 主键
     * @return 实例对象
     */
    Patient queryById(Integer pId);
    /**
     * 分页查询
     *
     * @param patient 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Patient> paginQuery(Patient patient, PageRequest pageRequest);
    /**
     * 新增数据
     *
     * @param patient 实例对象
     * @return 实例对象
     */
    Patient insert(Patient patient);
    /**
     * 更新数据
     *
     * @param patient 实例对象
     * @return 实例对象
     */
    Patient update(Patient patient);
    /**
     * 通过主键删除数据
     *
     * @param pId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer pId);
}