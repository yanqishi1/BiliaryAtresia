package com.biliaryatresia.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import com.biliaryatresia.entity.Dept;

/**
 * 科室;(dept)表服务接口
 * @author : yanqishi1
 * @date : 2022-7-11
 */
public interface DeptService{
    /**
     * 通过ID查询单条数据
     *
     * @param deptId 主键
     * @return 实例对象
     */
    Dept queryById(Integer deptId);
    /**
     * 分页查询
     *
     * @param dept 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Dept> paginQuery(Dept dept, PageRequest pageRequest);
    /**
     * 新增数据
     *
     * @param dept 实例对象
     * @return 实例对象
     */
    Dept insert(Dept dept);
    /**
     * 更新数据
     *
     * @param dept 实例对象
     * @return 实例对象
     */
    Dept update(Dept dept);
    /**
     * 通过主键删除数据
     *
     * @param deptId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer deptId);
}