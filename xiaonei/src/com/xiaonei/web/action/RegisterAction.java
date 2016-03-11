package com.xiaonei.web.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xiaonei.domain.University;
import com.xiaonei.domain.Users;
import com.xiaonei.domain.Useruniversity;
import com.xiaonei.service.CountryServiceInter;
import com.xiaonei.service.ProvinceServiceInter;
import com.xiaonei.service.UniversityServiceInter;
import com.xiaonei.service.UserServiceInter;
import com.xiaonei.service.UseruniversityServiceInter;
import com.xiaonei.web.form.UserFormInfo;

public class RegisterAction extends ActionSupport implements RequestAware, SessionAware, ModelDriven<UserFormInfo> {
	
	private Map<String, Object> request;
	private Map<String, Object> session;
	private CountryServiceInter countryService;
	private ProvinceServiceInter provinceService;
	private UniversityServiceInter universityService;
	private UserServiceInter userService;
	private UseruniversityServiceInter useruniversityService;
	
	private UserFormInfo userInfo = new UserFormInfo();
	
	public String register() {
		//���û�ע��ʱ�����Ϣ���浽һ���û�������
		Users user = new Users();
		user.setEmail(userInfo.getEmail());
		user.setLoginDate(new java.util.Date());
		user.setName(userInfo.getName());
		user.setPwd(userInfo.getPwd());
		user.setRegisterDate(new java.util.Date());
		user.setSex(userInfo.getSex());
		//�ȵõ����û��Ĵ�ѧ����
		University university = (University) universityService.findById(University.class, Integer.valueOf(userInfo.getUniversityId()));
		//�������û���Ӧ���û���ѧ��Ϣ
		Useruniversity uUniversity = new Useruniversity();
		uUniversity.setUsers(user);
		uUniversity.setUniversity(university);
		uUniversity.setUserType(userInfo.getUserType());
		//�����û�
		userService.save(user);
		useruniversityService.save(uUniversity);
		
		session.put("user", user);//��user�浽session�еȻ����
		return SUCCESS;
	}
	
	public String preRegister() {
		//׼�����ݣ����û�ѡ���ѧʹ��
		//����
		request.put("countrylist", countryService.findAll("from Country c", null));
		//ʡ��ֱϽ�е���Ϣ(Ĭ���й�)
		request.put("provincelist", provinceService.findAll
				("from Province p where p.country.id=?", new Object[]{new Integer(1)}));
		//��ѧ����(Ĭ����ʾ����)
		request.put("universitylist", universityService.findAll
				("from University u where u.country.id=? and u.province.id=?", new Object[]{new Integer(1), new Integer(1)}));
		return SUCCESS;
	}	
	
	public CountryServiceInter getCountryService() {
		return countryService;
	}
	@Resource
	public void setCountryService(CountryServiceInter countryService) {
		this.countryService = countryService;
	}

	public ProvinceServiceInter getProvinceService() {
		return provinceService;
	}
	@Resource
	public void setProvinceService(ProvinceServiceInter provinceService) {
		this.provinceService = provinceService;
	}
	
	public UniversityServiceInter getUniversityService() {
		return universityService;
	}
	@Resource
	public void setUniversityService(UniversityServiceInter universityService) {
		this.universityService = universityService;
	}
	
	public UserServiceInter getUserService() {
		return userService;
	}
	@Resource
	public void setUserService(UserServiceInter userService) {
		this.userService = userService;
	}

	public UseruniversityServiceInter getUseruniversityService() {
		return useruniversityService;
	}
	@Resource
	public void setUseruniversityService(
			UseruniversityServiceInter useruniversityService) {
		this.useruniversityService = useruniversityService;
	}

	public UserFormInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserFormInfo userInfo) {
		this.userInfo = userInfo;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	//struts2���ȴ�return��model�￴��û����Ӧ��set�������еĻ��ͰѴ������Ĳ�������return��model����
	//������action�ķ�����Ϳ��Բ�����������û�ע����Ϣ��userInfo��
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
	
}
