package com.biliaryatresia.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import com.biliaryatresia.entity.Dept;
import com.biliaryatresia.mapper.DeptMapper;
import com.biliaryatresia.service.DeptService;
/**
 * 科室;(dept)表服务实现类
 * @author : GyberPunk
 * @date : 2022-7-11
 */
@Service
public class DeptServiceImpl implements DeptService{
    @Autowired
    private DeptMapper deptMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param deptId 主键
     * @return 实例对象
     */
    public Dept queryById(Integer deptId){
        return deptMapper.queryById(deptId);
    }

    /**
     * 分页查询
     *
     * @param dept 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    public Page<Dept> paginQuery(Dept dept, PageRequest pageRequest){
        long total = deptMapper.count(dept);
        return new PageImpl<>(deptMapper.queryAllByLimit(dept, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param dept 实例对象
     * @return 实例对象
     */
    public Dept insert(Dept dept){
        deptMapper.insert(dept);
        return dept;
    }

    /**
     * 更新数据
     *
     * @param dept 实例对象
     * @return 实例对象
     */
    public Dept update(Dept dept){
        deptMapper.update(dept);
        return queryById(dept.getDeptId());
    }

    /**
     * 通过主键删除数据
     *
     * @param deptId 主键
     * @return 是否成功
     */
    public boolean deleteById(Integer deptId){
        int total = deptMapper.deleteById(deptId);
        return total > 0;
    }
}
