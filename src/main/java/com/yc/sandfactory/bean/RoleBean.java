package com.yc.sandfactory.bean;

import java.util.List;

public class RoleBean {

	/**
	 * 主键
	 */
	private Long id;
	
	/**
	 * 名称
	 */
	private String name;
	
	/**
	 * 权限
	 */
	private List<Long> funcs;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Long> getFuncs() {
		return funcs;
	}

	public void setFuncs(List<Long> funcs) {
		this.funcs = funcs;
	}
}
