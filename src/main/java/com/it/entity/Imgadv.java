package com.it.entity;
 

import java.io.Serializable;
import lombok.Data;
/**
 * (Imgadv)实体类
 *
 * @author makejava
 * @since 2023-02-09 16:07:04
 */
@Data
public class Imgadv implements Serializable {
    private static final long serialVersionUID = -12920900241551238L;
     
    private Integer id;
    /**
    * 图片文件名
    */ 
    private String filename;
    /**
    * 链接地址
    */ 
    private String url;
 
 
}
