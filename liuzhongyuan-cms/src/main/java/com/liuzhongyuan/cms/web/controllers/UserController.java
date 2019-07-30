/**
 * 
 */
package com.liuzhongyuan.cms.web.controllers;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuzhongyuan.cms.core.Page;
import com.liuzhongyuan.cms.domain.Article;
import com.liuzhongyuan.cms.domain.Category;
import com.liuzhongyuan.cms.domain.Channel;
import com.liuzhongyuan.cms.domain.Picture;
import com.liuzhongyuan.cms.domain.User;
import com.liuzhongyuan.cms.metas.Gender;
import com.liuzhongyuan.cms.service.ArticleService;
import com.liuzhongyuan.cms.utils.FileUploadUtil;
import com.liuzhongyuan.cms.utils.PageHelpUtil;
import com.liuzhongyuan.cms.web.Constant;
import com.liuzhongyuan.cms.service.UserService;

/**
 * 说明:
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2018年1月10日 下午2:40:38
 */
@Controller
@RequestMapping("/my")
public class UserController {

	@Autowired
	ArticleService articleService;
	
	@Resource(name="userService")
	UserService userService;
	
	@RequestMapping({"/", "/index", "/home"})
	public String home(){
		return "user-space/home";
	}
	
	//个人设置回显
	@RequestMapping({"/profile"})
	public String profile(HttpSession session,ModelMap map){
		User u = (User) session.getAttribute(Constant.LOGIN_USER);
		User user=userService.selectById(u.getId());
		if(user.getBirthday()!=null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			map.put("birth", sdf.format(user.getBirthday()));
		}
		map.put("user", user);
		return "user-space/profile";
	}
	
	// 个人设置  修改
	@RequestMapping("/user/save")
	public String save(User user,String birth,String sex) throws ParseException{
		Gender gender = Gender.valueOf(sex);
		user.setGender(gender);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		user.setBirthday(sdf.parse(birth));
		userService.updateByd(user);
		return "redirect:/my/profile";
	}
	
	
	
	
	//跳转到 头像
	@RequestMapping("/profile/avatar")
	public String avatar(){
		return "user-space/avatar";
	}
	
	@RequestMapping("/profile/upload")
	public String upload(MultipartFile file,HttpServletRequest request){
		User u = (User) request.getSession().getAttribute(Constant.LOGIN_USER);
		String upload = FileUploadUtil.upload(request, file);
		if(!upload.equals("")){
			u.setPicture(upload);
		}
		userService.upload(u);
		return "user-space/home";
	}
	
	
	// 我的文章
	@RequestMapping("/blogs")
	public String blogs(ModelMap map,HttpSession session,@RequestParam(required=false,defaultValue="1")Integer page){
		
		
		Article article = new Article();
		User user=(User) session.getAttribute(Constant.LOGIN_USER);
		article.setAuthor(user);
		PageHelper.startPage(page, 2);
		List<Article> list=articleService.queryAll(article);
		System.out.println(list);
		PageInfo<Article> pageInfo = new PageInfo<Article>(list, 3);
		String pageList = PageHelpUtil.page("blogs", pageInfo, null);
		map.put("blogs", list);
		map.put("pageList", pageList);
		return "/user-space/blog_list";
	}
	
	
	@RequestMapping("/blog/edit")
	public String edit(){
		return "/user-space/blog_edit_new";
	}
	
	
	
	@RequestMapping("/blog/save")
	public String save(Article article,ModelMap map,MultipartFile file,MultipartFile[] photos,String[] desc,HttpServletRequest request){
		
		ArrayList<Picture> picturesList = new ArrayList<Picture>();
		
		for (int i = 0; i < desc.length; i++) {
			Picture picture = new Picture();
			String upload = FileUploadUtil.upload(request,photos[i]);
			if(!upload.equals("")){
				picture.setPhoto(upload);
			}
			if(!desc.equals("")){
				picture.setContent(desc[i]);
			}
			picturesList.add(picture);
		}
		
		String upload = FileUploadUtil.upload(request,file);
		if(!upload.equals("")){
			article.setPicture(upload);
		}
		
		if(picturesList!=null){
			article.setContent(JSON.toJSONString(picturesList));
		}
		User user = (User) request.getSession().getAttribute(Constant.LOGIN_USER);
		article.setAuthor(user);
		articleService.blogSaveOrUpdate(article,request);
		
		return "/user-space/home";
	}
}
