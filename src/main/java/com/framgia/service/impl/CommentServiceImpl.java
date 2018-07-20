package com.framgia.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.framgia.dao.CommentDAO;
import com.framgia.model.Comment;
import com.framgia.service.CommentService;

public class CommentServiceImpl implements CommentService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CommentServiceImpl.class);
	private CommentDAO commentDAO;

	public CommentDAO getCommentDAO() {
		return commentDAO;
	}

	public void setCommentDAO(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}

	@Override
	public Comment createComment(Comment comment) {
		try {
			LOGGER.info("Create comment successful");
			return getCommentDAO().saveOrUpdate(comment);
		} catch (Exception e) {
			LOGGER.error("Create comment fail");
			throw e;
		}
	}

	@Override
	public List<Comment> loadCommentByNewsId(Integer newsId) {
		try {
			LOGGER.info("Load successfull comment by" + newsId);
			return getCommentDAO().findCommentsByNewsId(newsId);
		} catch (Exception e) {
			LOGGER.error("Load fail comment! ", e);
			return null;
		}
	}

}
