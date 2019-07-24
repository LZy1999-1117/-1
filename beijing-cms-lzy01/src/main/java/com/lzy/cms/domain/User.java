/**
 * 
 */
package com.lzy.cms.domain;

import java.io.Serializable;
import java.util.Date;

import com.lzy.cms.metas.Gender;

/**
 * 说明:用户表(cms_user)
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2019年3月16日  下午8:03:55
 */
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**主键**/
	private Integer id;

	/**用户名**/
	private String username;
	
	/**密码*/
	private String password;
	
	/**昵称**/
	private String nickname;
	
	/**生日*/
	private Date birthday;
	
	/**性别**/
	private Gender gender;
	
	/**是否启动|禁用**/
	private Boolean locked;

	/**创建时间*/
	private Date created;
	
	/**更新时间*/
	private Date updated;
	
	 
	
	// 手机号
	private String phone;
	
	//地区
	private String address;
	
	//星座
	private String star;
	
	//座右铭
	
	private String  motto;
	
	
	//邮箱
	private String email;
	
	
	// 图片地址
	private String picture;
	
	//------------------------------------------------------------------------
	
	
	
	
	
	
	public String getPhone() {
		return phone;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStar() {
		return star;
	}

	public void setStar(String star) {
		this.star = star;
	}

	public String getMotto() {
		return motto;
	}

	public void setMotto(String motto) {
		this.motto = motto;
	}

	public User() {
		super();
	}
	
	public User(Integer id) {
		super();
		this.id = id;
	}
	public User(String username) {
		super();
		this.username = username;
	}

	
	//------------------------------------------------------------------------


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	
	//--------------------------------------------------------------------------------

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", nickname=" + nickname + ", birthday="
				+ birthday + ", gender=" + gender + ", locked=" + locked
				+ ", created=" + created + ", updated=" + updated + ", phone="
				+ phone + ", address=" + address + ", star=" + star
				+ ", motto=" + motto + ", email=" + email + ", picture="
				+ picture + "]";
	}
	
	
	
	
}
