/**
 * 
 */
package com.liuzhongyuan.cms.web.controllers;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

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

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuzhongyuan.cms.core.Page;
import com.liuzhongyuan.cms.domain.Article;
import com.liuzhongyuan.cms.domain.Category;
import com.liuzhongyuan.cms.domain.Channel;
import com.liuzhongyuan.cms.domain.User;
import com.liuzhongyuan.cms.service.ArticleService;
import com.liuzhongyuan.cms.utils.FileUploadUtil;
import com.liuzhongyuan.cms.utils.PageHelpUtil;
import com.liuzhongyuan.cms.web.Constant;

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
	
	@RequestMapping({"/", "/index", "/home"})
	public String home(){
		return "user-space/home";
	}
	
	@RequestMapping({"/profile"})
	public String profile(){
		return "user-space/profile";
	}

	
	
	// 我的文章
	@RequestMapping("/blogs")
	public String blogs(ModelMap map,HttpSession session){
		Article article = new Article();
		User user=(User) session.getAttribute(Constant.LOGIN_USER);
		article.setAuthor(user);
		List<Article> list=articleService.queryAll(article);
		map.put("blogs", list);
		return "/user-space/blog_list";
	}
}
