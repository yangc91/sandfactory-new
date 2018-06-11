package com.yc.sandfactory.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.yc.sandfactory.entity.Dept;
import com.yc.sandfactory.entity.SysUser;
import com.yc.sandfactory.service.IDeptService;
import org.nutz.dao.Cnd;
import org.nutz.dao.impl.NutDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class DeptServiceImpl implements IDeptService {

	@Autowired
	private NutDao nutDao;

	private char[] CODE_BASE = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
	
	public List<Dept> tree() {
		List<Dept> result = Lists.newArrayList();
		List<Dept> deptList = nutDao.query(Dept.class, Cnd.where("status", "=", 1));
		Map<Long, Dept> map = Maps.newHashMap();
		
		for(Dept dept : deptList) {
			map.put(dept.getId(), dept);
			if(null == dept.getParentId()) {
				result.add(dept);
			}
		}
		
		Set<Long> keySet = map.keySet();
		for(Long id : keySet) {
			Dept dept = map.get(id);
			if(null == dept.getParentId()) {
				continue;
			}
			Dept parent = map.get(dept.getParentId());
			if(parent == null) {
				continue;
			}
			List<Dept> children = parent.getChildren();
			if(children == null) {
				children = Lists.newArrayList();
				parent.setChildren(children);
			}
			children.add(dept);
		}
		
		return result;
	}

	public boolean editSave(Dept dept) {
		dept.setUpdateTime(System.currentTimeMillis());
		this.nutDao.update(dept);
		return true;
	}

	public int getPersonSizeOfDept(int deptId) {
		return this.nutDao.count(SysUser.class, Cnd.where("deptId", "=", deptId));
	}

	public int getChildDeptSize(int deptId) {
		return this.nutDao.count(Dept.class, Cnd.where("parentId", "=", deptId));
	}

	public boolean delete(int deptId) {
		Dept dept = this.nutDao.fetch(Dept.class, Cnd.where("id", "=", deptId));
		dept.setStatus(2);
		this.nutDao.update(dept);
//		return this.dao.deleteDept(Dept.UPDATE_TYPE_DEL, System.currentTimeMillis(), deptId);
		return true;
	}

	public boolean add(Dept dept) {
		String code = null;

		List<Dept> pbCodes = nutDao.query(Dept.class, Cnd.where("parentId", "=", dept.getParentId()));

		String parentCode = "";
		List<String> brotherCodes = new ArrayList<String>();
		for(Dept codeDept : pbCodes) {
			if(codeDept.getId() == dept.getParentId()) {
				parentCode = codeDept.getCode();
			} else {
				brotherCodes.add(codeDept.getCode());
			}
		}
		
		code = createCode(parentCode, brotherCodes);
		if(StringUtils.isEmpty(code)) {
			return false;
		}
		dept.setCode(code);
		dept.setUpdateTime(System.currentTimeMillis());
		this.nutDao.insert(dept);
		return true;
	}

	/**
	 * 生成CODE
	 * @param parentCode
	 * @param brotherCodes
	 * @return
	 */
	private String createCode(String parentCode, List<String> brotherCodes) {
		if (brotherCodes.size() == 0) {
			return parentCode + CODE_BASE[0] + CODE_BASE[0];
		}
		if (brotherCodes.size() == CODE_BASE.length * CODE_BASE.length) {
			return null;
		}
		for (char code1 : CODE_BASE) {
			for (char code2 : CODE_BASE) {
				if(brotherCodes.contains(parentCode + code1 + code2)) {
					continue;
				} else {
					return parentCode + code1 + code2;
				}
			}
		}
		return null;
	}
}
