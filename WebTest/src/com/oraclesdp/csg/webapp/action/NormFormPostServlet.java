package com.oraclesdp.csg.webapp.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NormFormPostServlet extends HttpServlet {
	String ss;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
	//获取表单数据.
		
		request.setCharacterEncoding("UTF-8");
	//String ss=	request.getQueryString();
    String host=request.getRemoteAddr();
	String suser=request.getParameter("suser");
	String spwd=request.getParameter("spwd");
	String ssex=request.getParameter("ssex");
	String sxl=request.getParameter("sxl");
	String[] sah=request.getParameterValues("sah");
	String sjj=request.getParameter("sjj");
	System.out.println("sjj"+sjj);
	//输出显示在网页上.
	response.setContentType("text/html");
	 response.setCharacterEncoding("UTF-8");
	PrintWriter out = response.getWriter();
	out.println("用户名:"+suser+"<br>");
	out.println("密码:"+spwd+"<br>");
	out.println("性别:"+ssex+"<br>");
	out.println("学历:"+sxl+"<br>");
	for(int i=0;i<sah.length;i++) { out.println("爱好:"+sah[i]+"<br>"); }
	out.println("简介:"+sjj+"<br>");
	 if(host!=null)out.println("host"+host);
	 else out.println("host is null");
	 if(ss!=null)out.println("ss"+ss);
	 else out.println("ss is null");
	out.close();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {   
		ss= req.getQueryString();
		doPost(req,resp);
	}

}
