package com.biliaryatresia.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import com.biliaryatresia.entity.Prescription;

/**
 * 处方;(prescription)表服务接口
 * @author : GyberPunk
 * @date : 2022-7-11
 */
public interface PrescriptionService{
    /**
     * 通过ID查询单条数据
     *
     * @param preId 主键
     * @return 实例对象
     */
    Prescription queryById(Integer preId);
    /**
     * 分页查询
     *
     * @param prescription 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Prescription> paginQuery(Prescription prescription, PageRequest pageRequest);
    /**
     * 新增数据
     *
     * @param prescription 实例对象
     * @return 实例对象
     */
    Prescription insert(Prescription prescription);
    /**
     * 更新数据
     *
     * @param prescription 实例对象
     * @return 实例对象
     */
    Prescription update(Prescription prescription);
    /**
     * 通过主键删除数据
     *
     * @param preId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer preId);
}