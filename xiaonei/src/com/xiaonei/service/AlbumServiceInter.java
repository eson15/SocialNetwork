package com.xiaonei.service;

import com.xiaonei.base.service.BaseServiceInter;
import com.xiaonei.domain.Album;

public interface AlbumServiceInter extends BaseServiceInter {
	//��֤�����ֵ�����Ƿ��Ѿ����ڣ����Ƿ�����ᣬ���򷵻�null
	public Album check(Album album);
}
