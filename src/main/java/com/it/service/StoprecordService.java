package com.it.service;

import com.it.entity.Stoprecord;
import java.util.List;
import java.util.Map;
import com.it.common.page.PageResult;

/**
 * (Stoprecord)表服务接口
 *
 * @author makejava
 * @since 2023-02-14 09:58:58
 */
public interface StoprecordService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Stoprecord selectById(Integer id);

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    PageResult selectPage(int start, int limit, Stoprecord stoprecord);

    /**                                                                        
     * 查询全部
     *
     * @return 对象列表
     */
    List<Stoprecord> selectAll(Stoprecord stoprecord);


    /**
     * 统计
     *
     * @return 对象列表
     */
    List<Stoprecord> tj1(Stoprecord stoprecord);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param stoprecord 实例对象
     * @return 对象列表
     */
    List<Stoprecord> selectList(Stoprecord stoprecord);

    /**
     * 新增数据
     *
     * @param stoprecord 实例对象
     * @return 影响行数
     */
    int insert(Stoprecord stoprecord);
	
	/**
     * 批量新增
     *
     * @param stoprecords 实例对象的集合
     * @return 影响行数
     */
	int batchInsert(List<Stoprecord> stoprecords);
	
    /**
     * 修改数据
     *
     * @param stoprecord 实例对象
     * @return 修改
     */
    Stoprecord update(Stoprecord stoprecord);

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


