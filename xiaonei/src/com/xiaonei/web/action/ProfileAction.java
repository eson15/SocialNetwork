package com.xiaonei.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xiaonei.domain.Users;
import com.xiaonei.service.UserServiceInter;
import com.xiaonei.web.form.UserFormInfo;

public class ProfileAction extends ActionSupport implements RequestAware, SessionAware, ModelDriven<UserFormInfo> {
	
	private Map<String, Object> request;
	private Map<String, Object> session;
	private UserServiceInter userService;
	private UserFormInfo userInfo = new UserFormInfo();//ʹ��ModelDrivenһ��Ҫ��new��һ����������form����
	
	public String goHomePage() {
		return SUCCESS;
	}	
	public String goNewsPage() {
		return SUCCESS;
	}
	
	//��Ӧ�û���½����
	public String login() {
		Users user = new Users();
		user.setEmail(userInfo.getEmail());
		user.setPwd(userInfo.getPwd());
		
		Users loginuser = userService.check(user);
		if(loginuser != null) {
			loginuser.setLoginDate(new java.util.Date());//����һ�µ�½ʱ��
			userService.update(loginuser);//����һ�´��û�
			session.put("user", loginuser);//��user�浽session�еȻ����
			return SUCCESS;
		}
		else {//û�и��û�
			request.put("message", "error");//������/public/index.jsp�л�������
			request.put("user", user);//��Ϊloginuserλnull,����user�����û��ո��ύ��email�������������email
			return "fail";
		}
	}
	
	//�û��˳�
	public String logout() {
		session.clear();
		return SUCCESS;
	}
	
	//��ת���ϴ�ͷ�����
	public String uploadPhotoUI() {
		return SUCCESS;
	}
	
	//�ϴ�ͷ��
	public String uploadPhoto() {
		//�ϴ��ļ��ο�����
		//http://wenku.baidu.com/link?url=HTJfg_Kp4E0AUUKemwVwNiJVwmw4ZwGwjJ64ldZc3pA7Sjir3VnOcyItSR7yH8aK3aPPCCmFALHG9gab74jTeVz4E5Y9OVy4JEs-HJYx98q
		//http://blog.csdn.net/yjp198713/article/details/16887361
		
		
		Users user = (Users) session.get("user");//�õ���ǰ�û�����session��ȡ��
		File image = userInfo.getImage();//��ñ���������ͼ��
		String imageName = userInfo.getImageFileName();//��������ͼ������
		
		
		//�ظ����ϴ�������û���õ�image
		//����Ӧ��������ĳ������ж�һ�£�û�õ��ͷ��ظ�fail
		
		//��ͼ������ͳһ�ĳ�  �����.��׺�� ����ʽ������ֻ�ᱣ����һ��
		if(image != null) {
			imageName = user.getId() + imageName.substring(imageName.indexOf("."), imageName.length());

			//���û�ͷ�񴫵���������ĳ��Ŀ¼��[/xiaonei/images/�û����/head/]
		
			//�ڷ�������Ŀ¼�´���images�ļ��У�realpath = E:\web\apache-tomcat-8.0.26\webapps\xiaonei\images
			String realpath = ServletActionContext.getServletContext().getRealPath("/images");	
			System.out.println(realpath);
			//�ٴ�������Ҫ���Ŀ¼
			realpath = realpath + "\\" + user.getId() + "\\head\\";
			System.out.println(realpath);
			//�ڸ�Ŀ¼�´����ϴ��ļ����ļ�����
			File destFile = new File(realpath, imageName);
			System.out.println(destFile);
			
			//����ϴ��ļ����ڵ��ļ��в����ڣ��򴴽�
			if(!destFile.getParentFile().exists()) {
				destFile.getParentFile().mkdir();
			}
			try {
				//����strut2�е�FileUtils�����ཫ�ϴ����ļ�������Ŀ���ļ���
				FileUtils.copyFile(image, destFile);
				/*
				//���û��������ϴ��ļ�
				InputStream in = new FileInputStream(image);
				OutputStream out = new FileOutputStream(destFile);
				byte[] buffer = new byte[1024];
				int len = 0;
				while((len = in.read(buffer)) != -1) {
					out.write(data, 0, len);
				}
				out.flush();
				out.close();
				in.close();
				*/
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//�޸��û����е�photo�ֶ�,�����¸��û������ݣ���ͷ������ּӵ�photo�ֶ�
			user.setPhoto(imageName);
			userService.update(user);
			return SUCCESS;
		}
		else{
			request.put("message", "noimage");
			return "fail";
		}
	}

	public UserServiceInter getUserFormInfoervice() {
		return userService;
	}
	@Resource
	public void setUserFormInfoervice(UserServiceInter userService) {
		this.userService = userService;
	}

	@Override
	public UserFormInfo getModel() {
		// TODO Auto-generated method stub
		return userInfo;
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
