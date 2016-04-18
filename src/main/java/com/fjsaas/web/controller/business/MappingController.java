package com.fjsaas.web.controller.business;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;

import com.alibaba.fastjson.JSONObject;
import com.fjsaas.web.bean.SupplierMapping;
import com.fjsaas.web.constants.Constants;
import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.pagination.html.PageTagImpl;
import com.fjsaas.web.query.SupplierMappingQuery;
import com.fjsaas.web.service.SupplierMappingService;
import com.fjsaas.web.service.custom.MappingImportServiceImpl;
import com.fjsaas.web.utils.ResponseUtils;
import com.fjsaas.web.utils.excel.ExcelExportSXSSF;
import com.fjsaas.web.utils.excel.SxlsxOptRows;
import com.fjsaas.web.utils.excel.SxlsxOptRowsImpl;
import com.fjsaas.web.utils.excel.SxlsxRead;

@Controller
@RequestMapping("/business/")
public class MappingController {

	@Autowired
	private SupplierMappingService supplierMappingService;
	@Autowired
	private SxlsxOptRows sxlsxOptRows;
	
	@RequestMapping("mappingIndex.do")
	public String mappingIndex(String search,String status,Integer pageNo,ModelMap model,HttpServletRequest request){
		String appName = request.getContextPath();
		SupplierMappingQuery mappingQuery = new SupplierMappingQuery();
		StringBuffer params = new StringBuffer();
		if(!StringUtils.isEmpty(status)){
			mappingQuery.setStatus(status);
			params.append("&status=").append(status);
		}
		
		if(!StringUtils.isEmpty(search)){
			mappingQuery.setProductName(search);
			mappingQuery.setProductCode(search);
			mappingQuery.setProductBrand(search);
			params.append("&search=").append(search);
		}
		
		if(pageNo != null){
			mappingQuery.setPageNo(pageNo);
		}
		
		Pager pager = supplierMappingService.getSupplierMappingListWithPageByMulCondition(mappingQuery);
		
		model.addAttribute("pager", pager);
		model.addAttribute("search", search);
		model.addAttribute("status", status);
		
		pager.pageView(appName+"/business/mappingIndex.do", params.toString(),new PageTagImpl());
		return "business/mappingManage";
	}
	
	@RequestMapping("import.do")
	public void csvImport(@RequestParam() MultipartFile importCSV,HttpServletRequest request,HttpServletResponse response) throws Exception{
		String oldFilename = importCSV.getOriginalFilename();
		String extension = FilenameUtils.getExtension(oldFilename);
		JSONObject jsonObject = new JSONObject();
		if(!"xlsx".equals(extension) && !"csv".equals(extension)){
			jsonObject.put("msg", "上传的格式有问题，只支持xlsx、csv文件");
		}else{
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
				fieldNames.add("编码类型");
				fieldNames.add("对应编码");
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
		}
		
		
		ResponseUtils.renderJson(response, jsonObject.toJSONString());
	}
}
