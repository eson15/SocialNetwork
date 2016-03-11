package com.xiaonei.base.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.springframework.orm.hibernate4.HibernateTemplate;

public abstract class BaseServiceImpl implements BaseServiceInter {

	private HibernateTemplate hibernateTemplate;
	/**
	 * @author Ni Shengwu
	 * @param hql: �����hql�����Դ��ʺ�
	 * @param parameters: ��Ӧ�ʺŵĲ�������
	 */
	@Override
	public List findAll(String hql, Object[] parameters) {
		// TODO Auto-generated method stub
/*		
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(hql);
		//ע���ʺ�
		if(parameters != null && parameters.length > 0) {
			for(int i = 0; i < parameters.length; i++) {
				query.setParameter(i, parameters[i]);
			}
		}
		return query.list();
*/		
		return hibernateTemplate.find(hql, parameters);
	}

	@Override
	public void save(Object obj) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(obj);
	}

	@Override
	public void delete(Object obj) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(obj);
	}

	@Override
	public void update(Object obj) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(obj);
	}
	
	@Override
	public Object findById(Class clazz, Serializable id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.load(clazz, id);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
