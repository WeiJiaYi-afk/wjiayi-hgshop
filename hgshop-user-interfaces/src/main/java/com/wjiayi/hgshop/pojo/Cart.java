package com.wjiayi.hgshop.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

//购物车
public class Cart implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**  **/
	private Integer id;
	/** 用户id **/
	private int uid;
	/** 商品id(商品型号) **/
	private int skuId;
	/** 购买数量 **/
	private int pnum;
	/** 创建时间 **/
	private Date createtime;
	/** 最后修改时间 **/
	private Date updatetime;
	/** 总件 **/
	private BigDecimal sumTotal;

	private Sku sku;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getSkuId() {
		return skuId;
	}

	public void setSkuId(int skuId) {
		this.skuId = skuId;
	}

	public int getPnum() {
		return pnum;
	}

	public void setPnum(int pnum) {
		this.pnum = pnum;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public BigDecimal getSumTotal() {
		return sumTotal;
	}

	public void setSumTotal(BigDecimal sumTotal) {
		this.sumTotal = sumTotal;
	}

	public Sku getSku() {
		return sku;
	}

	public void setSku(Sku sku) {
		this.sku = sku;
	}

	public Cart(Integer id, int uid, int skuId, int pnum, Date createtime, Date updatetime, BigDecimal sumTotal,
			Sku sku) {
		super();
		this.id = id;
		this.uid = uid;
		this.skuId = skuId;
		this.pnum = pnum;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.sumTotal = sumTotal;
		this.sku = sku;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", uid=" + uid + ", skuId=" + skuId + ", pnum=" + pnum + ", createtime=" + createtime
				+ ", updatetime=" + updatetime + ", sumTotal=" + sumTotal + ", sku=" + sku + "]";
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createtime == null) ? 0 : createtime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + pnum;
		result = prime * result + ((sku == null) ? 0 : sku.hashCode());
		result = prime * result + skuId;
		result = prime * result + ((sumTotal == null) ? 0 : sumTotal.hashCode());
		result = prime * result + uid;
		result = prime * result + ((updatetime == null) ? 0 : updatetime.hashCode());
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
		Cart other = (Cart) obj;
		if (createtime == null) {
			if (other.createtime != null)
				return false;
		} else if (!createtime.equals(other.createtime))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pnum != other.pnum)
			return false;
		if (sku == null) {
			if (other.sku != null)
				return false;
		} else if (!sku.equals(other.sku))
			return false;
		if (skuId != other.skuId)
			return false;
		if (sumTotal == null) {
			if (other.sumTotal != null)
				return false;
		} else if (!sumTotal.equals(other.sumTotal))
			return false;
		if (uid != other.uid)
			return false;
		if (updatetime == null) {
			if (other.updatetime != null)
				return false;
		} else if (!updatetime.equals(other.updatetime))
			return false;
		return true;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
