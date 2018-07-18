package com.framgia.dao.impl;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang.StringUtils;

import com.framgia.dao.NewsDAO;
import com.framgia.model.News;
import com.framgia.model.User;
import com.framgia.search.Search;

public class NewsDAOImpl extends GenericDAOAbstract<News, Integer> implements NewsDAO {

	@Override
	public List<News> findNewsByCategoryId(Integer category_id, Integer status, Search<News> search) {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<News> cr = builder.createQuery(News.class);
		Root<News> root = cr.from(News.class);
		Predicate predicateCategoryIdAndStatus = builder.and(builder.equal(root.get("category").get("id"), category_id),
				builder.equal(root.get("status"), status));
		Predicate predicateTittleAndCity = builder.and(
				builder.like(builder.lower(root.get("tittle")), "%" + search.getFieldsSearch().getTittle() + "%"),
				builder.equal(root.get("city").get("id"), search.getFieldsSearch().getCity().getId()));
		Predicate predicateAll = builder.and(predicateCategoryIdAndStatus, predicateTittleAndCity);
		if (category_id != null) {
			if (StringUtils.isNotBlank(search.getFieldsSearch().getTittle())
					&& StringUtils.isNotBlank(search.getFieldsSearch().getCity().getName())) {
				cr.where(predicateAll);
			} else {
				cr.where(predicateCategoryIdAndStatus);
			}
		}
		cr.orderBy(builder.desc(root.get("startDate")));
		return (List<News>) getSession().createQuery(cr.select(root)).getResultList();
	}

	@Override
	public List<News> findNewsByUserId(Integer user_id) {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<News> criteriaQuery = builder.createQuery(News.class);
		Root<News> root = criteriaQuery.from(News.class);
		Join<News, User> join_user = root.join("user");
		if (user_id != null) {
			criteriaQuery.where(builder.equal(join_user.get("id"), user_id));
		}
		return getSession().createQuery(criteriaQuery.select(root)).getResultList();
	}
}