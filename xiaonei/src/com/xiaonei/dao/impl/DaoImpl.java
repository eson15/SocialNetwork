package com.xiaonei.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.xiaonei.domain.Country;

@Component("dao")
public class DaoImpl {
	
	private HibernateTemplate hibernateTemplate;
	
	public List<Country> getCountry() {
		return (List<Country>) hibernateTemplate.find("from Country c");
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
