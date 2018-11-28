package edu.hdu.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SuccesServlet
 */
@WebServlet("/SuccesServlet")
public class SuccesServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		out.println("<html><head><title>登录结果</title></head>");
		out.println("<body> 登录成功<br>");
		out.println("------------------------------------------<br>");
		out.println("</body></html>");
		out.close();
	}
}
