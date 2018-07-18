package com.framgia.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class GenericDAOAbstract<T, PK extends Serializable> {
	private Class<T> typeClass;

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Class<T> getTypeClass() {
		return typeClass;
	}

	public GenericDAOAbstract(Class<T> typeClass) {
		this.typeClass = typeClass;
	}

	@SuppressWarnings("unchecked")
	public GenericDAOAbstract() {
		this.typeClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public List<T> findAll() {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<T> cr = builder.createQuery(typeClass);
		Root<T> root = cr.from(typeClass);
		return (List<T>) getSession().createQuery(cr.select(root)).list();
	}

	public T findBy(String atribute, Serializable key) {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<T> cr = builder.createQuery(typeClass);
		Root<T> root = cr.from(typeClass);
		cr.where(builder.equal(root.get(atribute), key));
		return getSession().createQuery(cr.select(root)).getSingleResult();
	}

	public T saveOrUpdate(T entity) {
		getSession().saveOrUpdate(entity);
		return entity;
	}

	public void delete(T entity) {
		getSession().delete(entity);
	}
}