package com.qb.myblog.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

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
    private LocalDateTime createTime;
    private String createBy;
    private LocalDateTime updateTime;
    private String updateBy;
}
