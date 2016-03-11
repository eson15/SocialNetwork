package com.xiaonei.web.action;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xiaonei.domain.Album;
import com.xiaonei.domain.Photo;
import com.xiaonei.domain.Users;
import com.xiaonei.service.AlbumServiceInter;
import com.xiaonei.web.form.AlbumFormInfo;


public class AlbumAction extends ActionSupport implements RequestAware, SessionAware, ModelDriven<AlbumFormInfo> {
	
	private String albumid;
	private Map<String, Object> request;
	private Map<String, Object> session;
	private AlbumServiceInter albumService;
	private AlbumFormInfo albumInfo = new AlbumFormInfo();//ʹ��ModelDrivenһ��Ҫ��new��һ����������form����
	
	//��ת�����ҳ��
	public String goAlbumUI() {
		//��һЩ��ʼ�����Ĺ�������ʾ�������
		Users user = (Users) session.get("user");
		List<Album> list = albumService.findAll("from Album a where a.users.id=?", new Object[]{user.getId()});
		request.put("albumNum", list.size());
		request.put("albumList", list);
		return SUCCESS;
	}
	//��ת��������������ҳ��
	public String addAlbumUI() {
		return SUCCESS;
	}
	
	//������ᣬ����ת������������Ƭҳ��
	public String addAlbum() {
		
		Album album = new Album();
		
		album.setName(albumInfo.getName());
		album.setVirname(albumInfo.getVirname());
		album.setUsers((Users)session.get("user"));
		album.setDescript(albumInfo.getDescript());
		album.setPeople(albumInfo.getPeople());
		album.setCreTime(new java.util.Date());
		album.setUpdTime(new java.util.Date());		
		
		//�ж�����Ƿ�������
		Album newalbum = albumService.check(album);
		if(newalbum == null) {
			albumService.save(album);
			session.put("album", album);
			return SUCCESS;
		}
		else {//�Ѿ��и����������
			request.put("message", "error");//������/public/index.jsp�л�������
//			request.put("album", newalbum);
			return "fail";
		}
		
	}

	//�����ӵ�ͼƬ�������ͼƬҳ��
	public String addPhoto() {
		
		//���ļ��ϴ�
		Users user = (Users) session.get("user");//�õ���ǰ�û�����session��ȡ��
		Album album = (Album) session.get("album");//�õ���ǰ��Album
		Set<Photo> photos = new HashSet<Photo>(); //�����洢һ����������������Ƭ
		
		//����ύ����Ƭ����
		File[] photo = albumInfo.getPhoto();
		String[] photoName = albumInfo.getPhotoFileName();

		if(photo != null) {
			
			//�ڷ�������Ŀ¼�´���images�ļ��У�realpath = E:\web\apache-tomcat-8.0.26\webapps\xiaonei\images
			String realpath = ServletActionContext.getServletContext().getRealPath("/images");	
			System.out.println(realpath);
			//�ٴ����洢ͼ���Ŀ¼�����Ŀ¼���������ģ�������ʾͼƬ��ʱ����������
			/*�ұ����Ǹ����û��������������������ģ������޷������������ƣ�
			 * realpath = realpath + "\\" + user.getId() + "\\album\\" + album.getName();
			 * �������ڴ�������ҳ�������˸��ֶΣ��ø��ֶ�������·��
			 * 
			 * Ҳ����ֱ��������id��������
			 */
			realpath = realpath + "\\" + user.getId() + "\\album\\" + album.getVirname();
			System.out.println(realpath);
			for(int i = 0; i < photo.length; i++){
									
				//�ڸ�Ŀ¼�´����ϴ��ļ����ļ�����
				File destFile = new File(realpath, photoName[i]);
				System.out.println(destFile);
				//����ϴ��ļ����ڵ��ļ��в����ڣ��򴴽�
				if(!destFile.getParentFile().exists()) {
					destFile.getParentFile().mkdir();
				}
				try {
					FileUtils.copyFile(photo[i], destFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				Photo photo1 = new Photo();
				photo1.setAlbum(album);
				photo1.setPhoto(photoName[i]);//����photo��
				photo1.setAddTime(new java.util.Date());
				albumService.save(photo1);//����Ƭ���浽���ݿ�
				
				photos.add(photo1);//������Ƭ�ӵ�set��
				
			}
			album.setUpdTime(new java.util.Date());//����һ�������Ϣ
			album.setPhoto(photoName[0]);//Ĭ�Ͻ���һ����Ƭ��Ϊ������						
			album.setPhotos(photos);
			albumService.update(album);//����һ��album
			return SUCCESS;
		}
		else{
			request.put("message", "nophoto");
			return "fail";
		}
		
	}

	public String goOneAlbum() {
		System.out.println(albumid);
		Album album = (Album) albumService.findById(Album.class, Integer.parseInt(albumid));
		session.put("album", album);
		return SUCCESS;
	}
	
	public String getAlbumid() {
		return albumid;
	}
	public void setAlbumid(String albumid) {
		this.albumid = albumid;
	}
	public AlbumServiceInter getAlbumService() {
		return albumService;
	}
	@Resource
	public void setAlbumService(AlbumServiceInter albumService) {
		this.albumService = albumService;
	}
	@Override
	public AlbumFormInfo getModel() {
		// TODO Auto-generated method stub
		return albumInfo;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
}
