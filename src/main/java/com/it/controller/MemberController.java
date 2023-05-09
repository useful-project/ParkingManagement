package com.it.controller;

import com.it.entity.Loginip;
import com.it.entity.Member;
import com.it.entity.Site;
import com.it.service.LoginipService;
import com.it.service.MemberService;
import com.it.service.SiteService;
import com.it.util.Info;
import org.springframework.web.bind.annotation.*;
import com.it.common.ReturnData;
import com.it.common.page.PageResult;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * (Member)控制层
 *
 * @author makejava
 * @since 2022-12-16 20:51:49
 */
@RestController
@RequestMapping("/member")
public class MemberController {
    /**
     * 服务对象
     */
    @Resource
    private MemberService memberService;
    @Resource
    private UtilController utilController;
    @Resource
    private LoginipService loginipService;
    @Resource
    private SiteService siteService;

    /**
     * 通过主键查询单条数据
     *
     * @param member 参数对象
     * @return 单条数据
     */
    @RequestMapping(value = "get", method = RequestMethod.POST)
    public ReturnData<Member> selectOne(Member member) {
        Member result = memberService.selectById(member.getId());
        if(result != null){
            return ReturnData.GET_SUCCESS(result);
        }
        return ReturnData.GET_FAIL();
    }
    
    /**
     * 新增一条数据
     *
     * @param member 实体类
     * @return Response对象
     */
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public ReturnData<Member> insert(Member member) {
        int result = memberService.insert(member);
        if (result > 0) {
            return ReturnData.ADD_SUCCESS();
        }
        return ReturnData.ADD_FAIL();
    }

    /**
     * 修改一条数据
     *
     * @param member 实体类
     * @return Response对象
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ReturnData<Member> update(Member member) {
        Member result = memberService.update(member);
        if (result != null) {
            return ReturnData.UPDATE_SUCCESS(result);
        }
        return ReturnData.UPDATE_FAIL();
    }


    /**
     * 充值
     * @param member
     * @return
     */
    @RequestMapping(value = "chongZhi", method = RequestMethod.POST)
    public ReturnData<Member> chongZhi(Member member) {
        Member member1 = memberService.selectById(member.getId());
        member1.setWallet(member1.getWallet()+member.getWallet());
        Member result = memberService.update(member1);
        if (result != null) {
            return ReturnData.UPDATE_SUCCESS(result);
        }
        return ReturnData.UPDATE_FAIL();
    }

    /**
     * 修改密码
     *
     * @return Response对象
     */
    @RequestMapping(value = "updateUpass", method = RequestMethod.POST)
    public ReturnData<Member> updateUpass(Integer id,String upass,String newsupass) {
        Member member = memberService.selectById(id);
        if(member.getUpass().equals(upass)){
            member.setUpass(newsupass);
            Member result = memberService.update(member);
            return ReturnData.UPDATE_SUCCESS(result);
        }
        return ReturnData.UPDATE_FAIL();
    }

    /**
     * 删除一条数据
     *
     * @param member 参数对象
     * @return Response对象
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public ReturnData<Member> delete(Member member) {
        int result = memberService.deleteById(member.getId());
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
    public ReturnData<List<Member>> selectAll(Member member) {
        List<Member> members = memberService.selectList(member);
        if (members != null) {
            return ReturnData.GET_SUCCESS(members);
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
    public ReturnData<PageResult> selectPage(Integer start, Integer limit, Member member) {
        PageResult pageResult = memberService.selectPage(start, limit, member);
        if (pageResult != null) {
            return ReturnData.GET_SUCCESS(pageResult);
        }
        return ReturnData.GET_FAIL();
    }


    /**
     * 登录
     *
     * @param member 实体类
     * @return Response对象
     */
    @RequestMapping(value = "Login", method = RequestMethod.POST)
    public HashMap<String,Object> Login(Member member, HttpServletRequest request) {
        HashMap<String,Object> res = new HashMap<>();
        List<Member> members = memberService.selectList(member);

        if (members.size()!=0) {
            Member member1 = members.get(0);
            if(member1.getAudit().equals("已通过")){

                if(member1.getStatus().equals("正常")){
                    request.getSession().setAttribute("sessionmember", members.get(0));
                    Loginip loginip = new Loginip();
                    loginip.setAddr(utilController.getIpAddr(request));
                    loginip.setSavetime(Info.getDateStr());
                    loginip.setName(members.get(0).getTname());
                    String content = "用户【"+members.get(0).getTname()+"】于"+ Info.getDateStr()+"登录系统！";
                    loginip.setContent(content);
                    loginipService.insert(loginip);
                    res.put("data",200 );
                }else{
                    res.put("data",500 );//账号冻结
                }
            }else{
                res.put("data",300 );//未通过审核
            }
        }else{
            res.put("data",400 );//用户名或密码错误

        }
        return res;
    }

    /**
     * 验证是否登录
     * @return
     */
    @RequestMapping(value = "checkLogin", method = RequestMethod.POST)
    public ReturnData<Member> checkLogin(HttpServletRequest request) {
        Member sessionmember = (Member)request.getSession().getAttribute("sessionmember");
        if(sessionmember != null){
            Member member = memberService.selectById(sessionmember.getId());
            return ReturnData.GET_SUCCESS(member);
        }
        return ReturnData.GET_FAIL();
    }

    /**
     * 注销
     * @param request
     */
    @RequestMapping(value = "LogOut", method = RequestMethod.POST)
    public void LogOut(HttpServletRequest request) {
        Member sessionmember = (Member)request.getSession().getAttribute("sessionmember");
        if(sessionmember!=null){
            Loginip loginip = new Loginip();
            loginip.setAddr(utilController.getIpAddr(request));
            loginip.setSavetime(Info.getDateStr());
            loginip.setName(sessionmember.getTname());
            String content = "用户【"+sessionmember.getTname()+"】于"+ Info.getDateStr()+"登录系统！";
            loginip.setContent(content);
            loginipService.insert(loginip);
        }
        request.getSession().removeAttribute("sessionmember");
    }


}


