package com.it.dao;

import com.it.entity.Carport;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * (Carport)表数据库访问层
 *
 * @author makejava
 * @since 2023-02-13 22:22:02
 */
public interface CarportDAO {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Carport selectById(Integer id);
	
    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Carport> selectPage(@Param("start") int start, @Param("limit") int limit);

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<Carport> selectAll(Carport carport);
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param carport 实例对象
     * @return 对象列表
     */
    List<Carport> selectList(Carport carport);

    /**
     * 新增数据
     *
     * @param carport 实例对象
     * @return 影响行数
     */
    int insert(Carport carport);
	
	/**
     * 批量新增
     *
     * @param carports 实例对象的集合
     * @return 影响行数
     */
	int batchInsert(List<Carport> carports);
	
    /**
     * 修改数据
     *
     * @param carport 实例对象
     * @return 影响行数
     */
    int update(Carport carport);

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


