package com.xiaonei.web.form;

import java.io.File;

public class FileUploadFormInfo{
	// �ļ�����Ϊimage���������File���Զ�Ӧ������2������struts2���Զ�ͨ��set����ע�����
		private File image;//��Ӧ�ľ��Ǳ����ļ��ϴ����Ǹ�����������ƣ�Struts2��ܻ��װ��File���͵�
		private String imageFileName;//   �ϴ�������FileName  �ļ���
		private String imageContentType;// �ϴ��ļ���MIME����
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
