package com.lzy.cms.service;

import java.util.List;

import com.lzy.cms.domain.Comment;
import com.lzy.cms.domain.User;


/**
 * 说明: 用户服务
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2019年3月27日 下午1:12:48
 */
public interface UserService {

	public abstract User get(int id);

	public abstract User get(String username);

	public int count(User user);

	public abstract void updateByd(User user);

//	public abstract User selectUserKey(Integer id);

	public abstract User selectById(Integer id);

	public abstract List<Comment> commentsUser(Integer id);

	public abstract int upload(User u);
}