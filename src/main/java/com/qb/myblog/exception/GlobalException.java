package com.qb.myblog.exception;

import com.qb.myblog.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.List;

/**
 * @author qinb
 * @date 2021/4/30 10:36
 */
@RestControllerAdvice
@Slf4j
public class GlobalException extends RuntimeException{
    @ExceptionHandler(Exception.class)
    public ResultVo<T> handleException(Exception e) {
        log.error(e.getMessage(), e);
        return new ResultVo().failure("Exception异常", e.getMessage());
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResultVo<T> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
//        BindingResult exceptions = e.getBindingResult();
//        // 判断异常中是否有错误信息，如果存在就使用异常中的消息，否则使用默认消息
//        if (exceptions.hasErrors()) {
//            List<ObjectError> errors = exceptions.getAllErrors();
//            if (!errors.isEmpty()) {
//                // 这里列出了全部错误参数，按正常逻辑，只需要第一条错误即可
//                FieldError fieldError = (FieldError) errors.get(0);
//                return new ResultVo().failure("ConstraintViolationException",fieldError.getDefaultMessage());
//            }
//        }
//
//        return null;
//    }
}
