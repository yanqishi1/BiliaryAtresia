package com.biliaryatresia.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import com.biliaryatresia.entity.Patient;

/**
 * 患者;(patient)表数据库访问层
 * @author : yanqishi1
 * @date : 2022-7-11
 */
@Mapper
public interface PatientMapper{
    /**
     * 通过ID查询单条数据
     *
     * @param pId 主键
     * @return 实例对象
     */
    Patient queryById(Integer pId);

    /**
     * 通过电话号码查询单条数据
     *
     * @param tel 电话号码
     * @return 实例对象
     */
    Patient queryByTel(String tel);
    /**
     * 分页查询指定行数据
     *
     * @param patient 查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Patient> queryAllByLimit(Patient patient, @Param("pageable") Pageable pageable);
    /**
     * 统计总行数
     *
     * @param patient 查询条件
     * @return 总行数
     */
    long count(Patient patient);
    /**
     * 新增数据
     *
     * @param patient 实例对象
     * @return 影响行数
     */
    int insert(Patient patient);

    /**
     * 新增数据
     *
     * @param patient 实例对象
     * @return 影响行数
     */
    int register(Patient patient);

    /**
     * 批量新增数据
     *
     * @param entities List<Patient> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Patient> entities);
    /**
     * 批量新增或按主键更新数据
     *
     * @param entities List<Patient> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Patient> entities);
    /**
     * 更新数据
     *
     * @param patient 实例对象
     * @return 影响行数
     */
    int update(Patient patient);
    /**
     * 通过主键删除数据
     *
     * @param pId 主键
     * @return 影响行数
     */
    int deleteById(Integer pId);
}