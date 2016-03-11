package com.xiaonei.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.xiaonei.domain.University;
import com.xiaonei.service.UniversityServiceInter;

public class ChangeUniversity extends HttpServlet {

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/xml;charset=utf-8");
		//让ie禁用缓存
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		//响应用户选择不同省/直辖市的大学信息的请求
		String proid = request.getParameter("proid");
		String cid = request.getParameter("cid");
		
		//获取spring容器
		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		//从spring容器中，取出了 UniversityServiceInter 类型的bean
		UniversityServiceInter universityService = (UniversityServiceInter) ctx.getBean("universityService");
		
		List<University> uniList = universityService.findAll
		("from University u where u.province.id=? and u.country.id=?", 
				new Object[]{Integer.valueOf(proid),Integer.valueOf(cid)});
		
		String res = "<allUniversities>";
		
		for (int i = 0; i < uniList.size(); i++) {
			University u = uniList.get(i);
			res += "<unis><id>" + u.getId() + "</id><name><![CDATA["
					+ u.getName() + "]]></name></unis>";
		}
		res += "</allUniversities>";
		out.write(res);
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
