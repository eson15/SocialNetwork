package com.xiaonei.service;

import com.xiaonei.base.service.BaseServiceInter;
import com.xiaonei.domain.Album;

public interface AlbumServiceInter extends BaseServiceInter {
	//验证该名字的相册是否已经存在，若是返回相册，否则返回null
	public Album check(Album album);
}
