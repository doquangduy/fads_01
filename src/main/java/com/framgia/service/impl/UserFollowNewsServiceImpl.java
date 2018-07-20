package com.framgia.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.framgia.dao.UserFollowNewsDAO;
import com.framgia.model.UserFollowNews;
import com.framgia.service.UserFollowNewsService;

public class UserFollowNewsServiceImpl implements UserFollowNewsService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserFollowNewsServiceImpl.class);
	private UserFollowNewsDAO userFollowNewsDAO;

	public UserFollowNewsDAO getUserFollowNewsDAO() {
		return userFollowNewsDAO;
	}

	public void setUserFollowNewsDAO(UserFollowNewsDAO userFollowNewsDAO) {
		this.userFollowNewsDAO = userFollowNewsDAO;
	}

	@Override
	public UserFollowNews createFollow(UserFollowNews userFollowNews) {
		try {
			LOGGER.info("Followed news!!!");
			return getUserFollowNewsDAO().saveOrUpdate(userFollowNews);
		} catch (Exception e) {
			LOGGER.error("Can't follow this news", e);
			throw e;
		}
	}

	@Override
	public List<UserFollowNews> loadAll() {
		try {
			LOGGER.info("Load userfollow news successfull!!!");
			return getUserFollowNewsDAO().findAll();
		} catch (Exception e) {
			LOGGER.error("load userfollow news fail", e);
			return null;
		}
	}

	@Override
	public UserFollowNews loadByUserIdAndNewsId(Integer userId, Integer newsId) {
		try {
			LOGGER.info("load successful userfollownews by userId and newsIdl!!!");
			return getUserFollowNewsDAO().findByUserIdAndNewsId(userId, newsId);
		} catch (Exception e) {
			LOGGER.error("load fail userfollownews by userId and newsId", e);
			return null;
		}
	}

	@Override
	public void removeUserFollowNews(UserFollowNews userFollowNews) {
		try {
			LOGGER.info("Remove successful userfollownews!!!");
			getUserFollowNewsDAO().delete(userFollowNews);
		} catch (Exception e) {
			LOGGER.error("Remove fail userfollownews!!!", e);
			throw e;
		}
	}

	@Override
	public List<Integer> loadQuantityUserFollowNews() {
		try {
			LOGGER.info("load successful quantity UserFollowNews!!!");
			return getUserFollowNewsDAO().findQuantityUserFollowNews();
		} catch (Exception e) {
			LOGGER.error("load fail quantity UserFollowNews!!!", e);
			return null;
		}
	}

	public List<Integer> loadFavoriteNewses(Integer userId) {
		try {
			LOGGER.info("load successful FavoriteNewses!!!");
			return getUserFollowNewsDAO().findAllByUserId(userId);
		} catch (Exception e) {
			LOGGER.error("load fail FavoriteNewses!!!", e);
			return null;
		}
	}

}
