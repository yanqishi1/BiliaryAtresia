package com.biliaryatresia.service;

import com.biliaryatresia.entity.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


/**
 * 医生;(doctor)表服务接口
 * @author : GyberPunk
 * @date : 2022-7-11
 */
public interface DoctorService{
    /**
     * 通过ID查询单条数据
     *
     * @param docId 主键
     * @return 实例对象
     */
    Doctor queryById(Integer docId);
    /**
     * 分页查询
     *
     * @param doctor 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Doctor> paginQuery(Doctor doctor, PageRequest pageRequest);
    /**
     * 新增数据
     *
     * @param doctor 实例对象
     * @return 实例对象
     */
    Doctor insert(Doctor doctor);
    /**
     * 更新数据
     *
     * @param doctor 实例对象
     * @return 实例对象
     */
    Doctor update(Doctor doctor);
    /**
     * 通过主键删除数据
     *
     * @param docId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer docId);
}
