package com.it.service.impl;

import com.it.dao.CategoryDAO;
import com.it.entity.Carport;
import com.it.dao.CarportDAO;
import com.it.entity.Category;
import com.it.service.CarportService;
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
 * (Carport表)服务实现类
 *
 * @author makejava
 * @since 2023-02-13 22:22:02
 */
@Service("carportService")
public class CarportServiceImpl implements CarportService {
    @Resource
    private CarportDAO carportDAO;
    @Resource
    private CategoryDAO categoryDAO;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Carport selectById(Integer id) {
        return this.carportDAO.selectById(id);
    }

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public PageResult selectPage(int start, int limit, Carport carport) {
        PageRequest pageRequest=new PageRequest(start,limit);
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest,carport));
    }

    /**
     * 调用分页插件完成分页
     * @param pageRequest
     * @return
     */
    private PageInfo<Carport> getPageInfo(PageRequest pageRequest, Carport carport) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Carport> carports = this.carportDAO.selectList(carport);
        for (Carport carport1 : carports) {
            Category category = categoryDAO.selectById(carport1.getCategoryid());
            carport1.setCategory(category);
        }
        return new PageInfo<>(carports);
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
    @Override
    public List<Carport> selectAll( Carport carport) {
        return this.carportDAO.selectAll(carport);
    }
    
    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<Carport> selectList(Carport carport) {
        return this.carportDAO.selectList(carport);
    }
    
    /**
     * 新增数据
     *
     * @param carport 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Carport carport) {
        return this.carportDAO.insert(carport);
    }

    /**
     * 批量新增
     *
     * @param carports 实例对象的集合
     * @return 生效的条数
     */
    @Override
    public int batchInsert(List<Carport> carports) {
        return this.carportDAO.batchInsert(carports);
    }

    /**
     * 修改数据
     *
     * @param carport 实例对象
     * @return 实例对象
     */
    @Override
    public Carport update(Carport carport) {
        this.carportDAO.update(carport);
        return this.selectById(carport.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer id) {
        return this.carportDAO.deleteById(id);
    }
    
    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    @Override
    public int count(){
        return this.carportDAO.count();
    }
}


