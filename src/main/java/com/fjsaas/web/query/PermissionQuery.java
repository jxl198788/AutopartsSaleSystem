package com.fjsaas.web.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

import com.fjsaas.web.query.BaseQuery;

public class PermissionQuery extends BaseQuery {
	/**
	 * ==============================批量查询、更新、删除时的Where条件设置======================
	 * ============
	 **/
	private Integer id;
	public Integer getId() {
		return id;
	}
	public PermissionQuery setId(Integer id) {
		this.id = id;
		return this;
	}
    
	private String name;
	public String getName() {
		return name;
	}
	public PermissionQuery setName(String name) {
		this.name = name;
		return this;
	}
	private boolean nameLike;
	public PermissionQuery setNameLike(boolean isLike) {
		this.nameLike = isLike;
		return this;
	}
    
	private String type;
	public String getType() {
		return type;
	}
	public PermissionQuery setType(String type) {
		this.type = type;
		return this;
	}
	private boolean typeLike;
	public PermissionQuery setTypeLike(boolean isLike) {
		this.typeLike = isLike;
		return this;
	}
    
	private String url;
	public String getUrl() {
		return url;
	}
	public PermissionQuery setUrl(String url) {
		this.url = url;
		return this;
	}
	private boolean urlLike;
	public PermissionQuery setUrlLike(boolean isLike) {
		this.urlLike = isLike;
		return this;
	}
    
	private String percode;
	public String getPercode() {
		return percode;
	}
	public PermissionQuery setPercode(String percode) {
		this.percode = percode;
		return this;
	}
	private boolean percodeLike;
	public PermissionQuery setPercodeLike(boolean isLike) {
		this.percodeLike = isLike;
		return this;
	}
    
	private Integer parentid;
	public Integer getParentid() {
		return parentid;
	}
	public PermissionQuery setParentid(Integer parentid) {
		this.parentid = parentid;
		return this;
	}
    
	private String parentids;
	public String getParentids() {
		return parentids;
	}
	public PermissionQuery setParentids(String parentids) {
		this.parentids = parentids;
		return this;
	}
    
	private Date createDate;
	public Date getCreateDate() {
		return createDate;
	}
	public PermissionQuery setCreateDate(Date createDate) {
		this.createDate = createDate;
		return this;
	}
    
	private Integer creatorId;
	public Integer getCreatorId() {
		return creatorId;
	}
	public PermissionQuery setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
		return this;
	}
    
	private Date updateDate;
	public Date getUpdateDate() {
		return updateDate;
	}
	public PermissionQuery setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
		return this;
	}
    
	private Integer updatorId;
	public Integer getUpdatorId() {
		return updatorId;
	}
	public PermissionQuery setUpdatorId(Integer updatorId) {
		this.updatorId = updatorId;
		return this;
	}
    
	private String isDel;
	public String getIsDel() {
		return isDel;
	}
	public PermissionQuery setIsDel(String isDel) {
		this.isDel = isDel;
		return this;
	}
	private boolean isDelLike;
	public PermissionQuery setIsDelLike(boolean isLike) {
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
	public PermissionQuery orderbyId(boolean isAsc) {
		orderFields.add(new OrderField("id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：name
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public PermissionQuery orderbyName(boolean isAsc) {
		orderFields.add(new OrderField("name", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：type
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public PermissionQuery orderbyType(boolean isAsc) {
		orderFields.add(new OrderField("type", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：url
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public PermissionQuery orderbyUrl(boolean isAsc) {
		orderFields.add(new OrderField("url", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：percode
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public PermissionQuery orderbyPercode(boolean isAsc) {
		orderFields.add(new OrderField("percode", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：parentid
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public PermissionQuery orderbyParentid(boolean isAsc) {
		orderFields.add(new OrderField("parentid", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：parentids
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public PermissionQuery orderbyParentids(boolean isAsc) {
		orderFields.add(new OrderField("parentids", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：create_date
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public PermissionQuery orderbyCreateDate(boolean isAsc) {
		orderFields.add(new OrderField("create_date", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：creator_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public PermissionQuery orderbyCreatorId(boolean isAsc) {
		orderFields.add(new OrderField("creator_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：update_date
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public PermissionQuery orderbyUpdateDate(boolean isAsc) {
		orderFields.add(new OrderField("update_date", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：updator_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public PermissionQuery orderbyUpdatorId(boolean isAsc) {
		orderFields.add(new OrderField("updator_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：is_del
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public PermissionQuery orderbyIsDel(boolean isAsc) {
		orderFields.add(new OrderField("is_del", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	
}
