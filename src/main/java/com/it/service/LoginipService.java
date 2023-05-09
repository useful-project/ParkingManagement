package com.it.service;

import com.it.entity.Loginip;
import java.util.List;
import java.util.Map;
import com.it.common.page.PageResult;

/**
 * (Loginip)表服务接口
 *
 * @author makejava
 * @since 2022-10-15 23:08:59
 */
public interface LoginipService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Loginip selectById(Integer id);

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    PageResult selectPage(int start, int limit, Loginip loginip);

    /**                                                                        
     * 查询全部
     *
     * @return 对象列表
     */
    List<Loginip> selectAll(Loginip loginip);
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param loginip 实例对象
     * @return 对象列表
     */
    List<Loginip> selectList(Loginip loginip);

    /**
     * 新增数据
     *
     * @param loginip 实例对象
     * @return 影响行数
     */
    int insert(Loginip loginip);
	
	/**
     * 批量新增
     *
     * @param loginips 实例对象的集合
     * @return 影响行数
     */
	int batchInsert(List<Loginip> loginips);
	
    /**
     * 修改数据
     *
     * @param loginip 实例对象
     * @return 修改
     */
    Loginip update(Loginip loginip);

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


