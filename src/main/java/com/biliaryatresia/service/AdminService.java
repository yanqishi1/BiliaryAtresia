package com.biliaryatresia.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import com.biliaryatresia.entity.Admin;

/**
 * 管理员;(Admin)表服务接口
 * @author : yanqishi1
 * @date : 2022-7-11
 */
public interface AdminService{
    /**
     * 通过ID查询单条数据
     *
     * @param adminId 主键
     * @return 实例对象
     */
    Admin queryById(Integer adminId);
    /**
     * 分页查询
     *
     * @param admin 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Admin> paginQuery(Admin admin, PageRequest pageRequest);
    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    Admin insert(Admin admin);
    /**
     * 更新数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    Admin update(Admin admin);
    /**
     * 通过主键删除数据
     *
     * @param adminId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer adminId);
}