package com.biliaryatresia.service.serviceImpl;


import com.biliaryatresia.entity.Reserve;
import com.biliaryatresia.mapper.ReserveMapper;
import com.biliaryatresia.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
/**
 * 挂号;(reserve)表服务实现类
 * @author : GyberPunk
 * @date : 2022-7-11
 */
@Service
public class ReserveServiceImpl implements ReserveService {
    @Autowired
    private ReserveMapper reserveMapper;

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
        return queryById(reserve.getRId());
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
}
