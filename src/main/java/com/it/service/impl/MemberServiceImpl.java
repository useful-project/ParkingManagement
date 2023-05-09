package com.it.service.impl;

import com.it.entity.Member;
import com.it.dao.MemberDAO;
import com.it.service.MemberService;
import org.springframework.stereotype.Service;
import com.it.common.page.PageResult;
import com.it.common.page.PageRequest;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.common.util.PageUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (Member表)服务实现类
 *
 * @author makejava
 * @since 2022-12-16 20:51:53
 */
@Service("memberService")
public class MemberServiceImpl implements MemberService {
    @Resource
    private MemberDAO memberDAO;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Member selectById(Integer id) {
        return this.memberDAO.selectById(id);
    }

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public PageResult selectPage(int start, int limit, Member member) {
        PageRequest pageRequest=new PageRequest(start,limit);
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest,member));
    }

    /**
     * 调用分页插件完成分页
     * @param pageRequest
     * @return
     */
    private PageInfo<Member> getPageInfo(PageRequest pageRequest, Member member) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Member> members = this.memberDAO.selectList(member);
        return new PageInfo<>(members);
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
    @Override
    public List<Member> selectAll( Member member) {
        return this.memberDAO.selectAll(member);
    }
    
    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<Member> selectList(Member member) {
        return this.memberDAO.selectList(member);
    }
    
    /**
     * 新增数据
     *
     * @param member 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Member member) {
        return this.memberDAO.insert(member);
    }

    /**
     * 批量新增
     *
     * @param members 实例对象的集合
     * @return 生效的条数
     */
    @Override
    public int batchInsert(List<Member> members) {
        return this.memberDAO.batchInsert(members);
    }

    /**
     * 修改数据
     *
     * @param member 实例对象
     * @return 实例对象
     */
    @Override
    public Member update(Member member) {
        this.memberDAO.update(member);
        return this.selectById(member.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer id) {
        return this.memberDAO.deleteById(id);
    }
    
    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    @Override
    public int count(){
        return this.memberDAO.count();
    }
}


