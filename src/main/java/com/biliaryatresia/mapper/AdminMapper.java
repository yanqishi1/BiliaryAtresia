package com.biliaryatresia.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import com.biliaryatresia.entity.Admin;

/**
 * 管理员;(Admin)表数据库访问层
 * @author : GyberPunk
 * @date : 2022-7-11
 */
@Mapper
public interface AdminMapper{
    /**
     * 通过ID查询单条数据
     *
     * @param adminId 主键
     * @return 实例对象
     */
    Admin queryById(Integer adminId);
    /**
     * 分页查询指定行数据
     *
     * @param admin 查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Admin> queryAllByLimit(Admin admin, @Param("pageable") Pageable pageable);
    /**
     * 统计总行数
     *
     * @param admin 查询条件
     * @return 总行数
     */
    long count(Admin admin);
    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 影响行数
     */
    int insert(Admin admin);
    /**
     * 批量新增数据
     *
     * @param entities List<Admin> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Admin> entities);
    /**
     * 批量新增或按主键更新数据
     *
     * @param entities List<Admin> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Admin> entities);
    /**
     * 更新数据
     *
     * @param admin 实例对象
     * @return 影响行数
     */
    int update(Admin admin);
    /**
     * 通过主键删除数据
     *
     * @param adminId 主键
     * @return 影响行数
     */
    int deleteById(Integer adminId);
}