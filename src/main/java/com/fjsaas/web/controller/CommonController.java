package com.fjsaas.web.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fjsaas.web.bean.User;
import com.fjsaas.web.utils.session.SessionProvider;

@Controller
public class CommonController {

	@RequestMapping("/index")
	public String toIndex(HttpServletResponse response){
		return "index";
	}
	
	@RequestMapping("/head")
	public String toHead(){
		return "head";
	}
	
	@RequestMapping("/nav")
	public String toNav(ModelMap model){
		User user = SessionProvider.getCurrentUser();
		model.addAttribute("user", user);
		return "nav";
	}
	
}
