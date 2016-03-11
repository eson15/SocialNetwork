package com.xiaonei.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.xiaonei.dao.impl.DaoImpl;
import com.xiaonei.domain.Country;
@Component("testService")
public class TestService {
	
	private DaoImpl dao;
	
	public DaoImpl getDao() {
		return dao;
	}
	@Resource
	public void setDao(DaoImpl dao) {
		this.dao = dao;
	}

	//返回国家列表
	public List<Country> showCountry() {
		return dao.getCountry();
	}

}
