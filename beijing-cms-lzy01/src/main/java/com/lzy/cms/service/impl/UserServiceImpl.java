/**
 * 
 */
package com.lzy.cms.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lzy.cms.dao.UserMapper;
import com.lzy.cms.domain.User;
import com.lzy.cms.service.UserService;

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
	public void updateByd(User user) {
		// TODO Auto-generated method stub
		userMapper.updateByd(user);
	}

/*	@Override
	public User selectUserKey(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.selectUserKey(id);
	}*/

	@Override
	public User selectById(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.selectById(id);
	}

	
}
