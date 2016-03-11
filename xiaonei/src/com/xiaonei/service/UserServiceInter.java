package com.xiaonei.service;

import com.xiaonei.base.service.BaseServiceInter;
import com.xiaonei.domain.Users;

public interface UserServiceInter extends BaseServiceInter {
	
	//验证用户是否存在，返回一个Users对象，如果返回null表示用户不存在
	public Users check(Users user);

}
