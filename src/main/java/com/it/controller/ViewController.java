package com.it.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//后端
@Controller
@RequestMapping(value = "member")
public class ViewController {
    /**
     * 后台跳转到登录页面
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String toIndex() {
        return "member/index";
    }

    /**
     * 加载顶部页面
     */
    @RequestMapping(value = "toTop", method = RequestMethod.GET)
    public String toTop() {
        return "member/top";
    }

    /**
     * 加载底部页面
     */
    @RequestMapping(value = "toFoot", method = RequestMethod.GET)
    public String toFoot() {
        return "member/foot";
    }


    /**
     * 去注册页面
     */
    @RequestMapping(value = "toReg", method = RequestMethod.GET)
    public String toReg() {
        return "member/register";
    }

    /**
     * 去登录页面
     */
    @RequestMapping(value = "toLogin", method = RequestMethod.GET)
    public String toLogin() {
        return "member/login";
    }


    /**
     * to公告列表页面
     */
    @RequestMapping(value = "toNewsList", method = RequestMethod.GET)
    public String toNewsList() {
        return "member/newslist";
    }

    /**
     * to公告详情列表页面
     */
    @RequestMapping(value = "toNewsDetails", method = RequestMethod.GET)
    public String toNewsDetails() {
        return "member/newsdetails";
    }


    /**
     * TO停车场页面
     */
    @RequestMapping(value = "toCarportList", method = RequestMethod.GET)
    public String toCarportList() {
        return "member/carportlist";
    }

    /**
     * TO充值页面
     */
    @RequestMapping(value = "toWalletList", method = RequestMethod.GET)
    public String toWalletList() {
        return "member/walletlist";
    }


    /**
     * TO历史订单页面
     */
    @RequestMapping(value = "toStoprecordList", method = RequestMethod.GET)
    public String toStoprecordList() {
        return "member/stoprecordlist";
    }


    /**
     * to留言页面
     */
    @RequestMapping(value = "toMessageList", method = RequestMethod.GET)
    public String toMessageList() {
        return "member/messagelist";
    }


    /**
     * TO个人信息页面
     */
    @RequestMapping(value = "toMemberEdit", method = RequestMethod.GET)
    public String toMemberEdit() {
        return "member/memberedit";
    }

    /**
     * TO修改密码页面
     */
    @RequestMapping(value = "toUpassEdit", method = RequestMethod.GET)
    public String toUpassEdit() {
        return "member/upassedit";
    }


}
