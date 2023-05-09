package com.it.controller;

import com.it.entity.Imgadv;
import com.it.service.ImgadvService;
import org.springframework.web.bind.annotation.*;
import com.it.common.ReturnData;
import com.it.common.page.PageResult;
import java.util.List;

import javax.annotation.Resource;

/**
 * (Imgadv)控制层
 *
 * @author makejava
 * @since 2023-02-09 16:07:04
 */
@RestController
@RequestMapping("/imgadv")
public class ImgadvController {
    /**
     * 服务对象
     */
    @Resource
    private ImgadvService imgadvService;

    /**
     * 通过主键查询单条数据
     *
     * @param imgadv 参数对象
     * @return 单条数据
     */
    @RequestMapping(value = "get", method = RequestMethod.POST)
    public ReturnData<Imgadv> selectOne(Imgadv imgadv) {
        Imgadv result = imgadvService.selectById(imgadv.getId());
        if(result != null){
            return ReturnData.GET_SUCCESS(result);
        }
        return ReturnData.GET_FAIL();
    }
    
    /**
     * 新增一条数据
     *
     * @param imgadv 实体类
     * @return Response对象
     */
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public ReturnData<Imgadv> insert(Imgadv imgadv) {
        int result = imgadvService.insert(imgadv);
        if (result > 0) {
            return ReturnData.ADD_SUCCESS();
        }
        return ReturnData.ADD_FAIL();
    }

    /**
     * 修改一条数据
     *
     * @param imgadv 实体类
     * @return Response对象
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ReturnData<Imgadv> update(Imgadv imgadv) {
        Imgadv result = imgadvService.update(imgadv);
        if (result != null) {
            return ReturnData.UPDATE_SUCCESS(result);
        }
        return ReturnData.UPDATE_FAIL();
    }

    /**
     * 删除一条数据
     *
     * @param imgadv 参数对象
     * @return Response对象
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public ReturnData<Imgadv> delete(Imgadv imgadv) {
        int result = imgadvService.deleteById(imgadv.getId());
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
    public ReturnData<List<Imgadv>> selectAll(Imgadv imgadv) {
        List<Imgadv> imgadvs = imgadvService.selectList(imgadv);
        if (imgadvs != null) {
            return ReturnData.GET_SUCCESS(imgadvs);
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
    public ReturnData<PageResult> selectPage(Integer start, Integer limit, Imgadv imgadv) {
        PageResult pageResult = imgadvService.selectPage(start, limit, imgadv);
        if (pageResult != null) {
            return ReturnData.GET_SUCCESS(pageResult);
        }
        return ReturnData.GET_FAIL();
    }
    
}


