package com.xiaonei.service;

import com.xiaonei.base.service.BaseServiceInter;
import com.xiaonei.domain.Users;

public interface UserServiceInter extends BaseServiceInter {
	
	//��֤�û��Ƿ���ڣ�����һ��Users�����������null��ʾ�û�������
	public Users check(Users user);

}
