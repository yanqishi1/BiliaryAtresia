package com.biliaryatresia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import com.biliaryatresia.entity.Admin;
import com.biliaryatresia.mapper.AdminMapper;
import com.biliaryatresia.service.AdminService;
/**
 * 管理员;(Admin)表服务实现类
 * @author : yanqishi1
 * @date : 2022-7-11
 */
@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminMapper adminMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param adminId 主键
     * @return 实例对象
     */
    public Admin queryById(Integer adminId){
        return adminMapper.queryById(adminId);
    }

    /**
     * 分页查询
     *
     * @param admin 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    public Page<Admin> paginQuery(Admin admin, PageRequest pageRequest){
        long total = adminMapper.count(admin);
        return new PageImpl<>(adminMapper.queryAllByLimit(admin, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    public Admin insert(Admin admin){
        adminMapper.insert(admin);
        return admin;
    }

    /**
     * 更新数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    public Admin update(Admin admin){
        adminMapper.update(admin);
        return queryById(admin.getAdminId());
    }

    /**
     * 通过主键删除数据
     *
     * @param adminId 主键
     * @return 是否成功
     */
    public boolean deleteById(Integer adminId){
        int total = adminMapper.deleteById(adminId);
        return total > 0;
    }
}