package com.qb.myblog.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @author qinb
 * @date 2021/5/20 11:01
 */
@Data
@ApiModel("登录/注册接口数据对象")
public class MbUserDto implements Serializable {
    @ApiModelProperty("用户名")
    @NotEmpty(message = "用户名不能为空")
    private String userName;

    @ApiModelProperty("密码")
    @NotEmpty(message = "密码不能为空")
    private String password;

    @ApiModelProperty("手机号")
    @NotEmpty(message = "手机号不能为空")
    private String mobile;
}
