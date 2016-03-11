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
	private AlbumFormInfo albumInfo = new AlbumFormInfo();//使用ModelDriven一定要先new出一个对象来存form数据
	
	//跳转到相册页面
	public String goAlbumUI() {
		//做一些初始化相册的工作，显示所有相册
		Users user = (Users) session.get("user");
		List<Album> list = albumService.findAll("from Album a where a.users.id=?", new Object[]{user.getId()});
		request.put("albumNum", list.size());
		request.put("albumList", list);
		return SUCCESS;
	}
	//跳转到创建或添加相册页面
	public String addAlbumUI() {
		return SUCCESS;
	}
	
	//创建相册，并跳转到给相册添加照片页面
	public String addAlbum() {
		
		Album album = new Album();
		
		album.setName(albumInfo.getName());
		album.setVirname(albumInfo.getVirname());
		album.setUsers((Users)session.get("user"));
		album.setDescript(albumInfo.getDescript());
		album.setPeople(albumInfo.getPeople());
		album.setCreTime(new java.util.Date());
		album.setUpdTime(new java.util.Date());		
		
		//判断相册是否重名了
		Album newalbum = albumService.check(album);
		if(newalbum == null) {
			albumService.save(album);
			session.put("album", album);
			return SUCCESS;
		}
		else {//已经有该名的相册了
			request.put("message", "error");//用来在/public/index.jsp中回显数据
//			request.put("album", newalbum);
			return "fail";
		}
		
	}

	//点击添加的图片。进入该图片页面
	public String addPhoto() {
		
		//多文件上传
		Users user = (Users) session.get("user");//得到当前用户：从session中取出
		Album album = (Album) session.get("album");//得到当前的Album
		Set<Photo> photos = new HashSet<Photo>(); //用来存储一个相册里面的所有照片
		
		//获得提交的照片数据
		File[] photo = albumInfo.getPhoto();
		String[] photoName = albumInfo.getPhotoFileName();

		if(photo != null) {
			
			//在服务器根目录下创建images文件夹：realpath = E:\web\apache-tomcat-8.0.26\webapps\xiaonei\images
			String realpath = ServletActionContext.getServletContext().getRealPath("/images");	
			System.out.println(realpath);
			//再创建存储图像的目录，这个目录不能有中文，否则显示图片的时候会出现问题
			/*我本来是根据用户创建相册的名称来命名的，可是无法避免中文名称，
			 * realpath = realpath + "\\" + user.getId() + "\\album\\" + album.getName();
			 * 所以我在创建相册的页面隐藏了个字段，用该字段来创建路径
			 * 
			 * 也可以直接用相册的id创建！！
			 */
			realpath = realpath + "\\" + user.getId() + "\\album\\" + album.getVirname();
			System.out.println(realpath);
			for(int i = 0; i < photo.length; i++){
									
				//在该目录下创建上传文件的文件对象
				File destFile = new File(realpath, photoName[i]);
				System.out.println(destFile);
				//如果上传文件所在的文件夹不存在，则创建
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
				photo1.setPhoto(photoName[i]);//设置photo名
				photo1.setAddTime(new java.util.Date());
				albumService.save(photo1);//将照片保存到数据库
				
				photos.add(photo1);//将该照片加到set中
				
			}
			album.setUpdTime(new java.util.Date());//更新一下相册信息
			album.setPhoto(photoName[0]);//默认将第一张照片设为相册封面						
			album.setPhotos(photos);
			albumService.update(album);//更新一下album
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
