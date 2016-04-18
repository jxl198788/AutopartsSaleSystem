package com.fjsaas.web.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

import com.fjsaas.web.query.BaseQuery;

public class ProductcodeOeQuery extends BaseQuery {
	/**
	 * ==============================批量查询、更新、删除时的Where条件设置======================
	 * ============
	 **/
	private Integer id;
	public Integer getId() {
		return id;
	}
	public ProductcodeOeQuery setId(Integer id) {
		this.id = id;
		return this;
	}
    
	private String referenceCode;
	public String getReferenceCode() {
		return referenceCode;
	}
	public ProductcodeOeQuery setReferenceCode(String referenceCode) {
		this.referenceCode = referenceCode;
		return this;
	}
	private boolean referenceCodeLike;
	public ProductcodeOeQuery setReferenceCodeLike(boolean isLike) {
		this.referenceCodeLike = isLike;
		return this;
	}
    
	private String oeCode;
	public String getOeCode() {
		return oeCode;
	}
	public ProductcodeOeQuery setOeCode(String oeCode) {
		this.oeCode = oeCode;
		return this;
	}
	private boolean oeCodeLike;
	public ProductcodeOeQuery setOeCodeLike(boolean isLike) {
		this.oeCodeLike = isLike;
		return this;
	}
    
	private String productCode;
	public String getProductCode() {
		return productCode;
	}
	public ProductcodeOeQuery setProductCode(String productCode) {
		this.productCode = productCode;
		return this;
	}
	private boolean productCodeLike;
	public ProductcodeOeQuery setProductCodeLike(boolean isLike) {
		this.productCodeLike = isLike;
		return this;
	}
    
	private Date createDate;
	public Date getCreateDate() {
		return createDate;
	}
	public ProductcodeOeQuery setCreateDate(Date createDate) {
		this.createDate = createDate;
		return this;
	}
    
	private Integer creatorId;
	public Integer getCreatorId() {
		return creatorId;
	}
	public ProductcodeOeQuery setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
		return this;
	}
    
	private Date updateDate;
	public Date getUpdateDate() {
		return updateDate;
	}
	public ProductcodeOeQuery setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
		return this;
	}
    
	private Integer updatorId;
	public Integer getUpdatorId() {
		return updatorId;
	}
	public ProductcodeOeQuery setUpdatorId(Integer updatorId) {
		this.updatorId = updatorId;
		return this;
	}
    
	private String isDel;
	public String getIsDel() {
		return isDel;
	}
	public ProductcodeOeQuery setIsDel(String isDel) {
		this.isDel = isDel;
		return this;
	}
	private boolean isDelLike;
	public ProductcodeOeQuery setIsDelLike(boolean isLike) {
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
	public ProductcodeOeQuery orderbyId(boolean isAsc) {
		orderFields.add(new OrderField("id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：reference_code
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public ProductcodeOeQuery orderbyReferenceCode(boolean isAsc) {
		orderFields.add(new OrderField("reference_code", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：oe_code
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public ProductcodeOeQuery orderbyOeCode(boolean isAsc) {
		orderFields.add(new OrderField("oe_code", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：product_code
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public ProductcodeOeQuery orderbyProductCode(boolean isAsc) {
		orderFields.add(new OrderField("product_code", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：create_date
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public ProductcodeOeQuery orderbyCreateDate(boolean isAsc) {
		orderFields.add(new OrderField("create_date", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：creator_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public ProductcodeOeQuery orderbyCreatorId(boolean isAsc) {
		orderFields.add(new OrderField("creator_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：update_date
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public ProductcodeOeQuery orderbyUpdateDate(boolean isAsc) {
		orderFields.add(new OrderField("update_date", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：updator_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public ProductcodeOeQuery orderbyUpdatorId(boolean isAsc) {
		orderFields.add(new OrderField("updator_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：is_del
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public ProductcodeOeQuery orderbyIsDel(boolean isAsc) {
		orderFields.add(new OrderField("is_del", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	
}
