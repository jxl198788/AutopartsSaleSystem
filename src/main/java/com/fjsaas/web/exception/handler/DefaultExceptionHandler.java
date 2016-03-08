package com.fjsaas.web.exception.handler;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.NativeWebRequest;

import com.fjsaas.web.bean.JsonModel;
import com.fjsaas.web.exception.OperationNotAllowedException;

/**
 * 异常处理器
 * 
 * 
 */
@ControllerAdvice
public class DefaultExceptionHandler {

    /**
     * 没有权限异常
     * 
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler({ UnauthorizedException.class })
    @ResponseBody
    public JsonModel processUnauthenticatedException(NativeWebRequest request, UnauthorizedException e) {
        JsonModel json = new JsonModel();
        json.setSuccess(false);
        json.setStatus("exception");
        json.setMessage("没有权限 " + e.getMessage());
        json.setObj(e.getClass().getName());
        return json;
    }

    /**
     * 操作不允许
     * 
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler({ OperationNotAllowedException.class })
    @ResponseBody
    public JsonModel processOperationNotAllowedException(NativeWebRequest request, OperationNotAllowedException e) {
        JsonModel json = new JsonModel();
        json.setSuccess(false);
        json.setStatus("exception");
        json.setMessage("操作不允许 " + e.getMessage());
        json.setObj(e.getClass().getName());
        return json;
    }

}
