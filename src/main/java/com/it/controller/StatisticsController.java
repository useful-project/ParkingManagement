package com.it.controller;
import com.it.entity.Carport;
import com.it.entity.Category;
import com.it.entity.Stoprecord;
import com.it.service.CarportService;
import com.it.service.CategoryService;
import com.it.service.StoprecordService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/statistics")

public class StatisticsController {

    @Resource
    StoprecordService stoprecordService;
    @Resource
    CategoryService categoryService;


    /**
     * 柱状图
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("tj1")
    public HashMap<String,Object> tj1(HttpServletRequest request) {
        HashMap<String,Object> res = new HashMap<String,Object>();
        List dataAxis = new ArrayList();
        List dataval = new ArrayList();
        List<Stoprecord> stoprecords = stoprecordService.tj1(null);
        for(Stoprecord stoprecord:stoprecords){
            dataAxis.add(stoprecord.getStime());
            dataval.add(stoprecord.getMemberid());
        }
        res.put("dataAxis", dataAxis);
        res.put("dataval", dataval);
        return res;
    }

    /**
     * 饼图
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("tj2")
    public HashMap<String, Object> tj2(HttpServletRequest request) {
        HashMap<String, Object> res = new HashMap<String, Object>();
        List dataAxis = new ArrayList();
        List dataval = new ArrayList();

        List<Category> categories = categoryService.selectAll(null);
        for (Category category : categories) {
            HashMap map1 = new HashMap();
            map1.put("name", category.getName());
            dataval.add(map1);

            Stoprecord stoprecord = new Stoprecord();
            stoprecord.setCategoryid(category.getId());
            List<Stoprecord> stoprecords = stoprecordService.selectList(stoprecord);
            map1.put("value", stoprecords.size());
        }
        res.put("dataAxis", dataAxis);
        res.put("dataval", dataval);
        return res;
    }



}
