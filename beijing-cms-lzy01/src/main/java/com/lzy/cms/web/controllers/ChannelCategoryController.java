package com.lzy.cms.web.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lzy.cms.domain.Category;
import com.lzy.cms.domain.Channel;
import com.lzy.cms.service.ChannelCategoryService;

@Controller
public class ChannelCategoryController {
	
	
	@Resource
	private ChannelCategoryService channelCategoryService;
	
	@RequestMapping("/queryAllChannel")
	@ResponseBody
	public List<Channel> queryAllChannel(){
		List<Channel> channels = channelCategoryService.getChannels();
		System.out.println(channels);
		return  channels;
	}
	
	
	@RequestMapping("/queryCategoryByChannelId")
	@ResponseBody
	public List<Category> queryCategoryByChannelId(Integer channel){
		return channelCategoryService.getCategories(channel);
	}
}
