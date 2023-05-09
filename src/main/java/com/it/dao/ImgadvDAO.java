package com.it.dao;

import com.it.entity.Imgadv;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * (Imgadv)表数据库访问层
 *
 * @author makejava
 * @since 2023-02-09 16:07:04
 */
public interface ImgadvDAO {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Imgadv selectById(Integer id);
	
    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Imgadv> selectPage(@Param("start") int start, @Param("limit") int limit);

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<Imgadv> selectAll(Imgadv imgadv);
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param imgadv 实例对象
     * @return 对象列表
     */
    List<Imgadv> selectList(Imgadv imgadv);

    /**
     * 新增数据
     *
     * @param imgadv 实例对象
     * @return 影响行数
     */
    int insert(Imgadv imgadv);
	
	/**
     * 批量新增
     *
     * @param imgadvs 实例对象的集合
     * @return 影响行数
     */
	int batchInsert(List<Imgadv> imgadvs);
	
    /**
     * 修改数据
     *
     * @param imgadv 实例对象
     * @return 影响行数
     */
    int update(Imgadv imgadv);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    int count();
}


