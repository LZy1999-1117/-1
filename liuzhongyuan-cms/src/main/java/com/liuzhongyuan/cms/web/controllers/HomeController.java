/**
 * 
 */
package com.liuzhongyuan.cms.web.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.liuzhongyuan.cms.core.Page;
import com.liuzhongyuan.cms.domain.Article;
import com.liuzhongyuan.cms.domain.Category;
import com.liuzhongyuan.cms.domain.Channel;
import com.liuzhongyuan.cms.domain.Picture;
import com.liuzhongyuan.cms.domain.Slide;
import com.liuzhongyuan.cms.service.ArticleService;
import com.liuzhongyuan.cms.service.SlideService;

/**
 * 说明:首页
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2018年1月10日 下午8:19:15
 */
@Controller
public class HomeController {

	@Resource
	private ArticleService articleService;
	
	@Resource
	private SlideService slideService;
	
	@RequestMapping({"/", "/index", "/home"})
	public String home(
			@RequestParam(required = false) Integer channel, //频道
			@RequestParam(required = false) Integer category,//分类
			@RequestParam(defaultValue = "1") Integer page,//分类
			Model model){
		
		long start = System.currentTimeMillis();
		
		//------------------------------------
		Page _page = new Page(page, 30);
		List<Article> articles = null;
		
		//拼条件
		Article conditions = new Article();
		conditions.setDeleted(false);
		conditions.setStatus(1);

		
		Thread t1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				//默认首页显示热门文章
				if(category == null && channel == null){
					conditions.setHot(true);
					
					//热门文章时显示幻灯片
					List<Slide> slides = slideService.getTops(5);
					model.addAttribute("slides", slides);
				}
				
			}
		});
		
		
		Thread t2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				//如果频道或分类不为空，则显示分类或频道数据
				List<Article> articles = null;
				if(category != null){
					conditions.setCategory(new Category(category));
				}else if(channel != null){
					conditions.setChannel(new Channel(channel));
				}
				
				articles = articleService.gets(conditions, _page, null);
				model.addAttribute("articles", articles);
			}
		});
		
		
		Thread t3=new Thread(new Runnable() {
			
			@Override
			public void run() {
				//---------------右侧放10条最新文章---------------------
				Article lastArticlesConditions = new Article();
				lastArticlesConditions.setDeleted(false);
				lastArticlesConditions.setStatus(1);
				
				Page lastArticlesPage = new Page(1, 10);
				lastArticlesPage.setTotalCount(100);//设置了总记录数，可以节省统计查询，提高性能。
				
				List<Article> lastArticles = articleService.gets(lastArticlesConditions, lastArticlesPage, null);
				model.addAttribute("lastArticles", lastArticles);
			}
		});

		Thread t4=new Thread(new Runnable() {
			
			@Override
			public void run() {
				if(channel != null){
					model.addAttribute("channel", new Channel(channel));
				}
				model.addAttribute("category", category);
			}
		});
		
		
		Thread t5=new Thread(new Runnable() {
			
			@Override
			public void run() {
				Article lastArticlesConditions = new Article();
				lastArticlesConditions.setDeleted(false);
				lastArticlesConditions.setStatus(1);
				lastArticlesConditions.setType(1);
				Page lastArticlesPage = new Page(1, 5);
				lastArticlesPage.setTotalCount(50);//设置了总记录数，可以节省统计查询，提高性能。
				
				List<Article> lastArticles = articleService.gets(lastArticlesConditions, lastArticlesPage, null);
				model.addAttribute("lastArticlespic", lastArticles);
			}
		});
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		/*try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}*/
		
		while(true){
			if(t1.isAlive()==false && t2.isAlive()==false && t3.isAlive()==false && t4.isAlive()==false && t5.isAlive()==false){
				break;
			}
		}
		
		
		long end = System.currentTimeMillis();
		System.out.println("耗时:"+(end-start));
		return "home";
	}
	
	
	@RequestMapping("/article")
	public String blog(Integer id,ModelMap map,Model model){
		Article lastArticlesConditions = new Article();
		lastArticlesConditions.setDeleted(false);
		lastArticlesConditions.setStatus(1);
		lastArticlesConditions.setType(1);
		lastArticlesConditions.setHot(true);
		Page lastArticlesPage = new Page(1, 5);
		lastArticlesPage.setTotalCount(50);//设置了总记录数，可以节省统计查询，提高性能。
		
		List<Article> lastArticles = articleService.gets(lastArticlesConditions, lastArticlesPage, null);
		model.addAttribute("hitBlogs", lastArticles);
		//浏览量 ++
		articleService.increaseHit(id);
		// 根据 文章 主键ID 查询文章  返回值对象
		Article list=articleService.selectByPrimaryKey(id);
		if(list.getType()!=null && list.getType()==1){
			if(list.getContent()!=null && list.getContent().length()>0){
				List<Picture> parseArray = JSON.parseArray(list.getContent(),Picture.class);
				map.put("pictures", parseArray);
				map.put("flag", list.getType());
			}
			map.put("blog", list);
			return "blog";
		}else{
			map.put("blog", list);
			return "blog";
		}
		
		
		
		
	}
	
}
