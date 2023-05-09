package com.it.controller;

import com.it.entity.Carport;
import com.it.service.CarportService;
import org.springframework.web.bind.annotation.*;
import com.it.common.ReturnData;
import com.it.common.page.PageResult;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * (Carport)控制层
 *
 * @author makejava
 * @since 2023-02-13 22:22:02
 */
@RestController
@RequestMapping("/carport")
public class CarportController {
    /**
     * 服务对象
     */
    @Resource
    private CarportService carportService;

    /**
     * 通过主键查询单条数据
     *
     * @param carport 参数对象
     * @return 单条数据
     */
    @RequestMapping(value = "get", method = RequestMethod.POST)
    public ReturnData<Carport> selectOne(Carport carport) {
        Carport result = carportService.selectById(carport.getId());
        if(result != null){
            return ReturnData.GET_SUCCESS(result);
        }
        return ReturnData.GET_FAIL();
    }
    


    //添加车位
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public HashMap<String, Object> insert(Carport carport,Integer num) {
        HashMap<String, Object> res = new HashMap<>();
        Carport carport1 = new Carport();
        carport1.setCategoryid(carport.getCategoryid());
        List<Carport> list = carportService.selectList(carport1);
        boolean flag = true;
        for(Carport carport2:list){
            if(!carport2.getStatus().equals("空")){
                flag = false;
                break;
            }
        }

        if(flag==true){

            for(Carport carport2:list){
                carportService.deleteById(carport2.getId());
            }

            for(int i=1;i<num+1;i++){
                Carport carport3 = new Carport();
                if(i<10){
                    carport3.setName("00"+i);
                }else{
                    carport3.setName("0"+i);
                }
                carport3.setCategoryid(carport.getCategoryid());
                carport3.setStatus("空");
                carportService.insert(carport3);
            }
            res.put("data", 200);
        }else{
            res.put("data", 400);
        }
        return res;
    }

    /**
     * 修改一条数据
     *
     * @param carport 实体类
     * @return Response对象
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ReturnData<Carport> update(Carport carport) {
        Carport result = carportService.update(carport);
        if (result != null) {
            return ReturnData.UPDATE_SUCCESS(result);
        }
        return ReturnData.UPDATE_FAIL();
    }

    /**
     * 删除一条数据
     *
     * @param carport 参数对象
     * @return Response对象
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public ReturnData<Carport> delete(Carport carport) {
        int result = carportService.deleteById(carport.getId());
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
    public ReturnData<List<Carport>> selectAll(Carport carport) {
        List<Carport> carports = carportService.selectList(carport);
        if (carports != null) {
            return ReturnData.GET_SUCCESS(carports);
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
    public ReturnData<PageResult> selectPage(Integer start, Integer limit, Carport carport) {
        PageResult pageResult = carportService.selectPage(start, limit, carport);
        if (pageResult != null) {
            return ReturnData.GET_SUCCESS(pageResult);
        }
        return ReturnData.GET_FAIL();
    }
    
}


