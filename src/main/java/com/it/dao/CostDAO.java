package com.it.dao;

import com.it.entity.Cost;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * (Cost)表数据库访问层
 *
 * @author makejava
 * @since 2023-02-14 09:46:11
 */
public interface CostDAO {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Cost selectById(Integer id);
	
    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Cost> selectPage(@Param("start") int start, @Param("limit") int limit);

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<Cost> selectAll(Cost cost);
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param cost 实例对象
     * @return 对象列表
     */
    List<Cost> selectList(Cost cost);

    /**
     * 新增数据
     *
     * @param cost 实例对象
     * @return 影响行数
     */
    int insert(Cost cost);
	
	/**
     * 批量新增
     *
     * @param costs 实例对象的集合
     * @return 影响行数
     */
	int batchInsert(List<Cost> costs);
	
    /**
     * 修改数据
     *
     * @param cost 实例对象
     * @return 影响行数
     */
    int update(Cost cost);

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


