package com.biliaryatresia.mapper;

import java.util.Date;
import java.util.List;

import com.biliaryatresia.entity.Appointment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

/**
 * 挂号查询;(appointment)表数据库访问层
 * @author : GyberPunk
 * @date : 2022-7-18
 */
@Mapper
public interface AppointmentMapper{
    /**
     * 通过ID查询单条数据
     *
     * @param aId 主键
     * @return 实例对象
     */
    Appointment queryById(Integer aId);
    /**
     * 分页查询指定行数据
     *
     * @param appointment 查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Appointment> queryAllByLimit(Appointment appointment, @Param("pageable") Pageable pageable);
    /**
     * 统计总行数
     *
     * @param appointment 查询条件
     * @return 总行数
     */
    long count(Appointment appointment);
    /**
     * 新增数据
     *
     * @param appointment 实例对象
     * @return 影响行数
     */
    int insert(Appointment appointment);
    /**
     * 批量新增数据
     *
     * @param entities List<Appointment> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Appointment> entities);
    /**
     * 批量新增或按主键更新数据
     *
     * @param entities List<Appointment> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Appointment> entities);
    /**
     * 更新数据
     *
     * @param appointment 实例对象
     * @return 影响行数
     */
    int update(Appointment appointment);
    /**
     * 通过主键删除数据
     *
     * @param aId 主键
     * @return 影响行数
     */
    int deleteById(Integer aId);

    List<Appointment> queryByDate(String start);

    Appointment queryByDocDate(Integer doctorId, String date);
}
