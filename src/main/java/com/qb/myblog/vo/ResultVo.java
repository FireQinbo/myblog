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
    private static final long serialVersionUID = 1L;
    /**
     * 返回代码
     */
    @ApiModelProperty(value = "返回代码(1:成功，0:失败)", position = 1)
    private Integer code = 1;

    /**
     * 成功标志
     */
    @ApiModelProperty(value = "成功标志(true:成功，false:失败)", position = 2)
    private boolean success = true;

    /**
     * 返回处理消息
     */
    @ApiModelProperty(value = "返回消息", position = 3)
    private String message = "操作成功！";

    /**
     * 返回数据对象 data
     */
    @ApiModelProperty(value = "返回数据对象", position = 4)
    private T result;

    /**
     * 返回成功数据
     *
     * @param message
     * @param data
     * @return
     */
    public static ResultVo<Object> success(String message, Object data) {
        ResultVo<Object> resultVo = new ResultVo<>();
        resultVo.setMessage(message);
        resultVo.setCode(1);
        resultVo.setSuccess(true);
        resultVo.setResult(data);
        return resultVo;
    }

    /**
     * 返回失败数据
     *
     * @param message
     * @param data
     * @return
     */
    public static ResultVo<Object> failure(String message, Object data) {
        ResultVo<Object> resultVo = new ResultVo<>();
        resultVo.setMessage(message);
        resultVo.setCode(0);
        resultVo.setSuccess(false);
        resultVo.setResult(data);
        return resultVo;
    }

    /*====================================分隔线=====================================*/
    @Data
    @ApiModel(value = "系统异常返回结果")
    public static class ExceptionResultVo<T>{
        /**
         * 返回代码
         */
        @ApiModelProperty(value = "返回代码(1:成功，0:失败)", position = 1)
        private Integer code = 1;

        /**
         * 成功标志
         */
        @ApiModelProperty(value = "成功标志(true:成功，false:失败)", position = 2)
        private boolean success = true;

        /**
         * 返回处理消息
         */
        @ApiModelProperty(value = "返回消息", position = 3)
        private String message = "操作成功！";

        /**
         * 返回数据对象 data
         */
        @ApiModelProperty(value = "返回数据对象", position = 4)
        private T result;

        @ApiModelProperty(value = "Exception", position = 5)
        private Exception e;

        /**
         * 异常结果
         * @param e
         * @param data
         * @return
         */
        public static ExceptionResultVo<Object> exception(Exception e, Object data) {
            ExceptionResultVo<Object> resultVo = new ExceptionResultVo<>();
            resultVo.setMessage("系统异常！");
            resultVo.setCode(0);
            resultVo.setSuccess(false);
            resultVo.setResult(data);
            resultVo.setE(e);
            return resultVo;
        }
    }
}
