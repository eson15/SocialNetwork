package com.xiaonei.web.action;

import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.xiaonei.domain.Country;
import com.xiaonei.service.impl.TestService;

public class TestAction extends ActionSupport {
	
	private TestService testService;
	private List<Country> list;
	private Country country;
	
	public String execute() {
		list = testService.showCountry();
		return SUCCESS;
	}
	public TestService getTestService() {
		return testService;
	}
	
	@Resource
	public void setTestService(TestService testService) {
		this.testService = testService;
	}
	public List<Country> getList() {
		return list;
	}
	public void setList(List<Country> list) {
		this.list = list;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
		
}
