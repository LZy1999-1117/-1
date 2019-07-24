package com.lzy.cms.service;

import java.util.List;

import com.lzy.cms.domain.Comment;
import com.lzy.cms.domain.User;

public interface CommentService {

	void save(Comment comment);

	List<Comment> SelectKeyComment(Integer id);

	List<Comment> commentsUser(Integer id);

}
