package com.fjsaas.web.dao;

import java.util.List;

import com.fjsaas.web.bean.SupplierMapping;
import com.fjsaas.web.query.SupplierMappingQuery;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierMappingCustomDao {


	public List<SupplierMapping> getSupplierMappingListWithPageByMulCondition(SupplierMappingQuery supplierMappingQuery);

	public int getSupplierMappingListCountByMulCondition(SupplierMappingQuery supplierMappingQuery);

}
