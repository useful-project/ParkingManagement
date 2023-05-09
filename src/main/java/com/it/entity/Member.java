package com.it.entity;
 

import java.io.Serializable;
import lombok.Data;
/**
 * (Member)实体类
 *
 * @author makejava
 * @since 2022-12-16 20:51:51
 */
@Data
public class Member implements Serializable {
    private static final long serialVersionUID = 471291193267878432L;
     
    private Integer id;
    /**
    * 用户名
    */ 
    private String uname;
    /**
    * 密码
    */ 
    private String upass;
    /**
    * 姓名
    */ 
    private String tname;
    /**
    * 图片文件名
    */ 
    private String filename;
    /**
    * 电话
    */ 
    private String tel;

    /**
     * 审核状态
     */
    private String audit;

    /**
     * 冻结状态
     */
    private String status;


    /**
     * 余额
     */
    private Double wallet;

    /**
     * 搜索关键字
     */
    private String key;


 
}
