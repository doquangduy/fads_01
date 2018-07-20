package com.framgia.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.framgia.dao.CityDAO;
import com.framgia.model.City;
import com.framgia.service.CityService;

public class CityServiceImpl implements CityService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CityServiceImpl.class);
	private CityDAO cityDAO;

	public CityDAO getCityDAO() {
		return cityDAO;
	}

	public void setCityDAO(CityDAO cityDAO) {
		this.cityDAO = cityDAO;
	}

	@Override
	public List<City> findAll() {
		try {
			LOGGER.info("List news by category");
			return getCityDAO().findAll();
		} catch (Exception e) {
			LOGGER.error("load city all fail", e);
			return null;
		}
	}

	@Override
	public City findByName(String name) {
		try {
			LOGGER.info("Find by new by name");
			return getCityDAO().findBy("name", name);
		} catch (Exception e) {
			LOGGER.error("Not find city name!!!", e);
			return null;
		}
	}

}
