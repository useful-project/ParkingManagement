package com.it.service;

import com.it.entity.Message;
import java.util.List;
import java.util.Map;
import com.it.common.page.PageResult;

/**
 * (Message)表服务接口
 *
 * @author makejava
 * @since 2022-12-18 20:53:38
 */
public interface MessageService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Message selectById(Integer id);

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    PageResult selectPage(int start, int limit, Message message);

    /**                                                                        
     * 查询全部
     *
     * @return 对象列表
     */
    List<Message> selectAll(Message message);
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param message 实例对象
     * @return 对象列表
     */
    List<Message> selectList(Message message);

    /**
     * 新增数据
     *
     * @param message 实例对象
     * @return 影响行数
     */
    int insert(Message message);
	
	/**
     * 批量新增
     *
     * @param messages 实例对象的集合
     * @return 影响行数
     */
	int batchInsert(List<Message> messages);
	
    /**
     * 修改数据
     *
     * @param message 实例对象
     * @return 修改
     */
    Message update(Message message);

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


