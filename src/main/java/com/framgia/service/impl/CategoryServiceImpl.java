package com.framgia.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.framgia.dao.CategoryDAO;
import com.framgia.model.Category;
import com.framgia.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImpl.class);
	private CategoryDAO categoryDAO;

	@Override
	public List<Category> findAll() {
		try {
			return getCategoryDAO().findAll();
		} catch (Exception e) {
			LOGGER.info("find all category fail !", e);
			return null;
		}
	}

	public CategoryDAO getCategoryDAO() {
		return categoryDAO;
	}

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}
}
