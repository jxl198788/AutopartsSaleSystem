package com.fjsaas.web.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

import com.fjsaas.web.query.BaseQuery;

public class QuotaQuery extends BaseQuery {
	/**
	 * ==============================批量查询、更新、删除时的Where条件设置======================
	 * ============
	 **/
	private Integer id;
	public Integer getId() {
		return id;
	}
	public QuotaQuery setId(Integer id) {
		this.id = id;
		return this;
	}
    
	private Integer quota;
	public Integer getQuota() {
		return quota;
	}
	public QuotaQuery setQuota(Integer quota) {
		this.quota = quota;
		return this;
	}
    
	private Integer supplierId;
	public Integer getSupplierId() {
		return supplierId;
	}
	public QuotaQuery setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
		return this;
	}
    
	private Integer permissionId;
	public Integer getPermissionId() {
		return permissionId;
	}
	public QuotaQuery setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
		return this;
	}
    
	private Date createDate;
	public Date getCreateDate() {
		return createDate;
	}
	public QuotaQuery setCreateDate(Date createDate) {
		this.createDate = createDate;
		return this;
	}
    
	private Integer creatorId;
	public Integer getCreatorId() {
		return creatorId;
	}
	public QuotaQuery setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
		return this;
	}
    
	private Date updateDate;
	public Date getUpdateDate() {
		return updateDate;
	}
	public QuotaQuery setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
		return this;
	}
    
	private Integer updatorId;
	public Integer getUpdatorId() {
		return updatorId;
	}
	public QuotaQuery setUpdatorId(Integer updatorId) {
		this.updatorId = updatorId;
		return this;
	}
    
	private String isDel;
	public String getIsDel() {
		return isDel;
	}
	public QuotaQuery setIsDel(String isDel) {
		this.isDel = isDel;
		return this;
	}
	private boolean isDelLike;
	public QuotaQuery setIsDelLike(boolean isLike) {
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
	public QuotaQuery orderbyId(boolean isAsc) {
		orderFields.add(new OrderField("id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：quota
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public QuotaQuery orderbyQuota(boolean isAsc) {
		orderFields.add(new OrderField("quota", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：supplier_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public QuotaQuery orderbySupplierId(boolean isAsc) {
		orderFields.add(new OrderField("supplier_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：permission_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public QuotaQuery orderbyPermissionId(boolean isAsc) {
		orderFields.add(new OrderField("permission_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：create_date
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public QuotaQuery orderbyCreateDate(boolean isAsc) {
		orderFields.add(new OrderField("create_date", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：creator_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public QuotaQuery orderbyCreatorId(boolean isAsc) {
		orderFields.add(new OrderField("creator_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：update_date
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public QuotaQuery orderbyUpdateDate(boolean isAsc) {
		orderFields.add(new OrderField("update_date", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：updator_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public QuotaQuery orderbyUpdatorId(boolean isAsc) {
		orderFields.add(new OrderField("updator_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：is_del
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public QuotaQuery orderbyIsDel(boolean isAsc) {
		orderFields.add(new OrderField("is_del", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	
}
