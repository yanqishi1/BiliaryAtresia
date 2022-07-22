package com.biliaryatresia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import com.biliaryatresia.entity.Log;
import com.biliaryatresia.mapper.LogMapper;
import com.biliaryatresia.service.LogService;
/**
 * 日志管理;(Log)表服务实现类
 * @author : yanqishi1
 * @date : 2022-7-11
 */
@Service
public class LogServiceImpl implements LogService{
    @Autowired
    private LogMapper logMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param logId 主键
     * @return 实例对象
     */
    public Log queryById(Integer logId){
        return logMapper.queryById(logId);
    }

    /**
     * 分页查询
     *
     * @param log 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    public Page<Log> paginQuery(Log log, PageRequest pageRequest){
        long total = logMapper.count(log);
        return new PageImpl<>(logMapper.queryAllByLimit(log, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param log 实例对象
     * @return 实例对象
     */
    public Log insert(Log log){
        logMapper.insert(log);
        return log;
    }

    /**
     * 更新数据
     *
     * @param log 实例对象
     * @return 实例对象
     */
    public Log update(Log log){
        logMapper.update(log);
        return queryById(log.getLogId());
    }

    /**
     * 通过主键删除数据
     *
     * @param logId 主键
     * @return 是否成功
     */
    public boolean deleteById(Integer logId){
        int total = logMapper.deleteById(logId);
        return total > 0;
    }
}