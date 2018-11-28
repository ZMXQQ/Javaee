package com.oraclesdp.csg.webapp.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckAccount extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String username = req.getParameter("username");
		String pwd = req.getParameter("pwd");
		RequestDispatcher dispatcher = null;
		if ((username != null) && (username.trim().equals("abc"))) {
			if ((pwd != null) && (pwd.trim().equals("123"))) {
				System.out.println("success" + username);
				session.setAttribute("username", username);
				req.setAttribute("username", "reqxxxxxxxxxx");
				// resp.sendRedirect("success.jsp");
				req.getRequestDispatcher("WEB-INF/page/success.jsp").forward(req, resp);
				return;
			}
		}
		resp.sendRedirect("fail.jsp");
		return;
	}
}