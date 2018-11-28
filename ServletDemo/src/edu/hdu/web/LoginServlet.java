package edu.hdu.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	@Override
	public void init(ServletConfig sc) throws ServletException {
		String page = sc.getInitParameter("page");
		System.out.println("page:" + page);
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("pass");
		
		System.out.println("username :"+username+"-----\n"+"pass :"+password);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(username.equals("")) {
			request.getRequestDispatcher("/WrongServlet").forward(request, response);
			System.out.println("wrong");
			return;
		}else {
			Cookie c = new Cookie("uid",username+"");
			response.addCookie(c);
		}
		if(username.equals("a") && password.equals("123")) {
			//request.getRequestDispatcher("/SuccesServlet").forward(request, response);
			response.sendRedirect("/ServletDemo/SuccesServlet"); 		//�ض��򣬲����ظ��ύ
			System.out.println("Succes");
			return;
		}
		
		System.out.println("123");
		out.println("<html><head><title>��¼���</title></head>");
		out.println("<body> ��������û����ǣ�"+username+"<br>");
		out.println("------------------------------------------<br>");
		out.println("������������ǣ�"+password+"</body></html>");
		out.close();
	}

}