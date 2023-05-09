package com.it.service.impl;

import com.it.entity.Loginip;
import com.it.dao.LoginipDAO;
import com.it.service.LoginipService;
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
 * (Loginip表)服务实现类
 *
 * @author makejava
 * @since 2022-10-15 23:09:00
 */
@Service("loginipService")
public class LoginipServiceImpl implements LoginipService {
    @Resource
    private LoginipDAO loginipDAO;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Loginip selectById(Integer id) {
        return this.loginipDAO.selectById(id);
    }

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public PageResult selectPage(int start, int limit, Loginip loginip) {
        PageRequest pageRequest=new PageRequest(start,limit);
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest,loginip));
    }

    /**
     * 调用分页插件完成分页
     * @param pageRequest
     * @return
     */
    private PageInfo<Loginip> getPageInfo(PageRequest pageRequest, Loginip loginip) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Loginip> loginips = this.loginipDAO.selectList(loginip);
        return new PageInfo<>(loginips);
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
    @Override
    public List<Loginip> selectAll( Loginip loginip) {
        return this.loginipDAO.selectAll(loginip);
    }
    
    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<Loginip> selectList(Loginip loginip) {
        return this.loginipDAO.selectList(loginip);
    }
    
    /**
     * 新增数据
     *
     * @param loginip 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Loginip loginip) {
        return this.loginipDAO.insert(loginip);
    }

    /**
     * 批量新增
     *
     * @param loginips 实例对象的集合
     * @return 生效的条数
     */
    @Override
    public int batchInsert(List<Loginip> loginips) {
        return this.loginipDAO.batchInsert(loginips);
    }

    /**
     * 修改数据
     *
     * @param loginip 实例对象
     * @return 实例对象
     */
    @Override
    public Loginip update(Loginip loginip) {
        this.loginipDAO.update(loginip);
        return this.selectById(loginip.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer id) {
        return this.loginipDAO.deleteById(id);
    }
    
    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    @Override
    public int count(){
        return this.loginipDAO.count();
    }
}


