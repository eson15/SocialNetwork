package com.xiaonei.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.xiaonei.base.service.BaseServiceImpl;
import com.xiaonei.domain.Album;
import com.xiaonei.domain.Users;
import com.xiaonei.service.AlbumServiceInter;

@Component("albumService")
public class AlbumServiceImpl extends BaseServiceImpl implements AlbumServiceInter {

	@Override
	public Album check(Album album) {
		// TODO Auto-generated method stub
		List list = findAll("from Album a where a.name=?", new Object[]{album.getName()});
		if(list.size() == 1) {
			return (Album) list.get(0);
		}
		return null;
	}
	
}
