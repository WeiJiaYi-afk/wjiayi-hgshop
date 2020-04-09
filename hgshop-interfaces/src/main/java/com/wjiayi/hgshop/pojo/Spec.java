package com.wjiayi.hgshop.pojo;

import java.io.Serializable;
import java.util.List;

public class Spec implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 主键 **/
	private int id;
	/** 名称 **/
	private String specName;
	
	private List<SpecOption> optionList;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSpecName() {
		return specName;
	}

	public void setSpecName(String specName) {
		this.specName = specName;
	}

	public List<SpecOption> getOptionList() {
		return optionList;
	}

	public void setOptionList(List<SpecOption> optionList) {
		this.optionList = optionList;
	}

	public Spec(int id, String specName, List<SpecOption> optionList) {
		super();
		this.id = id;
		this.specName = specName;
		this.optionList = optionList;
	}

	@Override
	public String toString() {
		return "Spec [id=" + id + ", specName=" + specName + ", optionList=" + optionList + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((optionList == null) ? 0 : optionList.hashCode());
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
		Spec other = (Spec) obj;
		if (id != other.id)
			return false;
		if (optionList == null) {
			if (other.optionList != null)
				return false;
		} else if (!optionList.equals(other.optionList))
			return false;
		if (specName == null) {
			if (other.specName != null)
				return false;
		} else if (!specName.equals(other.specName))
			return false;
		return true;
	}

	public Spec() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
