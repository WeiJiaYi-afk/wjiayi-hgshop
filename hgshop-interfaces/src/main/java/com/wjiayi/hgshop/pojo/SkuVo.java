package com.wjiayi.hgshop.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class SkuVo extends Sku{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maxPrice;
	private String minPrice;
	
	private int maxStockCount;
	private int minStockCount;
	
	//卖点货标题当中含有的关键词
	private String key;

	public String getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(String maxPrice) {
		this.maxPrice = maxPrice;
	}

	public String getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(String minPrice) {
		this.minPrice = minPrice;
	}

	public int getMaxStockCount() {
		return maxStockCount;
	}

	public void setMaxStockCount(int maxStockCount) {
		this.maxStockCount = maxStockCount;
	}

	public int getMinStockCount() {
		return minStockCount;
	}

	public void setMinStockCount(int minStockCount) {
		this.minStockCount = minStockCount;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public SkuVo(Integer id, String title, String sellPoint, BigDecimal price, int stockCount, String barcode,
			String image, int status, Date createTime, Date updateTime, BigDecimal costPrice, BigDecimal marketPrice,
			int spuId, String cartThumbnail, Spu spu, List<SpecOption> specOptionList, String maxPrice, String minPrice,
			int maxStockCount, int minStockCount, String key) {
		super(id, title, sellPoint, price, stockCount, barcode, image, status, createTime, updateTime, costPrice,
				marketPrice, spuId, cartThumbnail, spu, specOptionList);
		this.maxPrice = maxPrice;
		this.minPrice = minPrice;
		this.maxStockCount = maxStockCount;
		this.minStockCount = minStockCount;
		this.key = key;
	}

	@Override
	public String toString() {
		return "SkuVo [maxPrice=" + maxPrice + ", minPrice=" + minPrice + ", maxStockCount=" + maxStockCount
				+ ", minStockCount=" + minStockCount + ", key=" + key + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((maxPrice == null) ? 0 : maxPrice.hashCode());
		result = prime * result + maxStockCount;
		result = prime * result + ((minPrice == null) ? 0 : minPrice.hashCode());
		result = prime * result + minStockCount;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SkuVo other = (SkuVo) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (maxPrice == null) {
			if (other.maxPrice != null)
				return false;
		} else if (!maxPrice.equals(other.maxPrice))
			return false;
		if (maxStockCount != other.maxStockCount)
			return false;
		if (minPrice == null) {
			if (other.minPrice != null)
				return false;
		} else if (!minPrice.equals(other.minPrice))
			return false;
		if (minStockCount != other.minStockCount)
			return false;
		return true;
	}

	public SkuVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SkuVo(Integer id, String title, String sellPoint, BigDecimal price, int stockCount, String barcode,
			String image, int status, Date createTime, Date updateTime, BigDecimal costPrice, BigDecimal marketPrice,
			int spuId, String cartThumbnail, Spu spu, List<SpecOption> specOptionList) {
		super(id, title, sellPoint, price, stockCount, barcode, image, status, createTime, updateTime, costPrice, marketPrice,
				spuId, cartThumbnail, spu, specOptionList);
		// TODO Auto-generated constructor stub
	}

	
	
	
}
