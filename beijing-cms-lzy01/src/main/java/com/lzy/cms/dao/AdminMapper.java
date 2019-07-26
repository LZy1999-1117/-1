package com.lzy.cms.dao;

import java.util.HashMap;
import java.util.List;

import com.lzy.cms.domain.Article;
import com.lzy.cms.domain.special;

public interface AdminMapper {

	List<special> specialAll();

	List<Article> articleAll(Integer id);

	int articleByd(HashMap<String, Object> maps);

}
