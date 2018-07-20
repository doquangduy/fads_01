package com.framgia.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.framgia.dao.NewsDAO;
import com.framgia.dao.NewsImageDAO;
import com.framgia.model.News;
import com.framgia.model.NewsImage;
import com.framgia.model.User;
import com.framgia.search.Search;
import com.framgia.service.NewsService;

public class NewsServiceImpl implements NewsService {
	private static final Logger LOGGER = LoggerFactory.getLogger(NewsServiceImpl.class);
	private NewsDAO newsDAO;
	private NewsImageDAO newsImgDAO;

	public NewsDAO getNewsDAO() {
		return newsDAO;
	}

	public NewsImageDAO getNewsImgDAO() {
		return newsImgDAO;
	}

	public void setNewsImgDAO(NewsImageDAO newsImgDAO) {
		this.newsImgDAO = newsImgDAO;
	}

	public void setNewsDAO(NewsDAO newsDAO) {
		this.newsDAO = newsDAO;
	}

	@Override
	public List<News> findNewsByCategoryId(Integer category_id, Integer status, Search<News> searchNew) {
		try {
			LOGGER.info("List news by category");
			return getNewsDAO().findNewsByCategoryId(category_id, status, searchNew);
		} catch (Exception e) {
			LOGGER.error("Not find list news by categoryIdl", e);
			return null;
		}
	}

	@Override
	public News findById(Integer id) {
		try {
			LOGGER.info("Find by new id");
			return getNewsDAO().findBy("id", id);
		} catch (Exception e) {
			LOGGER.error("Not find news!!", e);
			return null;
		}
	}

	@Override
	public News saveOrUpdate(News news, List<NewsImage> news_images) {
		try {
			if (news.getCreateDate() == null) {
				news.setCreateDate(new Date());
			}
			news = newsDAO.saveOrUpdate(news);
			if (news != null) {
				for (NewsImage news_img : news_images) {
					if (news_img == null || StringUtils.isEmpty(news_img.getName()))
						break;
					news_img.setNews(news);
					newsImgDAO.saveOrUpdate(news_img);
				}
				LOGGER.info("Save News successful");
				return news;
			} else
				LOGGER.error("Cann't create News object");
			return null;
		} catch (Exception e) {
			LOGGER.error("Oop error has exception", e);
			throw e;
		}
	}

	public List<News> loadAll() {
		try {
			LOGGER.info("Find all news");
			return getNewsDAO().findAll();
		} catch (Exception e) {
			LOGGER.error("load news all fail", e);
			return null;
		}
	}

	@Override
	public List<News> findNewsPost(User user) {
		try {
			List<News> news_list = newsDAO.findNewsByUserId(user.getId());
			return news_list;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<NewsImage>  findImageByIdNews(Integer id) {
		try {

			return newsImgDAO.findbyNewsId(id);
		} catch (Exception e) {
			return null;
		}
	}
}
