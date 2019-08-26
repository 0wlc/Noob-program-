package com.ozc.entity;
/**
 * 学生成绩类
 * @author Administrator
 *
 */
public class Score {
	private Long id;
	private Long studentId;
	private String studentName;
	private Long courseId;
	private String courseName;
	private String className;
	private String teacherName;
	private Double score;
	private Long cyear;
	private Integer schTerm;
	private Integer credit;
	private Integer state;
	
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
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
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
	public Integer getCredit() {
		return credit;
	}
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Score [id=" + id + ", studentId=" + studentId
				+ ", studentName=" + studentName + ", courseId=" + courseId
				+ ", courseName=" + courseName + ", className=" + className
				+ ", teacherName=" + teacherName + ", score=" + score
				+ ", cyear=" + cyear + ", schTerm=" + schTerm + ", credit="
				+ credit + ", state=" + state + "]";
	}
}
