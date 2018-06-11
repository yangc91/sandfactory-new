package com.yc.sandfactory.entity;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import java.util.List;

@Table("t_sys_func")
public class SysFunc {

	/**
	 * 主键
	 */
	@Id
	@Column("n_id")
	private Long id;
	
	/**
	 * 名称
	 */
	@Column("c_name")
	private String name;
	
	/**
	 * 图标
	 */
	@Column("c_icon")
	private String icon;
	
	/**
	 * 父ID
	 */
	@Column("n_parent_id")
	private Long parentId;
	
	/**
	 * 排序
	 */
	@Column("n_sort")
	private int sort;
	
	/**
	 * 链接，为angularjs使用，例如“demo”
	 */
	@Column("c_url")
	private String url;
	
	/**
	 * 权限，后台验证请求使用，如“/user/”
	 */
	@Column("c_permission")
	private String permission;
	
	/**
	 * 子菜单
	 */
	private List<SysFunc> child;

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

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public List<SysFunc> getChild() {
		return child;
	}

	public void setChild(List<SysFunc> child) {
		this.child = child;
	}
}
