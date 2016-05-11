/*
 * 类作用 平台的供应商管理页面的功能实现
 * author lyn
 * createTime 2016-04-20 
 * version 0.1
 */
package com.fjsaas.web.controller.platform;

import java.util.Date;
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
import com.fjsaas.web.bean.Supplier;
import com.fjsaas.web.query.SupplierQuery;
import com.fjsaas.web.service.SupplierService;
import com.fjsaas.web.utils.Function;
import com.fjsaas.web.utils.ImageUpload;
import com.fjsaas.web.utils.ResponseUtils;

@Controller
@RequestMapping("/platform/")
public class SupplierManage {
	@Autowired
	private SupplierService supplierService;
	
	@RequestMapping("getSupplierInfoList")//查询所有的供应商信息，用于页面表格展示
	public String getSupplierInfoList(ModelMap model,HttpServletRequest request){
		SupplierQuery supplierQuery = new SupplierQuery();
		List<Supplier> supplierList = supplierService.getSupplierInfoList(supplierQuery);
		model.addAttribute("supplierList", supplierList);//将值放入model中供页面获取
		model.addAttribute("listSize", supplierList.size());//将值放入model中供页面获取
		return "platform/suppliermanage";//将页面跳转至suppliermanage.jsp页面，根路径和“.jsp”会通过配置文件spring-mvc.xml自动补上
	}

	@RequestMapping(value="getSupplierById/{id}",method=RequestMethod.POST)//查看某个供应商的详细信息
	public void getSupplierById(@PathVariable("id") int id,HttpServletRequest request,HttpServletResponse response){
		JSONObject jsonObject = new JSONObject();
		Supplier supplier = supplierService.getSupplierById(id);
		jsonObject.put("supplier", supplier);
		ResponseUtils.renderJson(response, jsonObject.toJSONString());
	}
	
	@RequestMapping("updateSupplierById/{id}/{supplierId}")//根据id保存修改的供应商信息，importImag为前台页面file标签的name名
	public void updateSupplierById(@PathVariable("id") int id,@PathVariable("supplierId") int supplierId,ModelMap model,HttpServletRequest request,HttpServletResponse response){
		JSONObject jsonObject = new JSONObject();
		Supplier supplier = new Supplier();
		String username = request.getParameter("username");//获取jsp页面的表单域的值，直接通过标签的username名获取
		String telphone = request.getParameter("telphone");
		String domain_name = request.getParameter("domain_name");
		String suppliername = request.getParameter("suppliername");
		String filepath = request.getParameter("filepath");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String town = request.getParameter("town");
		String addr = request.getParameter("addr");
		String linkman = request.getParameter("linkman");
		int clientid = Integer.parseInt(request.getParameter("clientid"));//登录用户id
		if(!Function.equalsNull(filepath)){//Function.equalsNull判断是否为空的公用方法
			ImageUpload.upload(request, filepath);//图片上传，返回说明信息
		}
		supplier.setId(id);
		supplier.setUsername(username);
		supplier.setTelphone(telphone);
		supplier.setDomain_name(domain_name);
		supplier.setSupplierid(supplierId);
		supplier.setSuppliername(suppliername);
		supplier.setBusinessLicenseUrl(ImageUpload.filename);
		supplier.setProvince(province);
		supplier.setCity(city);
		supplier.setTown(town);
		supplier.setAddr(addr);
		supplier.setLinkman(linkman);
		supplier.setUpdateDate(new Date());//修改时间
		supplier.setUpdatorId(clientid);//修改人：获取登录用户id
		int flag1 = supplierService.updateSupplierById(supplier);//修改该供应商的数据库信息
		int flag2 = supplierService.updateUserById(supplier);
		int flag3 = supplierService.updateDomainById(supplier);
		if(flag3==0){
			flag3 = supplierService.addDomain(supplier);
		}
//		System.out.println("flag1:"+flag1+"flag2:"+flag2+"flag3"+flag3);
		String msg = "修改"+(flag1==1&&flag2==1&&flag3==1?"成功！":"失败！");
		jsonObject.put("imsg", msg);
		ResponseUtils.renderJson(response, jsonObject.toJSONString());
	}
	
	@RequestMapping("updateUserStatusById/{id}")//根据id改变用户的账户状态，锁定0 or 激活1
	public void updateUserStatusById(@PathVariable("id") int id,HttpServletRequest request,HttpServletResponse response){
		JSONObject jsonObject = new JSONObject();
		Supplier supplier = new Supplier();
		String islocked = request.getParameter("locked");
		int clientid = Integer.parseInt(request.getParameter("clientid"));//登录用户id
		supplier.setId(id);
		supplier.setUserlocked(Integer.parseInt(islocked));
		supplier.setUpdatorId(clientid);//修改人：获取登录用户id
		int flag = supplierService.updateUserStatusById(supplier);//修改该供应商的数据库信息
		String msg = (islocked.equals("0")?"激活":"锁定") + (flag==1?"成功！":"失败！");
		jsonObject.put("imsg", msg);
		ResponseUtils.renderJson(response, jsonObject.toJSONString());
	}
	
	@RequestMapping("deleteById/{id}")//根据id删除供应商
	public void deleteById(@PathVariable("id") int id,HttpServletRequest request,HttpServletResponse response){
		JSONObject jsonObject = new JSONObject();
		Supplier supplier = new Supplier();
		int clientid = Integer.parseInt(request.getParameter("clientid"));//登录用户id
		supplier.setId(id);
		supplier.setUpdatorId(clientid);//修改人：获取登录用户id
		int flag = supplierService.deleteById(supplier);//修改该供应商的数据库信息
		String msg = "删除"+(flag==1?"成功！":"失败！");
		jsonObject.put("imsg", msg);
		ResponseUtils.renderJson(response, jsonObject.toJSONString());
	}
}
