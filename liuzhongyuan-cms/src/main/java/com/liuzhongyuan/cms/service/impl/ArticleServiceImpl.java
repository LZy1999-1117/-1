/**
 * 
 */
package com.liuzhongyuan.cms.service.impl;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.liuzhongyuan.cms.core.Page;
import com.liuzhongyuan.cms.dao.ArticleMapper;
import com.liuzhongyuan.cms.domain.Article;
import com.liuzhongyuan.cms.service.ArticleService;

/**
 * 说明:
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2019年4月21日 下午9:06:07
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

	@Resource
	ArticleMapper articleMapper;

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<Article> gets(Article conditions, Page page, LinkedHashMap<String, Boolean> orders) {
		List<Article> articles = articleMapper.selects(conditions, orders, page);
		if(page != null && page.getPageCount() == 0){
			int totalCount = articleMapper.count(conditions);
			page.setTotalCount(totalCount);
		}
		return articles;
	}

	@Override
	public Article selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return articleMapper.selectByPrimaryKey(id);
	}

	@Override
	public void increaseHit(Integer id) {
		// TODO Auto-generated method stub
		articleMapper.increaseHit(id);
	}

	@Override
	public List<Article> queryAll(Article article) {
		// TODO Auto-generated method stub
		return articleMapper.queryAll(article);
	}

	@Override
	public void blogSaveOrUpdate(Article article, HttpServletRequest request) {
		// TODO Auto-generated method stub
		if(article.getId()!=null){
			
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
			article.setType(1);
			articleMapper.save(article);
		}
	}
	
	
}
