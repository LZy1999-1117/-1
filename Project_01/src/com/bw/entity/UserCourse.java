package com.bw.entity;

public class UserCourse {
	
	private Integer id;
	private Integer uid;
	private Integer cid;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	@Override
	public String toString() {
		return "UserCourse [uid=" + uid + ", cid=" + cid + "]";
	}
	public UserCourse(Integer uid, Integer cid) {
		super();
		this.uid = uid;
		this.cid = cid;
	}
	public UserCourse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
