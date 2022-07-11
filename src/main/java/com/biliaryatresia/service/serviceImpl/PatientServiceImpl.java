package com.biliaryatresia.service.serviceImpl;

import cn.hutool.core.util.StrUtil;
import com.biliaryatresia.entity.Patient;
import com.biliaryatresia.mapper.PatientMapper;
import com.biliaryatresia.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
/**
 * 患者;(patient)表服务实现类
 * @author : GyberPunk
 * @date : 2022-7-11
 */
@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientMapper patientMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param pId 主键
     * @return 实例对象
     */
    public Patient queryById(Integer pId){
        return patientMapper.selectById(pId);
    }

    /**
     * 分页查询
     *
     * @param patient 筛选条件
     * @param current 当前页码
     * @param size  每页大小
     * @return
     */
    public Page<Patient> paginQuery(Patient patient, long current, long size){
        //1. 构建动态查询条件
        LambdaQueryWrapper<Patient> queryWrapper = new LambdaQueryWrapper<>();
        if(StrUtil.isNotBlank(patient.getPName())){
            queryWrapper.eq(Patient::getPName, patient.getPName());
        }
        if(StrUtil.isNotBlank(patient.getPPassword())){
            queryWrapper.eq(Patient::getPPassword, patient.getPPassword());
        }
        if(StrUtil.isNotBlank(patient.getPTel())){
            queryWrapper.eq(Patient::getPTel, patient.getPTel());
        }
        if(StrUtil.isNotBlank(patient.getPWechat())){
            queryWrapper.eq(Patient::getPWechat, patient.getPWechat());
        }
        if(StrUtil.isNotBlank(patient.getPBirthday())){
            queryWrapper.eq(Patient::getPBirthday, patient.getPBirthday());
        }
        if(StrUtil.isNotBlank(patient.getPGender())){
            queryWrapper.eq(Patient::getPGender, patient.getPGender());
        }
        if(StrUtil.isNotBlank(patient.getPEat())){
            queryWrapper.eq(Patient::getPEat, patient.getPEat());
        }
        //2. 执行分页查询
        Page<Patient> pagin = new Page<>(current , size , true);
        IPage<Patient> selectResult = patientMapper.selectByPage(pagin , queryWrapper);
        pagin.setPages(selectResult.getPages());
        pagin.setTotal(selectResult.getTotal());
        pagin.setRecords(selectResult.getRecords());
        //3. 返回结果
        return pagin;
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
        //1. 根据条件动态更新
        LambdaUpdateChainWrapper<Patient> chainWrapper = new LambdaUpdateChainWrapper<Patient>(patientMapper);
        if(StrUtil.isNotBlank(patient.getPName())){
            chainWrapper.eq(Patient::getPName, patient.getPName());
        }
        if(StrUtil.isNotBlank(patient.getPPassword())){
            chainWrapper.eq(Patient::getPPassword, patient.getPPassword());
        }
        if(StrUtil.isNotBlank(patient.getPTel())){
            chainWrapper.eq(Patient::getPTel, patient.getPTel());
        }
        if(StrUtil.isNotBlank(patient.getPWechat())){
            chainWrapper.eq(Patient::getPWechat, patient.getPWechat());
        }
        if(StrUtil.isNotBlank(patient.getPBirthday())){
            chainWrapper.eq(Patient::getPBirthday, patient.getPBirthday());
        }
        if(StrUtil.isNotBlank(patient.getPGender())){
            chainWrapper.eq(Patient::getPGender, patient.getPGender());
        }
        if(StrUtil.isNotBlank(patient.getPEat())){
            chainWrapper.eq(Patient::getPEat, patient.getPEat());
        }
        //2. 设置主键，并更新
        chainWrapper.set(Patient::getPId, patient.getPId());
        boolean ret = chainWrapper.update();
        //3. 更新成功了，查询最最对象返回
        if(ret){
            return queryById(patient.getPId());
        }else{
            return patient;
        }
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
