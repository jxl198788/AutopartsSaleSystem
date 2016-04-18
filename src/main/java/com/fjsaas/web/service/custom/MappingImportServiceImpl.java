package com.fjsaas.web.service.custom;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fjsaas.web.bean.SupplierMapping;
import com.fjsaas.web.service.SupplierMappingService;
import com.fjsaas.web.utils.excel.SxlsxOptRows;

@Service
public class MappingImportServiceImpl implements SxlsxOptRows{

	private  static final String SUCCESS_FLAG = "success";
	
	@Autowired 
	private SupplierMappingService supplierMappingService;
	
	@Override
	public String optRows(int sheetIndex, int curRow, List<String> row) {
		String brand = row.get(0);
		String productName = row.get(1);
		String productCode = row.get(2);
		int codeType = 0;//数据类型
		try {
			codeType = Integer.parseInt(row.get(3));
			if(codeType !=0 && codeType != 1){
				return curRow+"行"+(3+1)+"列:"+row.get(3)+"导入数据有误，编码类型只能为0或者1";
			}
		} catch (NumberFormatException e) {
			return curRow+"行"+(3+1)+"列:"+row.get(3)+"导入数据类型有误，必须为数值 类型";
		}
		String referenceCode = row.get(4);
		String referenceBrand = row.get(5);
		float firstPrice = 0;
		try {
			firstPrice = Float.parseFloat(row.get(6));
		} catch (NumberFormatException e) {
			return curRow+"行"+(6+1)+"列:"+row.get(6)+"导入数据类型有误，必须为数值 类型";
		}
		float secondPrice = 0;
		try {
			secondPrice = Float.parseFloat(row.get(7));
		} catch (NumberFormatException e) {
			return curRow+"行"+(7+1)+"列:"+row.get(7)+"导入数据类型有误，必须为数值 类型";
		}
		float thirdPrice = 0;
		try {
			thirdPrice = Float.parseFloat(row.get(8));
		} catch (NumberFormatException e) {
			return curRow+"行"+(8+1)+"列:"+row.get(8)+"导入数据类型有误，必须为数值 类型";
		}
		
		SupplierMapping supplierMapping = new SupplierMapping();
		supplierMapping.setCreateDate(new Date());
		supplierMapping.setCreatorId(1);
		supplierMapping.setFirstPrice(firstPrice);
		if(codeType == 0){
			supplierMapping.setOeCode(referenceCode);
		}else{
			supplierMapping.setReferenceCode(referenceCode);
			supplierMapping.setReferenceBrand(referenceBrand);
		}
		supplierMapping.setProductBrand(brand);
		supplierMapping.setProductName(productName);
		supplierMapping.setProductCode(productCode);
		supplierMapping.setSecondPrice(secondPrice);
		supplierMapping.setStatus("0");
		supplierMapping.setSupplierId(1);
		supplierMapping.setThirdPrice(thirdPrice);
		
		
		Integer flag = supplierMappingService.addSupplierMapping(supplierMapping);
		
		if(flag > 0){
			return SUCCESS_FLAG;
		}
		return curRow+"行插入失败";
	}

}
