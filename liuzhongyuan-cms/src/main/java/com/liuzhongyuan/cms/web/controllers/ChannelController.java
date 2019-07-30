package com.liuzhongyuan.cms.web.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liuzhongyuan.cms.domain.Category;
import com.liuzhongyuan.cms.domain.Channel;
import com.liuzhongyuan.cms.service.ChannelCategoryService;


@Controller
public class ChannelController {
	
	
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
