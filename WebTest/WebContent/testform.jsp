<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Html的Form表单元素</title>
</head>
<fieldset style="width:500px;">
    <legend>Html的Form表单元素</legend>
<form action="${pageContext.request.contextPath}/servlet/RequestDemo03" method="post">
编&nbsp;&nbsp;号(文本框)：
    <input type="text" name="userid" value="NO." size="2" maxlength="2"><br>
用户名(文本框)：<input type="text" name="username" value="请输入用户名"><br>
密&nbsp;&nbsp;码(密码框)：
<input type="password" name="userpass" value="请输入密码"><br>
性&nbsp;&nbsp;别(单选框)：
    <input type="radio" name="sex" value="男" checked>男 
    <input type="radio" name="sex" value="女">女<br>
部&nbsp;&nbsp;门(下拉框)：
    <select name="dept">
        <option value="技术部">技术部</option>
        <option value="销售部" SELECTED>销售部</option>
        <option value="财务部">财务部</option>
    </select><br>
    兴&nbsp;&nbsp;趣(复选框)： 
    <input type="checkbox" name="inst" value="唱歌">唱歌 
    <input type="checkbox" name="inst" value="游泳">游泳 
    <input type="checkbox" name="inst" value="跳舞">跳舞 
    <input type="checkbox" name="inst" value="编程" checked>编程 
    <input type="checkbox" name="inst" value="上网">上网
    <br>
    说&nbsp;&nbsp;明(文本域)：
    <textarea name="note" cols="34" rows="5">
     </textarea>
    <br>
    <input type="hidden" name="hiddenField" value="hiddenvalue"/>
    <input type="submit" value="提交">
<input type="reset" value="重置"><br><br>
<img src="http://localhost:8080/WebTest/getAuthCodeServlet" id="authImg" /><br> <input type="text"
				name="inputCode"><br><br><br>
</form>
	     

</fieldset>
</body>
</html>