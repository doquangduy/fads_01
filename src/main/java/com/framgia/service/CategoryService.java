package com.framgia.service;

import java.util.List;

import com.framgia.model.Category;

public interface CategoryService {
	List<Category> findAll();

	Category findbyId(Integer id);
}