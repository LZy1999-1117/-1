package com.bw.mapper;

import java.util.List;

import com.bw.entity.Student;
import com.bw.entity.User;

public interface StudentDaoimpl {

	User Login(User user);

	List<Student> stuList();

}
