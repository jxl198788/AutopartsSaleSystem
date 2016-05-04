package com.fjsaas.web.controller.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.fjsaas.web.bean.Brand;
import com.fjsaas.web.bean.MappingIndex;
import com.fjsaas.web.bean.PartSort;
import com.fjsaas.web.bean.Producer;
import com.fjsaas.web.bean.Series;
import com.fjsaas.web.bean.Type;
import com.fjsaas.web.bean.TypeCustom;
import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.pagination.html.PageTagImpl;
import com.fjsaas.web.query.BrandQuery;
import com.fjsaas.web.query.MappingIndexQuery;
import com.fjsaas.web.query.PartSortQuery;
import com.fjsaas.web.query.ProducerQuery;
import com.fjsaas.web.query.SeriesQuery;
import com.fjsaas.web.query.TypeQuery;
import com.fjsaas.web.service.BrandService;
import com.fjsaas.web.service.MappingIndexService;
import com.fjsaas.web.service.PartSortService;
import com.fjsaas.web.service.ProducerService;
import com.fjsaas.web.service.SeriesService;
import com.fjsaas.web.service.TypeService;
import com.fjsaas.web.utils.ResponseUtils;
import com.mysql.fabric.xmlrpc.base.Array;

@Controller
@RequestMapping("/business/")
public class QueryController {

	@Autowired
	private MappingIndexService mappingIndexService;
	@Autowired
	private PartSortService partSortService;
	@Autowired
	private ProducerService producerService;
	@Autowired
	private BrandService brandService;
	@Autowired
	private SeriesService seriesService;
	@Autowired
	private TypeService typeService;
	
	@RequestMapping(value="/query.do")
	public String query(String search , Integer partSortId, String partSortName, String productBrand , Integer autoTypeId , Integer pageNo,ModelMap model,HttpServletRequest request){
		
		String appName = request.getContextPath();
		MappingIndexQuery mappingIndexQuery = new MappingIndexQuery();
		StringBuilder params = new StringBuilder();
	
		if(partSortId != null){
			mappingIndexQuery.setPartSortId(partSortId);
			params.append("&partSortId=").append(partSortId);
			model.addAttribute("partSortId", partSortId);
		}
		
		if(!StringUtils.isEmpty(partSortName)){
			params.append("&partSortName=").append(partSortName);
			model.addAttribute("partSortName", partSortName);
		}
		
		if(!StringUtils.isEmpty(productBrand)){
			mappingIndexQuery.setProductBrand(productBrand);
			params.append("&productBrand=").append(productBrand);
			model.addAttribute("productBrand", productBrand);
		}
		
		if(!StringUtils.isEmpty(search)){
			search = search.trim();
			mappingIndexQuery.setProductName(search);
			mappingIndexQuery.setProductCode(search);
			//mappingIndexQuery.setProductBrand(search);
			params.append("&search=").append(search);
			model.addAttribute("search", search);
		}
		
		if(autoTypeId != null){
			mappingIndexQuery.setAutoTypeId(autoTypeId);
			params.append("&autoTypeId=").append(autoTypeId);
			Type type = typeService.getTypeByKey(autoTypeId);
			model.addAttribute("autoType", type);
			model.addAttribute("autoTypeId", autoTypeId);
		}
		
		if(pageNo != null){
			mappingIndexQuery.setPageNo(pageNo);
		}
			
		PartSortQuery partSortQuery = new PartSortQuery();
		partSortQuery.setParentId(-1);//顶级节点
		List<PartSort> partSortList = partSortService.getPartSortList(partSortQuery);
		model.addAttribute("partSortList", partSortList);
		
		ProducerQuery producerQuery = new ProducerQuery();
		List<Producer> producerList = producerService.getProducerList(producerQuery);
		model.addAttribute("producerList", producerList);
		
		BrandQuery brandQuery = new BrandQuery();
		List<Brand> brandList = brandService.getBrandList(brandQuery);
		model.addAttribute("brandList", brandList);
		
		//TODO 获取supplierId
		mappingIndexQuery.setSupplierId(1);
		Pager pager = mappingIndexService.getMappingIndexListWithPageByMulCondition(mappingIndexQuery);
		model.addAttribute("pager", pager);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("data", pager.getList());
		model.addAttribute("json",jsonObject.toJSONString());
		
		pager.pageView(appName+"/business/query.do", params.toString(),new PageTagImpl());
		return "business/query";
	}
	
	@RequestMapping(value="/series/{brandId}")
	public @ResponseBody List<Series> series(@PathVariable Integer brandId){
		SeriesQuery seriesQuery = new SeriesQuery();
		seriesQuery.setBrandId(brandId);
		List<Series> seriesList = seriesService.getSeriesList(seriesQuery);
		return seriesList;
	}
	
	@RequestMapping(value="/type/{seriesId}")
	public @ResponseBody List<Type> type(@PathVariable Integer seriesId){
		TypeQuery typeQuery = new TypeQuery();
		typeQuery.setSeriesId(seriesId);
		List<Type> typeList = typeService.getTypeList(typeQuery);
		return typeList;
	}
	
	@RequestMapping(value="/types")
	public void types(Integer[] typeIds,HttpServletResponse response){
		if(typeIds != null){
			List<TypeCustom> list = new ArrayList<TypeCustom>();
			for (Integer id : typeIds) {
				 TypeCustom typeCustom = new TypeCustom();
				 
				 Type type = typeService.getTypeByKey(id);
				 typeCustom.setType(type);
				 Series series = seriesService.getSeriesByKey(type.getSeriesId());
				 typeCustom.setSeries(series);
				 Brand brand = brandService.getBrandByKey(series.getBrandId());
				 typeCustom.setBrand(brand);
				
				 list.add(typeCustom);
			}
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("data", list);
			ResponseUtils.renderJson(response, jsonObject.toJSONString());
		}	
	}
	
}
