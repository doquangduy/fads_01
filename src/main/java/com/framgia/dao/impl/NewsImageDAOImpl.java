package com.framgia.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import com.framgia.dao.NewsImageDAO;
import com.framgia.model.News;
import com.framgia.model.NewsImage;

public class NewsImageDAOImpl extends GenericDAOAbstract<NewsImage, Integer> implements NewsImageDAO {

	@Override
	public List<NewsImage> findbyNewsId(Integer id) {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<NewsImage> criteriaQuery = builder.createQuery(NewsImage.class);
		Root<NewsImage> root = criteriaQuery.from(NewsImage.class);
		Join<NewsImage, News> join = root.join("news");
		if (id != null) {
			criteriaQuery.where(builder.equal(join.get("id"), id));
		}
		return getSession().createQuery(criteriaQuery.select(root)).getResultList();
	}

}