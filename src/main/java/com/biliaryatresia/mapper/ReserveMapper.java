package com.biliaryatresia.mapper;

import java.util.List;
import com.biliaryatresia.entity.Reserve;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

/**
 * 挂号;(reserve)表数据库访问层
 * @author : GyberPunk
 * @date : 2022-7-11
 */
@Mapper
public interface ReserveMapper{
    /**
     * 通过ID查询单条数据
     *
     * @param rId 主键
     * @return 实例对象
     */
    Reserve queryById(Integer rId);
    /**
     * 分页查询指定行数据
     *
     * @param reserve 查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Reserve> queryAllByLimit(Reserve reserve, @Param("pageable") Pageable pageable);
    /**
     * 统计总行数
     *
     * @param reserve 查询条件
     * @return 总行数
     */
    long count(Reserve reserve);
    /**
     * 新增数据
     *
     * @param reserve 实例对象
     * @return 影响行数
     */
    int insert(Reserve reserve);
    /**
     * 批量新增数据
     *
     * @param entities List<Reserve> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Reserve> entities);
    /**
     * 批量新增或按主键更新数据
     *
     * @param entities List<Reserve> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Reserve> entities);
    /**
     * 更新数据
     *
     * @param reserve 实例对象
     * @return 影响行数
     */
    int update(Reserve reserve);
    /**
     * 通过主键删除数据
     *
     * @param rId 主键
     * @return 影响行数
     */
    int deleteById(Integer rId);

    /**
     * 创建预约
     * @param reserve
     */
    void create(Reserve reserve);
}
