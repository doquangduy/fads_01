package com.framgia.service;

import java.util.List;

import com.framgia.model.News;
import com.framgia.model.NewsImage;

import com.framgia.model.User;

import com.framgia.search.Search;

public interface NewsService {

	List<News> findNewsByCategoryId(Integer category_id, Integer status, Search<News> searchNew);

	List<News> findNewsPost(User user);

	News findById(Integer id);

	News saveOrUpdate(News news, List<NewsImage> news_images);

	List<News> loadAll();

	List<NewsImage> findImageByIdNews(Integer id);
	
	Boolean removeMyNews(Integer id);

}
