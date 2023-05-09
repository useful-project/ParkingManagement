package com.it.service;

import com.it.entity.Site;
import java.util.List;
import java.util.Map;
import com.it.common.page.PageResult;

/**
 * (Site)表服务接口
 *
 * @author makejava
 * @since 2023-02-11 20:48:59
 */
public interface SiteService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Site selectById(Integer id);

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    PageResult selectPage(int start, int limit, Site site);

    /**                                                                        
     * 查询全部
     *
     * @return 对象列表
     */
    List<Site> selectAll(Site site);
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param site 实例对象
     * @return 对象列表
     */
    List<Site> selectList(Site site);

    /**
     * 新增数据
     *
     * @param site 实例对象
     * @return 影响行数
     */
    int insert(Site site);
	
	/**
     * 批量新增
     *
     * @param sites 实例对象的集合
     * @return 影响行数
     */
	int batchInsert(List<Site> sites);
	
    /**
     * 修改数据
     *
     * @param site 实例对象
     * @return 修改
     */
    Site update(Site site);

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


