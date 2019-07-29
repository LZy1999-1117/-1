/**
 * 
 */
package com.lzy.cms.web.controllers;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
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
import com.lzy.cms.domain.Comment;
import com.lzy.cms.domain.User;
import com.lzy.cms.metas.Gender;
import com.lzy.cms.service.ArticleService;
import com.lzy.cms.service.CommentService;
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
	
	@Resource(name="userService")
	UserService userService;
	
	
	
	@Autowired
	CommentService commentService;
	
	//跳到 CMS 主页面
	@RequestMapping({"/", "/index", "/home"})
	public String home(){
		return "user-space/home";
	}
	
	
	//个人设置 进行回显
	@RequestMapping({"/profile"})
	public String profile(ModelMap map,HttpSession session){
		User u = (User) session.getAttribute(Constant.LOGIN_USER);
		User user=userService.selectById(u.getId());
		map.put("user", user);
		return "user-space/profile";
	}
	
	
	
	// 上传 头像
	@RequestMapping("/profile/avatar")
	public String avatar(){
		
		return "user-space/avatar";
		
	}
	
	
	// 进行上传  
	@RequestMapping("/profile/upload")
	public String upload(MultipartFile file,HttpServletRequest request,HttpSession session){
		System.out.println("1");
		System.out.println(file);
		String upload = FileUploadUtil.upload(request, file);
		System.out.println(upload);
		User u = (User) session.getAttribute(Constant.LOGIN_USER);
		System.out.println(u);
		if(!upload.equals("")){
			u.setPicture(upload);
		}
		System.out.println(u);
		int flag=userService.upload(u);
		return "user-space/home";
		
	}
	
	
	// 我的文章 查询       
	@RequestMapping("blogs")
	public String blogs(HttpSession session,Model model,@RequestParam(required=false,defaultValue="1")Integer page){
		
		// 设置文章的实例对象
		Article article = new Article();
		
		// 获取作用域的user 对象
		User user = (User) session.getAttribute(Constant.LOGIN_USER);
		//把 登陆的对象 存到   文章的  对象的字段里
		article.setAuthor(user);
		System.out.println(user);
		
		
		//进行 分页   传当前页 和   每页几条数据
		PageHelper.startPage(page, 3);
		
		
		// 进行 文章 查询   动态sql  
		List<Article> articles=articleService.queryAll(article);
		System.out.println(articles);
		
		//  调用 pageInfo  
		PageInfo<Article> pageInfo = new PageInfo<Article>(articles,3);
		// 然后 调用 pageHelperUtil  工具类
		String pageList = PageHelpUtil.page("blogs", pageInfo, null);
		
		model.addAttribute("blogs", articles);
		model.addAttribute("pageList", pageList);
		
		return "user-space/blog_list";
	}
	
	
	
	// 进行  文章编辑回显
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
	
	
	
	// 在我的文章页面 进行删除  方法
	@RequestMapping("/blog/remove")
	@ResponseBody
	public Object remove(Integer id){
		Integer deleteInteger=articleService.remove(id);
		return deleteInteger;
	}
	
	
	
	
	//  修改个人设置
	@RequestMapping("/user/save")
	public String Usersave(User user,ModelMap map,String sex){
		Gender gender=Gender.valueOf(sex);
		user.setGender(gender);
		userService.updateByd(user);
		return "redirect:/my/profile";
	}
	

	
	//  我的评论
	@RequestMapping("/comments")
	public String commentsUser(ModelMap map,HttpSession session,@RequestParam(required=false,defaultValue="1")Integer page){
		User u = (User) session.getAttribute(Constant.LOGIN_USER);
		System.out.println(u.getId()+"k");
		Integer id = u.getId();
		PageHelper.startPage(page, 3);
		List<Comment> list=userService.commentsUser(id);
		PageInfo<Comment> pageInfo = new PageInfo<Comment>(list, 3);
		String pageList = PageHelpUtil.page("comments", pageInfo, null);
		for (Comment comment : list) {
			System.out.println(comment);
		}
		map.put("comments", list);
		map.put("pageList", pageList);
		return "/user-space/comments";
	}
}
