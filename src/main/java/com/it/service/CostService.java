package com.it.service;

import com.it.entity.Cost;
import java.util.List;
import java.util.Map;
import com.it.common.page.PageResult;

/**
 * (Cost)表服务接口
 *
 * @author makejava
 * @since 2023-02-14 09:46:11
 */
public interface CostService {

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
    PageResult selectPage(int start, int limit, Cost cost);

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
     * @return 修改
     */
    Cost update(Cost cost);

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


