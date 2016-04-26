/*
 * 类作用 平台的供应商管理页面的功能实现
 * author lyn
 * createTime 2016-04-20
 * version 0.1
 */
package com.fjsaas.web.controller.platform;

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
	
	@RequestMapping("getSupplierList")//查询所有的供应商信息，用于页面表格展示
	public String getSupplierList(ModelMap model,HttpServletRequest request){
		System.out.println("开始了。。。");
		SupplierQuery supplierQuery = new SupplierQuery();
		List<Supplier> supplierList = supplierService.getSupplierList(supplierQuery);
		model.addAttribute("supplierList", supplierList);//将值放入model中供页面获取
		model.addAttribute("listSize", supplierList.size());//将值放入model中供页面获取
		System.out.println("结束了。。。。"+supplierList.size()+supplierList.get(0).getAddr());
		return "platform/suppliermanage";//将页面跳转至suppliermanage.jsp页面，根路径和“.jsp”会通过配置文件spring-mvc.xml自动补上
	}

	@RequestMapping(value="getSupplierById/{id}",method=RequestMethod.POST)//查看某个供应商的详细信息
	public void getSupplierById(@PathVariable("id") int id,HttpServletRequest request,HttpServletResponse response){
		System.out.println("开始了。。。。");
		JSONObject jsonObject = new JSONObject();
//		String id = request.getParameter("supplierId");//由页面获取id
		Supplier supplier = supplierService.getSupplierByKey(id);
		jsonObject.put("supplier", supplier);
		System.out.println("结束了。。。。id="+id+",addr:"+supplier.getAddr());
		ResponseUtils.renderJson(response, jsonObject.toJSONString());
	}
	
	@RequestMapping("updateSupplierById/{id}")//根据id保存修改的供应商信息，importImag为前台页面file标签的name名
	public void updateSupplierById(@PathVariable("id") int id,ModelMap model,HttpServletRequest request,HttpServletResponse response){
		System.out.println("开始了。。。。");
		String msg = "";
		JSONObject jsonObject = new JSONObject();
		Supplier supplier = new Supplier();
		String name = request.getParameter("name");//获取jsp页面的表单域的值，直接通过标签的name名获取
		String filepath = request.getParameter("filepath");
		if(!Function.equalsNull(filepath)){//Function.equalsNull判断是否为空的公用方法
			msg = ImageUpload.upload(request, filepath);//图片上传，返回说明信息
		}
		supplier.setId(id);
		supplier.setName(name);
		supplier.setBusinessLicenseUrl(ImageUpload.filename);
		supplierService.updateSupplierByKey(supplier);//修改该供应商的数据库信息
		System.out.println("结束了。。。。msg:【"+msg+"】,id="+id+",name="+name+",filepath:"+filepath+",imgfullpath:"+ImageUpload.filename);
		jsonObject.put("imsg", msg);
		ResponseUtils.renderJson(response, jsonObject.toJSONString());
	}
	
}
