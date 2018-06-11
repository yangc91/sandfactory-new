package com.yc.sandfactory.bean;

import java.util.List;

public class Pagination<T> {

	private int total;
	
	private List<T> list;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
