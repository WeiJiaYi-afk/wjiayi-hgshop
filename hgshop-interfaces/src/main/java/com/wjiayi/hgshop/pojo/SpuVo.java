package com.wjiayi.hgshop.pojo;

import java.io.Serializable;

//保存页面的查询条件
public class SpuVo extends Spu implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//排序字段的编号
	int sortField;
	//排序方式
	String sortType;
	
	
	public int getSortField() {
		return sortField;
	}
	public void setSortField(int sortField) {
		this.sortField = sortField;
	}
	public String getSortType() {
		return sortType;
	}
	public void setSortType(String sortType) {
		this.sortType = sortType;
	}
	public SpuVo(Integer id, String goodsName, String isMarketable, Integer brandId, String caption, Integer categoryId,
			String smallPic, Brand brand, Category category, int sortField, String sortType) {
		super(id, goodsName, isMarketable, brandId, caption, categoryId, smallPic, brand, category);
		this.sortField = sortField;
		this.sortType = sortType;
	}
	@Override
	public String toString() {
		return "SpuVo [sortField=" + sortField + ", sortType=" + sortType + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + sortField;
		result = prime * result + ((sortType == null) ? 0 : sortType.hashCode());
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
		SpuVo other = (SpuVo) obj;
		if (sortField != other.sortField)
			return false;
		if (sortType == null) {
			if (other.sortType != null)
				return false;
		} else if (!sortType.equals(other.sortType))
			return false;
		return true;
	}
	public SpuVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SpuVo(Integer id, String goodsName, String isMarketable, Integer brandId, String caption, Integer categoryId,
			String smallPic, Brand brand, Category category) {
		super(id, goodsName, isMarketable, brandId, caption, categoryId, smallPic, brand, category);
		// TODO Auto-generated constructor stub
	}
	
	
	
}
