package com.bw.service;

import java.util.HashMap;
import java.util.List;

import com.bw.entity.Area;
import com.bw.entity.Course;
import com.bw.entity.User;

public interface UserServiceimpl {

	int zhuece(User user);


	User login(HashMap<String, Object> map);


	List<Area> hxarea1();


	List<Area> HxShi(Integer aid);


	List<Area> HxXian(Integer aid);


	int addCoures(Course cou);


	List<Course> courseList(HashMap<String, Object> maps);


	Course chakankc(Integer cid);


	int addCouser(Integer cid, Integer uid);




	int deleteAll(Integer cid);

}
