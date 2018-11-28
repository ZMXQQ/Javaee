package edu.hdu.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServlet
 */
@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
//		Cookie c = new Cookie("mouse", "luoji");		//��ʱ�洢
//		response.addCookie(c);
//		Cookie dingshi_c = new Cookie("key","233");		//��ʱ�洢
//		dingshi_c.setMaxAge(3*60);
//		c.setPath("/CookieServlet/a");   							//������Ч·��
//		response.addCookie(dingshi_c);
//		
//		Cookie[] cks = request.getCookies();			//��ȡcookie,����
//		if(cks!=null) {
//			for(Cookie ck:cks) {
//				System.out.println(ck.getName() +":"+ck.getValue());
//			}
//		}
//		
		response.getWriter().write("cookie");
		
		//Cookie��ϢУ��     ������½����/������
		Cookie[] cks = request.getCookies();
		if(cks!=null) {
			//request.getRequestDispatcher("/SuccesServlet");
			
			response.sendRedirect("/SuccesServlet");
			return;
		}else {
			request.getRequestDispatcher("/LoginServlet");
			return;
		}
		
		
	};

}
