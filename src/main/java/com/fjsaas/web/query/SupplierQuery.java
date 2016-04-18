package com.fjsaas.web.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

import com.fjsaas.web.query.BaseQuery;

public class SupplierQuery extends BaseQuery {
	/**
	 * ==============================批量查询、更新、删除时的Where条件设置======================
	 * ============
	 **/
	private Integer id;
	public Integer getId() {
		return id;
	}
	public SupplierQuery setId(Integer id) {
		this.id = id;
		return this;
	}
    
	private String name;
	public String getName() {
		return name;
	}
	public SupplierQuery setName(String name) {
		this.name = name;
		return this;
	}
	private boolean nameLike;
	public SupplierQuery setNameLike(boolean isLike) {
		this.nameLike = isLike;
		return this;
	}
    
	private String businessLicenseUrl;
	public String getBusinessLicenseUrl() {
		return businessLicenseUrl;
	}
	public SupplierQuery setBusinessLicenseUrl(String businessLicenseUrl) {
		this.businessLicenseUrl = businessLicenseUrl;
		return this;
	}
	private boolean businessLicenseUrlLike;
	public SupplierQuery setBusinessLicenseUrlLike(boolean isLike) {
		this.businessLicenseUrlLike = isLike;
		return this;
	}
    
	private String province;
	public String getProvince() {
		return province;
	}
	public SupplierQuery setProvince(String province) {
		this.province = province;
		return this;
	}
	private boolean provinceLike;
	public SupplierQuery setProvinceLike(boolean isLike) {
		this.provinceLike = isLike;
		return this;
	}
    
	private String city;
	public String getCity() {
		return city;
	}
	public SupplierQuery setCity(String city) {
		this.city = city;
		return this;
	}
	private boolean cityLike;
	public SupplierQuery setCityLike(boolean isLike) {
		this.cityLike = isLike;
		return this;
	}
    
	private String town;
	public String getTown() {
		return town;
	}
	public SupplierQuery setTown(String town) {
		this.town = town;
		return this;
	}
	private boolean townLike;
	public SupplierQuery setTownLike(boolean isLike) {
		this.townLike = isLike;
		return this;
	}
    
	private String addr;
	public String getAddr() {
		return addr;
	}
	public SupplierQuery setAddr(String addr) {
		this.addr = addr;
		return this;
	}
	private boolean addrLike;
	public SupplierQuery setAddrLike(boolean isLike) {
		this.addrLike = isLike;
		return this;
	}
    
	private String linkman;
	public String getLinkman() {
		return linkman;
	}
	public SupplierQuery setLinkman(String linkman) {
		this.linkman = linkman;
		return this;
	}
	private boolean linkmanLike;
	public SupplierQuery setLinkmanLike(boolean isLike) {
		this.linkmanLike = isLike;
		return this;
	}
    
	private String telphone;
	public String getTelphone() {
		return telphone;
	}
	public SupplierQuery setTelphone(String telphone) {
		this.telphone = telphone;
		return this;
	}
	private boolean telphoneLike;
	public SupplierQuery setTelphoneLike(boolean isLike) {
		this.telphoneLike = isLike;
		return this;
	}
    
	private String groupId;
	public String getGroupId() {
		return groupId;
	}
	public SupplierQuery setGroupId(String groupId) {
		this.groupId = groupId;
		return this;
	}
    
	private Date createDate;
	public Date getCreateDate() {
		return createDate;
	}
	public SupplierQuery setCreateDate(Date createDate) {
		this.createDate = createDate;
		return this;
	}
    
	private Integer creatorId;
	public Integer getCreatorId() {
		return creatorId;
	}
	public SupplierQuery setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
		return this;
	}
    
	private Date updateDate;
	public Date getUpdateDate() {
		return updateDate;
	}
	public SupplierQuery setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
		return this;
	}
    
	private Integer updatorId;
	public Integer getUpdatorId() {
		return updatorId;
	}
	public SupplierQuery setUpdatorId(Integer updatorId) {
		this.updatorId = updatorId;
		return this;
	}
    
	private String isDel;
	public String getIsDel() {
		return isDel;
	}
	public SupplierQuery setIsDel(String isDel) {
		this.isDel = isDel;
		return this;
	}
	private boolean isDelLike;
	public SupplierQuery setIsDelLike(boolean isLike) {
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
	public SupplierQuery orderbyId(boolean isAsc) {
		orderFields.add(new OrderField("id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：name
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierQuery orderbyName(boolean isAsc) {
		orderFields.add(new OrderField("name", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：business_license_url
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierQuery orderbyBusinessLicenseUrl(boolean isAsc) {
		orderFields.add(new OrderField("business_license_url", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：province
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierQuery orderbyProvince(boolean isAsc) {
		orderFields.add(new OrderField("province", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：city
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierQuery orderbyCity(boolean isAsc) {
		orderFields.add(new OrderField("city", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：town
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierQuery orderbyTown(boolean isAsc) {
		orderFields.add(new OrderField("town", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：addr
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierQuery orderbyAddr(boolean isAsc) {
		orderFields.add(new OrderField("addr", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：linkman
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierQuery orderbyLinkman(boolean isAsc) {
		orderFields.add(new OrderField("linkman", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：telphone
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierQuery orderbyTelphone(boolean isAsc) {
		orderFields.add(new OrderField("telphone", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：group_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierQuery orderbyGroupId(boolean isAsc) {
		orderFields.add(new OrderField("group_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：create_date
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierQuery orderbyCreateDate(boolean isAsc) {
		orderFields.add(new OrderField("create_date", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：creator_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierQuery orderbyCreatorId(boolean isAsc) {
		orderFields.add(new OrderField("creator_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：update_date
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierQuery orderbyUpdateDate(boolean isAsc) {
		orderFields.add(new OrderField("update_date", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：updator_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierQuery orderbyUpdatorId(boolean isAsc) {
		orderFields.add(new OrderField("updator_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：is_del
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierQuery orderbyIsDel(boolean isAsc) {
		orderFields.add(new OrderField("is_del", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	
}
