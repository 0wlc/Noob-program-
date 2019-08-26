package com.ozc.entity;

import java.util.Date;

/**
 * 学生选课类
 * @author Administrator
 *
 */
public class SCourse {
	private Long id;
	private Long studentId;
	private String studentName;
	private Long courseId;
	private String courseName;
	private String teacherName;
	private Double score;
	private Long cyear;
	private Integer schTerm;
	private Double credit;
	private Integer state;
	private String remark;
	private Date createDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "SCourse [id=" + id + ", studentId=" + studentId
				+ ", studentName=" + studentName + ", courseId=" + courseId
				+ ", courseName=" + courseName 
				+ ", teacherName=" + teacherName + ", score=" + score
				+ ", cyear=" + cyear + ", schTerm=" + schTerm + ", credit="
				+ credit + ", state=" + state + ", remark=" + remark
				+ ", createDate=" + createDate + "]";
	}
}
