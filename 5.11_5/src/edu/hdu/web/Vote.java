package edu.hdu.web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Vote
 */
@WebServlet("/Vote")
public class Vote extends HttpServlet {
	Integer vote_1 = 0;		//定义票数
	Integer vote_2 = 0;
	Integer vote_3 = 0;
	Integer count = 0;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		String value = request.getParameter("thing");//获得投票结果
		
		
		if(value==null) {
			response.sendRedirect("Wrong");
			return;
		}else {
			String ip = request.getLocalAddr();
			System.out.println(ip);
			Cookie[] cookies = request.getCookies();
			for(int i = 0; i < cookies.length; i++) {
				if(ip.equals(cookies[i].getValue())) {
					response.sendRedirect("Error");
					return;
				}
			}
			Cookie cookie = new Cookie("ip", ip);
			cookie.setMaxAge(60);
			response.addCookie(cookie);

			++count;
			switch(Integer.parseInt(value)){
			case 1:vote_1 += 1;break;
			case 2:vote_2 += 1;break;
			case 3:vote_3 += 1;break;
		}
		}
		
		session.setAttribute("vote_1",vote_1);
		session.setAttribute("vote_2",vote_2);
		session.setAttribute("vote_3",vote_3);
		session.setAttribute("count",count);
		
		response.getWriter().write("投票成功, 谢谢您的参与!");
		
	}
}
