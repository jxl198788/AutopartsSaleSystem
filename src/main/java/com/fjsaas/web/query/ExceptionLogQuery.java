package com.fjsaas.web.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

import com.fjsaas.web.query.BaseQuery;

public class ExceptionLogQuery extends BaseQuery {
	/**
	 * ==============================批量查询、更新、删除时的Where条件设置======================
	 * ============
	 **/
	private Integer id;
	public Integer getId() {
		return id;
	}
	public ExceptionLogQuery setId(Integer id) {
		this.id = id;
		return this;
	}
    
	private String thread;
	public String getThread() {
		return thread;
	}
	public ExceptionLogQuery setThread(String thread) {
		this.thread = thread;
		return this;
	}
	private boolean threadLike;
	public ExceptionLogQuery setThreadLike(boolean isLike) {
		this.threadLike = isLike;
		return this;
	}
    
	private String level;
	public String getLevel() {
		return level;
	}
	public ExceptionLogQuery setLevel(String level) {
		this.level = level;
		return this;
	}
	private boolean levelLike;
	public ExceptionLogQuery setLevelLike(boolean isLike) {
		this.levelLike = isLike;
		return this;
	}
    
	private String className;
	public String getClassName() {
		return className;
	}
	public ExceptionLogQuery setClassName(String className) {
		this.className = className;
		return this;
	}
	private boolean classNameLike;
	public ExceptionLogQuery setClassNameLike(boolean isLike) {
		this.classNameLike = isLike;
		return this;
	}
    
	private String message;
	public String getMessage() {
		return message;
	}
	public ExceptionLogQuery setMessage(String message) {
		this.message = message;
		return this;
	}
	private boolean messageLike;
	public ExceptionLogQuery setMessageLike(boolean isLike) {
		this.messageLike = isLike;
		return this;
	}
    
	private String location;
	public String getLocation() {
		return location;
	}
	public ExceptionLogQuery setLocation(String location) {
		this.location = location;
		return this;
	}
	private boolean locationLike;
	public ExceptionLogQuery setLocationLike(boolean isLike) {
		this.locationLike = isLike;
		return this;
	}
    
	private Date createDate;
	public Date getCreateDate() {
		return createDate;
	}
	public ExceptionLogQuery setCreateDate(Date createDate) {
		this.createDate = createDate;
		return this;
	}
    
	private Integer creatorId;
	public Integer getCreatorId() {
		return creatorId;
	}
	public ExceptionLogQuery setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
		return this;
	}
    
	private Date updateDate;
	public Date getUpdateDate() {
		return updateDate;
	}
	public ExceptionLogQuery setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
		return this;
	}
    
	private Integer updatorId;
	public Integer getUpdatorId() {
		return updatorId;
	}
	public ExceptionLogQuery setUpdatorId(Integer updatorId) {
		this.updatorId = updatorId;
		return this;
	}
    
	private String isDel;
	public String getIsDel() {
		return isDel;
	}
	public ExceptionLogQuery setIsDel(String isDel) {
		this.isDel = isDel;
		return this;
	}
	private boolean isDelLike;
	public ExceptionLogQuery setIsDelLike(boolean isLike) {
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
	public ExceptionLogQuery orderbyId(boolean isAsc) {
		orderFields.add(new OrderField("id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：thread
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public ExceptionLogQuery orderbyThread(boolean isAsc) {
		orderFields.add(new OrderField("thread", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：level
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public ExceptionLogQuery orderbyLevel(boolean isAsc) {
		orderFields.add(new OrderField("level", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：class_name
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public ExceptionLogQuery orderbyClassName(boolean isAsc) {
		orderFields.add(new OrderField("class_name", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：message
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public ExceptionLogQuery orderbyMessage(boolean isAsc) {
		orderFields.add(new OrderField("message", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：location
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public ExceptionLogQuery orderbyLocation(boolean isAsc) {
		orderFields.add(new OrderField("location", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：create_date
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public ExceptionLogQuery orderbyCreateDate(boolean isAsc) {
		orderFields.add(new OrderField("create_date", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：creator_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public ExceptionLogQuery orderbyCreatorId(boolean isAsc) {
		orderFields.add(new OrderField("creator_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：update_date
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public ExceptionLogQuery orderbyUpdateDate(boolean isAsc) {
		orderFields.add(new OrderField("update_date", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：updator_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public ExceptionLogQuery orderbyUpdatorId(boolean isAsc) {
		orderFields.add(new OrderField("updator_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：is_del
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public ExceptionLogQuery orderbyIsDel(boolean isAsc) {
		orderFields.add(new OrderField("is_del", isAsc ? "ASC" : "DESC"));
		return this;
	}
	

}
