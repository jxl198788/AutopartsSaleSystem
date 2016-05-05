package com.fjsaas.web.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

import com.fjsaas.web.query.BaseQuery;

public class UserQuery extends BaseQuery {
	/**
	 * ==============================批量查询、更新、删除时的Where条件设置======================
	 * ============
	 **/
	private Integer id;
	public Integer getId() {
		return id;
	}
	public UserQuery setId(Integer id) {
		this.id = id;
		return this;
	}
    
	private String telphone;
	public String getTelphone() {
		return telphone;
	}
	public UserQuery setTelphone(String telphone) {
		this.telphone = telphone;
		return this;
	}
	private boolean telphoneLike;
	public UserQuery setTelphoneLike(boolean isLike) {
		this.telphoneLike = isLike;
		return this;
	}
    
	private String username;
	public String getUsername() {
		return username;
	}
	public UserQuery setUsername(String username) {
		this.username = username;
		return this;
	}
	private boolean usernameLike;
	public UserQuery setUsernameLike(boolean isLike) {
		this.usernameLike = isLike;
		return this;
	}
    
	private String realname;
	public String getRealname() {
		return realname;
	}
	public UserQuery setRealname(String realname) {
		this.realname = realname;
		return this;
	}
	private boolean realnameLike;
	public UserQuery setRealnameLike(boolean isLike) {
		this.realnameLike = isLike;
		return this;
	}
    
	private String password;
	public String getPassword() {
		return password;
	}
	public UserQuery setPassword(String password) {
		this.password = password;
		return this;
	}
	private boolean passwordLike;
	public UserQuery setPasswordLike(boolean isLike) {
		this.passwordLike = isLike;
		return this;
	}
    
	private String job;
	public String getJob() {
		return job;
	}
	public UserQuery setJob(String job) {
		this.job = job;
		return this;
	}
	private boolean jobLike;
	public UserQuery setJobLike(boolean isLike) {
		this.jobLike = isLike;
		return this;
	}
    
	private String email;
	public String getEmail() {
		return email;
	}
	public UserQuery setEmail(String email) {
		this.email = email;
		return this;
	}
	private boolean emailLike;
	public UserQuery setEmailLike(boolean isLike) {
		this.emailLike = isLike;
		return this;
	}
    
	private String address;
	public String getAddress() {
		return address;
	}
	public UserQuery setAddress(String address) {
		this.address = address;
		return this;
	}
	private boolean addressLike;
	public UserQuery setAddressLike(boolean isLike) {
		this.addressLike = isLike;
		return this;
	}
    
	private String groupId;
	public String getGroupId() {
		return groupId;
	}
	public UserQuery setGroupId(String groupId) {
		this.groupId = groupId;
		return this;
	}
    
	private String isRoot;
	public String getIsRoot() {
		return isRoot;
	}
	public UserQuery setIsRoot(String isRoot) {
		this.isRoot = isRoot;
		return this;
	}
	private boolean isRootLike;
	public UserQuery setIsRootLike(boolean isLike) {
		this.isRootLike = isLike;
		return this;
	}
    
	private Integer suppilerId;
	public Integer getSuppilerId() {
		return suppilerId;
	}
	public UserQuery setSuppilerId(Integer suppilerId) {
		this.suppilerId = suppilerId;
		return this;
	}
    
	private String locked;
	public String getLocked() {
		return locked;
	}
	public UserQuery setLocked(String locked) {
		this.locked = locked;
		return this;
	}
	private boolean lockedLike;
	public UserQuery setLockedLike(boolean isLike) {
		this.lockedLike = isLike;
		return this;
	}
    
	private String isActivation;
	public String getIsActivation() {
		return isActivation;
	}
	public UserQuery setIsActivation(String isActivation) {
		this.isActivation = isActivation;
		return this;
	}
	private boolean isActivationLike;
	public UserQuery setIsActivationLike(boolean isLike) {
		this.isActivationLike = isLike;
		return this;
	}
    
	private String salt;
	public String getSalt() {
		return salt;
	}
	public UserQuery setSalt(String salt) {
		this.salt = salt;
		return this;
	}
	private boolean saltLike;
	public UserQuery setSaltLike(boolean isLike) {
		this.saltLike = isLike;
		return this;
	}
    
	private Date createDate;
	public Date getCreateDate() {
		return createDate;
	}
	public UserQuery setCreateDate(Date createDate) {
		this.createDate = createDate;
		return this;
	}
    
	private Integer creatorId;
	public Integer getCreatorId() {
		return creatorId;
	}
	public UserQuery setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
		return this;
	}
    
	private Date updateDate;
	public Date getUpdateDate() {
		return updateDate;
	}
	public UserQuery setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
		return this;
	}
    
	private Integer updatorId;
	public Integer getUpdatorId() {
		return updatorId;
	}
	public UserQuery setUpdatorId(Integer updatorId) {
		this.updatorId = updatorId;
		return this;
	}
    
	private String isDel;
	public String getIsDel() {
		return isDel;
	}
	public UserQuery setIsDel(String isDel) {
		this.isDel = isDel;
		return this;
	}
	private boolean isDelLike;
	public UserQuery setIsDelLike(boolean isLike) {
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
	public UserQuery orderbyId(boolean isAsc) {
		orderFields.add(new OrderField("id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：telphone
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public UserQuery orderbyTelphone(boolean isAsc) {
		orderFields.add(new OrderField("telphone", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：username
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public UserQuery orderbyUsername(boolean isAsc) {
		orderFields.add(new OrderField("username", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：realname
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public UserQuery orderbyRealname(boolean isAsc) {
		orderFields.add(new OrderField("realname", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：password
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public UserQuery orderbyPassword(boolean isAsc) {
		orderFields.add(new OrderField("password", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：job
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public UserQuery orderbyJob(boolean isAsc) {
		orderFields.add(new OrderField("job", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：email
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public UserQuery orderbyEmail(boolean isAsc) {
		orderFields.add(new OrderField("email", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：address
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public UserQuery orderbyAddress(boolean isAsc) {
		orderFields.add(new OrderField("address", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：group_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public UserQuery orderbyGroupId(boolean isAsc) {
		orderFields.add(new OrderField("group_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：is_root
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public UserQuery orderbyIsRoot(boolean isAsc) {
		orderFields.add(new OrderField("is_root", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：suppiler_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public UserQuery orderbySuppilerId(boolean isAsc) {
		orderFields.add(new OrderField("suppiler_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：locked
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public UserQuery orderbyLocked(boolean isAsc) {
		orderFields.add(new OrderField("locked", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：is_activation
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public UserQuery orderbyIsActivation(boolean isAsc) {
		orderFields.add(new OrderField("is_activation", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：salt
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public UserQuery orderbySalt(boolean isAsc) {
		orderFields.add(new OrderField("salt", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：create_date
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public UserQuery orderbyCreateDate(boolean isAsc) {
		orderFields.add(new OrderField("create_date", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：creator_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public UserQuery orderbyCreatorId(boolean isAsc) {
		orderFields.add(new OrderField("creator_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：update_date
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public UserQuery orderbyUpdateDate(boolean isAsc) {
		orderFields.add(new OrderField("update_date", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：updator_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public UserQuery orderbyUpdatorId(boolean isAsc) {
		orderFields.add(new OrderField("updator_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：is_del
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public UserQuery orderbyIsDel(boolean isAsc) {
		orderFields.add(new OrderField("is_del", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	
}
