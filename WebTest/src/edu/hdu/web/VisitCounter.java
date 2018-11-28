package edu.hdu.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VisitCounter
 */
@WebServlet("/VisitCounter")
public class VisitCounter extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
		ServletContext app = this.getServletContext();
		Integer count = (Integer)app.getAttribute("count");
		if(count == null) {
			count = 1;
			app.setAttribute("count", count);
		}
		else {
			app.setAttribute("count", ++count);
		}
		response.getWriter().write("count" + count);
		
	}
}
