package com.fjsaas.web.service.custom;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fjsaas.web.bean.SupplierMapping;
import com.fjsaas.web.service.SupplierMappingService;
import com.fjsaas.web.utils.excel.OptRowResutl;
import com.fjsaas.web.utils.excel.OptRows;
import com.fjsaas.web.utils.excel.SxlsxRead;

@Service
public class MappingImportServiceImpl implements OptRows{
	
	@Autowired 
	private SupplierMappingService supplierMappingService;
	
	
	@Override
	public OptRowResutl optRows(int sheetIndex, int curRow, List<String> row) {
		OptRowResutl optRowResutl = new OptRowResutl();
		String brand = row.get(0);
		String productName = row.get(1);
		String productCode = row.get(2);
		String oeCode = row.get(3);
		String referenceCode = row.get(4);
		String referenceBrand = row.get(5);
		float firstPrice = 0;
		try {
			firstPrice = Float.parseFloat(row.get(6));
		} catch (NumberFormatException e) {
			optRowResutl.setResult(curRow+"行"+(6+1)+"列:"+row.get(6)+"导入数据类型有误，必须为数值 类型");
			return optRowResutl;
		}
		float secondPrice = 0;
		try {
			secondPrice = Float.parseFloat(row.get(7));
		} catch (NumberFormatException e) {
			optRowResutl.setResult(curRow+"行"+(7+1)+"列:"+row.get(7)+"导入数据类型有误，必须为数值 类型");
			return optRowResutl;
		}
		float thirdPrice = 0;
		try {
			thirdPrice = Float.parseFloat(row.get(8));
		} catch (NumberFormatException e) {
			optRowResutl.setResult(curRow+"行"+(8+1)+"列:"+row.get(8)+"导入数据类型有误，必须为数值 类型");
			return optRowResutl;
		}
		
		SupplierMapping supplierMapping = new SupplierMapping();
		//TODO add增量操作
		supplierMapping.setCreateDate(new Date());
		supplierMapping.setCreatorId(1);
		supplierMapping.setProductBrand(brand);
		supplierMapping.setProductName(productName);
		supplierMapping.setProductCode(productCode);
		supplierMapping.setOeCode(oeCode);
		supplierMapping.setReferenceCode(referenceCode);
		supplierMapping.setReferenceBrand(referenceBrand);
		supplierMapping.setFirstPrice(firstPrice);
		supplierMapping.setSecondPrice(secondPrice);
		supplierMapping.setThirdPrice(thirdPrice);
		supplierMapping.setStatus("0");
		//TODO 关联的企业
		supplierMapping.setSupplierId(1);

		
		
		Integer flag = supplierMappingService.addSupplierMapping(supplierMapping);
		
		if(flag > 0){
			optRowResutl.setResult(OptRowResutl.SUCCESS_FLAG);
			optRowResutl.setTarget(supplierMapping);
			return optRowResutl;
		}else{
			optRowResutl.setResult(curRow+"行"+"插入失败！");
			return optRowResutl;
		}
		
	}

}
