package com.yc.sandfactory.entity;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import java.util.List;

/**
 * TODO hsun 完成注释
 *
 * @author hsun
 * @version 1.0
 * @since 2018/6/4 下午11:39
 */
@Table("t_dept")
public class Dept {

	@Id
	@Column("n_id")
	private Long id;

	/**
	 * 名称
	 */
	@Column("c_name")
	private String name;

	/**
	 * 编号
	 */
	@Column("c_code")
	private String code;

	/**
	 * 上级部门
	 */
	@Column("n_parent_id")
	private Long parentId;

	/**
	 * 排序
	 */
	@Column("n_sort")
	private int sort = 999;

	/**
	 * 创建时间
	 */
	@Column("n_create_time")
	private long createTime = System.currentTimeMillis();

	/**
	 * 状态 0-禁用 1-启用
	 */
	@Column("n_status")
	private int status = 1;

	/**
	 * 修改时间
	 */
	@Column("n_update_time")
	private Long updateTime;

	private List<Dept> children;

	private List<SysUser> sysUsers;

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}

	public List<Dept> getChildren() {
		return children;
	}

	public void setChildren(List<Dept> children) {
		this.children = children;
	}

	public List<SysUser> getSysUsers() {
		return sysUsers;
	}

	public void setSysUsers(List<SysUser> sysUsers) {
		this.sysUsers = sysUsers;
	}
}
