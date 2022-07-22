package com.biliaryatresia.mapper;


import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import com.biliaryatresia.entity.Dept;

/**
 * 科室;(dept)表数据库访问层
 * @author : yanqishi1
 * @date : 2022-7-11
 */
@Mapper
public interface DeptMapper{
    /**
     * 通过ID查询单条数据
     *
     * @param deptId 主键
     * @return 实例对象
     */
    Dept queryById(Integer deptId);
    /**
     * 分页查询指定行数据
     *
     * @param dept 查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Dept> queryAllByLimit(Dept dept, @Param("pageable") Pageable pageable);
    /**
     * 统计总行数
     *
     * @param dept 查询条件
     * @return 总行数
     */
    long count(Dept dept);
    /**
     * 新增数据
     *
     * @param dept 实例对象
     * @return 影响行数
     */
    int insert(Dept dept);
    /**
     * 批量新增数据
     *
     * @param entities List<Dept> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Dept> entities);
    /**
     * 批量新增或按主键更新数据
     *
     * @param entities List<Dept> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Dept> entities);
    /**
     * 更新数据
     *
     * @param dept 实例对象
     * @return 影响行数
     */
    int update(Dept dept);
    /**
     * 通过主键删除数据
     *
     * @param deptId 主键
     * @return 影响行数
     */
    int deleteById(Integer deptId);
}
