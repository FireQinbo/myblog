package com.qb.myblog.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @author qinb
 * @date 2021/5/20 10:48
 */
@Data
@ApiModel("登录用户对象")
public class LoginUser implements Serializable {
    private String id;
    private String userName;
    private String password;
    private String mobile;
}
