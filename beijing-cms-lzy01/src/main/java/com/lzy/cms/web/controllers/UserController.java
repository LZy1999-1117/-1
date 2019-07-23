/**
 * 
 */
package com.lzy.cms.web.controllers;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lzy.cms.utils.FileUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzy.cms.core.Page;
import com.lzy.cms.domain.Article;
import com.lzy.cms.domain.Category;
import com.lzy.cms.domain.Channel;
import com.lzy.cms.domain.User;
import com.lzy.cms.service.ArticleService;
import com.lzy.cms.service.UserService;
import com.lzy.cms.utils.FileUploadUtil;
import com.lzy.cms.utils.PageHelpUtil;
import com.lzy.cms.web.Constant;

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
	
	@Autowired
	UserService userService;
	
	@RequestMapping({"/", "/index", "/home"})
	public String home(){
		return "user-space/home";
	}
	
	@RequestMapping({"/profile"})
	public String profile(ModelMap map,HttpSession session){
		User u = (User) session.getAttribute(Constant.LOGIN_USER);
		User user=userService.selectById(u.getId());
		map.put("user", user);
		return "user-space/profile";
	}
	
	
	
	
	@RequestMapping("blogs")
	public String blogs(HttpSession session,Model model,@RequestParam(required=false,defaultValue="1")Integer page){
		Article article = new Article();
		
		User user = (User) session.getAttribute(Constant.LOGIN_USER);
		article.setAuthor(user);
		System.out.println(user);
		PageHelper.startPage(page, 3);
		
		List<Article> articles=articleService.queryAll(article);
		System.out.println(articles);
		
		PageInfo<Article> pageInfo = new PageInfo<Article>(articles,3);
		String pageList = PageHelpUtil.page("blogs", pageInfo, null);
		
		model.addAttribute("blogs", articles);
		model.addAttribute("pageList", pageList);
		
		return "user-space/blog_list";
	}
	
	
	@RequestMapping("/blog/edit")
	public String edit(Integer id,ModelMap map){
		Article article = articleService.selectByPrimaryKey(id);
		map.put("blog", article);
		return "user-space/blog_edit";
		
	}
	
	
	@RequestMapping("/blog/save")
	public String save(Article article,MultipartFile file,HttpServletRequest request,HttpSession session){
		
		// 使用上传工具类    并且存到  文章 article 对象中  picture
		String upload = FileUploadUtil.upload(request, file);
		if(!upload.equals("")){
			article.setPicture(upload);
		}
			
		
		if(article.getId()!=null){
			//编辑方法
			articleService.updateByKey(article);
		}else{
			//发布方法  设置 article 对象中没有的变量值
			
			//点击量 第一次
			article.setHits(0);
			/**是否热门（是否上头条）**/
			article.setHot(true);
			/**状态：0:审核不通过，1:审核通过**/
			article.setStatus(1);
			/**是否删除：true-删除，false-不删除**/
			article.setDeleted(false);
			/**创建时间**/
			article.setCreated(new Date());
			// 设置文章的作者
			User user = (User) session.getAttribute(Constant.LOGIN_USER);
			article.setAuthor(user);
			articleService.save(article);
		
		}
		
		return "redirect:/my/blogs";	
	}
	
/*	@RequestMapping("/lookImg.do")
	public void lookImg(HttpServletRequest request,HttpServletResponse response){
		FileUtils.lookImg("c74ec2dfa67647a3b2db2141c831d5c720190625094007.jpg", request, response);
		
	}*/
	
	/*@RequestMapping("/profile/avatar")
	public String */
	
	
	@RequestMapping("/blog/remove")
	@ResponseBody
	public Object remove(Integer id){
		Integer deleteInteger=articleService.remove(id);
		return deleteInteger;
	}
	
	
	
	@RequestMapping("/user/save")
	public String Usersave(User user,ModelMap map){
		userService.updateByd(user);
		return "redirect:/my/profile";
	}
}
