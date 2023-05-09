package com.it.controller;

import com.it.entity.Loginip;
import com.it.entity.User;
import com.it.service.LoginipService;
import com.it.service.UserService;
import com.it.util.Info;
import org.springframework.web.bind.annotation.*;
import com.it.common.ReturnData;
import com.it.common.page.PageResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * (User)控制层
 *
 * @author makejava
 * @since 2022-09-28 15:37:03
 */
@RestController
@RequestMapping("/admin/user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;
    @Resource
    private UtilController utilController;
    @Resource
    private LoginipService loginipService;


    /**
     * 通过主键查询单条数据
     *
     * @param user 参数对象
     * @return 单条数据
     */
    @RequestMapping(value = "get", method = RequestMethod.POST)
    public ReturnData<User> selectOne(User user) {
        User result = userService.selectById(user.getId());
        if (result != null) {
            return ReturnData.GET_SUCCESS(result);
        }
        return ReturnData.GET_FAIL();
    }

    /**
     * 新增一条数据
     *
     * @param user 实体类
     * @return Response对象
     */
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public ReturnData<User> insert(User user) {
        int result = userService.insert(user);
        if (result > 0) {
            return ReturnData.ADD_SUCCESS();
        }
        return ReturnData.ADD_FAIL();
    }

    /**
     * 修改一条数据
     *
     * @param user 实体类
     * @return Response对象
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ReturnData<User> update(User user) {
        User result = userService.update(user);
        if (result != null) {
            return ReturnData.UPDATE_SUCCESS(result);
        }
        return ReturnData.UPDATE_FAIL();
    }

    /**
     * 删除一条数据
     *
     * @param user 参数对象
     * @return Response对象
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public ReturnData<User> delete(User user) {
        int result = userService.deleteById(user.getId());
        if (result > 0) {
            return ReturnData.DELETE_SUCCESS();
        }
        return ReturnData.DELETE_FAIL();
    }


    /**
     * 删除一条数据学生
     *
     * @param user 参数对象
     * @return Response对象
     */
    @RequestMapping(value = "deleteStudent", method = RequestMethod.POST)
    public ReturnData<User> deleteStudent(User user) {
        int result = userService.deleteById(user.getId());
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
    public ReturnData<List<User>> selectAll(User user) {
        List<User> users = userService.selectList(user);
        if (users != null) {
            return ReturnData.GET_SUCCESS(users);
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
    public ReturnData<PageResult> selectPage(Integer start, Integer limit, User user) {
        PageResult pageResult = userService.selectPage(start, limit, user);
        if (pageResult != null) {
            return ReturnData.GET_SUCCESS(pageResult);
        }
        return ReturnData.GET_FAIL();
    }


    /**
     * 登录
     *
     * @param user
     * @param request
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ReturnData<List<User>> login(User user, HttpServletRequest request) {
        List<User> users = userService.selectList(user);
        if(users.size()==0){
            return ReturnData.GET_FAIL();
        }else{
            Loginip loginip = new Loginip();
            loginip.setAddr(utilController.getIpAddr(request));
            loginip.setSavetime(Info.getDateStr());
            loginip.setName(users.get(0).getTname());
            String content = "用户【" + users.get(0).getTname() + "】于" + Info.getDateStr() + "登录系统！";
            loginip.setContent(content);
            loginipService.insert(loginip);
            request.getSession().setAttribute("admin",users.get(0));
            return ReturnData.GET_SUCCESS(users);
        }
    }

    /**
     * 退出
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "loginout", method = RequestMethod.POST)
    public HashMap<String, Object> loginout(HttpServletRequest request) {
        HashMap<String, Object> res = new HashMap<>();
        User admin = (User) request.getSession().getAttribute("admin");
        if (admin == null) {
        } else {
            Loginip loginip = new Loginip();
            loginip.setAddr(utilController.getIpAddr(request));
            loginip.setSavetime(Info.getDateStr());
            loginip.setName(admin.getTname());
            String content = "用户【" + admin.getTname() + "】于" + Info.getDateStr() + "退出系统！";
            loginip.setContent(content);
            loginipService.insert(loginip);
        }
        request.getSession().removeAttribute("admin");
        res.put("data", 200);
        return res;
    }


    /**
     * 验证登录名
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "checkUser", method = RequestMethod.POST)
    public ReturnData<List<User>> checkUser(User user) {
        List<User> users = userService.selectList(user);
        if (users != null) {
            return ReturnData.GET_SUCCESS(users);
        }
        return ReturnData.GET_FAIL();
    }


    /**
     * 验证用户是否登录
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "checkLogin", method = RequestMethod.POST)
    public ReturnData<User> checkLogin(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("admin");
        if (user != null) {
            User admin = userService.selectById(user.getId());
            return ReturnData.GET_SUCCESS(admin);
        }
        return ReturnData.GET_FAIL();
    }


    /**
     * 修改密码
     *
     * @param upass
     * @param newsupass
     * @param request
     * @return
     */
    @RequestMapping(value = "editupass", method = RequestMethod.POST)
    public ReturnData<User> editupass(String upass, String newsupass, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("admin");
        User admin = userService.selectById(user.getId());
        if (admin.getUpass().equals(upass)) {
            admin.setUpass(newsupass);
            userService.update(admin);
            return ReturnData.GET_SUCCESS(admin);

        }
        return ReturnData.GET_FAIL();
    }

}


