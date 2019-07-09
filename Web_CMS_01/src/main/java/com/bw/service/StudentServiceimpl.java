package com.bw.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.bw.entity.Student;
import com.bw.entity.User;

public interface StudentServiceimpl{



	int Login(User user, HttpSession session);

	List<Student> stuList();

}
