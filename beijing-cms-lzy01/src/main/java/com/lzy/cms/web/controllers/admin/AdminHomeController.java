/**
 * 
 */
package com.lzy.cms.web.controllers.admin;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lzy.cms.domain.Article;
import com.lzy.cms.domain.special;
import com.lzy.cms.service.AdminService;
import com.lzy.cms.web.controllers.PassportController;

/**
 * 说明:
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2019年3月29日 下午6:54:11
 */
@Controller
@RequestMapping("/admin")
public class AdminHomeController {

	public static Logger log = LoggerFactory.getLogger(PassportController.class);
	
	@Autowired(required=true)
	private AdminService adminservice;
	
	
	@RequestMapping({"/", "/index"})
	public String home(){
		return "admin/home";
	}
	
	
	@RequestMapping("/categories")
	public  String categories(){
	
		return "/admin/article";
	}
	
	
	
	@RequestMapping("/articleAll")
	public String articleAll(ModelMap map,Integer id){
		List<Article> list=adminservice.articleAll(id);
		map.put("list", list);
		map.put("sid", id);
		return "/admin/articles";
	}
	
	@RequestMapping("/specialAll")
	public String specialAll(ModelMap map){
		List<special> list=adminservice.specialAll();
		map.put("list", list);
		return "/admin/special";
	}
	
	
	@RequestMapping("/articleByd")
	@ResponseBody
	public Object articleByd(Integer sid,Integer aid){
		HashMap<String, Object> maps = new HashMap<String,Object>();
		maps.put("sid", sid);
		maps.put("aid", aid);
		int flag=adminservice.articleByd(maps);
		return flag;
	}
}
