package com.framgia.dao;

import java.util.List;

import com.framgia.model.NewsImage;

public interface NewsImageDAO extends BaseDAO<NewsImage, Integer> {
	List<NewsImage> findbyNewsId(Integer id);
}
