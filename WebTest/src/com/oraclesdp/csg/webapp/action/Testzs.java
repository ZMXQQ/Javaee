package com.oraclesdp.csg.webapp.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Testzs
 */
@WebServlet("/Testzs")
public class Testzs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Testzs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String requestUrl = request.getRequestURL().toString();//�õ������URL��ַ
        String requestUri = request.getRequestURI();//�õ��������Դ
        String queryString = request.getQueryString();//�õ������URL��ַ�и����Ĳ���
        String remoteAddr = request.getRemoteAddr();//�õ������ߵ�IP��ַ
        String remoteHost = request.getRemoteHost();
        int remotePort = request.getRemotePort();
        String remoteUser = request.getRemoteUser();
        String method = request.getMethod();//�õ�����URL��ַʱʹ�õķ���
        String pathInfo = request.getPathInfo();
        String localAddr = request.getLocalAddr();//��ȡWEB��������IP��ַ
        String localName = request.getLocalName();//��ȡWEB��������������
        System.out.println("requestUrl"+requestUrl);
        System.out.println("queryString"+queryString);
        System.out.println("remoteAddr"+remoteAddr);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
