package com.it.service.impl;

import com.it.dao.CarportDAO;
import com.it.dao.MemberDAO;
import com.it.entity.Carport;
import com.it.entity.Member;
import com.it.entity.Stoprecord;
import com.it.dao.StoprecordDAO;
import com.it.service.StoprecordService;
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
 * (Stoprecord表)服务实现类
 *
 * @author makejava
 * @since 2023-02-14 09:58:58
 */
@Service("stoprecordService")
public class StoprecordServiceImpl implements StoprecordService {
    @Resource
    private StoprecordDAO stoprecordDAO;
    @Resource
    private MemberDAO memberDAO;
    @Resource
    private CarportDAO carportDAO;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Stoprecord selectById(Integer id) {
        return this.stoprecordDAO.selectById(id);
    }

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public PageResult selectPage(int start, int limit, Stoprecord stoprecord) {
        PageRequest pageRequest=new PageRequest(start,limit);
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest,stoprecord));
    }

    /**
     * 调用分页插件完成分页
     * @param pageRequest
     * @return
     */
    private PageInfo<Stoprecord> getPageInfo(PageRequest pageRequest, Stoprecord stoprecord) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Stoprecord> stoprecords = this.stoprecordDAO.selectList(stoprecord);
        for (Stoprecord stoprecord1 : stoprecords) {
            Member member = memberDAO.selectById(stoprecord1.getMemberid());
            Carport carport = carportDAO.selectById(stoprecord1.getCarportid());
            stoprecord1.setMember(member);
            stoprecord1.setCarport(carport);
        }
        return new PageInfo<>(stoprecords);
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
    @Override
    public List<Stoprecord> selectAll( Stoprecord stoprecord) {
        return this.stoprecordDAO.selectAll(stoprecord);
    }



    /**
     * 统计
     *
     * @return 实例对象的集合
     */
    @Override
    public List<Stoprecord> tj1( Stoprecord stoprecord) {
        return this.stoprecordDAO.tj1(stoprecord);
    }
    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<Stoprecord> selectList(Stoprecord stoprecord) {
        return this.stoprecordDAO.selectList(stoprecord);
    }
    
    /**
     * 新增数据
     *
     * @param stoprecord 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Stoprecord stoprecord) {
        return this.stoprecordDAO.insert(stoprecord);
    }

    /**
     * 批量新增
     *
     * @param stoprecords 实例对象的集合
     * @return 生效的条数
     */
    @Override
    public int batchInsert(List<Stoprecord> stoprecords) {
        return this.stoprecordDAO.batchInsert(stoprecords);
    }

    /**
     * 修改数据
     *
     * @param stoprecord 实例对象
     * @return 实例对象
     */
    @Override
    public Stoprecord update(Stoprecord stoprecord) {
        this.stoprecordDAO.update(stoprecord);
        return this.selectById(stoprecord.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer id) {
        return this.stoprecordDAO.deleteById(id);
    }
    
    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    @Override
    public int count(){
        return this.stoprecordDAO.count();
    }
}


