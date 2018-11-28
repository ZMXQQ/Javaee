package com.oraclesdp.csg.webapp.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalAction extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		System.out.println("method" + method);

	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String method = req.getMethod();
		System.out.println("method" + method);
		String s=req.getParameter("query");
		resp.setContentType("text/html");
		 resp.setCharacterEncoding("UTF-8");
		String responseBody =  "query"+s + "</B>";
	    
		PrintWriter out = resp.getWriter();
		out.println(responseBody);

		out.close();

	}

}