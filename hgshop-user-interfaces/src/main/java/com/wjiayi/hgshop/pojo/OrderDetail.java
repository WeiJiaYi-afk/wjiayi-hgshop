package com.wjiayi.hgshop.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

//订单详情
public class OrderDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**  **/
	private Integer id;
	/** sku **/
	private int skuId;
	/** 总价格 **/
	private BigDecimal total;
	/** 订单id **/
	private int oid;
	/** 购买数量 **/
	private int pnum;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getSkuId() {
		return skuId;
	}
	public void setSkuId(int skuId) {
		this.skuId = skuId;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public Integer getPnum() {
		return pnum;
	}
	public void setPnum(Integer pnum) {
		this.pnum = pnum;
	}
	public OrderDetail(Integer id, int skuId, BigDecimal total, Integer oid, Integer pnum) {
		super();
		this.id = id;
		this.skuId = skuId;
		this.total = total;
		this.oid = oid;
		this.pnum = pnum;
	}
	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", skuId=" + skuId + ", total=" + total + ", oid=" + oid + ", pnum=" + pnum
				+ "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + oid;
		result = prime * result + pnum;
		result = prime * result + skuId;
		result = prime * result + ((total == null) ? 0 : total.hashCode());
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
		OrderDetail other = (OrderDetail) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (oid != other.oid)
			return false;
		if (pnum != other.pnum)
			return false;
		if (skuId != other.skuId)
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		return true;
	}
	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}
	
	
}
