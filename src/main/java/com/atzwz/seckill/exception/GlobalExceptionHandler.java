package com.atzwz.seckill.exception;

import com.atzwz.seckill.vo.RespBean;
import com.atzwz.seckill.vo.RespBeanEnum;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/*
全局异常处理类
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public RespBean exceptionHandler(Exception e){
        if (e instanceof GlobalException){
            GlobalException ex=(GlobalException) e;
            return RespBean.error(ex.getRespBeanEnum());
        } else if (e instanceof BindException) {
           BindException ex=  (BindException) e;
            RespBean respBean = RespBean.error(RespBeanEnum.BIND_ERROP);
            respBean.setMessage("参数校验异常："+ex.getAllErrors().get(0).getDefaultMessage());
            return respBean;
        }
        return RespBean.error(RespBeanEnum.ERROR);
    }
}
