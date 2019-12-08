package com.mayi.bean;

public class Order {
	
	private String sn;
	
	private Boolean isEn;

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public Boolean getIsEn() {
		return isEn;
	}

	public void setIsEn(Boolean isEn) {
		this.isEn = isEn;
	}

	@Override
	public String toString() {
		return "Order [sn=" + sn + ", isEn=" + isEn + "]";
	}
	
	
	
}
