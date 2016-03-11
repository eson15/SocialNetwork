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
	private UserFormInfo userInfo = new UserFormInfo();//使用ModelDriven一定要先new出一个对象来存form数据
	
	public String goHomePage() {
		return SUCCESS;
	}	
	public String goNewsPage() {
		return SUCCESS;
	}
	
	//响应用户登陆请求
	public String login() {
		Users user = new Users();
		user.setEmail(userInfo.getEmail());
		user.setPwd(userInfo.getPwd());
		
		Users loginuser = userService.check(user);
		if(loginuser != null) {
			loginuser.setLoginDate(new java.util.Date());//更新一下登陆时间
			userService.update(loginuser);//更新一下此用户
			session.put("user", loginuser);//将user存到session中等会儿用
			return SUCCESS;
		}
		else {//没有该用户
			request.put("message", "error");//用来在/public/index.jsp中回显数据
			request.put("user", user);//因为loginuser位null,但是user中有用户刚刚提交的email，用来回显这个email
			return "fail";
		}
	}
	
	//用户退出
	public String logout() {
		session.clear();
		return SUCCESS;
	}
	
	//跳转到上传头像界面
	public String uploadPhotoUI() {
		return SUCCESS;
	}
	
	//上传头像
	public String uploadPhoto() {
		//上传文件参考资料
		//http://wenku.baidu.com/link?url=HTJfg_Kp4E0AUUKemwVwNiJVwmw4ZwGwjJ64ldZc3pA7Sjir3VnOcyItSR7yH8aK3aPPCCmFALHG9gab74jTeVz4E5Y9OVy4JEs-HJYx98q
		//http://blog.csdn.net/yjp198713/article/details/16887361
		
		
		Users user = (Users) session.get("user");//得到当前用户：从session中取出
		File image = userInfo.getImage();//获得表单传过来的图像
		String imageName = userInfo.getImageFileName();//传过来的图像名称
		
		
		//重复点上传，这里没有拿到image
		//所以应该在下面的程序中判断一下，没拿到就返回个fail
		
		//把图像名称统一改成  “编号.后缀” 的形式，这样只会保存这一张
		if(image != null) {
			imageName = user.getId() + imageName.substring(imageName.indexOf("."), imageName.length());

			//把用户头像传到服务器的某个目录下[/xiaonei/images/用户编号/head/]
		
			//在服务器根目录下创建images文件夹：realpath = E:\web\apache-tomcat-8.0.26\webapps\xiaonei\images
			String realpath = ServletActionContext.getServletContext().getRealPath("/images");	
			System.out.println(realpath);
			//再创建上面要求的目录
			realpath = realpath + "\\" + user.getId() + "\\head\\";
			System.out.println(realpath);
			//在该目录下创建上传文件的文件对象
			File destFile = new File(realpath, imageName);
			System.out.println(destFile);
			
			//如果上传文件所在的文件夹不存在，则创建
			if(!destFile.getParentFile().exists()) {
				destFile.getParentFile().mkdir();
			}
			try {
				//利用strut2中的FileUtils工具类将上传的文件拷贝到目标文件里
				FileUtils.copyFile(image, destFile);
				/*
				//利用基本方法上传文件
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
			
			//修改用户表中的photo字段,即更新该用户的数据，将头像的名字加到photo字段
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
