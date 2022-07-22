package com.biliaryatresia.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import com.biliaryatresia.entity.ImageLog;

/**
 * 上传图片;(image)表数据库访问层
 * @author : yanqishi1
 * @date : 2022-7-11
 */
@Mapper
public interface ImageLogMapper {
    /**
     * 通过ID查询单条数据
     *
     * @param imgId 主键
     * @return 实例对象
     */
    ImageLog queryById(Integer imgId);
    /**
     * 分页查询指定行数据
     *
     * @param image 查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<ImageLog> queryAllByLimit(ImageLog image, @Param("pageable") Pageable pageable);
    /**
     * 统计总行数
     *
     * @param image 查询条件
     * @return 总行数
     */
    long count(ImageLog image);
    /**
     * 新增数据
     *
     * @param image 实例对象
     * @return 影响行数
     */
    int insert(ImageLog image);
    /**
     * 批量新增数据
     *
     * @param entities List<Image> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ImageLog> entities);
    /**
     * 批量新增或按主键更新数据
     *
     * @param entities List<Image> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<ImageLog> entities);
    /**
     * 更新数据
     *
     * @param image 实例对象
     * @return 影响行数
     */
    int update(ImageLog image);
    /**
     * 通过主键删除数据
     *
     * @param imgId 主键
     * @return 影响行数
     */
    int deleteById(Integer imgId);

    List<ImageLog> queryByPid(Integer Pid);
}