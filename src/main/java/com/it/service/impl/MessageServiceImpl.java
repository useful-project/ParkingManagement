package com.it.service.impl;

import com.it.dao.MemberDAO;
import com.it.entity.Member;
import com.it.entity.Message;
import com.it.dao.MessageDAO;
import com.it.service.MessageService;
import com.it.util.Info;
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
 * (Message表)服务实现类
 *
 * @author makejava
 * @since 2022-12-18 20:53:38
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService {
    @Resource
    private MessageDAO messageDAO;
    @Resource
    private MemberDAO memberDAO;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Message selectById(Integer id) {
        return this.messageDAO.selectById(id);
    }

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public PageResult selectPage(int start, int limit, Message message) {
        PageRequest pageRequest=new PageRequest(start,limit);
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest,message));
    }

    /**
     * 调用分页插件完成分页
     * @param pageRequest
     * @return
     */
    private PageInfo<Message> getPageInfo(PageRequest pageRequest, Message message) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Message> messages = this.messageDAO.selectList(message);
        for (Message message1 : messages) {
            Member member = memberDAO.selectById(message1.getMemberid());
            message1.setMember(member);
        }
        return new PageInfo<>(messages);
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
    @Override
    public List<Message> selectAll( Message message) {
        return this.messageDAO.selectAll(message);
    }
    
    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<Message> selectList(Message message) {
        return this.messageDAO.selectList(message);
    }
    
    /**
     * 新增数据
     *
     * @param message 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Message message) {
        message.setSavetime(Info.getDateStr());
        return this.messageDAO.insert(message);
    }

    /**
     * 批量新增
     *
     * @param messages 实例对象的集合
     * @return 生效的条数
     */
    @Override
    public int batchInsert(List<Message> messages) {
        return this.messageDAO.batchInsert(messages);
    }

    /**
     * 修改数据
     *
     * @param message 实例对象
     * @return 实例对象
     */
    @Override
    public Message update(Message message) {
        this.messageDAO.update(message);
        return this.selectById(message.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer id) {
        return this.messageDAO.deleteById(id);
    }
    
    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    @Override
    public int count(){
        return this.messageDAO.count();
    }
}


