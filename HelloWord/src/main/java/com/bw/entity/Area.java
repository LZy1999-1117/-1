package com.bw.entity;

public class Area {
	private Integer aid;
	private String aname;
	private Integer faid;
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public Integer getFaid() {
		return faid;
	}
	public void setFaid(Integer faid) {
		this.faid = faid;
	}
	@Override
	public String toString() {
		return "Area [aid=" + aid + ", aname=" + aname + ", faid=" + faid + "]";
	}
	public Area(Integer aid, String aname, Integer faid) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.faid = faid;
	}
	public Area() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
