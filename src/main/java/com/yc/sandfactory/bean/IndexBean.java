package com.yc.sandfactory.bean;

import com.yc.sandfactory.entity.SysFunc;

import java.util.List;

public class IndexBean {

	private String name;
	
	private List<SysFunc> funcs;

	public IndexBean() {
	}

	public IndexBean(String name, List<SysFunc> funcs) {
		this.name = name;
		this.funcs = funcs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SysFunc> getFuncs() {
		return funcs;
	}

	public void setFuncs(List<SysFunc> funcs) {
		this.funcs = funcs;
	}
	
}
