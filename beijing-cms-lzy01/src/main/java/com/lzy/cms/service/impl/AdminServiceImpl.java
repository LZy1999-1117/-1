package com.lzy.cms.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzy.cms.dao.AdminMapper;
import com.lzy.cms.domain.Article;
import com.lzy.cms.domain.special;
import com.lzy.cms.service.AdminService;



@Service("adminservice")
public class AdminServiceImpl implements AdminService {
	
	
	@Autowired
	private AdminMapper adminMapper;

	@Override
	public List<special> specialAll() {
		// TODO Auto-generated method stub
		return adminMapper.specialAll();
	}

	@Override
	public List<Article> articleAll(Integer id) {
		// TODO Auto-generated method stub
		return adminMapper.articleAll(id);
	}

	@Override
	public int articleByd(HashMap<String, Object> maps) {
		// TODO Auto-generated method stub
		return adminMapper.articleByd(maps);
	}
}
