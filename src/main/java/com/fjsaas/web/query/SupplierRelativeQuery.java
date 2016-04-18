package com.fjsaas.web.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

import com.fjsaas.web.query.BaseQuery;

public class SupplierRelativeQuery extends BaseQuery {
	/**
	 * ==============================批量查询、更新、删除时的Where条件设置======================
	 * ============
	 **/
	private Integer id;
	public Integer getId() {
		return id;
	}
	public SupplierRelativeQuery setId(Integer id) {
		this.id = id;
		return this;
	}
    
	private String name;
	public String getName() {
		return name;
	}
	public SupplierRelativeQuery setName(String name) {
		this.name = name;
		return this;
	}
	private boolean nameLike;
	public SupplierRelativeQuery setNameLike(boolean isLike) {
		this.nameLike = isLike;
		return this;
	}
    
	private Integer supplierId;
	public Integer getSupplierId() {
		return supplierId;
	}
	public SupplierRelativeQuery setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
		return this;
	}
    
	private Integer parentId;
	public Integer getParentId() {
		return parentId;
	}
	public SupplierRelativeQuery setParentId(Integer parentId) {
		this.parentId = parentId;
		return this;
	}
    
	private Date createDate;
	public Date getCreateDate() {
		return createDate;
	}
	public SupplierRelativeQuery setCreateDate(Date createDate) {
		this.createDate = createDate;
		return this;
	}
    
	private Integer creatorId;
	public Integer getCreatorId() {
		return creatorId;
	}
	public SupplierRelativeQuery setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
		return this;
	}
    
	private Date updateDate;
	public Date getUpdateDate() {
		return updateDate;
	}
	public SupplierRelativeQuery setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
		return this;
	}
    
	private Integer updatorId;
	public Integer getUpdatorId() {
		return updatorId;
	}
	public SupplierRelativeQuery setUpdatorId(Integer updatorId) {
		this.updatorId = updatorId;
		return this;
	}
    
	private String isDel;
	public String getIsDel() {
		return isDel;
	}
	public SupplierRelativeQuery setIsDel(String isDel) {
		this.isDel = isDel;
		return this;
	}
	private boolean isDelLike;
	public SupplierRelativeQuery setIsDelLike(boolean isLike) {
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
	public SupplierRelativeQuery orderbyId(boolean isAsc) {
		orderFields.add(new OrderField("id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：name
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierRelativeQuery orderbyName(boolean isAsc) {
		orderFields.add(new OrderField("name", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：supplier_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierRelativeQuery orderbySupplierId(boolean isAsc) {
		orderFields.add(new OrderField("supplier_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：parent_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierRelativeQuery orderbyParentId(boolean isAsc) {
		orderFields.add(new OrderField("parent_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：create_date
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierRelativeQuery orderbyCreateDate(boolean isAsc) {
		orderFields.add(new OrderField("create_date", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：creator_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierRelativeQuery orderbyCreatorId(boolean isAsc) {
		orderFields.add(new OrderField("creator_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：update_date
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierRelativeQuery orderbyUpdateDate(boolean isAsc) {
		orderFields.add(new OrderField("update_date", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：updator_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierRelativeQuery orderbyUpdatorId(boolean isAsc) {
		orderFields.add(new OrderField("updator_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：is_del
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierRelativeQuery orderbyIsDel(boolean isAsc) {
		orderFields.add(new OrderField("is_del", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	
}
