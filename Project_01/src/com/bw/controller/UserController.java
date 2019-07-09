package com.bw.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.bw.entity.Area;
import com.bw.entity.Course;
import com.bw.entity.User;
import com.bw.service.UserServiceimpl;
import com.bw.utils.FileUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Controller
public class UserController {
	
	
	@Resource
	private UserServiceimpl usp;
	
	
	@RequestMapping("/zhuece.do")
	@ResponseBody
	public Object zhuece(User user,HttpSession session){
		System.out.println(user.getPassword());
		System.out.println(user);
		int flag=usp.zhuece(user);
		
		return flag;
	}
	
	
	@RequestMapping("/login.do")
	@ResponseBody
	public Object login(String uname,String password,HttpSession session){
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("uname", uname);
		map.put("password", password);
		User ur=usp.login(map);
		System.out.println(ur);
		if(ur!=null){
			session.setAttribute("user", ur);
			return 1;
		}else{
			return 0;
		}
	}
	
	
	
	@RequestMapping("/hxarea1.do")
	@ResponseBody
	public Object hxarea1(){
		List<Area> list=usp.hxarea1();
		return list;
	}
	
	@RequestMapping("/HxShi.do")
	@ResponseBody
	public Object HxShi(Integer aid){
		List<Area> list=usp.HxShi(aid);
		System.out.println(list);
		return list;
	}
	
	
	@RequestMapping("/HxXian.do")
	@ResponseBody
	public Object HxXian(Integer aid){
		List<Area> list=usp.HxXian(aid);
		System.out.println(list);
		return list;
	}
	
	
	
	@RequestMapping("/lookImg.do")
	public void lookImg(String path,HttpServletRequest request,HttpServletResponse response){
		FileUtils.lookImg(path, request, response);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/addCoures.do")
	public String addCoures(Course cou,MultipartFile photo) throws IllegalStateException, IOException{
		String path = FileUtils.upload(photo);
		cou.setPath(path);
		int flag=usp.addCoures(cou);
		if(flag>0){
			return "redirect:courselist.do";
		}
		return "addCourse1";
	}
	
	@RequestMapping("/courselist.do")
	public String courseList(ModelMap map,@RequestParam(required=false,defaultValue="1")Integer pageNum,@RequestParam(required=false,defaultValue="")String label
			,@RequestParam(required=false,defaultValue="")String cname){

		HashMap<String, Object> maps = new HashMap<String,Object>();
		maps.put("cname", cname);
		maps.put("label", label);
		
		
		PageHelper pageHelper = new PageHelper();
		pageHelper.startPage(pageNum, 2);
		List<Course> list=usp.courseList(maps);
		
		
		PageInfo<Course> page = new PageInfo<Course>(list);
		map.put("pages", page.getPages());
		map.put("page", page);
	/*	map.put("listarea", listarea);*/
		return "coureslist";
	}
	
	
	
	@RequestMapping("/chakankc.do")
	@ResponseBody
	public Object chakankc(Integer cid,ModelMap map){
		Course cou=usp.chakankc(cid);
		List<Area> sheng=usp.hxarea1();
		List<Area> shi=usp.HxShi(cou.getArea1());
		List<Area> xian=usp.HxXian(cou.getArea2());

		map.put("cou", cou);
		map.put("sheng", sheng);
		map.put("shi", shi);
		map.put("xian", xian);
		String string = JSON.toJSONString(map);
		Object json = JSON.toJSON(string);
		return cou;
	}
	
	
	@RequestMapping("/addCouser1.do")
	@ResponseBody 
	public Object addCouser(Integer cid,HttpSession session){
		User user = (User) session.getAttribute("user");
		System.out.println(user.getUid());
		int flag=usp.addCouser(cid,user.getUid());
		return "redirect:courselist.do";
	}
	
	@RequestMapping("/deleteAll.do")
	@ResponseBody
	public Object deleteAll(Integer cid){
		int flag=usp.deleteAll(cid);
		return flag;
	}
	
/*	@RequestMapping("/selectMh.do")
	@ResponseBody
	public Object selectMh(String cname,String label){
		
	}*/
}
