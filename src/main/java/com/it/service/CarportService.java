package com.it.service;

import com.it.entity.Carport;
import java.util.List;
import java.util.Map;
import com.it.common.page.PageResult;

/**
 * (Carport)表服务接口
 *
 * @author makejava
 * @since 2023-02-13 22:22:02
 */
public interface CarportService {

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
    PageResult selectPage(int start, int limit, Carport carport);

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
     * @return 修改
     */
    Carport update(Carport carport);

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


