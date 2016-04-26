package com.fjsaas.web.controller.business;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;

import com.alibaba.fastjson.JSONObject;
import com.csvreader.CsvReader;
import com.fjsaas.web.bean.SupplierMapping;
import com.fjsaas.web.bean.TaskDetail;
import com.fjsaas.web.constants.Constants;
import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.pagination.html.PageTagImpl;
import com.fjsaas.web.query.SupplierMappingQuery;
import com.fjsaas.web.service.SupplierMappingService;
import com.fjsaas.web.service.custom.MappingImportServiceImpl;
import com.fjsaas.web.service.custom.MappingIndexjob;
import com.fjsaas.web.service.custom.SysTaskServiceImpl;
import com.fjsaas.web.utils.ResponseUtils;
import com.fjsaas.web.utils.csv.CsvExport;
import com.fjsaas.web.utils.csv.CsvImport;
import com.fjsaas.web.utils.csv.CsvOptRowsImpl;
import com.fjsaas.web.utils.excel.ExcelExportSXSSF;
import com.fjsaas.web.utils.excel.OptRows;
import com.fjsaas.web.utils.excel.SxlsxOptRowsImpl;
import com.fjsaas.web.utils.excel.SxlsxRead;

@Controller
@RequestMapping("/business/")
public class MappingController {

	@Autowired
	private SupplierMappingService supplierMappingService;
	@Autowired
	private OptRows sxlsxOptRows;
	@Autowired
	private SysTaskServiceImpl sysTaskServiceImpl;
	
	@RequestMapping("mappingIndex.do")
	public String mappingIndex(String search,String status,Integer pageNo,ModelMap model,HttpServletRequest request){
		String appName = request.getContextPath();
		SupplierMappingQuery mappingQuery = new SupplierMappingQuery();
		mappingQuery.orderbyId(false);
		StringBuffer params = new StringBuffer();
		if(!StringUtils.isEmpty(status)){
			mappingQuery.setStatus(status);
			params.append("&status=").append(status);
			model.addAttribute("status", status);
		}
		
		if(!StringUtils.isEmpty(search)){
			search = search.trim();
			mappingQuery.setProductName(search);
			mappingQuery.setProductCode(search);
			mappingQuery.setProductBrand(search);
			params.append("&search=").append(search);
			model.addAttribute("search", search);
		}
		
		if(pageNo != null){
			mappingQuery.setPageNo(pageNo);
		}
		
		Pager pager = supplierMappingService.getSupplierMappingListWithPageByMulCondition(mappingQuery);	
		model.addAttribute("pager", pager);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("data", pager.getList());
		model.addAttribute("json",jsonObject.toJSONString());
		
		pager.pageView(appName+"/business/mappingIndex.do", params.toString(),new PageTagImpl());
		return "business/mappingManage";
	}
	
	@RequestMapping("forbidden.do")
	public String forbidden(Integer id,String search,String status,Integer pageNo,ModelMap model,HttpServletRequest request){
		if(!StringUtils.isEmpty(search)){
			model.addAttribute("search", search);
		}
		if(!StringUtils.isEmpty(status)){
			model.addAttribute("status", status);
		}
		
		if(pageNo != null){
			model.addAttribute("pageNo", pageNo);
		}
		
		SupplierMapping supplierMapping = new SupplierMapping();
		if(id != null){
			supplierMapping.setId(id);
			supplierMapping.setStatus("2");//禁用
			supplierMappingService.updateSupplierMappingByKey(supplierMapping);
		}			
		return "redirect:/business/mappingIndex.do";
	}
	
	@RequestMapping("delete.do")
	public String delete(Integer id,String search,String status,Integer pageNo,ModelMap model,HttpServletRequest request){
		if(!StringUtils.isEmpty(search)){
			model.addAttribute("search", search);
		}
		if(!StringUtils.isEmpty(status)){
			model.addAttribute("status", status);
		}
		
		if(pageNo != null){
			model.addAttribute("pageNo", pageNo);
		}
		
		SupplierMapping supplierMapping = new SupplierMapping();
		if(id != null){
			supplierMappingService.deleteByKey(id);
		}			
		return "redirect:/business/mappingIndex.do";
	}
	
	@RequestMapping("forbiddenAll.do")
	public void forbiddenAll(Integer[] ids,HttpServletResponse response){
		
		if(ids != null){
			List<SupplierMapping> list = new ArrayList<SupplierMapping>();
			for (Integer id : ids) {
				SupplierMapping supplierMapping = supplierMappingService.getSupplierMappingByKey(id);
				supplierMapping.setStatus("2");//禁用
				//TODO：update增量操作
				supplierMappingService.updateSupplierMappingByKey(supplierMapping);
				list.add(supplierMapping);
			}		
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("data",list);
			ResponseUtils.renderJson(response, jsonObject.toJSONString());
		}			
	}
	
	@RequestMapping("deleteAll.do")
	public void deleteAll(Integer[] ids,HttpServletResponse response){	
		if(ids != null){
			supplierMappingService.deleteByKeys(Arrays.asList(ids));
			List<SupplierMapping> list = new ArrayList<SupplierMapping>();
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("data",list);
			ResponseUtils.renderJson(response, jsonObject.toJSONString());
		}			
	}
	
	@RequestMapping("update.do")
	public void update(SupplierMapping supplierMapping,Integer codeType,HttpServletResponse response){
		if(supplierMapping != null && codeType != null){
			//TODO：update增量操作
			if(codeType == 1){
				//OE编
				supplierMapping.setOeCode(supplierMapping.getReferenceCode());
				supplierMapping.setReferenceBrand(null);
				supplierMapping.setReferenceCode(null);
				
			}
			supplierMappingService.updateSupplierMappingByKey(supplierMapping);	
			List<SupplierMapping> list = new ArrayList<SupplierMapping>();
			list.add(supplierMapping);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("data",list);
			ResponseUtils.renderJson(response, jsonObject.toJSONString());
		}			
	}
	
	@RequestMapping("add.do")
	public void add(SupplierMapping supplierMapping,Integer codeType,HttpServletResponse response){
		if(supplierMapping != null && codeType != null){
			//TODO：add增量操作
			if(codeType == 1){
				//OE编
				supplierMapping.setOeCode(supplierMapping.getReferenceCode());
				supplierMapping.setReferenceBrand(null);
				supplierMapping.setReferenceCode(null);
				
			}
			supplierMapping.setStatus("0");
			supplierMappingService.addSupplierMapping(supplierMapping);
			List<SupplierMapping> list = new ArrayList<SupplierMapping>();
			list.add(supplierMapping);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("data",list);
			ResponseUtils.renderJson(response, jsonObject.toJSONString());
		}			
	}
	
	@RequestMapping("import.do")
	public void fileImport(@RequestParam() MultipartFile importCSV,HttpServletRequest request,HttpServletResponse response) throws Exception{
		String oldFilename = importCSV.getOriginalFilename();
		String extension = FilenameUtils.getExtension(oldFilename);
		JSONObject jsonObject = new JSONObject();
		if("xlsx".equals(extension)){
			String realPath = request.getSession().getServletContext().getRealPath("/");//获取web项目的路径
			String fullDir = realPath + Constants.CSV_FILE_URL;
			File file = new File(fullDir);
			if(!file.exists()){
				file.mkdirs();
			}
			String newFilename = UUID.randomUUID().toString();
			String fullPath = fullDir + newFilename + "." + extension;
		
			importCSV.transferTo(new File(fullPath));

			SxlsxRead sxlsxRead = new SxlsxRead(sxlsxOptRows);
			sxlsxRead.processSheet(fullPath, 1, true);
			if(sxlsxRead.getFailrows().size()>0){
				String outputDir = realPath + Constants.CSV_OUTPUT_URL;
				File outputFile = new File(outputDir);
				if(!outputFile.exists()){
					outputFile.mkdirs();
				}
				List<String> fieldNames = new ArrayList<String>();
				fieldNames.add("品牌");
				fieldNames.add("配件名称");
				fieldNames.add("配件编码");
				fieldNames.add("OE码");
				fieldNames.add("参照编码");
				fieldNames.add("参照品牌");
				fieldNames.add("一级报价");
				fieldNames.add("二级报价");
				fieldNames.add("三级报价");				
				ExcelExportSXSSF excelExportSXSSF = ExcelExportSXSSF.start(outputDir, "/output/excel/", "fjsaas", fieldNames, null, 100);
				excelExportSXSSF.writeDatasByList(sxlsxRead.getFailrows());
				String appName = request.getContextPath();
				String exportUrl = excelExportSXSSF.exportFile();
				jsonObject.put("downloadUrl",appName+"/"+exportUrl);
			}
			jsonObject.put("msg", "success");
			jsonObject.put("data", sxlsxRead);
			//TODO 企业ID+企业名称
			List<Object> successBeans = sxlsxRead.getSuccessBeans();
			//启动任务
			if(successBeans!=null && successBeans.size()>0){
				//获取spring容器
				ServletContext sc = request.getServletContext();  
		        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(sc); 
		        
				TaskDetail taskDetail = new TaskDetail("import", "1：壳牌", MappingIndexjob.class, new Date());
				taskDetail.getMap().put(Constants.APPLICATION_CONTEXT, context);
				taskDetail.getMap().put(Constants.MAPPING_DATA, sxlsxRead.getSuccessBeans());
				sysTaskServiceImpl.runTasks(taskDetail);
			}	
		}else if("csv".equals(extension)){
			String realPath = request.getSession().getServletContext().getRealPath("/");//获取web项目的路径
			String fullDir = realPath + Constants.CSV_FILE_URL;
			File file = new File(fullDir);
			if(!file.exists()){
				file.mkdirs();
			}
			String newFilename = UUID.randomUUID().toString();
			String fullPath = fullDir + newFilename + "." + extension;
		
			importCSV.transferTo(new File(fullPath));

			CsvImport csvImport = new CsvImport(sxlsxOptRows);
			csvImport.ReadCSV(fullPath, true);
			if(csvImport.getFailrows().size()>0){
				String outputDir = realPath + Constants.CSV_OUTPUT_URL;
				File outputFile = new File(outputDir);
				if(!outputFile.exists()){
					outputFile.mkdirs();
				}
				List<String> fieldNames = new ArrayList<String>();
				fieldNames.add("品牌");
				fieldNames.add("配件名称");
				fieldNames.add("配件编码");
				fieldNames.add("编码类型");
				fieldNames.add("对应编码");
				fieldNames.add("参照品牌");
				fieldNames.add("一级报价");
				fieldNames.add("二级报价");
				fieldNames.add("三级报价");		
				CsvExport csvExport = CsvExport.start(outputDir, "/output/excel/", "fjsaas", fieldNames, null, "GBK");
				//ExcelExportSXSSF excelExportSXSSF = ExcelExportSXSSF.start(outputDir, "/output/excel/", "fjsaas", fieldNames, null, 100);
				csvExport.writeDatasByList(csvImport.getFailrows());
				String appName = request.getContextPath();
				String exportUrl = csvExport.exportFile();
				jsonObject.put("downloadUrl",appName+"/"+exportUrl);
			}
			jsonObject.put("msg", "success");
			jsonObject.put("data", csvImport);
			//TODO 企业ID+企业名称
			TaskDetail taskDetail = new TaskDetail("import", "1：壳牌", MappingIndexjob.class, new Date());
			taskDetail.getMap().put(Constants.MAPPING_DATA, csvImport.getSuccessBeans());
			sysTaskServiceImpl.runTasks(taskDetail);
		}else{
			jsonObject.put("msg", "上传的格式有问题，只支持xlsx、csv文件");
		}
			
		ResponseUtils.renderJson(response, jsonObject.toJSONString());
	}
	
	@RequestMapping("csvExport.do")
	public String csvExport(String search,String status,HttpServletRequest request) throws Exception{
		SupplierMappingQuery mappingQuery = new SupplierMappingQuery();
		mappingQuery.orderbyId(false);
		if(!StringUtils.isEmpty(status)){
			mappingQuery.setStatus(status);
		}
		
		if(!StringUtils.isEmpty(search)){
			search = search.trim();
			mappingQuery.setProductName(search);
			mappingQuery.setProductCode(search);
			mappingQuery.setProductBrand(search);
		}
		
		List<SupplierMapping> list = supplierMappingService.getSupplierMappingListByMulCondition(mappingQuery);

		List<String> fieldNames = new ArrayList<String>();
		fieldNames.add("品牌");
		fieldNames.add("配件名称");
		fieldNames.add("配件编码");
		fieldNames.add("OE码");
		fieldNames.add("参照编码");
		fieldNames.add("参照品牌");
		fieldNames.add("一级报价");
		fieldNames.add("二级报价");
		fieldNames.add("三级报价");
		
 		List<String> fieldCodes=new ArrayList<String>();
 		fieldCodes.add("productBrand");
 		fieldCodes.add("productName");
 		fieldCodes.add("productCode");
 		fieldCodes.add("oeCode");
 		fieldCodes.add("referenceCode");
 		fieldCodes.add("referenceBrand");
 		fieldCodes.add("firstPrice");
 		fieldCodes.add("secondPrice");
 		fieldCodes.add("thirdPrice");
 		
 		
		String realPath = request.getSession().getServletContext().getRealPath("/");//获取web项目的路径
		String outputDir = realPath + Constants.CSV_OUTPUT_URL;
		CsvExport csvExport = CsvExport.start(outputDir, "/output/excel/", "fjsaas", fieldNames, fieldCodes, "GBK");
		csvExport.writeDatasByObject(list);
		String exportUrl = csvExport.exportFile();

		return "redirect:"+exportUrl;
	}
	
	@RequestMapping("excleExport.do")
	public String excleExport(String search,String status,HttpServletRequest request) throws Exception{
		SupplierMappingQuery mappingQuery = new SupplierMappingQuery();
		mappingQuery.orderbyId(false);
		if(!StringUtils.isEmpty(status)){
			mappingQuery.setStatus(status);
		}
		
		if(!StringUtils.isEmpty(search)){
			search = search.trim();
			mappingQuery.setProductName(search);
			mappingQuery.setProductCode(search);
			mappingQuery.setProductBrand(search);
		}
		
		List<SupplierMapping> list = supplierMappingService.getSupplierMappingListByMulCondition(mappingQuery);

		List<String> fieldNames = new ArrayList<String>();
		fieldNames.add("品牌");
		fieldNames.add("配件名称");
		fieldNames.add("配件编码");
		fieldNames.add("OE码");
		fieldNames.add("参照编码");
		fieldNames.add("参照品牌");
		fieldNames.add("一级报价");
		fieldNames.add("二级报价");
		fieldNames.add("三级报价");
		
 		List<String> fieldCodes=new ArrayList<String>();
 		fieldCodes.add("productBrand");
 		fieldCodes.add("productName");
 		fieldCodes.add("productCode");
 		fieldCodes.add("oeCode");
 		fieldCodes.add("referenceCode");
 		fieldCodes.add("referenceBrand");
 		fieldCodes.add("firstPrice");
 		fieldCodes.add("secondPrice");
 		fieldCodes.add("thirdPrice");
 		
 		
		String realPath = request.getSession().getServletContext().getRealPath("/");//获取web项目的路径
		String outputDir = realPath + Constants.CSV_OUTPUT_URL;
		ExcelExportSXSSF excelExportSXSSF = ExcelExportSXSSF.start(outputDir, "/output/excel/", "fjsaas", fieldNames, fieldCodes, 100);
		excelExportSXSSF.writeDatasByObject(list);
		String exportUrl = excelExportSXSSF.exportFile();

		return "redirect:"+exportUrl;
	}

	
	@RequestMapping("test.do")
	public String test(){
		return "business/mappingManage";
	}
}
