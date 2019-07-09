package com.bw.entity;

public class Course {
	private Integer cid;
	private String cname;
	private String content;
	private Integer area1;
	private Integer area2;
	private Integer area3;
	private String startdate;
	private String enddate;
	private String label;
	private String path;


	private Area sname;
	private Area ssname;
	private Area xname;
	
	private String uname;
	private Integer rolecode;
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getArea1() {
		return area1;
	}
	public void setArea1(Integer area1) {
		this.area1 = area1;
	}
	public Integer getArea2() {
		return area2;
	}
	public void setArea2(Integer area2) {
		this.area2 = area2;
	}
	public Integer getArea3() {
		return area3;
	}
	public void setArea3(Integer area3) {
		this.area3 = area3;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Area getSname() {
		return sname;
	}
	public void setSname(Area sname) {
		this.sname = sname;
	}
	public Area getSsname() {
		return ssname;
	}
	public void setSsname(Area ssname) {
		this.ssname = ssname;
	}
	public Area getXname() {
		return xname;
	}
	public void setXname(Area xname) {
		this.xname = xname;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Integer getRolecode() {
		return rolecode;
	}
	public void setRolecode(Integer rolecode) {
		this.rolecode = rolecode;
	}
	public Course(Integer cid, String cname, String content, Integer area1,
			Integer area2, Integer area3, String startdate, String enddate,
			String label, String path, Area sname, Area ssname, Area xname,
			String uname, Integer rolecode) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.content = content;
		this.area1 = area1;
		this.area2 = area2;
		this.area3 = area3;
		this.startdate = startdate;
		this.enddate = enddate;
		this.label = label;
		this.path = path;
		this.sname = sname;
		this.ssname = ssname;
		this.xname = xname;
		this.uname = uname;
		this.rolecode = rolecode;
	}
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + ", content="
				+ content + ", area1=" + area1 + ", area2=" + area2
				+ ", area3=" + area3 + ", startdate=" + startdate
				+ ", enddate=" + enddate + ", label=" + label + ", path="
				+ path + ", sname=" + sname + ", ssname=" + ssname + ", xname="
				+ xname + ", uname=" + uname + ", rolecode=" + rolecode + "]";
	}
	
	
	
	
	
	
}
