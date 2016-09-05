<%@page import="com.njupt.model.Revert"%>
<%@page import="java.util.List"%>
<%@page import="com.njupt.dao.impl.RevertDaoImpl"%>
<%@page import="com.njupt.dao.impl.UserDaoImpl"%>
<%@page import="com.njupt.model.Message"%>
<%@page import="java.util.ArrayList"%>
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
<title>MessageDetail</title>
</head>
<body>

	<%
		Boolean flag = null;
		flag = (Boolean) request.getAttribute("sendRevert");
		if (flag != null && flag) {
	%>
	<script type="text/javascript">
		alert("回帖成功")
	</script>
	<%
		} else if (flag != null && !flag) {
	%>
	<script type="text/javascript">
		alert("回帖失败")
	</script>
	<%
		}
	%>
	<%
		Boolean dflag = null;
		flag = (Boolean) request.getAttribute("deleteRevert");
		if (flag != null && flag) {
	%>
	<script type="text/javascript">
		alert("删除回复成功")
	</script>
	<%
		} else if (flag != null && !flag) {
	%>
	<script type="text/javascript">
		alert("删除回复失败")
	</script>
	<%
		}
	%>

	<div class="center">【帖子详情一览表】</div>
	<table width="100%" border="3">
		<tr>
			<td align="center">帖子编号</td>
			<td align="center">帖子标题</td>
			<td align="center">帖子作者</td>
			<td align="center">回帖数</td>
			<td align="center">发帖时间</td>
			<td align="center">操作</td>
		</tr>
		<%
			Message message = (Message) request.getAttribute("searchMessage");
			UserDaoImpl userImpl = new UserDaoImpl();
			RevertDaoImpl revertImpl = new RevertDaoImpl();
			System.out.println(message.getTitle());
		%>
		<tr>
			<td bgcolor="A4B6D7"><%=message.getMessageId()%></td>
			<td bgcolor="A4B6D7"><%=message.getTitle()%></td>
			<td bgcolor="A4B6D7"><%=userImpl.searchAdminById(message.getWriter())
					.getUserName()%></td>
			<td bgcolor="A4B6D7"><%=revertImpl.searchRevertAll(message.getMessageId()).size()%></td>
			<td bgcolor="A4B6D7"><%=message.getWriterDate()%></td>
			<td bgcolor="A4B6D7"><a
				href="MessageServlet?method=deleteMessage&messageId=<%=message.getMessageId()%>">删除帖子</a></td>
		</tr>
		<tr>
			<td colspan="6"><%=message.getContent()%></td>
		</tr>
	</table>
	<p>回复一览</p>
	<hr size="3" color="000000" />
		<%
			List<Revert> reverts = revertImpl.searchRevertAll(message
					.getMessageId());
			for (int i = 0; i < reverts.size(); i++) {
				Revert revert = reverts.get(i);
		%>
		<%="第"
						+ i
						+ " 楼 "
						+ revert.getContent()
						+ "\n"
						+ userImpl.searchAdminById(revert.getWriter())
								.getUserName() + revert.getWriterDate() + "\n"%>
		<a
			href="RevertServlet?method=deleteRevert&revertId=<%=revert.getRevertId()%>&messageId=<%=message.getMessageId()%>">删除回复</a>
		<hr size="3" color="000000" />
		<%
			}
		%>
	</table>

	<form name="sendForm" method="post"
		action="RevertServlet?method=temp&messageId=<%=message.getMessageId()%>">
		<input type="submit" name="sendMessage" value="发表回复">
	</form>
</body>
</html>