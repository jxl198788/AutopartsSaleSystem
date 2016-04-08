package com.fjsaas.web.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

import com.fjsaas.web.query.BaseQuery;

public class ProducerPartQuery extends BaseQuery {
	/**
	 * ==============================批量查询、更新、删除时的Where条件设置======================
	 * ============
	 **/
	private Integer id;
	public Integer getId() {
		return id;
	}
	public ProducerPartQuery setId(Integer id) {
		this.id = id;
		return this;
	}
    
	private String productCode;
	public String getProductCode() {
		return productCode;
	}
	public ProducerPartQuery setProductCode(String productCode) {
		this.productCode = productCode;
		return this;
	}
	private boolean productCodeLike;
	public ProducerPartQuery setProductCodeLike(boolean isLike) {
		this.productCodeLike = isLike;
		return this;
	}
    
	private String oeCode;
	public String getOeCode() {
		return oeCode;
	}
	public ProducerPartQuery setOeCode(String oeCode) {
		this.oeCode = oeCode;
		return this;
	}
	private boolean oeCodeLike;
	public ProducerPartQuery setOeCodeLike(boolean isLike) {
		this.oeCodeLike = isLike;
		return this;
	}
    
	private Integer producerId;
	public Integer getProducerId() {
		return producerId;
	}
	public ProducerPartQuery setProducerId(Integer producerId) {
		this.producerId = producerId;
		return this;
	}
    
	private Integer partId;
	public Integer getPartId() {
		return partId;
	}
	public ProducerPartQuery setPartId(Integer partId) {
		this.partId = partId;
		return this;
	}
    
	private Date createDate;
	public Date getCreateDate() {
		return createDate;
	}
	public ProducerPartQuery setCreateDate(Date createDate) {
		this.createDate = createDate;
		return this;
	}
    
	private Integer creatorId;
	public Integer getCreatorId() {
		return creatorId;
	}
	public ProducerPartQuery setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
		return this;
	}
    
	private Date updateDate;
	public Date getUpdateDate() {
		return updateDate;
	}
	public ProducerPartQuery setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
		return this;
	}
    
	private Integer updatorId;
	public Integer getUpdatorId() {
		return updatorId;
	}
	public ProducerPartQuery setUpdatorId(Integer updatorId) {
		this.updatorId = updatorId;
		return this;
	}
    
	private String isDel;
	public String getIsDel() {
		return isDel;
	}
	public ProducerPartQuery setIsDel(String isDel) {
		this.isDel = isDel;
		return this;
	}
	private boolean isDelLike;
	public ProducerPartQuery setIsDelLike(boolean isLike) {
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
	public ProducerPartQuery orderbyId(boolean isAsc) {
		orderFields.add(new OrderField("id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：product_code
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public ProducerPartQuery orderbyProductCode(boolean isAsc) {
		orderFields.add(new OrderField("product_code", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：oe_code
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public ProducerPartQuery orderbyOeCode(boolean isAsc) {
		orderFields.add(new OrderField("oe_code", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：producer_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public ProducerPartQuery orderbyProducerId(boolean isAsc) {
		orderFields.add(new OrderField("producer_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：part_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public ProducerPartQuery orderbyPartId(boolean isAsc) {
		orderFields.add(new OrderField("part_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：create_date
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public ProducerPartQuery orderbyCreateDate(boolean isAsc) {
		orderFields.add(new OrderField("create_date", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：creator_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public ProducerPartQuery orderbyCreatorId(boolean isAsc) {
		orderFields.add(new OrderField("creator_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：update_date
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public ProducerPartQuery orderbyUpdateDate(boolean isAsc) {
		orderFields.add(new OrderField("update_date", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：updator_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public ProducerPartQuery orderbyUpdatorId(boolean isAsc) {
		orderFields.add(new OrderField("updator_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：is_del
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public ProducerPartQuery orderbyIsDel(boolean isAsc) {
		orderFields.add(new OrderField("is_del", isAsc ? "ASC" : "DESC"));
		return this;
	}
	

}
