package com.ozc.entity;

import java.util.Date;
/**
 * 班级管理
 * @author Administrator
 *
 */
public class Class {
	private Long id;
	private String name;
	private String charger;
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
	public String getCharger() {
		return charger;
	}
	public void setCharger(String charger) {
		this.charger = charger;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "Class [id=" + id + ", name=" + name + ", charger=" + charger
				+ ", createDate=" + createDate + "]";
	}
	
}
