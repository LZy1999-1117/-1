package com.bw.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bw.entity.Area;
import com.bw.entity.Course;
import com.bw.entity.User;
import com.bw.mapper.UserDao;


@Service
public class UserService implements UserServiceimpl{
	
	
	@Resource
	private UserDao udp;

	public int zhuece(User user) {
		// TODO Auto-generated method stub
		return udp.zhuce(user);
	}

	public User login(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return udp.login(map);
	}

	public List<Area> hxarea1() {
		// TODO Auto-generated method stub
		return udp.hxarea1();
	}

	public List<Area> HxShi(Integer aid) {
		// TODO Auto-generated method stub
		return udp.HxShi(aid);
	}

	public List<Area> HxXian(Integer aid) {
		// TODO Auto-generated method stub
		return udp.HxXian(aid);
	}

	
	
	public int addCoures(Course cou) {
		// TODO Auto-generated method stub
		return udp.addCoures(cou);
	}

	public List<Course> courseList(HashMap<String, Object> maps) {
		// TODO Auto-generated method stub
		return udp.courseList(maps);
	}

	public Course chakankc(Integer cid) {
		// TODO Auto-generated method stub
		return udp.chakankc(cid);
	}

	public int addCouser(Integer cid, Integer uid) {
		// TODO Auto-generated method stub
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("cid", cid);
		map.put("uid", uid);
		udp.addCouser(map);
		return 1;
	}

	public int deleteAll(Integer cid) {
		// TODO Auto-generated method stub
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("cid", cid);
		return udp.deleteAll(map);
	}

	




}
