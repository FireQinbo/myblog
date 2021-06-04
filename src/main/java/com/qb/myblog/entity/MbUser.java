package com.qb.myblog.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author qinb
 * @date 2021/4/2 15:43
 */
@Data
public class MbUser implements Serializable {
    private String id;
    private String userName;
    private String password;
    private String mobile;
    private String salt;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private String createBy;
    private Date updateTime;
    private String updateBy;
}
