package com.fjsaas.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fjsaas.web.bean.Brand;
import com.fjsaas.web.query.BrandQuery;
import com.fjsaas.web.service.BrandService;

@Controller
public class TestController {

	@Autowired
	private BrandService brandService;
	
	@RequestMapping("/test/test.do")
	public String test(){
		BrandQuery brandQuery = new BrandQuery();
		List<Brand> brandList = brandService.getBrandList(brandQuery);
		for (Brand brand : brandList) {
			System.out.println(brand);
		}
		return "index";
	}
	
}
