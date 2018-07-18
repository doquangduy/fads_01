package com.framgia.dao;

import java.util.List;

import com.framgia.model.News;
import com.framgia.search.Search;

public interface NewsDAO extends BaseDAO<News, Integer> {
	List<News> findNewsByCategoryId(Integer category_id, Integer status, Search<News> search);

	List<News> findNewsByUserId(Integer user_id);

}
