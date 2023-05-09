package com.it.service;

import com.it.entity.Category;
import java.util.List;
import java.util.Map;
import com.it.common.page.PageResult;

/**
 * (Category)表服务接口
 *
 * @author makejava
 * @since 2023-02-13 22:13:01
 */
public interface CategoryService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Category selectById(Integer id);

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    PageResult selectPage(int start, int limit, Category category);

    /**                                                                        
     * 查询全部
     *
     * @return 对象列表
     */
    List<Category> selectAll(Category category);
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param category 实例对象
     * @return 对象列表
     */
    List<Category> selectList(Category category);

    /**
     * 新增数据
     *
     * @param category 实例对象
     * @return 影响行数
     */
    int insert(Category category);
	
	/**
     * 批量新增
     *
     * @param categorys 实例对象的集合
     * @return 影响行数
     */
	int batchInsert(List<Category> categorys);
	
    /**
     * 修改数据
     *
     * @param category 实例对象
     * @return 修改
     */
    Category update(Category category);

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


