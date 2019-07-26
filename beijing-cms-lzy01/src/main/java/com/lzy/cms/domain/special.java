package com.lzy.cms.domain;

import java.util.List;

public class special {
	
	
	private Integer id;
	private String title;
	private String abstracts;
	private String created;
	private List<Article> artlist;
	
	
	
	
	public List<Article> getArtlist() {
		return artlist;
	}
	public void setArtlist(List<Article> artlist) {
		this.artlist = artlist;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAbstracts() {
		return abstracts;
	}
	public void setAbstracts(String abstracts) {
		this.abstracts = abstracts;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public special(Integer id, String title, String abstracts, String created) {
		super();
		this.id = id;
		this.title = title;
		this.abstracts = abstracts;
		this.created = created;
	}
	public special() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "special [id=" + id + ", title=" + title + ", abstracts="
				+ abstracts + ", created=" + created + "]";
	}
	
	
	
	
	
}
