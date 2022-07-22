package com.biliaryatresia.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import com.biliaryatresia.entity.Fee;

/**
 * 缴费管理;(fee)表数据库访问层
 * @author : yanqishi1
 * @date : 2022-7-11
 */
@Mapper
public interface FeeMapper{
    /**
     * 通过ID查询单条数据
     *
     * @param fId 主键
     * @return 实例对象
     */
    Fee queryById(Integer fId);
    /**
     * 分页查询指定行数据
     *
     * @param fee 查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Fee> queryAllByLimit(Fee fee, @Param("pageable") Pageable pageable);
    /**
     * 统计总行数
     *
     * @param fee 查询条件
     * @return 总行数
     */
    long count(Fee fee);
    /**
     * 新增数据
     *
     * @param fee 实例对象
     * @return 影响行数
     */
    int insert(Fee fee);
    /**
     * 批量新增数据
     *
     * @param entities List<Fee> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Fee> entities);
    /**
     * 批量新增或按主键更新数据
     *
     * @param entities List<Fee> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Fee> entities);
    /**
     * 更新数据
     *
     * @param fee 实例对象
     * @return 影响行数
     */
    int update(Fee fee);
    /**
     * 通过主键删除数据
     *
     * @param fId 主键
     * @return 影响行数
     */
    int deleteById(Integer fId);
}