package com.lzy.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzy.cms.dao.CommentMapper;
import com.lzy.cms.domain.Comment;
import com.lzy.cms.domain.User;
import com.lzy.cms.service.CommentService;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentMapper commentMapper;

	@Override
	public void save(Comment comment) {
		commentMapper.save(comment);
	}

	@Override
	public List<Comment> SelectKeyComment(Integer id) {
		// TODO Auto-generated method stub
		return commentMapper.SelectKeyComment(id);
	}

	@Override
	public List<Comment> commentsUser(Integer id) {
		// TODO Auto-generated method stub
		System.out.println(id+"-----");
		return commentMapper.commentsUser(id);
	}
}
