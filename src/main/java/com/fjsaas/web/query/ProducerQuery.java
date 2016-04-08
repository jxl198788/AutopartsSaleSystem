package com.fjsaas.web.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

import com.fjsaas.web.query.BaseQuery;

public class ProducerQuery extends BaseQuery {
	/**
	 * ==============================批量查询、更新、删除时的Where条件设置======================
	 * ============
	 **/
	private Integer id;
	public Integer getId() {
		return id;
	}
	public ProducerQuery setId(Integer id) {
		this.id = id;
		return this;
	}
    
	private String name;
	public String getName() {
		return name;
	}
	public ProducerQuery setName(String name) {
		this.name = name;
		return this;
	}
	private boolean nameLike;
	public ProducerQuery setNameLike(boolean isLike) {
		this.nameLike = isLike;
		return this;
	}
    
	private String email;
	public String getEmail() {
		return email;
	}
	public ProducerQuery setEmail(String email) {
		this.email = email;
		return this;
	}
	private boolean emailLike;
	public ProducerQuery setEmailLike(boolean isLike) {
		this.emailLike = isLike;
		return this;
	}
    
	private String phone;
	public String getPhone() {
		return phone;
	}
	public ProducerQuery setPhone(String phone) {
		this.phone = phone;
		return this;
	}
	private boolean phoneLike;
	public ProducerQuery setPhoneLike(boolean isLike) {
		this.phoneLike = isLike;
		return this;
	}
    
	private String fax;
	public String getFax() {
		return fax;
	}
	public ProducerQuery setFax(String fax) {
		this.fax = fax;
		return this;
	}
	private boolean faxLike;
	public ProducerQuery setFaxLike(boolean isLike) {
		this.faxLike = isLike;
		return this;
	}
    
	private String telephone;
	public String getTelephone() {
		return telephone;
	}
	public ProducerQuery setTelephone(String telephone) {
		this.telephone = telephone;
		return this;
	}
	private boolean telephoneLike;
	public ProducerQuery setTelephoneLike(boolean isLike) {
		this.telephoneLike = isLike;
		return this;
	}
    
	private String website;
	public String getWebsite() {
		return website;
	}
	public ProducerQuery setWebsite(String website) {
		this.website = website;
		return this;
	}
	private boolean websiteLike;
	public ProducerQuery setWebsiteLike(boolean isLike) {
		this.websiteLike = isLike;
		return this;
	}
    
	private String description;
	public String getDescription() {
		return description;
	}
	public ProducerQuery setDescription(String description) {
		this.description = description;
		return this;
	}
	private boolean descriptionLike;
	public ProducerQuery setDescriptionLike(boolean isLike) {
		this.descriptionLike = isLike;
		return this;
	}
    
	private String imgUrl;
	public String getImgUrl() {
		return imgUrl;
	}
	public ProducerQuery setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
		return this;
	}
	private boolean imgUrlLike;
	public ProducerQuery setImgUrlLike(boolean isLike) {
		this.imgUrlLike = isLike;
		return this;
	}
    
	private String address;
	public String getAddress() {
		return address;
	}
	public ProducerQuery setAddress(String address) {
		this.address = address;
		return this;
	}
	private boolean addressLike;
	public ProducerQuery setAddressLike(boolean isLike) {
		this.addressLike = isLike;
		return this;
	}
    
	private Date createDate;
	public Date getCreateDate() {
		return createDate;
	}
	public ProducerQuery setCreateDate(Date createDate) {
		this.createDate = createDate;
		return this;
	}
    
	private Integer creatorId;
	public Integer getCreatorId() {
		return creatorId;
	}
	public ProducerQuery setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
		return this;
	}
    
	private Date updateDate;
	public Date getUpdateDate() {
		return updateDate;
	}
	public ProducerQuery setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
		return this;
	}
    
	private Integer updatorId;
	public Integer getUpdatorId() {
		return updatorId;
	}
	public ProducerQuery setUpdatorId(Integer updatorId) {
		this.updatorId = updatorId;
		return this;
	}
    
	private String isDel;
	public String getIsDel() {
		return isDel;
	}
	public ProducerQuery setIsDel(String isDel) {
		this.isDel = isDel;
		return this;
	}
	private boolean isDelLike;
	public ProducerQuery setIsDelLike(boolean isLike) {
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
	public ProducerQuery orderbyId(boolean isAsc) {
		orderFields.add(new OrderField("id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：name
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public ProducerQuery orderbyName(boolean isAsc) {
		orderFields.add(new OrderField("name", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：email
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public ProducerQuery orderbyEmail(boolean isAsc) {
		orderFields.add(new OrderField("email", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：phone
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public ProducerQuery orderbyPhone(boolean isAsc) {
		orderFields.add(new OrderField("phone", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：fax
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public ProducerQuery orderbyFax(boolean isAsc) {
		orderFields.add(new OrderField("fax", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：telephone
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public ProducerQuery orderbyTelephone(boolean isAsc) {
		orderFields.add(new OrderField("telephone", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：website
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public ProducerQuery orderbyWebsite(boolean isAsc) {
		orderFields.add(new OrderField("website", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：description
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public ProducerQuery orderbyDescription(boolean isAsc) {
		orderFields.add(new OrderField("description", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：img_url
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public ProducerQuery orderbyImgUrl(boolean isAsc) {
		orderFields.add(new OrderField("img_url", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：address
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public ProducerQuery orderbyAddress(boolean isAsc) {
		orderFields.add(new OrderField("address", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：create_date
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public ProducerQuery orderbyCreateDate(boolean isAsc) {
		orderFields.add(new OrderField("create_date", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：creator_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public ProducerQuery orderbyCreatorId(boolean isAsc) {
		orderFields.add(new OrderField("creator_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：update_date
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public ProducerQuery orderbyUpdateDate(boolean isAsc) {
		orderFields.add(new OrderField("update_date", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：updator_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public ProducerQuery orderbyUpdatorId(boolean isAsc) {
		orderFields.add(new OrderField("updator_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：is_del
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public ProducerQuery orderbyIsDel(boolean isAsc) {
		orderFields.add(new OrderField("is_del", isAsc ? "ASC" : "DESC"));
		return this;
	}
	

}
