package com.yc.sandfactory.bean;

import java.io.Serializable;

public class MonthCountBean implements Serializable {

	private static final long serialVersionUID = 1L;
	  
	private String month;
	private Float weight;
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}
}
