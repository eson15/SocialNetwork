package com.xiaonei.web.form;

import java.io.File;

public class FileUploadFormInfo{
	// 文件表单名为image，与下面的File属性对应，另外2个属性struts2会自动通过set方法注入进来
		private File image;//对应的就是表单中文件上传的那个输入域的名称，Struts2框架会封装成File类型的
		private String imageFileName;//   上传输入域FileName  文件名
		private String imageContentType;// 上传文件的MIME类型
		public File getImage() {
			return image;
		}
		public void setImage(File image) {
			this.image = image;
		}
		public String getImageFileName() {
			return imageFileName;
		}
		public void setImageFileName(String imageFileName) {
			this.imageFileName = imageFileName;
		}
		public String getImageContentType() {
			return imageContentType;
		}
		public void setImageContentType(String imageContentType) {
			this.imageContentType = imageContentType;
		}
		
}
