package com.it.controller;

import com.it.entity.Carport;
import com.it.entity.Cost;
import com.it.entity.Member;
import com.it.entity.Stoprecord;
import com.it.service.CarportService;
import com.it.service.CostService;
import com.it.service.MemberService;
import com.it.service.StoprecordService;
import com.it.util.CheckCode;
import com.it.util.Info;
import org.springframework.web.bind.annotation.*;
import com.it.common.ReturnData;
import com.it.common.page.PageResult;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

/**
 * (Stoprecord)控制层
 *
 * @author makejava
 * @since 2023-02-14 09:58:58
 */
@RestController
@RequestMapping("/stoprecord")
public class StoprecordController {
    /**
     * 服务对象
     */
    @Resource
    private StoprecordService stoprecordService;
    @Resource
    private CarportService carportService;
    @Resource
    private MemberService memberService;
    @Resource
    private CostService costService;


    /**
     * 通过主键查询单条数据
     *
     * @param stoprecord 参数对象
     * @return 单条数据
     */
    @RequestMapping(value = "get", method = RequestMethod.POST)
    public ReturnData<Stoprecord> selectOne(Stoprecord stoprecord) {
        Stoprecord result = stoprecordService.selectById(stoprecord.getId());
        if(result != null){
            return ReturnData.GET_SUCCESS(result);
        }
        return ReturnData.GET_FAIL();
    }
    
    /**
     * 新增一条数据
     *
     * @param stoprecord 实体类
     * @return Response对象
     */
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public ReturnData<Stoprecord> insert(Stoprecord stoprecord) {

        Stoprecord stoprecord1 = new Stoprecord();
        stoprecord1.setCarno(stoprecord.getCarno());
        stoprecord1.setStatus("在库");
        List<Stoprecord> stoprecords = stoprecordService.selectList(stoprecord1);
        if(stoprecords.size()==0){
            CheckCode cc = new CheckCode();
            String stime = Info.getDateStr();
            Carport carport = carportService.selectById(stoprecord.getCarportid());
            stoprecord.setDdno("T" + cc.getCheckCode());
            stoprecord.setStime(stime);
            stoprecord.setStatus("在库");
            stoprecord.setCategoryid(carport.getCategoryid());
            int result = stoprecordService.insert(stoprecord);

            Member member = memberService.selectById(stoprecord.getMemberid());
            String str = "<div><ul>" +
                    "<li><span>车牌号:"+stoprecord.getCarno()+"</span></li>" +
                    "<li><span>进场时间:"+stime+"</span></li>" +
                    "<li><span>车主:"+member.getTname()+"</span></li>" +
                    "<li><span>联系电话:"+member.getTel()+"</span></li>" +
                    "</ul></div>";

            carport.setStatus("满");
            carport.setContent(str);
            carportService.update(carport);
            return ReturnData.ADD_SUCCESS();
        }else{
            return ReturnData.ADD_FAIL();
        }
    }

    /**
     * 修改一条数据
     *
     * @param stoprecord 实体类
     * @return Response对象
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ReturnData<Stoprecord> update(Stoprecord stoprecord) {
        Stoprecord result = stoprecordService.update(stoprecord);
        if (result != null) {
            return ReturnData.UPDATE_SUCCESS(result);
        }
        return ReturnData.UPDATE_FAIL();
    }

    /**
     * 删除一条数据
     *
     * @param stoprecord 参数对象
     * @return Response对象
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public ReturnData<Stoprecord> delete(Stoprecord stoprecord) {
        int result = stoprecordService.deleteById(stoprecord.getId());
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
    public ReturnData<List<Stoprecord>> selectAll(Stoprecord stoprecord) {
        List<Stoprecord> stoprecords = stoprecordService.selectList(stoprecord);
        if (stoprecords != null) {
            return ReturnData.GET_SUCCESS(stoprecords);
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
    public ReturnData<PageResult> selectPage(Integer start, Integer limit, Stoprecord stoprecord) {
        PageResult pageResult = stoprecordService.selectPage(start, limit, stoprecord);
        if (pageResult != null) {
            return ReturnData.GET_SUCCESS(pageResult);
        }
        return ReturnData.GET_FAIL();
    }


    /**
     * 车辆离场
     * @param stoprecord
     * @return
     */
    @RequestMapping(value = "leaveStop", method = RequestMethod.POST)
    public HashMap<String,Object> leaveStop(Stoprecord stoprecord) {

        HashMap<String,Object> res = new HashMap<String,Object>();
        List<Stoprecord> stoprecords = stoprecordService.selectList(stoprecord);

        if(stoprecords.size()==0){
            res.put("data",400 );//不能操作别的车
        }else{
            Stoprecord stoprecord1 = stoprecords.get(0);
            long longtime = Info.getDatePoor(stoprecord1.getStime(), Info.getDateStr());
            Cost cost = costService.selectById(1);
            double total = cost.getPrice() * longtime;
            Member member = memberService.selectById(stoprecord.getMemberid());
            if(member.getWallet()>=total){
                //进入离场业务
                stoprecord1.setEtime(Info.getDateStr());
                stoprecord1.setLongtime(longtime);
                stoprecord1.setTotal(Double.parseDouble(String.format("%.2f", total)));
                stoprecord1.setStatus("交易完成");
                stoprecordService.update(stoprecord1);

                Carport carport = carportService.selectById(stoprecord.getCarportid());
                carport.setStatus("空");
                carport.setContent("");
                carportService.update(carport);

                member.setWallet(member.getWallet()-total);
                memberService.update(member);
                res.put("data",200 );
            }else{
                res.put("data",300 );//余额不足
            }

        }
        return res;
    }
}


