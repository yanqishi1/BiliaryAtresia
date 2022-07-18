package com.biliaryatresia.service;

import com.biliaryatresia.entity.Patient;
import com.biliaryatresia.entity.Reserve;
import com.biliaryatresia.util.Msg;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


/**
 * 挂号;(reserve)表服务接口
 * @author : GyberPunk
 * @date : 2022-7-11
 */
public interface ReserveService{
    /**
     * 通过ID查询单条数据
     *
     * @param rId 主键
     * @return 实例对象
     */
    Reserve queryById(Integer rId);
    /**
     * 分页查询
     *
     * @param reserve 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Reserve> paginQuery(Reserve reserve, PageRequest pageRequest);
    /**
     * 新增数据
     *
     * @param reserve 实例对象
     * @return 实例对象
     */
    Reserve insert(Reserve reserve);
    /**
     * 更新数据
     *
     * @param reserve 实例对象
     * @return 实例对象
     */
    Reserve update(Reserve reserve);
    /**
     * 通过主键删除数据
     *
     * @param rId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer rId);

    Msg reserve(String name, String _birthday, String sex, String _date, Patient patient, Integer doctorId);
}
