package com.liuzhongyuan.cms.domain;

public class Picture {
	
	
	
	private Integer pid;
	private String photo;
	private String content;
	
	
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Picture(Integer pid, String photo, String content) {
		super();
		this.pid = pid;
		this.photo = photo;
		this.content = content;
	}
	public Picture() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Picture [pid=" + pid + ", photo=" + photo + ", content="
				+ content + "]";
	}
	
	
	
	
	
}
