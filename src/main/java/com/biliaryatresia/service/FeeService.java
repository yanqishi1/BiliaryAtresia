package com.biliaryatresia.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import com.biliaryatresia.entity.Fee;

/**
 * 缴费管理;(fee)表服务接口
 * @author : yanqishi1
 * @date : 2022-7-11
 */
public interface FeeService{
    /**
     * 通过ID查询单条数据
     *
     * @param fId 主键
     * @return 实例对象
     */
    Fee queryById(Integer fId);
    /**
     * 分页查询
     *
     * @param fee 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Fee> paginQuery(Fee fee, PageRequest pageRequest);
    /**
     * 新增数据
     *
     * @param fee 实例对象
     * @return 实例对象
     */
    Fee insert(Fee fee);
    /**
     * 更新数据
     *
     * @param fee 实例对象
     * @return 实例对象
     */
    Fee update(Fee fee);
    /**
     * 通过主键删除数据
     *
     * @param fId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer fId);
}