package com.fjsaas.web.bean;

import java.util.*;
import java.io.Serializable;
import java.lang.annotation.Target;
import java.math.BigDecimal;


public class MappingIndex implements Serializable {
	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String productBrand;
	private String productName;
	private String productCode;
	private String productSize;
	private String referenceCode;
	private String referenceBrand;
	private Float firstPrice;
	private Float secondPrice;
	private Float thirdPrice;
	private String oeCode;
	private Integer autoTypeId;
	private Integer partSortId;
	private String status;
	private Integer supplierId;
	private Integer mappingId;
	private Date createDate;
	private Integer creatorId;
	private Date updateDate;
	private Integer updatorId;
	private Date mappingCreateDate;
	private Date mappingUpdateDate;
	private String isDel;
	private String imageUrl;
	
	private Set<Integer> autoTypes = new HashSet<Integer>();

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getProductBrand() {
		return productBrand;
	}
	
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getProductCode() {
		return productCode;
	}
	
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	
	public String getProductSize() {
		return productSize;
	}
	
	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}
	
	public String getReferenceCode() {
		return referenceCode;
	}
	
	public void setReferenceCode(String referenceCode) {
		this.referenceCode = referenceCode;
	}
	
	public String getReferenceBrand() {
		return referenceBrand;
	}
	
	public void setReferenceBrand(String referenceBrand) {
		this.referenceBrand = referenceBrand;
	}
	
	public Float getFirstPrice() {
		return firstPrice;
	}
	
	public void setFirstPrice(Float firstPrice) {
		this.firstPrice = firstPrice;
	}
	
	public Float getSecondPrice() {
		return secondPrice;
	}
	
	public void setSecondPrice(Float secondPrice) {
		this.secondPrice = secondPrice;
	}
	
	public Float getThirdPrice() {
		return thirdPrice;
	}
	
	public void setThirdPrice(Float thirdPrice) {
		this.thirdPrice = thirdPrice;
	}
	
	public String getOeCode() {
		return oeCode;
	}
	
	public void setOeCode(String oeCode) {
		this.oeCode = oeCode;
	}
	
	public Integer getAutoTypeId() {
		return autoTypeId;
	}
	
	public void setAutoTypeId(Integer autoTypeId) {
		this.autoTypeId = autoTypeId;
	}
	
	public Integer getPartSortId() {
		return partSortId;
	}
	
	public void setPartSortId(Integer partSortId) {
		this.partSortId = partSortId;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Integer getSupplierId() {
		return supplierId;
	}
	
	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}
	
	public Integer getMappingId() {
		return mappingId;
	}
	
	public void setMappingId(Integer mappingId) {
		this.mappingId = mappingId;
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
	
	public Date getUpdateDate() {
		return updateDate;
	}
	
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	public Integer getUpdatorId() {
		return updatorId;
	}
	
	public void setUpdatorId(Integer updatorId) {
		this.updatorId = updatorId;
	}
	
	public Date getMappingCreateDate() {
		return mappingCreateDate;
	}
	
	public void setMappingCreateDate(Date mappingCreateDate) {
		this.mappingCreateDate = mappingCreateDate;
	}
	
	public Date getMappingUpdateDate() {
		return mappingUpdateDate;
	}
	
	public void setMappingUpdateDate(Date mappingUpdateDate) {
		this.mappingUpdateDate = mappingUpdateDate;
	}
	
	public String getIsDel() {
		return isDel;
	}
	
	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public String toString() {
		return "MappingIndex [id=" + id + ",productBrand=" + productBrand + ",productName=" + productName + ",productCode=" + productCode + ",productSize=" + productSize + ",referenceCode=" + referenceCode + ",referenceBrand=" + referenceBrand + ",firstPrice=" + firstPrice + ",secondPrice=" + secondPrice + ",thirdPrice=" + thirdPrice + ",oeCode=" + oeCode + ",autoTypeId=" + autoTypeId + ",partSortId=" + partSortId + ",status=" + status + ",supplierId=" + supplierId + ",mappingId=" + mappingId + ",createDate=" + createDate + ",creatorId=" + creatorId + ",updateDate=" + updateDate + ",updatorId=" + updatorId + ",mappingCreateDate=" + mappingCreateDate + ",mappingUpdateDate=" + mappingUpdateDate + ",isDel=" + isDel + ",imageUrl=" + imageUrl + "]";
	}

	@Override
	public int hashCode() {
		return productCode.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MappingIndex other = (MappingIndex) obj;
		System.out.println("=================");
		System.out.println(other.getId() + ":" + this.getId());
		System.out.println(other.getAutoTypeId() + ":" + this.getAutoTypeId());
		System.out.println("=================");
		if (firstPrice == null) {
			if (other.firstPrice != null)
				return false;
		} else if (!firstPrice.equals(other.firstPrice))
			return false;
		if (imageUrl == null) {
			if (other.imageUrl != null)
				return false;
		} else if (!imageUrl.equals(other.imageUrl))
			return false;
		if (mappingId == null) {
			if (other.mappingId != null)
				return false;
		} else if (!mappingId.equals(other.mappingId))
			return false;
		if (partSortId == null) {
			if (other.partSortId != null)
				return false;
		} else if (!partSortId.equals(other.partSortId))
			return false;
		if (productBrand == null) {
			if (other.productBrand != null)
				return false;
		} else if (!productBrand.equals(other.productBrand))
			return false;
		if (productCode == null) {
			if (other.productCode != null)
				return false;
		} else if (!productCode.equals(other.productCode))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (productSize == null) {
			if (other.productSize != null)
				return false;
		} else if (!productSize.equals(other.productSize))
			return false;
		if (secondPrice == null) {
			if (other.secondPrice != null)
				return false;
		} else if (!secondPrice.equals(other.secondPrice))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (supplierId == null) {
			if (other.supplierId != null)
				return false;
		} else if (!supplierId.equals(other.supplierId))
			return false;
		if (thirdPrice == null) {
			if (other.thirdPrice != null)
				return false;
		} else if (!thirdPrice.equals(other.thirdPrice))
			return false;
		this.getAutoTypes().add(other.autoTypeId);
		return true;
	}

	public Set<Integer> getAutoTypes() {
		return autoTypes;
	}

	public void setAutoTypes(Set<Integer> autoTypes) {
		this.autoTypes = autoTypes;
	}
	
}