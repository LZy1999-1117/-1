package com.bw.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.bw.entity.Student;
import com.bw.entity.User;
import com.bw.mapper.StudentDaoimpl;


@Service
public class StudentService implements StudentServiceimpl{

	
	
	@Resource
	private StudentDaoimpl sdp;
	


	@Override
	public int Login(User user, HttpSession session) {
		// TODO Auto-generated method stub
		User u=sdp.Login(user);
		System.out.println(u);
		if(u!=null){
			session.setAttribute("user", u);
			return 1;
		}
		return 0;
	}



	@Override
	public List<Student> stuList() {
		// TODO Auto-generated method stub
		return sdp.stuList();
	}

}
