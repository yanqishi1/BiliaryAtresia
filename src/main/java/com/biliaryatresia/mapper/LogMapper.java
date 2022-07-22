package com.biliaryatresia.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import com.biliaryatresia.entity.Log;

/**
 * 日志管理;(Log)表数据库访问层
 * @author : yanqishi1
 * @date : 2022-7-11
 */
@Mapper
public interface LogMapper{
    /**
     * 通过ID查询单条数据
     *
     * @param logId 主键
     * @return 实例对象
     */
    Log queryById(Integer logId);
    /**
     * 分页查询指定行数据
     *
     * @param log 查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Log> queryAllByLimit(Log log, @Param("pageable") Pageable pageable);
    /**
     * 统计总行数
     *
     * @param log 查询条件
     * @return 总行数
     */
    long count(Log log);
    /**
     * 新增数据
     *
     * @param log 实例对象
     * @return 影响行数
     */
    int insert(Log log);
    /**
     * 批量新增数据
     *
     * @param entities List<Log> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Log> entities);
    /**
     * 批量新增或按主键更新数据
     *
     * @param entities List<Log> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Log> entities);
    /**
     * 更新数据
     *
     * @param log 实例对象
     * @return 影响行数
     */
    int update(Log log);
    /**
     * 通过主键删除数据
     *
     * @param logId 主键
     * @return 影响行数
     */
    int deleteById(Integer logId);
}