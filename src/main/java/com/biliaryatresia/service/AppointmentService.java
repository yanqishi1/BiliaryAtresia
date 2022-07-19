package com.biliaryatresia.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import com.biliaryatresia.entity.Appointment;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * 挂号查询;(appointment)表服务接口
 * @author : GyberPunk
 * @date : 2022-7-18
 */
public interface AppointmentService{
    /**
     * 通过ID查询单条数据
     *
     * @param aId 主键
     * @return 实例对象
     */
    Appointment queryById(Integer aId);
    /**
     * 分页查询
     *
     * @param appointment 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Appointment> paginQuery(Appointment appointment, PageRequest pageRequest);
    /**
     * 新增数据
     *
     * @param appointment 实例对象
     * @return 实例对象
     */
    Appointment insert(Appointment appointment);
    /**
     * 更新数据
     *
     * @param appointment 实例对象
     * @return 实例对象
     */
    Appointment update(Appointment appointment);
    /**
     * 通过主键删除数据
     *
     * @param aId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer aId);

    /**
     * 根据日期获取可以挂号的医生
     * @param date
     * @return
     */
    List<Appointment> getDoctors(String date);

    /**
     * 每天运行一次，自动分配医生的挂号任务
     */
    void assignments(boolean init);
}