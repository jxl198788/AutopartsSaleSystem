package com.fjsaas.web.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

import com.fjsaas.web.query.BaseQuery;

public class SupplierTaskQuery extends BaseQuery {
	/**
	 * ==============================批量查询、更新、删除时的Where条件设置======================
	 * ============
	 **/
	private Integer id;
	public Integer getId() {
		return id;
	}
	public SupplierTaskQuery setId(Integer id) {
		this.id = id;
		return this;
	}
    
	private String name;
	public String getName() {
		return name;
	}
	public SupplierTaskQuery setName(String name) {
		this.name = name;
		return this;
	}
	private boolean nameLike;
	public SupplierTaskQuery setNameLike(boolean isLike) {
		this.nameLike = isLike;
		return this;
	}
    
	private String content;
	public String getContent() {
		return content;
	}
	public SupplierTaskQuery setContent(String content) {
		this.content = content;
		return this;
	}
	private boolean contentLike;
	public SupplierTaskQuery setContentLike(boolean isLike) {
		this.contentLike = isLike;
		return this;
	}
    
	private Integer total;
	public Integer getTotal() {
		return total;
	}
	public SupplierTaskQuery setTotal(Integer total) {
		this.total = total;
		return this;
	}
    
	private Integer successNum;
	public Integer getSuccessNum() {
		return successNum;
	}
	public SupplierTaskQuery setSuccessNum(Integer successNum) {
		this.successNum = successNum;
		return this;
	}
    
	private Integer failNum;
	public Integer getFailNum() {
		return failNum;
	}
	public SupplierTaskQuery setFailNum(Integer failNum) {
		this.failNum = failNum;
		return this;
	}
    
	private String status;
	public String getStatus() {
		return status;
	}
	public SupplierTaskQuery setStatus(String status) {
		this.status = status;
		return this;
	}
	private boolean statusLike;
	public SupplierTaskQuery setStatusLike(boolean isLike) {
		this.statusLike = isLike;
		return this;
	}
    
	private Date createDate;
	public Date getCreateDate() {
		return createDate;
	}
	public SupplierTaskQuery setCreateDate(Date createDate) {
		this.createDate = createDate;
		return this;
	}
    
	private Date endDate;
	public Date getEndDate() {
		return endDate;
	}
	public SupplierTaskQuery setEndDate(Date endDate) {
		this.endDate = endDate;
		return this;
	}
    
	private Integer creatorId;
	public Integer getCreatorId() {
		return creatorId;
	}
	public SupplierTaskQuery setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
		return this;
	}
    
	private Date updateDate;
	public Date getUpdateDate() {
		return updateDate;
	}
	public SupplierTaskQuery setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
		return this;
	}
    
	private Integer updatorId;
	public Integer getUpdatorId() {
		return updatorId;
	}
	public SupplierTaskQuery setUpdatorId(Integer updatorId) {
		this.updatorId = updatorId;
		return this;
	}
    
	private String isDel;
	public String getIsDel() {
		return isDel;
	}
	public SupplierTaskQuery setIsDel(String isDel) {
		this.isDel = isDel;
		return this;
	}
	private boolean isDelLike;
	public SupplierTaskQuery setIsDelLike(boolean isLike) {
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
	public SupplierTaskQuery orderbyId(boolean isAsc) {
		orderFields.add(new OrderField("id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：name
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierTaskQuery orderbyName(boolean isAsc) {
		orderFields.add(new OrderField("name", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：content
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierTaskQuery orderbyContent(boolean isAsc) {
		orderFields.add(new OrderField("content", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：total
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierTaskQuery orderbyTotal(boolean isAsc) {
		orderFields.add(new OrderField("total", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：success_num
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierTaskQuery orderbySuccessNum(boolean isAsc) {
		orderFields.add(new OrderField("success_num", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：fail_num
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierTaskQuery orderbyFailNum(boolean isAsc) {
		orderFields.add(new OrderField("fail_num", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：status
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierTaskQuery orderbyStatus(boolean isAsc) {
		orderFields.add(new OrderField("status", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：create_date
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierTaskQuery orderbyCreateDate(boolean isAsc) {
		orderFields.add(new OrderField("create_date", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：end_date
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierTaskQuery orderbyEndDate(boolean isAsc) {
		orderFields.add(new OrderField("end_date", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：creator_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierTaskQuery orderbyCreatorId(boolean isAsc) {
		orderFields.add(new OrderField("creator_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：update_date
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierTaskQuery orderbyUpdateDate(boolean isAsc) {
		orderFields.add(new OrderField("update_date", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：updator_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierTaskQuery orderbyUpdatorId(boolean isAsc) {
		orderFields.add(new OrderField("updator_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：is_del
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierTaskQuery orderbyIsDel(boolean isAsc) {
		orderFields.add(new OrderField("is_del", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	
}
