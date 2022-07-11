package com.biliaryatresia.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import com.biliaryatresia.entity.Prescription;

/**
 * 处方;(prescription)表数据库访问层
 * @author : GyberPunk
 * @date : 2022-7-11
 */
@Mapper
public interface PrescriptionMapper{
    /**
     * 通过ID查询单条数据
     *
     * @param preId 主键
     * @return 实例对象
     */
    Prescription queryById(Integer preId);
    /**
     * 分页查询指定行数据
     *
     * @param prescription 查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Prescription> queryAllByLimit(Prescription prescription, @Param("pageable") Pageable pageable);
    /**
     * 统计总行数
     *
     * @param prescription 查询条件
     * @return 总行数
     */
    long count(Prescription prescription);
    /**
     * 新增数据
     *
     * @param prescription 实例对象
     * @return 影响行数
     */
    int insert(Prescription prescription);
    /**
     * 批量新增数据
     *
     * @param entities List<Prescription> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Prescription> entities);
    /**
     * 批量新增或按主键更新数据
     *
     * @param entities List<Prescription> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Prescription> entities);
    /**
     * 更新数据
     *
     * @param prescription 实例对象
     * @return 影响行数
     */
    int update(Prescription prescription);
    /**
     * 通过主键删除数据
     *
     * @param preId 主键
     * @return 影响行数
     */
    int deleteById(Integer preId);
}