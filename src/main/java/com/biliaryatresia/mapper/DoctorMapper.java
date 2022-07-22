package com.biliaryatresia.mapper;



import java.util.List;

import com.biliaryatresia.entity.Doctor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;


/**
 * 医生;(doctor)表数据库访问层
 * @author : yanqishi1
 * @date : 2022-7-11
 */
@Mapper
public interface DoctorMapper{
    /**
     * 通过ID查询单条数据
     *
     * @param docId 主键
     * @return 实例对象
     */
    Doctor queryById(Integer docId);
    /**
     * 分页查询指定行数据
     *
     * @param doctor 查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Doctor> queryAllByLimit(Doctor doctor, @Param("pageable") Pageable pageable);
    /**
     * 统计总行数
     *
     * @param doctor 查询条件
     * @return 总行数
     */
    long count(Doctor doctor);
    /**
     * 新增数据
     *
     * @param doctor 实例对象
     * @return 影响行数
     */
    int insert(Doctor doctor);
    /**
     * 批量新增数据
     *
     * @param entities List<Doctor> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Doctor> entities);
    /**
     * 批量新增或按主键更新数据
     *
     * @param entities List<Doctor> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Doctor> entities);
    /**
     * 更新数据
     *
     * @param doctor 实例对象
     * @return 影响行数
     */
    int update(Doctor doctor);
    /**
     * 通过主键删除数据
     *
     * @param docId 主键
     * @return 影响行数
     */
    int deleteById(Integer docId);

    /**
     * 获取所有医生的信息
     * @return
     */
    List<Doctor> queryAll();
}
