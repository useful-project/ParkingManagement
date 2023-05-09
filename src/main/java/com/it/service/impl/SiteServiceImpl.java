package com.it.service.impl;

import com.it.entity.Site;
import com.it.dao.SiteDAO;
import com.it.service.SiteService;
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
 * (Site表)服务实现类
 *
 * @author makejava
 * @since 2023-02-11 20:48:59
 */
@Service("siteService")
public class SiteServiceImpl implements SiteService {
    @Resource
    private SiteDAO siteDAO;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Site selectById(Integer id) {
        return this.siteDAO.selectById(id);
    }

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public PageResult selectPage(int start, int limit, Site site) {
        PageRequest pageRequest=new PageRequest(start,limit);
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest,site));
    }

    /**
     * 调用分页插件完成分页
     * @param pageRequest
     * @return
     */
    private PageInfo<Site> getPageInfo(PageRequest pageRequest, Site site) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Site> sites = this.siteDAO.selectList(site);
        return new PageInfo<>(sites);
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
    @Override
    public List<Site> selectAll( Site site) {
        return this.siteDAO.selectAll(site);
    }
    
    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<Site> selectList(Site site) {
        return this.siteDAO.selectList(site);
    }
    
    /**
     * 新增数据
     *
     * @param site 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Site site) {
        return this.siteDAO.insert(site);
    }

    /**
     * 批量新增
     *
     * @param sites 实例对象的集合
     * @return 生效的条数
     */
    @Override
    public int batchInsert(List<Site> sites) {
        return this.siteDAO.batchInsert(sites);
    }

    /**
     * 修改数据
     *
     * @param site 实例对象
     * @return 实例对象
     */
    @Override
    public Site update(Site site) {
        this.siteDAO.update(site);
        return this.selectById(site.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer id) {
        return this.siteDAO.deleteById(id);
    }
    
    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    @Override
    public int count(){
        return this.siteDAO.count();
    }
}


