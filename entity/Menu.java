package com.ozc.entity;

import java.util.Date;

import net.sf.json.JSONString;

/**
 * 菜单管理
 * @author Administrator
 *
 */
public class Menu implements Comparable<Menu>,JSONString{
	private Long id;
	private String name;
	private String url;
	private Long pid;
	private Integer mlevel;
	private Long orderNo;
	private Date createDate;
	//表示该角色已经被分配权限
	private Boolean checked;
	
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public Integer getMlevel() {
		return mlevel;
	}
	public void setMlevel(Integer mlevel) {
		this.mlevel = mlevel;
	}
	public Long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	
	@Override
	public int compareTo(Menu o) {
		if(this.getId() > o.getId()){
			return 1;
		}else if(this.getId() < o.getId()){
			return -1;
		}else return 0;
	}
	
	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", url=" + url + ", pid="
				+ pid + ", mlevel=" + mlevel + ", orderNo=" + orderNo
				+ ", createDate=" + createDate + "]";
	}
	
	@Override
	public String toJSONString() {
		String json = "{\"id\":" + this.id + ",\"pId\":" + this.pid
				+ ",\"name\":\"" + this.name + "\",\"open\":"
				+ (this.mlevel == 1 ? true : false) + ",\"checked\":"
				+ this.checked + "}";
		return json;
	}
	
}