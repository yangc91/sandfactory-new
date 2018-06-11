package com.yc.sandfactory.service;


import com.yc.sandfactory.entity.Dept;

import java.util.List;

public interface IDeptService {

	public List<Dept> tree();
	
	public boolean editSave(Dept dept);
	
	public int getPersonSizeOfDept(int deptId);
	
	public int getChildDeptSize(int deptId);
	
	public boolean delete(int deptId);
	
	public boolean add(Dept dept);
}
