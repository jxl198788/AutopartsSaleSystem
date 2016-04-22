package com.fjsaas.web.controller.platform;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fjsaas.web.bean.Supplier;
import com.fjsaas.web.query.SupplierQuery;
import com.fjsaas.web.service.SupplierService;

@Controller
@RequestMapping("/platform/")
public class SupplierManage {
	@Autowired
	private SupplierService supplierService;
	
	@RequestMapping("getSupplierInfos.do")
	public String getSupplierInfos(ModelMap model,HttpServletRequest request){
		System.out.println("开始了。。。。");
		SupplierQuery supplierQuery = new SupplierQuery();
		List<Supplier> supplierList = supplierService.getSupplierList(supplierQuery);
		model.addAttribute("supplierList", supplierList);
		model.addAttribute("listSize", supplierList.size());
		System.out.println("结束了。。。。"+supplierList.size()+supplierList.get(0).getAddr());
		return "platform/suppliermanage";
	}

	@RequestMapping("getSupplierDetail.do")
	public String getSupplierDetail(ModelMap model,HttpServletRequest request){
		System.out.println("开始了。。。。");
		String id = request.getParameter("id");
		System.out.println("id="+id);
		Supplier supplier = supplierService.getSupplierByKey(Integer.parseInt(id));
		model.addAttribute("supplier", supplier);
		System.out.println("结束了。。。。"+supplier.getAddr());
		return "platform/suppliermanage";
	}
	
	@RequestMapping("updateSupplierDetail.do")
	public String updateSupplierDetail(HttpServletRequest request){
		System.out.println("开始了。。。。");
		Supplier supplier = new Supplier();
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		System.out.println("name="+name+",id="+id);
		supplier.setName(name);
		supplierService.updateSupplierByKey(supplier);
		System.out.println("结束了。。。。");
		return "platform/suppliermanage";
	}
}
