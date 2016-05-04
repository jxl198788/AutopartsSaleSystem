package com.fjsaas.web.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.Image;
import com.fjsaas.web.bean.MappingIndex;
import com.fjsaas.web.bean.Oe;
import com.fjsaas.web.bean.ProductcodeOe;
import com.fjsaas.web.bean.SupplierMapping;
import com.fjsaas.web.bean.TypeOe;
import com.fjsaas.web.dao.ProductcodeOeCustomDao;
import com.fjsaas.web.dao.ProductcodeOeDao;
import com.fjsaas.web.query.ImageQuery;
import com.fjsaas.web.query.ProductcodeOeQuery;
import com.fjsaas.web.query.TypeOeQuery;
import com.fjsaas.web.service.ImageService;
import com.fjsaas.web.service.OeService;
import com.fjsaas.web.service.ProductcodeOeService;
import com.fjsaas.web.service.TypeOeService;

@Service
public class ProductcodeOeServiceImpl implements ProductcodeOeService {

	@Resource
	ProductcodeOeDao productcodeOeDao;

	@Resource
	ProductcodeOeCustomDao productcodeOeCustomDao;
	
	@Resource
	private TypeOeService typeOeService;
	
	@Resource
	private OeService oeService;
	
	@Resource
	private ImageService imageService;

	private Set<String> productCodeList;
	private Set<String> oeCodeList;
	private Set<String> referenceCodeList;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addProductcodeOe(ProductcodeOe productcodeOe) {
		return productcodeOeDao.addProductcodeOe(productcodeOe);
	}

	/**
	 * 根据主键查找
	 */
	public ProductcodeOe getProductcodeOeByKey(Integer id) {
		return productcodeOeDao.getProductcodeOeByKey(id);
	}

	public List<ProductcodeOe> getProductcodeOesByKeys(List<Integer> idList) {
		return productcodeOeDao.getProductcodeOesByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return productcodeOeDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return productcodeOeDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateProductcodeOeByKey(ProductcodeOe productcodeOe) {
		return productcodeOeDao.updateProductcodeOeByKey(productcodeOe);
	}

	public Pager getProductcodeOeListWithPage(
			ProductcodeOeQuery productcodeOeQuery) {
		Pager p = new Pager(productcodeOeQuery.getPageNo(),
				productcodeOeQuery.getPageSize(),
				productcodeOeDao.getProductcodeOeListCount(productcodeOeQuery));
		p.setList(productcodeOeDao
				.getProductcodeOeListWithPage(productcodeOeQuery));
		return p;
	}

	public List<ProductcodeOe> getProductcodeOeList(
			ProductcodeOeQuery productcodeOeQuery) {
		return productcodeOeDao.getProductcodeOeList(productcodeOeQuery);
	}

	@Override
	public List<ProductcodeOe> getProductcodeOesByProductCode(
			HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return productcodeOeCustomDao.getProductcodeOesByProductCode(map);
	}

	@Override
	public List<ProductcodeOe> getProductcodeOesByOeCode(
			HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return productcodeOeCustomDao.getProductcodeOesByOeCode(map);
	}

	@Override
	public List<ProductcodeOe> getProductcodeOesByReferenceCode(
			HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return productcodeOeCustomDao.getProductcodeOesByReferenceCode(map);
	}

	@Override
	public List<MappingIndex> InferMappingIndexs(SupplierMapping supplierMapping) {
		// TODO Auto-generated method stub
		List<MappingIndex> mappingIndexs = new ArrayList<MappingIndex>();
		//productCode不能为空
		if(StringUtils.isEmpty(supplierMapping.getProductCode())){
			return null;
		}
		System.out.println(supplierMapping.getProductCode());
		String productCode = null;
		//productCode，如果存在参照编码，那么取参照编码；如果不存在，则取oe编码对应的productCode；如果不存在，最后去传入的productCode
		if(!StringUtils.isEmpty(supplierMapping.getReferenceCode())){
			productCode = supplierMapping.getReferenceCode();
		}else if(!StringUtils.isEmpty(supplierMapping.getOeCode())){
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			hashMap.put("oeCode", supplierMapping.getOeCode());
			List<ProductcodeOe> list = getProductcodeOesByOeCode(hashMap);
			if(list != null && list.size() > 0){
				productCode = list.get(0).getProductCode();
			}else{
				productCode = supplierMapping.getProductCode();
			}
		}else{
			productCode = supplierMapping.getProductCode();
		}
		
		productCodeList = new HashSet<String>();
		oeCodeList = new HashSet<String>();
		referenceCodeList = new HashSet<String>();
		query(productCode);
		//oeCode填充到oeCodeList
		if(!StringUtils.isEmpty(supplierMapping.getOeCode())){
			oeCodeList.add(supplierMapping.getOeCode());
		}
		
		if(oeCodeList.size() <= 0){
			MappingIndex mappingIndex = new MappingIndex();
			BeanUtils.copyProperties(supplierMapping, mappingIndex, "id","createDate","creatorId","updateDate","updatorId","isDel");
			mappingIndex.setMappingId(supplierMapping.getId());
			mappingIndex.setCreateDate(new Date());
			mappingIndex.setCreatorId(-1);
			mappingIndex.setMappingCreateDate(supplierMapping.getCreateDate());
			mappingIndexs.add(mappingIndex);
			return mappingIndexs;
		}else{
			String productSize = null;
			Integer partSortId = null ;
			String imageUrl = null;
			
			//默认取第一个的productSize、partSortId、imageUrl
			for (String oeCode : oeCodeList) {
				if(StringUtils.isEmpty(productSize) || StringUtils.isEmpty(partSortId)){
					Oe oe = oeService.getOeByKey(oeCode);
					if(oe != null){
						productSize = oe.getSize();
						partSortId = oe.getPartSortId();
					}			
				}
				if(StringUtils.isEmpty(imageUrl) ){
					ImageQuery imageQuery = new ImageQuery();
					imageQuery.setTargetId(oeCode);
					imageQuery.setGroupId("0");//OE
					List<Image> imageList = imageService.getImageList(imageQuery);
					if(imageList != null && imageList.size() > 0){
						imageUrl = imageList.get(0).getUrl();
					}
				}
				if(!StringUtils.isEmpty(productSize) || !StringUtils.isEmpty(partSortId) && !StringUtils.isEmpty(imageUrl)){
					break;
				}
				
			}
			
			//遍历oeCodeList
			for (String oeCode : oeCodeList) {
				TypeOeQuery typeOeQuery = new TypeOeQuery();
				typeOeQuery.setOeCode(oeCode);
				List<TypeOe> typeOeList = typeOeService.getTypeOeList(typeOeQuery);
				if(typeOeList!=null && typeOeList.size() >0){
					for (TypeOe typeOe : typeOeList) {
						MappingIndex mappingIndex = new MappingIndex();
						BeanUtils.copyProperties(supplierMapping, mappingIndex, "id","createDate","creatorId","updateDate","updatorId");
						mappingIndex.setMappingId(supplierMapping.getId());
						mappingIndex.setCreateDate(new Date());
						mappingIndex.setCreatorId(-1);
						mappingIndex.setMappingCreateDate(supplierMapping.getCreateDate());
						mappingIndex.setProductSize(productSize);
						mappingIndex.setPartSortId(partSortId);
						mappingIndex.setImageUrl(imageUrl);
						mappingIndex.setOeCode(oeCode);
						mappingIndex.setAutoTypeId(typeOe.getTypeId());
						mappingIndexs.add(mappingIndex);
					}
				}else{
					MappingIndex mappingIndex = new MappingIndex();
					BeanUtils.copyProperties(supplierMapping, mappingIndex, "id","createDate","creatorId","updateDate","updatorId");
					mappingIndex.setMappingId(supplierMapping.getId());
					mappingIndex.setCreateDate(new Date());
					mappingIndex.setCreatorId(-1);
					mappingIndex.setMappingCreateDate(supplierMapping.getCreateDate());
					mappingIndex.setProductSize(productSize);
					mappingIndex.setPartSortId(partSortId);
					mappingIndex.setImageUrl(imageUrl);
					mappingIndex.setOeCode(oeCode);
					mappingIndexs.add(mappingIndex);
				}	
			}
			
			return mappingIndexs;
		}	
	}

	/**
	 * 通过productCode获取所有的oeCodes,通过递归的方式
	 * @param productCode
	 */
	private void query(String productCode) {
		if (productCodeList.contains(productCode)) {
			return;
		}
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("productCode", productCode);
		hashMap.put("oeCodes", oeCodeList);
		hashMap.put("referenceCodes", referenceCodeList);
		List<ProductcodeOe> productcodeOeList = this
				.getProductcodeOesByProductCode(hashMap);
		productCodeList.add(productCode);
		for (ProductcodeOe productcodeOe : productcodeOeList) {
			System.out.println(productcodeOe);
			String referenceCode = productcodeOe.getReferenceCode();
			String oeCode = productcodeOe.getOeCode();

			if (!StringUtils.isEmpty(referenceCode)) {
				referenceCodeList.add(referenceCode);
				query(referenceCode);
			}

			if (!StringUtils.isEmpty(oeCode)) {
				hashMap = new HashMap<String, Object>();
				hashMap.put("oeCode", oeCode);
				hashMap.put("productCodes", productCodeList);
				List<ProductcodeOe> productcodeOeList2 = this
						.getProductcodeOesByOeCode(hashMap);
				oeCodeList.add(oeCode);
				for (ProductcodeOe productcodeOe2 : productcodeOeList2) {
					query(productcodeOe2.getProductCode());
				}
			}

		}
	}
}
