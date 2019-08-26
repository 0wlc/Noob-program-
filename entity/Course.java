package com.ozc.entity;

import java.util.Date;

public class Course {
	private Long id;
	private Long teacherId;
	private String teacherName;
	private String name;
	private Long cyear;
	private Integer schTerm;
	private Double credit;
	private Integer state;
	private Date createDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getCyear() {
		return cyear;
	}
	public void setCyear(Long cyear) {
		this.cyear = cyear;
	}
	public Integer getSchTerm() {
		return schTerm;
	}
	public void setSchTerm(Integer schTerm) {
		this.schTerm = schTerm;
	}
	public Double getCredit() {
		return credit;
	}
	public void setCredit(Double credit) {
		this.credit = credit;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", teacherId=" + teacherId + ", name="
				+ name + ", cyear=" + cyear + ", schTerm=" + schTerm
				+ ", credit=" + credit + ", state=" + state + ", createDate="
				+ createDate + "]";
	}
	
}
