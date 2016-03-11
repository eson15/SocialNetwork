package com.xiaonei.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.xiaonei.base.service.BaseServiceImpl;
import com.xiaonei.domain.Users;
import com.xiaonei.service.UserServiceInter;

@Component("userService")
public class UserServiceImpl extends BaseServiceImpl implements
		UserServiceInter {

	@Override
	public Users check(Users user) {
		// TODO Auto-generated method stub
		List list = findAll("from Users u where u.email=? and u.pwd=?", new Object[]{user.getEmail(), user.getPwd()});
		if(list.size() == 1) {
			return (Users) list.get(0);
		}
		return null;
	}

}
