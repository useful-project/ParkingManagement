package com.it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


//后端
@Controller
@RequestMapping(value = "admin")
public class VisitController {

    /**
     * 后台跳转到登录页面
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String toLogin() {
        return "admin/login";
    }

    /**
     * 后台跳转到首页
     */
    @RequestMapping(value = "toIndex", method = RequestMethod.GET)
    public String toIndex() {
        return "admin/index";
    }

    /**
     * 后台js加载top
     */
    @RequestMapping(value = "toTop", method = RequestMethod.GET)
    public String toTop() {
        return "admin/top";
    }

    /**
     * 后台iframe里加载main
     */
    @RequestMapping(value = "toMain", method = RequestMethod.GET)
    public String toMain() {
        return "admin/main";
    }


    /**
     * TO跳转到管理员列表页面
     */
    @RequestMapping(value = "toUserList", method = RequestMethod.GET)
    public String toUserList() {
        return "admin/userlist";
    }


    /**
     * TO跳转到管理员新增页面
     */
    @RequestMapping(value = "toUserAdd", method = RequestMethod.GET)
    public String toUserAdd() {
        return "admin/useradd";
    }

    /**
     * TO跳转到管理员编辑页面
     */
    @RequestMapping(value = "toUserEdit", method = RequestMethod.GET)
    public String toUserEdit() {
        return "admin/useredit";
    }


    /**
     * 后台跳转到个人信息
     */
    @RequestMapping(value = "toEditUser", method = RequestMethod.GET)
    public String toEditUser() {
        return "admin/edituser";
    }

    /**
     * 后台跳转到个人信息
     */
    @RequestMapping(value = "toEditShop", method = RequestMethod.GET)
    public String toEditShop() {
        return "admin/editshop";
    }

    /**
     * 后台跳转到修改密码
     */
    @RequestMapping(value = "toEditUpass", method = RequestMethod.GET)
    public String toEditUpass() {
        return "admin/editupass";
    }


    /**
     * 后台跳转到注册用户列表
     */
    @RequestMapping(value = "toMemberList", method = RequestMethod.GET)
    public String toMemberList() {
        return "admin/memberlist";
    }


    /**
     * TO焦点图管理页面
     *
     * @return
     */
    @RequestMapping(value = "toImgadvList", method = RequestMethod.GET)
    public String toImgadvList() {
        return "admin/imgadvlist";
    }


    /**
     * TO焦点图新增页面
     *
     * @return
     */
    @RequestMapping(value = "toImgadvAdd", method = RequestMethod.GET)
    public String toImgadvAdd() {
        return "admin/imgadvadd";
    }

    /**
     * TO焦点图编辑页面
     *
     * @return
     */
    @RequestMapping(value = "toImgadvEdit", method = RequestMethod.GET)
    public String toImgadvEdit() {
        return "admin/imgadvedit";
    }

    /**
     * to留言管理页面
     *
     * @return
     */
    @RequestMapping(value = "toMessageList", method = RequestMethod.GET)
    public String toMessageList() {
        return "admin/messagelist";
    }

    /**
     * to留言回复页面
     *
     * @return
     */
    @RequestMapping(value = "toMessageEdit", method = RequestMethod.GET)
    public String toMessageEdit() {
        return "admin/messageedit";
    }


    /**
     * to公告列表页面
     *
     * @return
     */
    @RequestMapping(value = "toNewsList", method = RequestMethod.GET)
    public String toNewsList() {
        return "admin/newslist";
    }

    /**
     * to公告新增页面
     *
     * @return
     */
    @RequestMapping(value = "toNewsAdd", method = RequestMethod.GET)
    public String toNewsAdd() {
        return "admin/newsadd";
    }

    /**
     * to公告编辑页面
     *
     * @return
     */
    @RequestMapping(value = "toNewsEdit", method = RequestMethod.GET)
    public String toNewsEdit() {
        return "admin/newsedit";
    }


    /**
     * to区域列表页面
     *
     * @return
     */
    @RequestMapping(value = "toCategoryList", method = RequestMethod.GET)
    public String toCategoryList() {
        return "admin/categorylist";
    }

    /**
     * to区域新增页面
     *
     * @return
     */
    @RequestMapping(value = "toCategoryAdd", method = RequestMethod.GET)
    public String toCategoryAdd() {
        return "admin/categoryadd";
    }

    /**
     * to区域编辑页面
     *
     * @return
     */
    @RequestMapping(value = "toCategoryEdit", method = RequestMethod.GET)
    public String toCategoryEdit() {
        return "admin/categoryedit";
    }


    /**
     * TO车位管理页面
     *
     * @return
     */
    @RequestMapping(value = "toCarportList", method = RequestMethod.GET)
    public String toCarportList() {
        return "admin/carportlist";
    }


    /**
     * TO车位新增页面
     *
     * @return
     */
    @RequestMapping(value = "toCarportAdd", method = RequestMethod.GET)
    public String toCarportAdd() {
        return "admin/carportadd";
    }


    /**
     * TO价格管理页面
     *
     * @return
     */
    @RequestMapping(value = "toCostEdit", method = RequestMethod.GET)
    public String toCostEdit() {
        return "admin/costedit";
    }



    /**
     * TO停车记录管理页面
     *
     * @return
     */
    @RequestMapping(value = "toStoprecordList", method = RequestMethod.GET)
    public String toStoprecordList() {
        return "admin/stoprecordlist";
    }


    /**
     * TO网站设置
     *
     * @return
     */
    @RequestMapping(value = "toSiteEdit", method = RequestMethod.GET)

    public String toSiteEdit() {
        return "admin/siteedit";
    }



    /**
     * TO 统计分析
     *
     * @return
     */
    @RequestMapping(value = "toTj", method = RequestMethod.GET)

    public String toTj() {
        return "admin/tj";
    }




}
