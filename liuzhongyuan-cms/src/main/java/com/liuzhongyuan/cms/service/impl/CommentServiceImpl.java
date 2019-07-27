package com.liuzhongyuan.cms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liuzhongyuan.cms.dao.CommentMapper;
import com.liuzhongyuan.cms.domain.Comment;
import com.liuzhongyuan.cms.service.CommentService;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentMapper commentMapper;

	@Override
	public void save(Comment comment) {
		commentMapper.save(comment);
	}
}
