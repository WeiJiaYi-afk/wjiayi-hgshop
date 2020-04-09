package com.wjiayi.hgshop.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

//商品订单
public class Orders implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**  **/
	private Integer oid;
	/**  **/
	private int uid;
	/**  **/
	private BigDecimal sumtotal;
	/**  **/
	private String address;
	/**  **/
	private Date createTime;
	//订单详情列表
	private List<OrderDetail> detailList;

	
	
	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public BigDecimal getSumtotal() {
		return sumtotal;
	}

	public void setSumtotal(BigDecimal sumtotal) {
		this.sumtotal = sumtotal;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public List<OrderDetail> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<OrderDetail> detailList) {
		this.detailList = detailList;
	}

	public Orders(Integer oid, int uid, BigDecimal sumtotal, String address, Date createTime,
			List<OrderDetail> detailList) {
		super();
		this.oid = oid;
		this.uid = uid;
		this.sumtotal = sumtotal;
		this.address = address;
		this.createTime = createTime;
		this.detailList = detailList;
	}

	@Override
	public String toString() {
		return "Orders [oid=" + oid + ", uid=" + uid + ", sumtotal=" + sumtotal + ", address=" + address
				+ ", createTime=" + createTime + ", detailList=" + detailList + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((detailList == null) ? 0 : detailList.hashCode());
		result = prime * result + ((oid == null) ? 0 : oid.hashCode());
		result = prime * result + ((sumtotal == null) ? 0 : sumtotal.hashCode());
		result = prime * result + uid;
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
		Orders other = (Orders) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (detailList == null) {
			if (other.detailList != null)
				return false;
		} else if (!detailList.equals(other.detailList))
			return false;
		if (oid == null) {
			if (other.oid != null)
				return false;
		} else if (!oid.equals(other.oid))
			return false;
		if (sumtotal == null) {
			if (other.sumtotal != null)
				return false;
		} else if (!sumtotal.equals(other.sumtotal))
			return false;
		if (uid != other.uid)
			return false;
		return true;
	}

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
