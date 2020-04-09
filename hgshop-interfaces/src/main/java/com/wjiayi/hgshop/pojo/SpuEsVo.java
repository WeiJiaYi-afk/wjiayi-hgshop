package com.wjiayi.hgshop.pojo;

import java.io.Serializable;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "hgshop",type = "spu")
public class SpuEsVo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/** 主键 **/
	private Integer id;
	/** SPU名 **/
	private String goodsName;
	/** 品牌 **/
	private Integer brandId;
	/** 副标题 **/
	private String caption;
	/** 一级类目 **/
	private Integer categoryId;
	/** 小图 **/
	private String smallPic;

	//品牌的名称
	private String brandName;
	//分类的名称
	private String categoryName;
	
	
	
	public SpuEsVo() {
		super();
	}
	
	public SpuEsVo(Spu spu) {
		super();
		this.brandId=spu.getId();
//		this.brandName=spu.getBrand()==null?"":	spu.getBrand()	
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public Integer getBrandId() {
		return brandId;
	}
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getSmallPic() {
		return smallPic;
	}
	public void setSmallPic(String smallPic) {
		this.smallPic = smallPic;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public SpuEsVo(Integer id, String goodsName, Integer brandId, String caption, Integer categoryId, String smallPic,
			String brandName, String categoryName) {
		super();
		this.id = id;
		this.goodsName = goodsName;
		this.brandId = brandId;
		this.caption = caption;
		this.categoryId = categoryId;
		this.smallPic = smallPic;
		this.brandName = brandName;
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "SpuEsVo [id=" + id + ", goodsName=" + goodsName + ", brandId=" + brandId + ", caption=" + caption
				+ ", categoryId=" + categoryId + ", smallPic=" + smallPic + ", brandName=" + brandName
				+ ", categoryName=" + categoryName + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brandId == null) ? 0 : brandId.hashCode());
		result = prime * result + ((brandName == null) ? 0 : brandName.hashCode());
		result = prime * result + ((caption == null) ? 0 : caption.hashCode());
		result = prime * result + ((categoryId == null) ? 0 : categoryId.hashCode());
		result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
		result = prime * result + ((goodsName == null) ? 0 : goodsName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((smallPic == null) ? 0 : smallPic.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SpuEsVo other = (SpuEsVo) obj;
		if (brandId == null) {
			if (other.brandId != null)
				return false;
		} else if (!brandId.equals(other.brandId))
			return false;
		if (brandName == null) {
			if (other.brandName != null)
				return false;
		} else if (!brandName.equals(other.brandName))
			return false;
		if (caption == null) {
			if (other.caption != null)
				return false;
		} else if (!caption.equals(other.caption))
			return false;
		if (categoryId == null) {
			if (other.categoryId != null)
				return false;
		} else if (!categoryId.equals(other.categoryId))
			return false;
		if (categoryName == null) {
			if (other.categoryName != null)
				return false;
		} else if (!categoryName.equals(other.categoryName))
			return false;
		if (goodsName == null) {
			if (other.goodsName != null)
				return false;
		} else if (!goodsName.equals(other.goodsName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (smallPic == null) {
			if (other.smallPic != null)
				return false;
		} else if (!smallPic.equals(other.smallPic))
			return false;
		return true;
	}
	
	
	
}
