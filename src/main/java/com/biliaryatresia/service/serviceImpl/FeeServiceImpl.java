package com.biliaryatresia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import com.biliaryatresia.entity.Fee;
import com.biliaryatresia.mapper.FeeMapper;
import com.biliaryatresia.service.FeeService;
/**
 * 缴费管理;(fee)表服务实现类
 * @author : GyberPunk
 * @date : 2022-7-11
 */
@Service
public class FeeServiceImpl implements FeeService{
    @Autowired
    private FeeMapper feeMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param fId 主键
     * @return 实例对象
     */
    public Fee queryById(Integer fId){
        return feeMapper.queryById(fId);
    }

    /**
     * 分页查询
     *
     * @param fee 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    public Page<Fee> paginQuery(Fee fee, PageRequest pageRequest){
        long total = feeMapper.count(fee);
        return new PageImpl<>(feeMapper.queryAllByLimit(fee, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param fee 实例对象
     * @return 实例对象
     */
    public Fee insert(Fee fee){
        feeMapper.insert(fee);
        return fee;
    }

    /**
     * 更新数据
     *
     * @param fee 实例对象
     * @return 实例对象
     */
    public Fee update(Fee fee){
        feeMapper.update(fee);
        return queryById(fee.getFId());
    }

    /**
     * 通过主键删除数据
     *
     * @param fId 主键
     * @return 是否成功
     */
    public boolean deleteById(Integer fId){
        int total = feeMapper.deleteById(fId);
        return total > 0;
    }
}