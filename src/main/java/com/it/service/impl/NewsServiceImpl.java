package com.it.service.impl;

import com.it.dao.UserDAO;
import com.it.entity.News;
import com.it.dao.NewsDAO;
import com.it.entity.User;
import com.it.service.NewsService;
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
 * (News表)服务实现类
 *
 * @author makejava
 * @since 2023-02-09 18:57:13
 */
@Service("newsService")
public class NewsServiceImpl implements NewsService {
    @Resource
    private NewsDAO newsDAO;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public News selectById(Integer id) {
        return this.newsDAO.selectById(id);
    }

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public PageResult selectPage(int start, int limit, News news) {
        PageRequest pageRequest=new PageRequest(start,limit);
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest,news));
    }

    /**
     * 调用分页插件完成分页
     * @param pageRequest
     * @return
     */
    private PageInfo<News> getPageInfo(PageRequest pageRequest, News news) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<News> newss = this.newsDAO.selectList(news);
        for (News newss1 : newss) {
            String content = Info.delHTMLTag(newss1.getContent());
            newss1.setContent(content);
        }
        return new PageInfo<>(newss);
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
    @Override
    public List<News> selectAll( News news) {
        return this.newsDAO.selectAll(news);
    }
    
    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<News> selectList(News news) {
        List<News> newss = this.newsDAO.selectList(news);
        for (News newss1 : newss) {
            String content = Info.delHTMLTag(newss1.getContent());
            newss1.setContent(content);
        }
        return newss;
    }
    
    /**
     * 新增数据
     *
     * @param news 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(News news) {
        news.setSavetime(Info.getDateStr());
        return this.newsDAO.insert(news);
    }

    /**
     * 批量新增
     *
     * @param newss 实例对象的集合
     * @return 生效的条数
     */
    @Override
    public int batchInsert(List<News> newss) {
        return this.newsDAO.batchInsert(newss);
    }

    /**
     * 修改数据
     *
     * @param news 实例对象
     * @return 实例对象
     */
    @Override
    public News update(News news) {
        this.newsDAO.update(news);
        return this.selectById(news.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer id) {
        return this.newsDAO.deleteById(id);
    }
    
    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    @Override
    public int count(){
        return this.newsDAO.count();
    }
}


