package com.it.entity;
 

import java.io.Serializable;
import lombok.Data;
/**
 * (Site)实体类
 *
 * @author makejava
 * @since 2023-02-11 20:48:59
 */
@Data
public class Site implements Serializable {
    private static final long serialVersionUID = -19891355879378868L;
     
    private Integer id;
    /**
    * 网站商标
    */ 
    private String filename;
    /**
    * 站点名称
    */ 
    private String name;
    /**
    * 站点版权
    */ 
    private String copyright;
 
 
}
