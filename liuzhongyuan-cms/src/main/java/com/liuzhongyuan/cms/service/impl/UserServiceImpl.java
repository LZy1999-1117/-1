/**
 * 
 */
package com.liuzhongyuan.cms.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liuzhongyuan.cms.dao.UserMapper;
import com.liuzhongyuan.cms.domain.User;
import com.liuzhongyuan.cms.service.UserService;

/**
 * 说明:用户服务
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2019年3月27日 下午1:10:12
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	protected UserMapper userMapper;
	
	/* (non-Javadoc)
	 * @see com.bawei.cms.service.impl.UserService#get(int)
	 */
	@Override
	public User get(int id){
		return userMapper.selectById(id);
	}
	
	/* (non-Javadoc)
	 * @see com.bawei.cms.service.impl.UserService#get(java.lang.String)
	 */
	@Override
	public User get(String username){
		return userMapper.selectByUsername(username);
	}

	@Override
	public int count(User conditions) {
		return userMapper.count(conditions);
	}

	@Override
	public void upload(User u) {
		// TODO Auto-generated method stub
		userMapper.upload(u);
	}

	@Override
	public User selectById(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.selectById(id);
	}

	@Override
	public void updateByd(User user) {
		// TODO Auto-generated method stub
		userMapper.updateByd(user);
	}

	
}
