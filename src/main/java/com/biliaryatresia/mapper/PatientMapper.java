package com.biliaryatresia.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.biliaryatresia.entity.Patient;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 患者;(patient)表数据库访问层
 * @author : GyberPunk
 * @date : 2022-7-11
 */
@Mapper
public interface PatientMapper  extends BaseMapper<Patient>{
    /**
     * 分页查询指定行数据
     *
     * @param page 分页参数
     * @param wrapper 动态查询条件
     * @return 分页对象列表
     */
    IPage<Patient> selectByPage(IPage<Patient> page , @Param(Constants.WRAPPER) Wrapper<Patient> wrapper);
}
