package com.oraclesdp.csg.webapp.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstAction extends HttpServlet{
	String pageSize;String ss;
	   //第一种：在init时读入
	   public void init(ServletConfig sc){
	 	pageSize = sc.getInitParameter("pageSize");
		if(pageSize!=null) System.out.println("pagsize="+pageSize);
	 	//aa = sc.getInitParameter(“aa”);
	   }
	    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {   
		 ss = req.getQueryString();
		doPost(req,resp);
        
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {   

        resp.setContentType("text/html");
	    String method = req.getMethod();

         String responseBody = "Current request method is <B>:"+ss+""
	                                                                                             + method + "</B>";
	//������HTML��Ӧ����ͨ������ط����ͻ��ˡ�
	//��ȡ������Ӧ��PrintWriter����
	PrintWriter out = resp.getWriter();
	//װ����Ҫ��Ӧ���ͻ��˵���Ӧ����
	out.println(responseBody);
	
	 out.println("pageSize"+pageSize);

	//������Ӧ
	out.close();


	}

}
