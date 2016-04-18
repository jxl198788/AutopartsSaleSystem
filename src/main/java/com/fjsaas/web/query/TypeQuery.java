package com.fjsaas.web.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

import com.fjsaas.web.query.BaseQuery;

public class TypeQuery extends BaseQuery {
	/**
	 * ==============================批量查询、更新、删除时的Where条件设置======================
	 * ============
	 **/
	private Integer id;
	public Integer getId() {
		return id;
	}
	public TypeQuery setId(Integer id) {
		this.id = id;
		return this;
	}
    
	private String displacement;
	public String getDisplacement() {
		return displacement;
	}
	public TypeQuery setDisplacement(String displacement) {
		this.displacement = displacement;
		return this;
	}
	private boolean displacementLike;
	public TypeQuery setDisplacementLike(boolean isLike) {
		this.displacementLike = isLike;
		return this;
	}
    
	private String manufactureYear;
	public String getManufactureYear() {
		return manufactureYear;
	}
	public TypeQuery setManufactureYear(String manufactureYear) {
		this.manufactureYear = manufactureYear;
		return this;
	}
	private boolean manufactureYearLike;
	public TypeQuery setManufactureYearLike(boolean isLike) {
		this.manufactureYearLike = isLike;
		return this;
	}
    
	private String engineType;
	public String getEngineType() {
		return engineType;
	}
	public TypeQuery setEngineType(String engineType) {
		this.engineType = engineType;
		return this;
	}
	private boolean engineTypeLike;
	public TypeQuery setEngineTypeLike(boolean isLike) {
		this.engineTypeLike = isLike;
		return this;
	}
    
	private Integer horsepower;
	public Integer getHorsepower() {
		return horsepower;
	}
	public TypeQuery setHorsepower(Integer horsepower) {
		this.horsepower = horsepower;
		return this;
	}
    
	private Integer power;
	public Integer getPower() {
		return power;
	}
	public TypeQuery setPower(Integer power) {
		this.power = power;
		return this;
	}
    
	private String bodyType;
	public String getBodyType() {
		return bodyType;
	}
	public TypeQuery setBodyType(String bodyType) {
		this.bodyType = bodyType;
		return this;
	}
	private boolean bodyTypeLike;
	public TypeQuery setBodyTypeLike(boolean isLike) {
		this.bodyTypeLike = isLike;
		return this;
	}
    
	private String origin;
	public String getOrigin() {
		return origin;
	}
	public TypeQuery setOrigin(String origin) {
		this.origin = origin;
		return this;
	}
	private boolean originLike;
	public TypeQuery setOriginLike(boolean isLike) {
		this.originLike = isLike;
		return this;
	}
    
	private String description;
	public String getDescription() {
		return description;
	}
	public TypeQuery setDescription(String description) {
		this.description = description;
		return this;
	}
	private boolean descriptionLike;
	public TypeQuery setDescriptionLike(boolean isLike) {
		this.descriptionLike = isLike;
		return this;
	}
    
	private Integer seriesId;
	public Integer getSeriesId() {
		return seriesId;
	}
	public TypeQuery setSeriesId(Integer seriesId) {
		this.seriesId = seriesId;
		return this;
	}
    
	private Date createDate;
	public Date getCreateDate() {
		return createDate;
	}
	public TypeQuery setCreateDate(Date createDate) {
		this.createDate = createDate;
		return this;
	}
    
	private Integer creatorId;
	public Integer getCreatorId() {
		return creatorId;
	}
	public TypeQuery setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
		return this;
	}
    
	private Integer updateDate;
	public Integer getUpdateDate() {
		return updateDate;
	}
	public TypeQuery setUpdateDate(Integer updateDate) {
		this.updateDate = updateDate;
		return this;
	}
    
	private Integer updatorId;
	public Integer getUpdatorId() {
		return updatorId;
	}
	public TypeQuery setUpdatorId(Integer updatorId) {
		this.updatorId = updatorId;
		return this;
	}
    
	private String isDel;
	public String getIsDel() {
		return isDel;
	}
	public TypeQuery setIsDel(String isDel) {
		this.isDel = isDel;
		return this;
	}
	private boolean isDelLike;
	public TypeQuery setIsDelLike(boolean isLike) {
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
	public TypeQuery orderbyId(boolean isAsc) {
		orderFields.add(new OrderField("id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：displacement
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public TypeQuery orderbyDisplacement(boolean isAsc) {
		orderFields.add(new OrderField("displacement", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：manufacture_year
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public TypeQuery orderbyManufactureYear(boolean isAsc) {
		orderFields.add(new OrderField("manufacture_year", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：engine_type
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public TypeQuery orderbyEngineType(boolean isAsc) {
		orderFields.add(new OrderField("engine_type", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：horsepower
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public TypeQuery orderbyHorsepower(boolean isAsc) {
		orderFields.add(new OrderField("horsepower", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：power
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public TypeQuery orderbyPower(boolean isAsc) {
		orderFields.add(new OrderField("power", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：body_type
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public TypeQuery orderbyBodyType(boolean isAsc) {
		orderFields.add(new OrderField("body_type", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：origin
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public TypeQuery orderbyOrigin(boolean isAsc) {
		orderFields.add(new OrderField("origin", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：description
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public TypeQuery orderbyDescription(boolean isAsc) {
		orderFields.add(new OrderField("description", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：series_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public TypeQuery orderbySeriesId(boolean isAsc) {
		orderFields.add(new OrderField("series_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：create_date
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public TypeQuery orderbyCreateDate(boolean isAsc) {
		orderFields.add(new OrderField("create_date", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：creator_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public TypeQuery orderbyCreatorId(boolean isAsc) {
		orderFields.add(new OrderField("creator_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：update_date
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public TypeQuery orderbyUpdateDate(boolean isAsc) {
		orderFields.add(new OrderField("update_date", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：updator_id
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public TypeQuery orderbyUpdatorId(boolean isAsc) {
		orderFields.add(new OrderField("updator_id", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	/**
	 * 设置排序按属性：is_del
	 * 
	 * @param isAsc
	 *            是否升序，是为升序，否为降序
	 */
	public TypeQuery orderbyIsDel(boolean isAsc) {
		orderFields.add(new OrderField("is_del", isAsc ? "ASC" : "DESC"));
		return this;
	}
	
	
}
