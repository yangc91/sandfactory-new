package com.yc.sandfactory.entity;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

@Table("t_sys_role_func")
public class RoleFunc {

	@Id
	@Column("n_id")
	private Long id;

	@Column("n_role_id")
	private Long roleId;

	@Column("n_func_id")
	private Long funcId;
	
	public RoleFunc() {
	}

	public RoleFunc(Long roleId, Long funcId) {
		this.roleId = roleId;
		this.funcId = funcId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getFuncId() {
		return funcId;
	}

	public void setFuncId(Long funcId) {
		this.funcId = funcId;
	}
}
