package com.framgia.service;

import java.util.List;

import com.framgia.model.City;

public interface CityService {

	List<City> findAll();

	City findByName(String name);

	City findbyId(Integer id);

}