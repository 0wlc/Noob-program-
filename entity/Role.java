package com.ozc.entity;

import java.util.Date;
/**
 * 角色管理
 * @author Administrator
 *
 */
public class Role {
	private Long id;
	private String name;
	private Date createDate;
	
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
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", createDate="
				+ createDate + "]";
	}
	
}
