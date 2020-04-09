package com.wjiayi.hgshop.pojo;

import java.io.Serializable;

public class SpecOption implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 规格项ID **/
	private int id;
	/** 规格项名称  黑色 38m ..**/
	private String optionName;
	//选项内容
	private String specName;
	/** 规格ID **/
	private int specId;
	/** 排序值 **/
	private int orders;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOptionName() {
		return optionName;
	}
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	public String getSpecName() {
		return specName;
	}
	public void setSpecName(String specName) {
		this.specName = specName;
	}
	public int getSpecId() {
		return specId;
	}
	public void setSpecId(int specId) {
		this.specId = specId;
	}
	public int getOrders() {
		return orders;
	}
	public void setOrders(int orders) {
		this.orders = orders;
	}
	public SpecOption(int id, String optionName, String specName, int specId, int orders) {
		super();
		this.id = id;
		this.optionName = optionName;
		this.specName = specName;
		this.specId = specId;
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "SpecOption [id=" + id + ", optionName=" + optionName + ", specName=" + specName + ", specId=" + specId
				+ ", orders=" + orders + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((optionName == null) ? 0 : optionName.hashCode());
		result = prime * result + orders;
		result = prime * result + specId;
		result = prime * result + ((specName == null) ? 0 : specName.hashCode());
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
		SpecOption other = (SpecOption) obj;
		if (id != other.id)
			return false;
		if (optionName == null) {
			if (other.optionName != null)
				return false;
		} else if (!optionName.equals(other.optionName))
			return false;
		if (orders != other.orders)
			return false;
		if (specId != other.specId)
			return false;
		if (specName == null) {
			if (other.specName != null)
				return false;
		} else if (!specName.equals(other.specName))
			return false;
		return true;
	}
	public SpecOption() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
