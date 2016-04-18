package com.fjsaas.web.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

import com.fjsaas.web.query.BaseQuery;

public class TaskQuery extends BaseQuery {
	/**
	 * ==============================批量查询、更新、删除时的Where条件设置======================
	 * ============
	 **/
	private Integer id;
	public Integer getId() {
		return id;
	}
	public TaskQuery setId(Integer id) {
		this.id = id;
		return this;
	}
    
	private String code;
	public String getCode() {
		return code;
	}
	public TaskQuery setCode(String code) {
		this.code = code;
		return this;
	}
	private boolean codeLike;
	public TaskQuery setCodeLike(boolean isLike) {
		this.codeLike = isLike;
		return this;
	}
    
	private String title;
	public String getTitle() {
		return title;
	}
	public TaskQuery setTitle(String title) {
		this.title = title;
		return this;
	}
	private boolean titleLike;
	public TaskQuery setTitleLike(boolean isLike) {
		this.titleLike = isLike;
		return this;
	}
    
	private Integer submitUserId;
	public Integer getSubmitUserId() {
		return submitUserId;
	}
	public TaskQuery setSubmitUserId(Integer submitUserId) {
		this.submitUserId = submitUserId;
		return this;
	}
    
	private Date submitDate;
	public Date getSubmitDate() {
		return submitDate;
	}
	public TaskQuery setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
		return this;
	}
    
	private Integer roleId;
	public Integer getRoleId() {
		return roleId;
	}
	public TaskQuery setRoleId(Integer roleId) {
		this.roleId = roleId;
		return this;
	}
    
	private Integer finishUserId;
	public Integer getFinishUserId() {
		return finishUserId;
	}
	public TaskQuery setFinishUserId(Integer finishUserId) {
		this.finishUserId = finishUserId;
		return this;
	}
    
	private Date endDate;
	public Date getEndDate() {
		return endDate;
	}
	public TaskQuery setEndDate(Date endDate) {
		this.endDate = endDate;
		return this;
	}
    
	private String status;
	public String getStatus() {
		return status;
	}
	public TaskQuery setStatus(String status) {
		this.status = status;
		return this;
	}
	private boolean statusLike;
	public TaskQuery setStatusLike(boolean isLike) {
		this.statusLike = isLike;
		return this;
	}
    
	private Date createDate;
	public Date getCreateDate() {
		return createDate;
	}
	public TaskQuery setCreateDate(Date createDate) {
		this.createDate = createDate;
		return this;
	}
    
	private Integer creatorId;
	public Integer getCreatorId() {
		return creatorId;
	}
	public TaskQuery setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
		return this;
	}
    
	private Date updateDate;
	public Date getUpdateDate() {
		return updateDate;
	}
	public TaskQuery setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
		return this;
	}
    
	private Integer updatorId;
	public Integer getUpdatorId() {
		return updatorId;
	}
	public TaskQuery setUpdatorId(Integer updatorId) {
		this.updatorId = updatorId;
		return this;
	}
    
	private String isDel;
	public String getIsDel() {
		return isDel;
	}
	public TaskQuery setIsDel(String isDel) {
		this.isDel = isDel;
		return this;
	}
	private boolean isDelLike;
	public TaskQuery setIsDelLike(boolean isLike) {
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
	public TaskQuery orderbyId(boolean isAsc) {
		orderFields.add(new OrderField("id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：code
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public TaskQuery orderbyCode(boolean isAsc) {
		orderFields.add(new OrderField("code", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：title
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public TaskQuery orderbyTitle(boolean isAsc) {
		orderFields.add(new OrderField("title", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：submit_user_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public TaskQuery orderbySubmitUserId(boolean isAsc) {
		orderFields.add(new OrderField("submit_user_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：submit_date
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public TaskQuery orderbySubmitDate(boolean isAsc) {
		orderFields.add(new OrderField("submit_date", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：role_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public TaskQuery orderbyRoleId(boolean isAsc) {
		orderFields.add(new OrderField("role_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：finish_user_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public TaskQuery orderbyFinishUserId(boolean isAsc) {
		orderFields.add(new OrderField("finish_user_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：end_date
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public TaskQuery orderbyEndDate(boolean isAsc) {
		orderFields.add(new OrderField("end_date", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：status
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public TaskQuery orderbyStatus(boolean isAsc) {
		orderFields.add(new OrderField("status", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：create_date
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public TaskQuery orderbyCreateDate(boolean isAsc) {
		orderFields.add(new OrderField("create_date", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：creator_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public TaskQuery orderbyCreatorId(boolean isAsc) {
		orderFields.add(new OrderField("creator_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：update_date
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public TaskQuery orderbyUpdateDate(boolean isAsc) {
		orderFields.add(new OrderField("update_date", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：updator_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public TaskQuery orderbyUpdatorId(boolean isAsc) {
		orderFields.add(new OrderField("updator_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：is_del
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public TaskQuery orderbyIsDel(boolean isAsc) {
		orderFields.add(new OrderField("is_del", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	
}
