package com.qb.myblog.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * 角色-权限表
 * </p>
 *
 * @author qinbo
 * @since 2021-05-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="MbRolePermission对象", description="角色-权限表")
public class MbRolePermission implements Serializable {

    private static final long serialVersionUID=1L;

      private String id;

    @ApiModelProperty(value = "角色id")
    private String roleId;

    @ApiModelProperty(value = "权限id")
    private String permissionId;

    @ApiModelProperty(value = "创建时间")
    private LocalDate createTime;

    @ApiModelProperty(value = "创建者")
    private String createBy;

    @ApiModelProperty(value = "更新时间")
    private LocalDate updateTime;

    @ApiModelProperty(value = "更新者")
    private String updateBy;


}
