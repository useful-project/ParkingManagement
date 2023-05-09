package com.it.service.impl;

import com.it.entity.Imgadv;
import com.it.dao.ImgadvDAO;
import com.it.service.ImgadvService;
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
 * (Imgadv表)服务实现类
 *
 * @author makejava
 * @since 2023-02-09 16:07:04
 */
@Service("imgadvService")
public class ImgadvServiceImpl implements ImgadvService {
    @Resource
    private ImgadvDAO imgadvDAO;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Imgadv selectById(Integer id) {
        return this.imgadvDAO.selectById(id);
    }

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public PageResult selectPage(int start, int limit, Imgadv imgadv) {
        PageRequest pageRequest=new PageRequest(start,limit);
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest,imgadv));
    }

    /**
     * 调用分页插件完成分页
     * @param pageRequest
     * @return
     */
    private PageInfo<Imgadv> getPageInfo(PageRequest pageRequest, Imgadv imgadv) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Imgadv> imgadvs = this.imgadvDAO.selectList(imgadv);
        return new PageInfo<>(imgadvs);
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
    @Override
    public List<Imgadv> selectAll( Imgadv imgadv) {
        return this.imgadvDAO.selectAll(imgadv);
    }
    
    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<Imgadv> selectList(Imgadv imgadv) {
        return this.imgadvDAO.selectList(imgadv);
    }
    
    /**
     * 新增数据
     *
     * @param imgadv 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Imgadv imgadv) {
        return this.imgadvDAO.insert(imgadv);
    }

    /**
     * 批量新增
     *
     * @param imgadvs 实例对象的集合
     * @return 生效的条数
     */
    @Override
    public int batchInsert(List<Imgadv> imgadvs) {
        return this.imgadvDAO.batchInsert(imgadvs);
    }

    /**
     * 修改数据
     *
     * @param imgadv 实例对象
     * @return 实例对象
     */
    @Override
    public Imgadv update(Imgadv imgadv) {
        this.imgadvDAO.update(imgadv);
        return this.selectById(imgadv.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer id) {
        return this.imgadvDAO.deleteById(id);
    }
    
    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    @Override
    public int count(){
        return this.imgadvDAO.count();
    }
}


