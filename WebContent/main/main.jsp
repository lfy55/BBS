<%@ page language="java" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>BBS管理系统</title>

</head>

	<% session.setAttribute("userName", request.getParameter("admin.userName"));%>

	
<frameset rows="90,80%,*"  framespacing="0" frameborder="no" border="0">
  <frame src="main/top.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" />
 
  <frame src="main/center.jsp" name="mainFrame" id="mainFrame" />
 
  <frame src="main/down.jsp" name="bottomFrame" scrolling="No" noresize="noresize" id="bottomFrame" />
</frameset>
<noframes><body onload="javascript:location='main/mian.jsp'">
</body>
</noframes> 
</body>
</html>
