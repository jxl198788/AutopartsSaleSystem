package com.fjsaas.web.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

import com.fjsaas.web.query.BaseQuery;

public class OperateLogQuery extends BaseQuery {
	/**
	 * ==============================批量查询、更新、删除时的Where条件设置======================
	 * ============
	 **/
	private Integer id;
	public Integer getId() {
		return id;
	}
	public OperateLogQuery setId(Integer id) {
		this.id = id;
		return this;
	}
    
	private String type;
	public String getType() {
		return type;
	}
	public OperateLogQuery setType(String type) {
		this.type = type;
		return this;
	}
	private boolean typeLike;
	public OperateLogQuery setTypeLike(boolean isLike) {
		this.typeLike = isLike;
		return this;
	}
    
	private String content;
	public String getContent() {
		return content;
	}
	public OperateLogQuery setContent(String content) {
		this.content = content;
		return this;
	}
	private boolean contentLike;
	public OperateLogQuery setContentLike(boolean isLike) {
		this.contentLike = isLike;
		return this;
	}
    
	private Integer userId;
	public Integer getUserId() {
		return userId;
	}
	public OperateLogQuery setUserId(Integer userId) {
		this.userId = userId;
		return this;
	}
    
	private String userName;
	public String getUserName() {
		return userName;
	}
	public OperateLogQuery setUserName(String userName) {
		this.userName = userName;
		return this;
	}
	private boolean userNameLike;
	public OperateLogQuery setUserNameLike(boolean isLike) {
		this.userNameLike = isLike;
		return this;
	}
    
	private String userCompany;
	public String getUserCompany() {
		return userCompany;
	}
	public OperateLogQuery setUserCompany(String userCompany) {
		this.userCompany = userCompany;
		return this;
	}
	private boolean userCompanyLike;
	public OperateLogQuery setUserCompanyLike(boolean isLike) {
		this.userCompanyLike = isLike;
		return this;
	}
    
	private String operationTime;
	public String getOperationTime() {
		return operationTime;
	}
	public OperateLogQuery setOperationTime(String operationTime) {
		this.operationTime = operationTime;
		return this;
	}
	private boolean operationTimeLike;
	public OperateLogQuery setOperationTimeLike(boolean isLike) {
		this.operationTimeLike = isLike;
		return this;
	}
    
	private Date createDate;
	public Date getCreateDate() {
		return createDate;
	}
	public OperateLogQuery setCreateDate(Date createDate) {
		this.createDate = createDate;
		return this;
	}
    
	private Integer creatorId;
	public Integer getCreatorId() {
		return creatorId;
	}
	public OperateLogQuery setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
		return this;
	}
    
	private Date updateDate;
	public Date getUpdateDate() {
		return updateDate;
	}
	public OperateLogQuery setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
		return this;
	}
    
	private Integer updatorId;
	public Integer getUpdatorId() {
		return updatorId;
	}
	public OperateLogQuery setUpdatorId(Integer updatorId) {
		this.updatorId = updatorId;
		return this;
	}
    
	private String isDel;
	public String getIsDel() {
		return isDel;
	}
	public OperateLogQuery setIsDel(String isDel) {
		this.isDel = isDel;
		return this;
	}
	private boolean isDelLike;
	public OperateLogQuery setIsDelLike(boolean isLike) {
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
	public OperateLogQuery orderbyId(boolean isAsc) {
		orderFields.add(new OrderField("id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：type
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public OperateLogQuery orderbyType(boolean isAsc) {
		orderFields.add(new OrderField("type", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：content
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public OperateLogQuery orderbyContent(boolean isAsc) {
		orderFields.add(new OrderField("content", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：user_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public OperateLogQuery orderbyUserId(boolean isAsc) {
		orderFields.add(new OrderField("user_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：user_name
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public OperateLogQuery orderbyUserName(boolean isAsc) {
		orderFields.add(new OrderField("user_name", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：user_company
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public OperateLogQuery orderbyUserCompany(boolean isAsc) {
		orderFields.add(new OrderField("user_company", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：operation_time
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public OperateLogQuery orderbyOperationTime(boolean isAsc) {
		orderFields.add(new OrderField("operation_time", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：create_date
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public OperateLogQuery orderbyCreateDate(boolean isAsc) {
		orderFields.add(new OrderField("create_date", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：creator_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public OperateLogQuery orderbyCreatorId(boolean isAsc) {
		orderFields.add(new OrderField("creator_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：update_date
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public OperateLogQuery orderbyUpdateDate(boolean isAsc) {
		orderFields.add(new OrderField("update_date", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：updator_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public OperateLogQuery orderbyUpdatorId(boolean isAsc) {
		orderFields.add(new OrderField("updator_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：is_del
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public OperateLogQuery orderbyIsDel(boolean isAsc) {
		orderFields.add(new OrderField("is_del", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	
}
