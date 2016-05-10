package com.fjsaas.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fjsaas.shiro.exception.UnactivatedAccountException;

/**
 * 登录控制器
 * 
 * 
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Model model) {
        String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
        String error = null;
        if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
            error = "用户名或密码错误";
        } else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = "用户名或密码错误";
        } else if (ExcessiveAttemptsException.class.getName().equals(exceptionClassName)) {
            error = "重复尝试次数过多，请稍后再试";
        }else if(LockedAccountException.class.getName().equals(exceptionClassName)){
        	error = "用户已被锁定";
		} else if (UnactivatedAccountException.class.getName().equals(exceptionClassName)) {
            error = "用户未激活";
        }else if (exceptionClassName != null) {
            error = "其他错误：" + exceptionClassName;
        }
        model.addAttribute("error", error);
        if(request.getParameter("forceLogout") != null) {
            model.addAttribute("error", "您已经被管理员强制退出，请重新登录");
        }
         
        return "login";
    }
}
