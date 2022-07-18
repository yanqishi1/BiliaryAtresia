package com.biliaryatresia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import com.biliaryatresia.entity.Appointment;
import com.biliaryatresia.mapper.AppointmentMapper;
import com.biliaryatresia.service.AppointmentService;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 挂号查询;(appointment)表服务实现类
 * @author : GyberPunk
 * @date : 2022-7-18
 */
@Service
public class AppointmentServiceImpl implements AppointmentService{
    @Autowired
    private AppointmentMapper appointmentMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param aId 主键
     * @return 实例对象
     */
    public Appointment queryById(Integer aId){
        return appointmentMapper.queryById(aId);
    }

    /**
     * 分页查询
     *
     * @param appointment 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    public Page<Appointment> paginQuery(Appointment appointment, PageRequest pageRequest){
        long total = appointmentMapper.count(appointment);
        return new PageImpl<>(appointmentMapper.queryAllByLimit(appointment, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param appointment 实例对象
     * @return 实例对象
     */
    public Appointment insert(Appointment appointment){
        appointmentMapper.insert(appointment);
        return appointment;
    }

    /**
     * 更新数据
     *
     * @param appointment 实例对象
     * @return 实例对象
     */
    public Appointment update(Appointment appointment){
        appointmentMapper.update(appointment);
        return queryById(appointment.getAId());
    }

    /**
     * 通过主键删除数据
     *
     * @param aId 主键
     * @return 是否成功
     */
    public boolean deleteById(Integer aId){
        int total = appointmentMapper.deleteById(aId);
        return total > 0;
    }

    @Override
    public List<Appointment> getDoctors(String date) {
        List<Appointment> appointments = new ArrayList<>();
        try {
            appointments = appointmentMapper.queryByDate(date);
            System.out.println(appointments);
        }catch (Exception e){
            e.printStackTrace();
        }
        return appointments;
    }
}