package com.it.controller;

import com.it.entity.Cost;
import com.it.service.CostService;
import org.springframework.web.bind.annotation.*;
import com.it.common.ReturnData;
import com.it.common.page.PageResult;
import java.util.List;

import javax.annotation.Resource;

/**
 * (Cost)控制层
 *
 * @author makejava
 * @since 2023-02-14 09:46:11
 */
@RestController
@RequestMapping("/cost")
public class CostController {
    /**
     * 服务对象
     */
    @Resource
    private CostService costService;

    /**
     * 通过主键查询单条数据
     *
     * @param cost 参数对象
     * @return 单条数据
     */
    @RequestMapping(value = "get", method = RequestMethod.POST)
    public ReturnData<Cost> selectOne(Cost cost) {
        Cost result = costService.selectById(cost.getId());
        if(result != null){
            return ReturnData.GET_SUCCESS(result);
        }
        return ReturnData.GET_FAIL();
    }
    
    /**
     * 新增一条数据
     *
     * @param cost 实体类
     * @return Response对象
     */
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public ReturnData<Cost> insert(Cost cost) {
        int result = costService.insert(cost);
        if (result > 0) {
            return ReturnData.ADD_SUCCESS();
        }
        return ReturnData.ADD_FAIL();
    }

    /**
     * 修改一条数据
     *
     * @param cost 实体类
     * @return Response对象
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ReturnData<Cost> update(Cost cost) {
        Cost result = costService.update(cost);
        if (result != null) {
            return ReturnData.UPDATE_SUCCESS(result);
        }
        return ReturnData.UPDATE_FAIL();
    }

    /**
     * 删除一条数据
     *
     * @param cost 参数对象
     * @return Response对象
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public ReturnData<Cost> delete(Cost cost) {
        int result = costService.deleteById(cost.getId());
        if (result > 0) {
            return ReturnData.DELETE_SUCCESS();
        }
        return ReturnData.DELETE_FAIL();
    }

    /**
     * 查询全部
     *
     * @return Response对象
     */
    @RequestMapping(value = "selectAll", method = RequestMethod.POST)
    public ReturnData<List<Cost>> selectAll(Cost cost) {
        List<Cost> costs = costService.selectList(cost);
        if (costs != null) {
            return ReturnData.GET_SUCCESS(costs);
        }
        return ReturnData.GET_FAIL();
    }

    /**
     * 分页查询
     *
     * @param start 偏移
     * @param limit 条数
     * @return Response对象
     */
    @RequestMapping(value = "selectPage", method = RequestMethod.POST)
    public ReturnData<PageResult> selectPage(Integer start, Integer limit, Cost cost) {
        PageResult pageResult = costService.selectPage(start, limit, cost);
        if (pageResult != null) {
            return ReturnData.GET_SUCCESS(pageResult);
        }
        return ReturnData.GET_FAIL();
    }
    
}


