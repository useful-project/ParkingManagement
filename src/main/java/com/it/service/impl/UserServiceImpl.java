package com.it.service.impl;
import com.it.entity.User;
import com.it.dao.UserDAO;
import com.it.service.UserService;
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
 * (User表)服务实现类
 *
 * @author makejava
 * @since 2022-09-28 15:37:05
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDAO userDAO;


    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User selectById(Integer id) {
        User user = this.userDAO.selectById(id);
        return user;
    }

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public PageResult selectPage(int start, int limit, User user) {
        PageRequest pageRequest=new PageRequest(start,limit);
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest,user));
    }

    /**
     * 调用分页插件完成分页
     * @param pageRequest
     * @return
     */
    private PageInfo<User> getPageInfo(PageRequest pageRequest, User user) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = this.userDAO.selectList(user);
        return new PageInfo<>(users);
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
    @Override
    public List<User> selectAll( User user) {
        return this.userDAO.selectAll(user);
    }
    
    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<User> selectList(User user) {
        return this.userDAO.selectList(user);
    }
    
    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(User user) {
        return this.userDAO.insert(user);
    }

    /**
     * 批量新增
     *
     * @param users 实例对象的集合
     * @return 生效的条数
     */
    @Override
    public int batchInsert(List<User> users) {
        return this.userDAO.batchInsert(users);
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDAO.update(user);
        return this.selectById(user.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer id) {
        return this.userDAO.deleteById(id);
    }
    
    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    @Override
    public int count(){
        return this.userDAO.count();
    }
}


