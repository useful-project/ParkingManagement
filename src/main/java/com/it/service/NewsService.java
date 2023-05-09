package com.it.service;

import com.it.entity.News;
import java.util.List;
import java.util.Map;
import com.it.common.page.PageResult;

/**
 * (News)表服务接口
 *
 * @author makejava
 * @since 2023-02-09 18:57:13
 */
public interface NewsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    News selectById(Integer id);

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    PageResult selectPage(int start, int limit, News news);

    /**                                                                        
     * 查询全部
     *
     * @return 对象列表
     */
    List<News> selectAll(News news);
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param news 实例对象
     * @return 对象列表
     */
    List<News> selectList(News news);

    /**
     * 新增数据
     *
     * @param news 实例对象
     * @return 影响行数
     */
    int insert(News news);
	
	/**
     * 批量新增
     *
     * @param newss 实例对象的集合
     * @return 影响行数
     */
	int batchInsert(List<News> newss);
	
    /**
     * 修改数据
     *
     * @param news 实例对象
     * @return 修改
     */
    News update(News news);

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


