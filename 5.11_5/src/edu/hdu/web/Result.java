package edu.hdu.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Resault
 */
@WebServlet("/Resault")
public class Result extends HttpServlet {
	Integer vote_1 = 0;		//����Ʊ��
	Integer vote_2 = 0;
	Integer vote_3 = 0;
	float v1 = 0;
	float v2 = 0;
	float v3 = 0;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		vote_1 = (Integer) session.getAttribute("vote_1");		//����Ʊ��
		vote_2 = (Integer) session.getAttribute("vote_2");
		vote_3 = (Integer) session.getAttribute("vote_3");
		if(vote_1==null) {
			vote_1=0;
		}
		if(vote_2==null) {
			vote_2=0;
		}
		if(vote_3==null) {
			vote_3=0;
		}
		PrintWriter out = response.getWriter();
		Integer count = (Integer) session.getAttribute("count");
		if(count==null) {
			count=0;
		}else {
			v1 = (float)vote_1 / (float)count;
			v2 = (float)vote_2 / (float)count;
			v3 = (float)vote_3 / (float)count;
			v1 = (float)(Math.round(v1*100));
			v2 = (float)(Math.round(v2*100));
			v3 = (float)(Math.round(v3*100));
		}
		
		out.println("<html><head><title>ͶƱ���</title></head>");
		out.println("<body><br>");
		out.println("<label>��Ŀ- - - - - - - - - - - - - - ���� - - - - - - ����</label><br>");
		out.println("<label>ͶƱ����______________" + count + "</label><br>");
		out.println("<label>�Լ��˺õ�____________" + vote_1 +"_________" + v1 +  "%</label><br>");
		out.println("<label>�Ҹ��Լ�ϲ���Ĺ���____" + vote_2 +"_________" + v2 +  "%</label><br>");
		out.println("<label>�����Լ�������________" + vote_3 +"_________" + v3 +  "%</label><br>");
		out.println("</body></html>");
		out.close();
	}
}
