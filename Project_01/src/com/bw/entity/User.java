package com.bw.entity;

public class User {
	private Integer uid;
	private String uname;
	private String password;
	
	private Integer rolecode;

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRolecode() {
		return rolecode;
	}

	public void setRolecode(Integer rolecode) {
		this.rolecode = rolecode;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", password="
				+ password + ", rolecode=" + rolecode + "]";
	}

	public User(Integer uid, String uname, String password, Integer rolecode) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.password = password;
		this.rolecode = rolecode;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	
	
	
	
}
