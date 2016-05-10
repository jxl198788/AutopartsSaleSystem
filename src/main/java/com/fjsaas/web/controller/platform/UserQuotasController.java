/*
 * 类作用 平台的供应商管理页面的功能实现
 * author lyn
 * createTime 2016-04-20 
 * version 0.1
 */
package com.fjsaas.web.controller.platform;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;
import com.fjsaas.web.bean.Quota;
import com.fjsaas.web.bean.UserQuotas;
import com.fjsaas.web.query.QuotaQuery;
import com.fjsaas.web.service.QuotaService;
import com.fjsaas.web.utils.ResponseUtils;

@Controller
@RequestMapping("/platform/")
public class UserQuotasController {
	@Autowired
	private QuotaService quotaService;
	
	@RequestMapping("getUserQuotasList")//查询所有的供应商信息，用于页面表格展示
	public String getUserQuotasList(ModelMap model,HttpServletRequest request){
		QuotaQuery quotaQuery = new QuotaQuery();
		List<UserQuotas> userQuotasList = quotaService.getUserQuotaList(quotaQuery);
		model.addAttribute("userQuotasList", userQuotasList);//将值放入model中供页面获取
		return "platform/userquotas";//将页面跳转至userquotas.jsp页面，根路径和“.jsp”会通过配置文件spring-mvc.xml自动补上
	}
	
	@RequestMapping(value="getUserQuotasByKeys/{ids}",method=RequestMethod.POST)//批量查询用户的配额信息
	public void getUserQuotasByKeys(@PathVariable("ids") String ids,HttpServletRequest request,HttpServletResponse response){
		JSONObject jsonObject = new JSONObject();
		List<Integer> idList = araayToList(ids);
		List<UserQuotas> userQuotasList = quotaService.getUserQuotasByKeys(idList);
		jsonObject.put("setUserQuotas", userQuotasList);//将值放入jsonObject中供页面获取
		jsonObject.put("size", userQuotasList.size());//将值放入jsonObject中供页面获取
		ResponseUtils.renderJson(response, jsonObject.toJSONString());
	}
	
	@RequestMapping(value="getUserQuotasByKey/{id}",method=RequestMethod.POST)//根据id查询用户配额信息
	public void getUserQuotasByKey(@PathVariable("id") int id,HttpServletRequest request,HttpServletResponse response){
		JSONObject jsonObject = new JSONObject();
		UserQuotas userQuotas = quotaService.getUserQuotasByKey(id);
		jsonObject.put("userQuotas", userQuotas);//将值放入jsonObject中供页面获取
		ResponseUtils.renderJson(response, jsonObject.toJSONString());
	}

	@RequestMapping(value="updateUserQuotaByKey/{type}/{supplierid}/{setquota}",method=RequestMethod.POST)//根据id查询用户配额信息
	public void updateUserQuotaByKey(@PathVariable("type") int type,@PathVariable("supplierid") int supplierid,@PathVariable("setquota") int setquota,HttpServletRequest request,HttpServletResponse response){
		JSONObject jsonObject = new JSONObject();
		UserQuotas userquotas = new UserQuotas();
		userquotas.setSupplierid(supplierid);
		userquotas.setType(type);
		if(type==1){//高级查询
			userquotas.setHigh_quotas(setquota);
		}else{
			userquotas.setComm_quotas(setquota);
		}
		int result = quotaService.updateUserQuotaByKey(userquotas);
		jsonObject.put("result", "配额设置"+(result==1?"成功！":"失败！"));//将值放入jsonObject中供页面获取
		ResponseUtils.renderJson(response, jsonObject.toJSONString());
	}
	
	@RequestMapping(value="updateUserQuotaByKeys/{types}/{supplierids}/{setquotas}",method=RequestMethod.POST)//根据id查询用户配额信息
	public void updateUserQuotaByKeys(@PathVariable("types") String types,@PathVariable("supplierids") String supplierids,@PathVariable("setquotas") String setquotas,HttpServletRequest request,HttpServletResponse response){
		JSONObject jsonObject = new JSONObject();
		List<Integer> typesList = araayToList(types);
		List<Integer> supplieridsList = araayToList(supplierids);
		List<Integer> setquotasList = araayToList(setquotas);
		int result = 0;
		for (int i = 0; i < typesList.size(); i++) {
			UserQuotas userquotas = new UserQuotas();
			userquotas.setSupplierid(supplieridsList.get(i));
			userquotas.setType(typesList.get(i));
			if(typesList.get(i)==1){//高级查询
				userquotas.setHigh_quotas(setquotasList.get(i));
			}else{
				userquotas.setComm_quotas(setquotasList.get(i));
			}
			result = result + quotaService.updateUserQuotaByKey(userquotas);
			System.out.println("result:"+result);
		}
		jsonObject.put("result", "配额设置"+(result==typesList.size()?"成功！":"失败！"));//将值放入jsonObject中供页面获取
		ResponseUtils.renderJson(response, jsonObject.toJSONString());
	}
	
	/**
	 * String数组转Integer的list
	 * @param str
	 * @return
	 */
	public List<Integer> araayToList(String str){
		String[] strarray = str.split(",");//java中使用“|”要加“\\”进行转义-->"\\|"
		Integer[] id=new Integer[strarray.length];
		for(int i=0;i<strarray.length;i++){
			id[i]=Integer.parseInt(strarray[i]);
		}
		List<Integer> idList = new ArrayList<Integer>();
		Collections.addAll(idList, id);
		return idList;
	}
}
