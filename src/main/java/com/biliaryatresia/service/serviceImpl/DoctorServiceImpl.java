package com.biliaryatresia.service.serviceImpl;


import com.biliaryatresia.entity.Doctor;
import com.biliaryatresia.mapper.DoctorMapper;
import com.biliaryatresia.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

/**
 * 医生;(doctor)表服务实现类
 * @author : yanqishi1
 * @date : 2022-7-11
 */
@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorMapper doctorMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param docId 主键
     * @return 实例对象
     */
    public Doctor queryById(Integer docId){
        return doctorMapper.queryById(docId);
    }

    /**
     * 分页查询
     *
     * @param doctor 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    public Page<Doctor> paginQuery(Doctor doctor, PageRequest pageRequest){
        long total = doctorMapper.count(doctor);
        return new PageImpl<>(doctorMapper.queryAllByLimit(doctor, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param doctor 实例对象
     * @return 实例对象
     */
    public Doctor insert(Doctor doctor){
        doctorMapper.insert(doctor);
        return doctor;
    }

    /**
     * 更新数据
     *
     * @param doctor 实例对象
     * @return 实例对象
     */
    public Doctor update(Doctor doctor){
        doctorMapper.update(doctor);
        return queryById(doctor.getDocId());
    }

    /**
     * 通过主键删除数据
     *
     * @param docId 主键
     * @return 是否成功
     */
    public boolean deleteById(Integer docId){
        int total = doctorMapper.deleteById(docId);
        return total > 0;
    }
}
