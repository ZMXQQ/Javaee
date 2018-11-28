<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%
	if(request.getParameter("inputCode").equals(session.getAttribute("authCode"))) {
		response.sendRedirect("/servlet/RequestDemo03");
	}else{
		out.print("输入错误");
	}           
%>
	<a href="javascript:history.go(-1)">返回</a>