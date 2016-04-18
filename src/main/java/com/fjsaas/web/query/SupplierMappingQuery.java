package com.fjsaas.web.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

import com.fjsaas.web.query.BaseQuery;

public class SupplierMappingQuery extends BaseQuery {
	/**
	 * ==============================批量查询、更新、删除时的Where条件设置======================
	 * ============
	 **/
	private Integer id;
	public Integer getId() {
		return id;
	}
	public SupplierMappingQuery setId(Integer id) {
		this.id = id;
		return this;
	}
    
	private String productBrand;
	public String getProductBrand() {
		return productBrand;
	}
	public SupplierMappingQuery setProductBrand(String productBrand) {
		this.productBrand = productBrand;
		return this;
	}
	private boolean productBrandLike;
	public SupplierMappingQuery setProductBrandLike(boolean isLike) {
		this.productBrandLike = isLike;
		return this;
	}
    
	private String productName;
	public String getProductName() {
		return productName;
	}
	public SupplierMappingQuery setProductName(String productName) {
		this.productName = productName;
		return this;
	}
	private boolean productNameLike;
	public SupplierMappingQuery setProductNameLike(boolean isLike) {
		this.productNameLike = isLike;
		return this;
	}
    
	private String productCode;
	public String getProductCode() {
		return productCode;
	}
	public SupplierMappingQuery setProductCode(String productCode) {
		this.productCode = productCode;
		return this;
	}
	private boolean productCodeLike;
	public SupplierMappingQuery setProductCodeLike(boolean isLike) {
		this.productCodeLike = isLike;
		return this;
	}
    
	private String referenceCode;
	public String getReferenceCode() {
		return referenceCode;
	}
	public SupplierMappingQuery setReferenceCode(String referenceCode) {
		this.referenceCode = referenceCode;
		return this;
	}
	private boolean referenceCodeLike;
	public SupplierMappingQuery setReferenceCodeLike(boolean isLike) {
		this.referenceCodeLike = isLike;
		return this;
	}
    
	private String referenceBrand;
	public String getReferenceBrand() {
		return referenceBrand;
	}
	public SupplierMappingQuery setReferenceBrand(String referenceBrand) {
		this.referenceBrand = referenceBrand;
		return this;
	}
	private boolean referenceBrandLike;
	public SupplierMappingQuery setReferenceBrandLike(boolean isLike) {
		this.referenceBrandLike = isLike;
		return this;
	}
    
	private String oeCode;
	public String getOeCode() {
		return oeCode;
	}
	public SupplierMappingQuery setOeCode(String oeCode) {
		this.oeCode = oeCode;
		return this;
	}
	private boolean oeCodeLike;
	public SupplierMappingQuery setOeCodeLike(boolean isLike) {
		this.oeCodeLike = isLike;
		return this;
	}
    
	private Float firstPrice;
	public Float getFirstPrice() {
		return firstPrice;
	}
	public SupplierMappingQuery setFirstPrice(Float firstPrice) {
		this.firstPrice = firstPrice;
		return this;
	}
    
	private Float secondPrice;
	public Float getSecondPrice() {
		return secondPrice;
	}
	public SupplierMappingQuery setSecondPrice(Float secondPrice) {
		this.secondPrice = secondPrice;
		return this;
	}
    
	private Float thirdPrice;
	public Float getThirdPrice() {
		return thirdPrice;
	}
	public SupplierMappingQuery setThirdPrice(Float thirdPrice) {
		this.thirdPrice = thirdPrice;
		return this;
	}
    
	private String status;
	public String getStatus() {
		return status;
	}
	public SupplierMappingQuery setStatus(String status) {
		this.status = status;
		return this;
	}
	private boolean statusLike;
	public SupplierMappingQuery setStatusLike(boolean isLike) {
		this.statusLike = isLike;
		return this;
	}
    
	private Integer supplierId;
	public Integer getSupplierId() {
		return supplierId;
	}
	public SupplierMappingQuery setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
		return this;
	}
    
	private Date createDate;
	public Date getCreateDate() {
		return createDate;
	}
	public SupplierMappingQuery setCreateDate(Date createDate) {
		this.createDate = createDate;
		return this;
	}
    
	private Integer creatorId;
	public Integer getCreatorId() {
		return creatorId;
	}
	public SupplierMappingQuery setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
		return this;
	}
    
	private Date updateDate;
	public Date getUpdateDate() {
		return updateDate;
	}
	public SupplierMappingQuery setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
		return this;
	}
    
	private Integer updatorId;
	public Integer getUpdatorId() {
		return updatorId;
	}
	public SupplierMappingQuery setUpdatorId(Integer updatorId) {
		this.updatorId = updatorId;
		return this;
	}
    
	private String isDel;
	public String getIsDel() {
		return isDel;
	}
	public SupplierMappingQuery setIsDel(String isDel) {
		this.isDel = isDel;
		return this;
	}
	private boolean isDelLike;
	public SupplierMappingQuery setIsDelLike(boolean isLike) {
		this.isDelLike = isLike;
		return this;
	}
    
	/**
	 * ==============================批量查询时的Order条件顺序设置==========================
	 * ========
	 **/
	 public class OrderField {
		public OrderField(String fieldName, String order) {
			super();
			this.fieldName = fieldName;
			this.order = order;
		}
		private String fieldName;
		private String order;

		public String getFieldName() {
			return fieldName;
		}
		public OrderField setFieldName(String fieldName) {
			this.fieldName = fieldName;
			return this;
		}
		public String getOrder() {
			return order;
		}
		public OrderField setOrder(String order) {
			this.order = order;
			return this;
		}
	 }
		/**
	 * ==============================批量查询时的Order条件顺序设置==========================
	 * ========
	 **/
	/** 排序列表字段 **/
	private List<OrderField> orderFields = new ArrayList<OrderField>();
	
	/**
	 * 设置排序按属性：id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierMappingQuery orderbyId(boolean isAsc) {
		orderFields.add(new OrderField("id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：product_brand
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierMappingQuery orderbyProductBrand(boolean isAsc) {
		orderFields.add(new OrderField("product_brand", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：product_name
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierMappingQuery orderbyProductName(boolean isAsc) {
		orderFields.add(new OrderField("product_name", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：product_code
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierMappingQuery orderbyProductCode(boolean isAsc) {
		orderFields.add(new OrderField("product_code", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：reference_code
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierMappingQuery orderbyReferenceCode(boolean isAsc) {
		orderFields.add(new OrderField("reference_code", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：reference_brand
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierMappingQuery orderbyReferenceBrand(boolean isAsc) {
		orderFields.add(new OrderField("reference_brand", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：oe_code
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierMappingQuery orderbyOeCode(boolean isAsc) {
		orderFields.add(new OrderField("oe_code", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：first_price
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierMappingQuery orderbyFirstPrice(boolean isAsc) {
		orderFields.add(new OrderField("first_price", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：second_price
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierMappingQuery orderbySecondPrice(boolean isAsc) {
		orderFields.add(new OrderField("second_price", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：third_price
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierMappingQuery orderbyThirdPrice(boolean isAsc) {
		orderFields.add(new OrderField("third_price", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：status
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierMappingQuery orderbyStatus(boolean isAsc) {
		orderFields.add(new OrderField("status", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：supplier_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierMappingQuery orderbySupplierId(boolean isAsc) {
		orderFields.add(new OrderField("supplier_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：create_date
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierMappingQuery orderbyCreateDate(boolean isAsc) {
		orderFields.add(new OrderField("create_date", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：creator_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierMappingQuery orderbyCreatorId(boolean isAsc) {
		orderFields.add(new OrderField("creator_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：update_date
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierMappingQuery orderbyUpdateDate(boolean isAsc) {
		orderFields.add(new OrderField("update_date", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：updator_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierMappingQuery orderbyUpdatorId(boolean isAsc) {
		orderFields.add(new OrderField("updator_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：is_del
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierMappingQuery orderbyIsDel(boolean isAsc) {
		orderFields.add(new OrderField("is_del", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	
}
