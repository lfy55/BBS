
<%@page import="com.njupt.dao.impl.RevertDaoImpl"%>
<%@page import="com.njupt.dao.impl.UserDaoImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.njupt.model.Message"%>
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>messageList</title>
</head>
<body>

	<%
		Boolean sendFlag = null;
		sendFlag = (Boolean) request.getAttribute("sendResult");
		if (sendFlag != null && sendFlag) {
	%>
	<script type="text/javascript">
		alert("发送帖子成功")
	</script>
	<%
		} else if (sendFlag != null && !sendFlag) {
	%>
	<script type="text/javascript">
		alert("发送帖子失败")
	</script>
	<%
		}
	%>

	<form name="sendForm" method="post" action="main/sendMessage.jsp">
		<input type="submit" name="sendMessage" value="发帖">
	</form>

	<%
		Boolean deleteFlag = null;
		deleteFlag = (Boolean) request.getAttribute("deleteMessage");
		if (deleteFlag != null && deleteFlag) {
	%>
	<script type="text/javascript">
		alert("删除帖子成功")
	</script>
	<%
		} else if (deleteFlag != null && !deleteFlag) {
	%>
	<script type="text/javascript">
		alert("删除帖子失败")
	</script>
	<%
		}
	%>

	<table width="100%" border="1" align="center" cellpadding="3"
		cellspacing="1" bordercolor="#00FFFF"
		style="border-collapse: collapse">
		<tr>
			<td bgcolor="A4B6D7">帖子编号</td>
			<td bgcolor="A4B6D7">帖子标题</td>
			<td bgcolor="A4B6D7">帖子作者</td>
			<td bgcolor="A4B6D7">回帖数</td>
			<td bgcolor="A4B6D7">发帖时间</td>
			<td bgcolor="A4B6D7">操作</td>
		</tr>

		<%
			ArrayList<Message> messages = (ArrayList<Message>) request
					.getAttribute("messageList");
			UserDaoImpl userImpl = new UserDaoImpl();
			RevertDaoImpl revertImpl = new RevertDaoImpl();
			for (int i = 0; i < messages.size(); i++) {
		%>
		<tr>
			<td bgcolor="A4B6D7"><%=messages.get(i).getMessageId()%></td>
			<td bgcolor="A4B6D7"><%=messages.get(i).getTitle()%></td>
			<td bgcolor="A4B6D7"><%=userImpl.searchAdminById(messages.get(i).getWriter())
						.getUserName()%></td>
			<td bgcolor="A4B6D7"><%=revertImpl.searchRevertAll(
						messages.get(i).getMessageId()).size()%></td>
			<td bgcolor="A4B6D7"><%=messages.get(i).getWriterDate()%></td>
			<td bgcolor="A4B6D7"><a
				href="MessageServlet?method=searchById&messageId=<%=messages.get(i).getMessageId()%>">查看帖子详情</a></td>
		</tr>

		<%
			}
		%>
	</table>

</body>
</html>