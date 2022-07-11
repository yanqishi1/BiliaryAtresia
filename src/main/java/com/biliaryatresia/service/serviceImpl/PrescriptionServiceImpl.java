package com.biliaryatresia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import com.biliaryatresia.entity.Prescription;
import com.biliaryatresia.mapper.PrescriptionMapper;
import com.biliaryatresia.service.PrescriptionService;
/**
 * 处方;(prescription)表服务实现类
 * @author : GyberPunk
 * @date : 2022-7-11
 */
@Service
public class PrescriptionServiceImpl implements PrescriptionService{
    @Autowired
    private PrescriptionMapper prescriptionMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param preId 主键
     * @return 实例对象
     */
    public Prescription queryById(Integer preId){
        return prescriptionMapper.queryById(preId);
    }

    /**
     * 分页查询
     *
     * @param prescription 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    public Page<Prescription> paginQuery(Prescription prescription, PageRequest pageRequest){
        long total = prescriptionMapper.count(prescription);
        return new PageImpl<>(prescriptionMapper.queryAllByLimit(prescription, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param prescription 实例对象
     * @return 实例对象
     */
    public Prescription insert(Prescription prescription){
        prescriptionMapper.insert(prescription);
        return prescription;
    }

    /**
     * 更新数据
     *
     * @param prescription 实例对象
     * @return 实例对象
     */
    public Prescription update(Prescription prescription){
        prescriptionMapper.update(prescription);
        return queryById(prescription.getPreId());
    }

    /**
     * 通过主键删除数据
     *
     * @param preId 主键
     * @return 是否成功
     */
    public boolean deleteById(Integer preId){
        int total = prescriptionMapper.deleteById(preId);
        return total > 0;
    }
}