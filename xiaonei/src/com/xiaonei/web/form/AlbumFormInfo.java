package com.xiaonei.web.form;

import java.io.File;

public class AlbumFormInfo{
	
	//�������ơ������Լ���ʲô�˿���
	private String name;
	private String descript;
	private String people;
	private String virname;
	
	//�ϴ��Ķ�����Ƭ
	private File[] photo;
	private String[] photoFileName;
	private String[] photoContentType;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public String getPeople() {
		return people;
	}
	public void setPeople(String people) {
		this.people = people;
	}
	public File[] getPhoto() {
		return photo;
	}
	public void setPhoto(File[] photo) {
		this.photo = photo;
	}
	public String[] getPhotoFileName() {
		return photoFileName;
	}
	public void setPhotoFileName(String[] photoFileName) {
		this.photoFileName = photoFileName;
	}
	public String[] getPhotoContentType() {
		return photoContentType;
	}
	public void setPhotoContentType(String[] photoContentType) {
		this.photoContentType = photoContentType;
	}
	public String getVirname() {
		return virname;
	}
	public void setVirname(String virname) {
		this.virname = virname;
	}

		
}
