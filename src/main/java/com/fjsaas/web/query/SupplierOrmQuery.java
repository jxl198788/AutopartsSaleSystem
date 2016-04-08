package com.fjsaas.web.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

import com.fjsaas.web.query.BaseQuery;

public class SupplierOrmQuery extends BaseQuery {
	/**
	 * ==============================批量查询、更新、删除时的Where条件设置======================
	 * ============
	 **/
	private Integer id;
	public Integer getId() {
		return id;
	}
	public SupplierOrmQuery setId(Integer id) {
		this.id = id;
		return this;
	}
    
	private String supplierNo;
	public String getSupplierNo() {
		return supplierNo;
	}
	public SupplierOrmQuery setSupplierNo(String supplierNo) {
		this.supplierNo = supplierNo;
		return this;
	}
	private boolean supplierNoLike;
	public SupplierOrmQuery setSupplierNoLike(boolean isLike) {
		this.supplierNoLike = isLike;
		return this;
	}
    
	private String oeCode;
	public String getOeCode() {
		return oeCode;
	}
	public SupplierOrmQuery setOeCode(String oeCode) {
		this.oeCode = oeCode;
		return this;
	}
	private boolean oeCodeLike;
	public SupplierOrmQuery setOeCodeLike(boolean isLike) {
		this.oeCodeLike = isLike;
		return this;
	}
    
	private String bigProductNo;
	public String getBigProductNo() {
		return bigProductNo;
	}
	public SupplierOrmQuery setBigProductNo(String bigProductNo) {
		this.bigProductNo = bigProductNo;
		return this;
	}
	private boolean bigProductNoLike;
	public SupplierOrmQuery setBigProductNoLike(boolean isLike) {
		this.bigProductNoLike = isLike;
		return this;
	}
    
	private String smallProductNo;
	public String getSmallProductNo() {
		return smallProductNo;
	}
	public SupplierOrmQuery setSmallProductNo(String smallProductNo) {
		this.smallProductNo = smallProductNo;
		return this;
	}
	private boolean smallProductNoLike;
	public SupplierOrmQuery setSmallProductNoLike(boolean isLike) {
		this.smallProductNoLike = isLike;
		return this;
	}
    
	private String produerName;
	public String getProduerName() {
		return produerName;
	}
	public SupplierOrmQuery setProduerName(String produerName) {
		this.produerName = produerName;
		return this;
	}
	private boolean produerNameLike;
	public SupplierOrmQuery setProduerNameLike(boolean isLike) {
		this.produerNameLike = isLike;
		return this;
	}
    
	private String partName;
	public String getPartName() {
		return partName;
	}
	public SupplierOrmQuery setPartName(String partName) {
		this.partName = partName;
		return this;
	}
	private boolean partNameLike;
	public SupplierOrmQuery setPartNameLike(boolean isLike) {
		this.partNameLike = isLike;
		return this;
	}
    
	private Float firstPrice;
	public Float getFirstPrice() {
		return firstPrice;
	}
	public SupplierOrmQuery setFirstPrice(Float firstPrice) {
		this.firstPrice = firstPrice;
		return this;
	}
    
	private Float secondPrice;
	public Float getSecondPrice() {
		return secondPrice;
	}
	public SupplierOrmQuery setSecondPrice(Float secondPrice) {
		this.secondPrice = secondPrice;
		return this;
	}
    
	private Float thirdPrice;
	public Float getThirdPrice() {
		return thirdPrice;
	}
	public SupplierOrmQuery setThirdPrice(Float thirdPrice) {
		this.thirdPrice = thirdPrice;
		return this;
	}
    
	private Integer supplierId;
	public Integer getSupplierId() {
		return supplierId;
	}
	public SupplierOrmQuery setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
		return this;
	}
    
	private String status;
	public String getStatus() {
		return status;
	}
	public SupplierOrmQuery setStatus(String status) {
		this.status = status;
		return this;
	}
	private boolean statusLike;
	public SupplierOrmQuery setStatusLike(boolean isLike) {
		this.statusLike = isLike;
		return this;
	}
    
	private Date createDate;
	public Date getCreateDate() {
		return createDate;
	}
	public SupplierOrmQuery setCreateDate(Date createDate) {
		this.createDate = createDate;
		return this;
	}
    
	private Integer creatorId;
	public Integer getCreatorId() {
		return creatorId;
	}
	public SupplierOrmQuery setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
		return this;
	}
    
	private Date updateDate;
	public Date getUpdateDate() {
		return updateDate;
	}
	public SupplierOrmQuery setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
		return this;
	}
    
	private Integer updatorId;
	public Integer getUpdatorId() {
		return updatorId;
	}
	public SupplierOrmQuery setUpdatorId(Integer updatorId) {
		this.updatorId = updatorId;
		return this;
	}
    
	private String isDel;
	public String getIsDel() {
		return isDel;
	}
	public SupplierOrmQuery setIsDel(String isDel) {
		this.isDel = isDel;
		return this;
	}
	private boolean isDelLike;
	public SupplierOrmQuery setIsDelLike(boolean isLike) {
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
	public SupplierOrmQuery orderbyId(boolean isAsc) {
		orderFields.add(new OrderField("id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：supplier_no
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierOrmQuery orderbySupplierNo(boolean isAsc) {
		orderFields.add(new OrderField("supplier_no", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：oe_code
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierOrmQuery orderbyOeCode(boolean isAsc) {
		orderFields.add(new OrderField("oe_code", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：big_product_no
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierOrmQuery orderbyBigProductNo(boolean isAsc) {
		orderFields.add(new OrderField("big_product_no", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：small_product_no
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierOrmQuery orderbySmallProductNo(boolean isAsc) {
		orderFields.add(new OrderField("small_product_no", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：produer_name
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierOrmQuery orderbyProduerName(boolean isAsc) {
		orderFields.add(new OrderField("produer_name", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：part_name
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierOrmQuery orderbyPartName(boolean isAsc) {
		orderFields.add(new OrderField("part_name", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：first_price
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierOrmQuery orderbyFirstPrice(boolean isAsc) {
		orderFields.add(new OrderField("first_price", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：second_price
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierOrmQuery orderbySecondPrice(boolean isAsc) {
		orderFields.add(new OrderField("second_price", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：third_price
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierOrmQuery orderbyThirdPrice(boolean isAsc) {
		orderFields.add(new OrderField("third_price", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：supplier_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierOrmQuery orderbySupplierId(boolean isAsc) {
		orderFields.add(new OrderField("supplier_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：status
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierOrmQuery orderbyStatus(boolean isAsc) {
		orderFields.add(new OrderField("status", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：create_date
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierOrmQuery orderbyCreateDate(boolean isAsc) {
		orderFields.add(new OrderField("create_date", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：creator_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierOrmQuery orderbyCreatorId(boolean isAsc) {
		orderFields.add(new OrderField("creator_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：update_date
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierOrmQuery orderbyUpdateDate(boolean isAsc) {
		orderFields.add(new OrderField("update_date", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：updator_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierOrmQuery orderbyUpdatorId(boolean isAsc) {
		orderFields.add(new OrderField("updator_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：is_del
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public SupplierOrmQuery orderbyIsDel(boolean isAsc) {
		orderFields.add(new OrderField("is_del", isAsc ? "ASC" : "DESC"));
		return this;
	}
	

}
