package com.fjsaas.web.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

import com.fjsaas.web.query.BaseQuery;

public class OeQuery extends BaseQuery {
	/**
	 * ==============================批量查询、更新、删除时的Where条件设置======================
	 * ============
	 **/
	private String oeCode;
	public String getOeCode() {
		return oeCode;
	}
	public OeQuery setOeCode(String oeCode) {
		this.oeCode = oeCode;
		return this;
	}
	private boolean oeCodeLike;
	public OeQuery setOeCodeLike(boolean isLike) {
		this.oeCodeLike = isLike;
		return this;
	}
    
	private String name;
	public String getName() {
		return name;
	}
	public OeQuery setName(String name) {
		this.name = name;
		return this;
	}
	private boolean nameLike;
	public OeQuery setNameLike(boolean isLike) {
		this.nameLike = isLike;
		return this;
	}
    
	private String type;
	public String getType() {
		return type;
	}
	public OeQuery setType(String type) {
		this.type = type;
		return this;
	}
	private boolean typeLike;
	public OeQuery setTypeLike(boolean isLike) {
		this.typeLike = isLike;
		return this;
	}
    
	private String size;
	public String getSize() {
		return size;
	}
	public OeQuery setSize(String size) {
		this.size = size;
		return this;
	}
	private boolean sizeLike;
	public OeQuery setSizeLike(boolean isLike) {
		this.sizeLike = isLike;
		return this;
	}
    
	private String description;
	public String getDescription() {
		return description;
	}
	public OeQuery setDescription(String description) {
		this.description = description;
		return this;
	}
	private boolean descriptionLike;
	public OeQuery setDescriptionLike(boolean isLike) {
		this.descriptionLike = isLike;
		return this;
	}
    
	private String attributes;
	public String getAttributes() {
		return attributes;
	}
	public OeQuery setAttributes(String attributes) {
		this.attributes = attributes;
		return this;
	}
	private boolean attributesLike;
	public OeQuery setAttributesLike(boolean isLike) {
		this.attributesLike = isLike;
		return this;
	}
    
	private String imgs;
	public String getImgs() {
		return imgs;
	}
	public OeQuery setImgs(String imgs) {
		this.imgs = imgs;
		return this;
	}
	private boolean imgsLike;
	public OeQuery setImgsLike(boolean isLike) {
		this.imgsLike = isLike;
		return this;
	}
    
	private Integer partSortId;
	public Integer getPartSortId() {
		return partSortId;
	}
	public OeQuery setPartSortId(Integer partSortId) {
		this.partSortId = partSortId;
		return this;
	}
    
	private Date createDate;
	public Date getCreateDate() {
		return createDate;
	}
	public OeQuery setCreateDate(Date createDate) {
		this.createDate = createDate;
		return this;
	}
    
	private Integer creatorId;
	public Integer getCreatorId() {
		return creatorId;
	}
	public OeQuery setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
		return this;
	}
    
	private Date updateDate;
	public Date getUpdateDate() {
		return updateDate;
	}
	public OeQuery setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
		return this;
	}
    
	private Integer updatorId;
	public Integer getUpdatorId() {
		return updatorId;
	}
	public OeQuery setUpdatorId(Integer updatorId) {
		this.updatorId = updatorId;
		return this;
	}
    
	private String isDel;
	public String getIsDel() {
		return isDel;
	}
	public OeQuery setIsDel(String isDel) {
		this.isDel = isDel;
		return this;
	}
	private boolean isDelLike;
	public OeQuery setIsDelLike(boolean isLike) {
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
	 * 设置排序按属性：oe_code
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public OeQuery orderbyOeCode(boolean isAsc) {
		orderFields.add(new OrderField("oe_code", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：name
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public OeQuery orderbyName(boolean isAsc) {
		orderFields.add(new OrderField("name", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：type
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public OeQuery orderbyType(boolean isAsc) {
		orderFields.add(new OrderField("type", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：size
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public OeQuery orderbySize(boolean isAsc) {
		orderFields.add(new OrderField("size", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：description
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public OeQuery orderbyDescription(boolean isAsc) {
		orderFields.add(new OrderField("description", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：attributes
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public OeQuery orderbyAttributes(boolean isAsc) {
		orderFields.add(new OrderField("attributes", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：imgs
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public OeQuery orderbyImgs(boolean isAsc) {
		orderFields.add(new OrderField("imgs", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：part_sort_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public OeQuery orderbyPartSortId(boolean isAsc) {
		orderFields.add(new OrderField("part_sort_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：create_date
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public OeQuery orderbyCreateDate(boolean isAsc) {
		orderFields.add(new OrderField("create_date", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：creator_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public OeQuery orderbyCreatorId(boolean isAsc) {
		orderFields.add(new OrderField("creator_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：update_date
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public OeQuery orderbyUpdateDate(boolean isAsc) {
		orderFields.add(new OrderField("update_date", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：updator_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public OeQuery orderbyUpdatorId(boolean isAsc) {
		orderFields.add(new OrderField("updator_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：is_del
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public OeQuery orderbyIsDel(boolean isAsc) {
		orderFields.add(new OrderField("is_del", isAsc ? "ASC" : "DESC"));
		return this;
	}
	

}
