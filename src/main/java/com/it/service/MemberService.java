package com.it.service;

import com.it.entity.Member;
import java.util.List;
import java.util.Map;
import com.it.common.page.PageResult;

/**
 * (Member)表服务接口
 *
 * @author makejava
 * @since 2022-12-16 20:51:52
 */
public interface MemberService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Member selectById(Integer id);

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    PageResult selectPage(int start, int limit, Member member);

    /**                                                                        
     * 查询全部
     *
     * @return 对象列表
     */
    List<Member> selectAll(Member member);
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param member 实例对象
     * @return 对象列表
     */
    List<Member> selectList(Member member);

    /**
     * 新增数据
     *
     * @param member 实例对象
     * @return 影响行数
     */
    int insert(Member member);
	
	/**
     * 批量新增
     *
     * @param members 实例对象的集合
     * @return 影响行数
     */
	int batchInsert(List<Member> members);
	
    /**
     * 修改数据
     *
     * @param member 实例对象
     * @return 修改
     */
    Member update(Member member);

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


