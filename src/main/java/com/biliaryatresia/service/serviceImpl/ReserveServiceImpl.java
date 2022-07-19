package com.biliaryatresia.service.serviceImpl;


import com.biliaryatresia.entity.Appointment;
import com.biliaryatresia.entity.Patient;
import com.biliaryatresia.entity.Reserve;
import com.biliaryatresia.mapper.AppointmentMapper;
import com.biliaryatresia.mapper.ReserveMapper;
import com.biliaryatresia.service.ReserveService;
import com.biliaryatresia.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 挂号;(reserve)表服务实现类
 * @author : GyberPunk
 * @date : 2022-7-11
 */
@Service
public class ReserveServiceImpl implements ReserveService {
    @Autowired
    private ReserveMapper reserveMapper;

    @Autowired
    private AppointmentMapper appointmentMapper = null;

    /**
     * 通过ID查询单条数据
     *
     * @param rId 主键
     * @return 实例对象
     */
    public Reserve queryById(Integer rId){
        return reserveMapper.queryById(rId);
    }

    /**
     * 分页查询
     *
     * @param reserve 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    public Page<Reserve> paginQuery(Reserve reserve, PageRequest pageRequest){
        long total = reserveMapper.count(reserve);
        return new PageImpl<>(reserveMapper.queryAllByLimit(reserve, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param reserve 实例对象
     * @return 实例对象
     */
    public Reserve insert(Reserve reserve){
        reserveMapper.insert(reserve);
        return reserve;
    }

    /**
     * 更新数据
     *
     * @param reserve 实例对象
     * @return 实例对象
     */
    public Reserve update(Reserve reserve){
        reserveMapper.update(reserve);
        return queryById(reserve.getrId());
    }

    /**
     * 通过主键删除数据
     *
     * @param rId 主键
     * @return 是否成功
     */
    public boolean deleteById(Integer rId){
        int total = reserveMapper.deleteById(rId);
        return total > 0;
    }

    @Override
    public synchronized Msg reserve(String name, String _birthday, String sex, String _date, Patient patient, Integer doctorId) {
        Msg msg = new Msg();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Appointment appointment = appointmentMapper.queryByDocDate(doctorId, _date);
            if(appointment!=null && appointment.getNum()>0){
                Date birthday = df.parse(_birthday);
                Date date = df.parse(_date);
                Reserve reserve = new Reserve();
                reserve.setpId(patient.getPId());
                reserve.setDocId(doctorId);
                reserve.setrFee(appointment.getFee());
                reserve.setrDate(new Date());
                reserve.setrMeetingDate(date);
                reserve.setrState(Reserve.SUCCESS);
                //并发， 加锁  事务
                reserveMapper.create(reserve);
                appointment.setNum(appointment.getNum()-1);
                appointmentMapper.update(appointment);

                msg.setCode(200);
                msg.setMsg("Reserve success!");
            }else{
                msg.setCode(502);
                msg.setMsg("Fully booked!");
            }
        } catch (Exception e) {
            msg.setCode(500);
            msg.setMsg("Error");
            e.printStackTrace();
        }finally {
            return msg;
        }
    }
}
