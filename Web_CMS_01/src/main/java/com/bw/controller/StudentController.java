package com.bw.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bw.entity.Student;
import com.bw.entity.User;
import com.bw.service.StudentServiceimpl;
import com.github.pagehelper.PageHelper;

@Controller
public class StudentController {

	
	@Resource
	private StudentServiceimpl ssp;
	
	
	@RequestMapping("login.do")
	@ResponseBody
	public int Login(User user,HttpSession session){
		System.out.println(user+"------");
		int num=ssp.Login(user,session);
		return num;
	}
	
	
	@RequestMapping("/list.do")
	public String stuList(ModelMap map){
		List<Student> list=ssp.stuList();
		map.put("list", list);
		return "list";
	}
}
