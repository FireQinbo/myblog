package com.qb.myblog.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author qinb
 * @date 2021/4/6 18:01
 */
@Data
@ApiModel(value = "接口返回对象", description = "接口返回对象")
public class ResultVo<T> implements Serializable {
    /**
     * 成功标志
     */
    @ApiModelProperty(value = "成功标志(true:成功，false:失败)")
    private boolean success = true;

    /**
     * 返回处理消息
     */
    @ApiModelProperty(value = "返回消息")
    private String message = "操作成功！";

    /**
     * 返回代码
     */
    @ApiModelProperty(value = "返回代码(1:成功，0:失败)")
    private Integer code = 1;

    /**
     * 返回数据对象 data
     */
    @ApiModelProperty(value = "返回数据对象")
    private T result;

    /**
     * 返回成功数据
     *
     * @param message
     * @param t
     * @return
     */
    public ResultVo<T> success(String message, T t) {
        this.success = true;
        this.code = 1;
        this.message = message;
        this.result = t;
        return this;
    }

    /**
     * 返回失败数据
     *
     * @param message
     * @param t
     * @return
     */
    public ResultVo<T> failure(String message, T t) {
        this.success = false;
        this.code = 0;
        this.message = message;
        this.result = t;
        return this;
    }
}
