package com.it.dao;

import com.it.entity.Site;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * (Site)表数据库访问层
 *
 * @author makejava
 * @since 2023-02-11 20:48:59
 */
public interface SiteDAO {

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
    List<Site> selectPage(@Param("start") int start, @Param("limit") int limit);

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
     * @return 影响行数
     */
    int update(Site site);

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


