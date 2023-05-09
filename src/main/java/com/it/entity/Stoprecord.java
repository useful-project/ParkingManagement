package com.it.entity;
 

import java.io.Serializable;
import lombok.Data;
/**
 * (Stoprecord)实体类
 *
 * @author makejava
 * @since 2023-02-14 09:58:58
 */
@Data
public class Stoprecord implements Serializable {
    private static final long serialVersionUID = -29648091680760226L;
     
    private Integer id;
    /**
    * 订单号
    */ 
    private String ddno;
    /**
    * 注册用户ID
    */ 
    private Integer memberid;
    /**
    * 车位ID
    */ 
    private Integer carportid;
    /**
    * 车牌号
    */ 
    private String carno;
    /**
    * 进场时间
    */ 
    private String stime;
    /**
    * 离场时间
    */ 
    private String etime;
    /**
    * 时长
    */ 
    private Long longtime;
    /**
    * 停车费
    */ 
    private Double total;
    /**
    * 状态
    */ 
    private String status;


    /**
     * 区域
     */
    private Integer categoryid;


    /**
      搜索关键字
    */
    private String key;

    /**
     注册用户对象
     */
    private Member member;

    /**
     车位对象
     */
    private Carport carport;


 
}
