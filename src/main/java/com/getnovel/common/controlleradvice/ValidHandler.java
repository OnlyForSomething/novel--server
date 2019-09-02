package com.getnovel.common.controlleradvice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 处理@valid或者@Validated验证不通过时的异常
 */
@ControllerAdvice
@ResponseBody
public class ValidHandler extends HandlerInterceptorAdapter{
    private static final Logger logger = LoggerFactory.getLogger(Validated.class);
    @ResponseStatus(value = HttpStatus.BAD_REQUEST) //400
    @ExceptionHandler(value=MethodArgumentNotValidException.class)
    public Map<String,Object> handleValidtionExc(MethodArgumentNotValidException e){
        StringBuffer buffer = new StringBuffer();
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        for (ObjectError error : errors){
            buffer.append(error.getDefaultMessage()).append("\n");
        }
        Map<String,Object> result =new HashMap<>();
        result.put("code",400);
        result.put("msg",buffer.toString());
        logger.error("请求参数有误：" + errors.toString());
        return  result;
    }
}
