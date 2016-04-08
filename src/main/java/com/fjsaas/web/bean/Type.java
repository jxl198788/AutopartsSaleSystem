package com.fjsaas.web.bean;

import java.util.*;
import java.io.Serializable;
import java.math.BigDecimal;


public class Type implements Serializable {
	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String displacement;
	private String manufactureYear;
	private String engineType;
	private Integer horsepower;
	private Integer power;
	private String bodyType;
	private String origin;
	private String description;
	private Integer seriesId;
	private Date createDate;
	private Integer creatorId;
	private Integer updateDate;
	private Integer updatorId;
	private String isDel;

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDisplacement() {
		return displacement;
	}
	
	public void setDisplacement(String displacement) {
		this.displacement = displacement;
	}
	
	public String getManufactureYear() {
		return manufactureYear;
	}
	
	public void setManufactureYear(String manufactureYear) {
		this.manufactureYear = manufactureYear;
	}
	
	public String getEngineType() {
		return engineType;
	}
	
	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}
	
	public Integer getHorsepower() {
		return horsepower;
	}
	
	public void setHorsepower(Integer horsepower) {
		this.horsepower = horsepower;
	}
	
	public Integer getPower() {
		return power;
	}
	
	public void setPower(Integer power) {
		this.power = power;
	}
	
	public String getBodyType() {
		return bodyType;
	}
	
	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}
	
	public String getOrigin() {
		return origin;
	}
	
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Integer getSeriesId() {
		return seriesId;
	}
	
	public void setSeriesId(Integer seriesId) {
		this.seriesId = seriesId;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public Integer getCreatorId() {
		return creatorId;
	}
	
	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}
	
	public Integer getUpdateDate() {
		return updateDate;
	}
	
	public void setUpdateDate(Integer updateDate) {
		this.updateDate = updateDate;
	}
	
	public Integer getUpdatorId() {
		return updatorId;
	}
	
	public void setUpdatorId(Integer updatorId) {
		this.updatorId = updatorId;
	}
	
	public String getIsDel() {
		return isDel;
	}
	
	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}
	
	public String toString() {
		return "Type [id=" + id + ",displacement=" + displacement + ",manufactureYear=" + manufactureYear + ",engineType=" + engineType + ",horsepower=" + horsepower + ",power=" + power + ",bodyType=" + bodyType + ",origin=" + origin + ",description=" + description + ",seriesId=" + seriesId + ",createDate=" + createDate + ",creatorId=" + creatorId + ",updateDate=" + updateDate + ",updatorId=" + updatorId + ",isDel=" + isDel + "]";
	}
	
	
}