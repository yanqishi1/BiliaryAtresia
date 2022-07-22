package com.biliaryatresia.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import com.biliaryatresia.entity.Log;

/**
 * 日志管理;(Log)表服务接口
 * @author : yanqishi1
 * @date : 2022-7-11
 */
public interface LogService{
    /**
     * 通过ID查询单条数据
     *
     * @param logId 主键
     * @return 实例对象
     */
    Log queryById(Integer logId);
    /**
     * 分页查询
     *
     * @param log 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Log> paginQuery(Log log, PageRequest pageRequest);
    /**
     * 新增数据
     *
     * @param log 实例对象
     * @return 实例对象
     */
    Log insert(Log log);
    /**
     * 更新数据
     *
     * @param log 实例对象
     * @return 实例对象
     */
    Log update(Log log);
    /**
     * 通过主键删除数据
     *
     * @param logId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer logId);
}