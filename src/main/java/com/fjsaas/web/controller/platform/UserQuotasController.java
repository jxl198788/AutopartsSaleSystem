/*
 * 类作用 平台的供应商管理页面的功能实现
 * author lyn
 * createTime 2016-04-20 
 * version 0.1
 */
package com.fjsaas.web.controller.platform;

import java.util.ArrayList;
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
import com.fjsaas.web.bean.Tree;
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
		System.out.println("result1:"+result);
		if(result==0){
			result = quotaService.addUserQuota(userquotas);
			System.out.println("result2:"+result);
		}
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
			int result1 = quotaService.updateUserQuotaByKey(userquotas);
			System.out.println("result1:"+result1);
			if(result1==0){
				result1 = quotaService.addUserQuota(userquotas);
				System.out.println("result2:"+result1);
			}
			result = result + result1; 
			System.out.println("result:"+result);
		}
		jsonObject.put("result", "配额设置"+(result==typesList.size()?"成功！":"失败！"));//将值放入jsonObject中供页面获取
		ResponseUtils.renderJson(response, jsonObject.toJSONString());
	}
	
	@RequestMapping(value="getTreeDataByKey/{id}",method=RequestMethod.GET)//根据id查询用户配额树信息
	public void getTreeDataByKey(@PathVariable("id") int id,HttpServletRequest request,HttpServletResponse response){
		JSONObject jsonObject = new JSONObject();
		List<Tree> treelist = new ArrayList<Tree>();
		try{
			UserQuotas reqBean = new UserQuotas();
			reqBean.setSupplierid(id);
			List<UserQuotas> userQuotasList = quotaService.getTreeDataByKey(reqBean);
			if (userQuotasList.size() > 0) {
				System.out.println("供应商跟管理员:"+userQuotasList.size());
				for (int k = 0; k < userQuotasList.size(); k++) {
					UserQuotas userquota = userQuotasList.get(k);
					System.out.println("供应商跟管理员"+k+":"+userquota.getSuppliername());
					Tree tree = new Tree();//供应商跟管理员
					tree.setId(userquota.getSupplierid());
					tree.setText(userquota.getSuppliername()+"（高级查询 配额"+userquota.getHigh_quotas()+"-已分配"+userquota.getH_deal_quotas()+"-剩余"+userquota.getH_left_quotas()+" 已分配"+userquota.getH_deal_quotas()+"-已使用"+userquota.getH_use_quotas()+"-未使用"+userquota.getH_unuse_quotas()+"<br/><label>普通查询 配额"+userquota.getComm_quotas()+"-已分配"+userquota.getC_deal_quotas()+"-剩余"+userquota.getC_left_quotas()+" 已分配"+userquota.getC_deal_quotas()+"-已使用"+userquota.getC_use_quotas()+"-未使用"+userquota.getC_unuse_quotas()+"）<label>");
					//n个供应商
					List<Tree> treetwo = new ArrayList<Tree>();
					UserQuotas reqBean2 = new UserQuotas();
					reqBean2.setParent_id(userquota.getSupplierid());
					System.out.println("userquota.getSupplierid():"+userquota.getSupplierid()+"---reqBean2.getParent_id():"+reqBean2.getParent_id());
					List<UserQuotas> userQuotasList1 = quotaService.getTreeDataByKey(reqBean2);
					if (userQuotasList1.size() > 0) {
						System.out.println("供应商:"+userQuotasList1.size());
						for (int m = 0; m < userQuotasList1.size(); m++) {
							UserQuotas userquota2 = userQuotasList1.get(m);
							System.out.println("供应商"+m+":"+userquota2.getSuppliername());
							Tree tree2 = new Tree();
							tree2.setId(userquota2.getSupplierid());
							tree2.setText(userquota2.getSuppliername()+"（高级查询 配额"+userquota2.getHigh_quotas()+"-已分配"+userquota2.getH_deal_quotas()+"-剩余"+userquota2.getH_left_quotas()+" 已分配"+userquota2.getH_deal_quotas()+"-已使用"+userquota2.getH_use_quotas()+"-未使用"+userquota2.getH_unuse_quotas()+"<br/><label>普通查询 配额"+userquota2.getComm_quotas()+"-已分配"+userquota2.getC_deal_quotas()+"-剩余"+userquota2.getC_left_quotas()+" 已分配"+userquota2.getC_deal_quotas()+"-已使用"+userquota2.getC_use_quotas()+"-未使用"+userquota2.getC_unuse_quotas()+"）<label>");
							//n个二级分销商
							List<Tree> treethree = new ArrayList<Tree>();
							UserQuotas reqBean3 = new UserQuotas();
							reqBean3.setParent_id(userquota2.getSupplierid());
							List<UserQuotas> userQuotasList3 = quotaService.getTreeDataByKey(reqBean3);
							if (userQuotasList3.size() > 0) {
								System.out.println("二级分销商:"+userQuotasList3.size());
								for (int n = 0; n < userQuotasList3.size(); n++) {
									UserQuotas userquota3 = userQuotasList3.get(n);
									System.out.println("供应商跟管理员"+n+":"+userquota3.getSuppliername());
									Tree tree3 = new Tree();
									tree3.setId(userquota3.getSupplierid());
									tree3.setText(userquota3.getSuppliername()+"（高级查询 配额"+userquota3.getHigh_quotas()+"-已分配"+userquota3.getH_deal_quotas()+"-剩余"+userquota3.getH_left_quotas()+" 已分配"+userquota3.getH_deal_quotas()+"-已使用"+userquota3.getH_use_quotas()+"-未使用"+userquota3.getH_unuse_quotas()+"<br/><label>普通查询 配额"+userquota3.getComm_quotas()+"-已分配"+userquota3.getC_deal_quotas()+"-剩余"+userquota3.getC_left_quotas()+" 已分配"+userquota3.getC_deal_quotas()+"-已使用"+userquota3.getC_use_quotas()+"-未使用"+userquota3.getC_unuse_quotas()+"）<label>");
									//n个维修厂
									List<Tree> treefour = new ArrayList<Tree>();
									UserQuotas reqBean4 = new UserQuotas();
									reqBean4.setParent_id(userquota3.getSupplierid());
									List<UserQuotas> userQuotasList4 = quotaService.getTreeDataByKey(reqBean4);
									if (userQuotasList4.size() > 0) {
										System.out.println("维修厂:"+userQuotasList4.size());
										for (int j = 0; j < userQuotasList4.size(); j++) {
											UserQuotas userquota4 = userQuotasList4.get(j);
											System.out.println("维修厂"+j+":"+userquota4.getSuppliername());
											Tree tree4 = new Tree();
											tree4.setId(userquota4.getSupplierid());
											tree4.setText(userquota4.getSuppliername()+"（高级查询 配额"+userquota4.getHigh_quotas()+"-已分配"+userquota4.getH_deal_quotas()+"-剩余"+userquota4.getH_left_quotas()+" 已分配"+userquota4.getH_deal_quotas()+"-已使用"+userquota4.getH_use_quotas()+"-未使用"+userquota4.getH_unuse_quotas()+"<br/><label>普通查询 配额"+userquota4.getComm_quotas()+"-已分配"+userquota4.getC_deal_quotas()+"-剩余"+userquota4.getC_left_quotas()+" 已分配"+userquota4.getC_deal_quotas()+"-已使用"+userquota4.getC_use_quotas()+"-未使用"+userquota4.getC_unuse_quotas()+"）<label>");
											//n个个体用户
											List<Tree> treefive = new ArrayList<Tree>();
											UserQuotas reqBean5 = new UserQuotas();
											reqBean5.setSupplierid(userquota4.getSupplierid());
											List<UserQuotas> userQuotasList5 = quotaService.getTreeUserByKey(reqBean5);
											if (userQuotasList5.size() > 0) {
												System.out.println("个体用户:"+userQuotasList5.size());
												for (int i = 0; i < userQuotasList5.size(); i++) {
													UserQuotas userquota5 = userQuotasList5.get(i);
													System.out.println("个体用户"+j+":"+userquota5.getUsername());
													Tree tree5 = new Tree();
													tree5.setId(userquota5.getSupplierid());
													tree5.setText(userquota5.getUsername()+" "+userquota5.getTelphone()+" 高级查询使用"+userquota5.getHigh_quotas()+"次 普通查询使用"+userquota5.getComm_quotas()+"次");
													treefive.add(tree5);
												}
											}
											tree4.setChildren(treefive);
											treefour.add(tree4);
										}
									}
									tree3.setChildren(treefour);
									treethree.add(tree3);
								}
							}
							tree2.setChildren(treethree);
							treetwo.add(tree2);
						}
					}
					tree.setChildren(treetwo);
					treelist.add(tree);
				}
			}
			jsonObject.put("treedata", treelist);//将值放入jsonObject中供页面获取
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("查询用户配额树信息异常了！");
		}finally{
			ResponseUtils.renderJson(response, jsonObject.toJSONString());
		}
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
