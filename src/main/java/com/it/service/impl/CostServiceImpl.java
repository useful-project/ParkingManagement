package com.it.service.impl;

import com.it.entity.Cost;
import com.it.dao.CostDAO;
import com.it.service.CostService;
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
 * (Cost表)服务实现类
 *
 * @author makejava
 * @since 2023-02-14 09:46:11
 */
@Service("costService")
public class CostServiceImpl implements CostService {
    @Resource
    private CostDAO costDAO;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Cost selectById(Integer id) {
        return this.costDAO.selectById(id);
    }

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public PageResult selectPage(int start, int limit, Cost cost) {
        PageRequest pageRequest=new PageRequest(start,limit);
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest,cost));
    }

    /**
     * 调用分页插件完成分页
     * @param pageRequest
     * @return
     */
    private PageInfo<Cost> getPageInfo(PageRequest pageRequest, Cost cost) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Cost> costs = this.costDAO.selectList(cost);
        return new PageInfo<>(costs);
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
    @Override
    public List<Cost> selectAll( Cost cost) {
        return this.costDAO.selectAll(cost);
    }
    
    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<Cost> selectList(Cost cost) {
        return this.costDAO.selectList(cost);
    }
    
    /**
     * 新增数据
     *
     * @param cost 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Cost cost) {
        return this.costDAO.insert(cost);
    }

    /**
     * 批量新增
     *
     * @param costs 实例对象的集合
     * @return 生效的条数
     */
    @Override
    public int batchInsert(List<Cost> costs) {
        return this.costDAO.batchInsert(costs);
    }

    /**
     * 修改数据
     *
     * @param cost 实例对象
     * @return 实例对象
     */
    @Override
    public Cost update(Cost cost) {
        this.costDAO.update(cost);
        return this.selectById(cost.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer id) {
        return this.costDAO.deleteById(id);
    }
    
    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    @Override
    public int count(){
        return this.costDAO.count();
    }
}


