package com.biliaryatresia.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
     * @param current 当前页码
     * @param size  每页大小
     * @return
     */
    Page<Patient> paginQuery(Patient patient, long current, long size);
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
