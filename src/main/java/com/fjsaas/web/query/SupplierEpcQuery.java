package com.fjsaas.web.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

import com.fjsaas.web.query.BaseQuery;

public class SupplierEpcQuery extends BaseQuery {
	/**
	 * ==============================批量查询、更新、删除时的Where条件设置======================
	 * ============
	 **/
	private Integer id;
	public Integer getId() {
		return id;
	}
	public SupplierEpcQuery setId(Integer id) {
		this.id = id;
		return this;
	}
    
	private String oeCode;
	public String getOeCode() {
		return oeCode;
	}
	public SupplierEpcQuery setOeCode(String oeCode) {
		this.oeCode = oeCode;
		return this;
	}
	private boolean oeCodeLike;
	public SupplierEpcQuery setOeCodeLike(boolean isLike) {
		this.oeCodeLike = isLike;
		return this;
	}
    
	private String productName;
	public String getProductName() {
		return productName;
	}
	public SupplierEpcQuery setProductName(String productName) {
		this.productName = productName;
		return this;
	}
	private boolean productNameLike;
	public SupplierEpcQuery setProductNameLike(boolean isLike) {
		this.productNameLike = isLike;
		return this;
	}
    
	private String type;
	public String getType() {
		return type;
	}
	public SupplierEpcQuery setType(String type) {
		this.type = type;
		return this;
	}
	private boolean typeLike;
	public SupplierEpcQuery setTypeLike(boolean isLike) {
		this.typeLike = isLike;
		return this;
	}
    
	private String size;
	public String getSize() {
		return size;
	}
	public SupplierEpcQuery setSize(String size) {
		this.size = size;
		return this;
	}
	private boolean sizeLike;
	public SupplierEpcQuery setSizeLike(boolean isLike) {
		this.sizeLike = isLike;
		return this;
	}
    
	private String attributes;
	public String getAttributes() {
		return attributes;
	}
	public SupplierEpcQuery setAttributes(String attributes) {
		this.attributes = attributes;
		return this;
	}
	private boolean attributesLike;
	public SupplierEpcQuery setAttributesLike(boolean isLike) {
		this.attributesLike = isLike;
		return this;
	}
    
	private Integer partSortId;
	public Integer getPartSortId() {
		return partSortId;
	}
	public SupplierEpcQuery setPartSortId(Integer partSortId) {
		this.partSortId = partSortId;
		return this;
	}
    
	private Integer supplierId;
	public Integer getSupplierId() {
		return supplierId;
	}
	public SupplierEpcQuery setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
		return this;
	}
    
	private Integer typeId;
	public Integer getTypeId() {
		return typeId;
	}
	public SupplierEpcQuery setTypeId(Integer typeId) {
		this.typeId = typeId;
		return this;
	}
    
	private String status;
	public String getStatus() {
		return status;
	}
	public SupplierEpcQuery setStatus(String status) {
		this.status = status;
		return this;
	}
	private boolean statusLike;
	public SupplierEpcQuery setStatusLike(boolean isLike) {
		this.statusLike = isLike;
		return this;
	}
    
	private String platformStatus;
	public String getPlatformStatus() {
		return platformStatus;
	}
	public SupplierEpcQuery setPlatformStatus(String platformStatus) {
		this.platformStatus = platformStatus;
		return this;
	}
	private boolean platformStatusLike;
	public SupplierEpcQuery setPlatformStatusLike(boolean isLike) {
		this.platformStatusLike = isLike;
		return this;
	}
    
	private Date createDate;
	public Date getCreateDate() {
		return createDate;
	}
	public SupplierEpcQuery setCreateDate(Date createDate) {
		this.createDate = createDate;
		return this;
	}
    
	private Integer creatorId;
	public Integer getCreatorId() {
		return creatorId;
	}
	public SupplierEpcQuery setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
		return this;
	}
    
	private Date updateDate;
	public Date getUpdateDate() {
		return updateDate;
	}
	public SupplierEpcQuery setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
		return this;
	}
    
	private Integer updatorId;
	public Integer getUpdatorId() {
		return updatorId;
	}
	public SupplierEpcQuery setUpdatorId(Integer updatorId) {
		this.updatorId = updatorId;
		return this;
	}
    
	private String isDel;
	public String getIsDel() {
		return isDel;
	}
	public SupplierEpcQuery setIsDel(String isDel) {
		this.isDel = isDel;
		return this;
	}
	private boolean isDelLike;
	public SupplierEpcQuery setIsDelLike(boolean isLike) {
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
	public SupplierEpcQuery orderbyId(boolean isAsc) {
		orderFields.add(new OrderField("id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：oe_code
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierEpcQuery orderbyOeCode(boolean isAsc) {
		orderFields.add(new OrderField("oe_code", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：product_name
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierEpcQuery orderbyProductName(boolean isAsc) {
		orderFields.add(new OrderField("product_name", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：type
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierEpcQuery orderbyType(boolean isAsc) {
		orderFields.add(new OrderField("type", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：size
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierEpcQuery orderbySize(boolean isAsc) {
		orderFields.add(new OrderField("size", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：attributes
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierEpcQuery orderbyAttributes(boolean isAsc) {
		orderFields.add(new OrderField("attributes", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：part_sort_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierEpcQuery orderbyPartSortId(boolean isAsc) {
		orderFields.add(new OrderField("part_sort_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：supplier_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierEpcQuery orderbySupplierId(boolean isAsc) {
		orderFields.add(new OrderField("supplier_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：type_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierEpcQuery orderbyTypeId(boolean isAsc) {
		orderFields.add(new OrderField("type_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：status
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierEpcQuery orderbyStatus(boolean isAsc) {
		orderFields.add(new OrderField("status", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：platform_status
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierEpcQuery orderbyPlatformStatus(boolean isAsc) {
		orderFields.add(new OrderField("platform_status", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：create_date
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierEpcQuery orderbyCreateDate(boolean isAsc) {
		orderFields.add(new OrderField("create_date", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：creator_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierEpcQuery orderbyCreatorId(boolean isAsc) {
		orderFields.add(new OrderField("creator_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：update_date
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierEpcQuery orderbyUpdateDate(boolean isAsc) {
		orderFields.add(new OrderField("update_date", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：updator_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierEpcQuery orderbyUpdatorId(boolean isAsc) {
		orderFields.add(new OrderField("updator_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：is_del
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierEpcQuery orderbyIsDel(boolean isAsc) {
		orderFields.add(new OrderField("is_del", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	
}
