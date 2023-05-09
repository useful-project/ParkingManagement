package com.it.controller;

import com.it.entity.Loginip;
import com.it.service.LoginipService;
import org.springframework.web.bind.annotation.*;
import com.it.common.ReturnData;
import com.it.common.page.PageResult;

import java.util.List;

import javax.annotation.Resource;

/**
 * (Loginip)控制层
 *
 * @author makejava
 * @since 2022-10-15 23:08:59
 */
@RestController
@RequestMapping("/admin/loginip")
public class LoginipController {
    /**
     * 服务对象
     */
    @Resource
    private LoginipService loginipService;

    /**
     * 通过主键查询单条数据
     *
     * @param loginip 参数对象
     * @return 单条数据
     */
    @RequestMapping(value = "get", method = RequestMethod.POST)
    public ReturnData<Loginip> selectOne(Loginip loginip) {
        Loginip result = loginipService.selectById(loginip.getId());
        if (result != null) {
            return ReturnData.GET_SUCCESS(result);
        }
        return ReturnData.GET_FAIL();
    }

    /**
     * 新增一条数据
     *
     * @param loginip 实体类
     * @return Response对象
     */
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public ReturnData<Loginip> insert(Loginip loginip) {
        int result = loginipService.insert(loginip);
        if (result > 0) {
            return ReturnData.ADD_SUCCESS();
        }
        return ReturnData.ADD_FAIL();
    }

    /**
     * 修改一条数据
     *
     * @param loginip 实体类
     * @return Response对象
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ReturnData<Loginip> update(Loginip loginip) {
        Loginip result = loginipService.update(loginip);
        if (result != null) {
            return ReturnData.UPDATE_SUCCESS(result);
        }
        return ReturnData.UPDATE_FAIL();
    }

    /**
     * 删除一条数据
     *
     * @return Response对象
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public ReturnData<Loginip> delete() {
        List<Loginip> loginips = loginipService.selectAll(null);
        for (Loginip loginip : loginips) {
            loginipService.deleteById(loginip.getId());
        }
        return ReturnData.DELETE_SUCCESS();
    }

    /**
     * 查询全部
     *
     * @return Response对象
     */
    @RequestMapping(value = "selectAll", method = RequestMethod.POST)
    public ReturnData<List<Loginip>> selectAll(Loginip loginip) {
        List<Loginip> loginips = loginipService.selectAll(loginip);
        if (loginips != null) {
            return ReturnData.GET_SUCCESS(loginips);
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
    public ReturnData<PageResult> selectPage(Integer start, Integer limit, Loginip loginip) {
        PageResult pageResult = loginipService.selectPage(start, limit, loginip);
        if (pageResult != null) {
            return ReturnData.GET_SUCCESS(pageResult);
        }
        return ReturnData.GET_FAIL();
    }

}


