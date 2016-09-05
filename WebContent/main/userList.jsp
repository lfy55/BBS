
<%@page import="com.njupt.model.User"%>
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
<base href="<%=basePath%>">

<title>管理员操作界面</title>


</head>
<script type="text/javascript">
	function checkLogin() {
		var username = document.getElementById("username").value;
		var pwd1 = document.getElementById("pwd1").value;
		var pwd2 = document.getElementById("pwd2").value;
		if (username == ""||username ==null) {
			document.getElementById("nameSpan").innerHTML="用户名不能为空";
			return false;
		}
		if (pwd1 == ""||pwd1==null) {
			document.getElementById("pwd1Span").innerHTML="密码不能为空";
			return false;
		}
		if (pwd2 == ""||pwd2==null) {
			document.getElementById("pwd2Span").innerHTML="密码不能为空";
			return false;
		}
		if (pwd2 != pwd1) {
			document.getElementById("pwd2Span").innerHTML="两次密码不一致,请确认";
			pwd1 = "";
			return false;
		}
		return true;
	}
</script>
<body>
	<%
		Boolean flag = null;
		flag = (Boolean) request.getAttribute("amessage");
		if (flag != null && flag) {
	%>
	<script type="text/javascript">
		alert("添加用户成功")
	</script>
	<%
		} else if (flag != null && !flag) {
	%>
	<script type="text/javascript">
		alert("添加用户失败")
	</script>
	<%
		}
	%>

	添加用户
	<form name="form1" id="form1" method="post" onsubmit="return checkLogin()"
		action="LoginAndRegisterServlet?method=addUser" >
		<table width="100%" border="1" align="center" cellpadding="3"
			cellspacing="1" bordercolor="#00FFFF"
			style="border-collapse: collapse">
			<tr>
				<td><s:text name="username"></s:text>用户名：</td>
				<td><input name="admin.adminName" type="text" id="username" /><span style="color:red" id="nameSpan">请输入用户名</span>
					</td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input name="admin.adminPass" type="password" id="pwd1" /><span style="color:red" id="pwd1Span">请输入密码</span>
					</td>
			</tr>
			<tr>
				<td>确认密码：</td>
				<td><input name="pwd2" type="password" id="pwd2" /><span style="color:red" id="pwd2Span">请在输入一次密码</span> </td>
			</tr>
			<tr>
				<td>权限：</td>
				<td><select name="admin.adminLimits" id="admin.adminLimits">

						<option value="0">普通会员</option>
						<option value="1">系统管理员</option>

				</select> <span id="nameSpan" style="color:red">请选择权限</span></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" name="Submit" value="提交"
					  /> <input type="reset" name="Submit2" value="重置" /></td>
			</tr>
		</table>
	</form>
	
	
	<p>已有用户列表：</p>
	<%
		Boolean deleteflag = null;
		flag = (Boolean) request.getAttribute("dmessage");
		if (flag != null && flag) {
	%>
	<script type="text/javascript">
		alert("删除用户成功")
	</script>
	<%
		} else if (flag != null && !flag) {
	%>
	<script type="text/javascript">
		alert("删除用户失败")
	</script>
	<%
		}
	%>
	<%
		Boolean updateflag = null;
		flag = (Boolean) request.getAttribute("umessage");
		if (flag != null && flag) {
	%>
	<script type="text/javascript">
		alert("更改用户权限成功")
	</script>
	<%
		} else if (flag != null && !flag) {
	%>
	<script type="text/javascript">
		alert("更改用户权限失败")
	</script>
	<%
		}
	%>
	<table width="100%" border="1" align="center" cellpadding="3"
		cellspacing="1" bordercolor="#00FFFF"
		style="border-collapse: collapse">
		<tr>
			<td bgcolor="A4B6D7">用户ID</td>
			<td bgcolor="A4B6D7">用户名</td>
			<td bgcolor="A4B6D7">密码</td>
			<td bgcolor="A4B6D7">权限</td>
			<td bgcolor="A4B6D7">添加时间</td>
			<td bgcolor="A4B6D7">操作</td>
		</tr>
		<c:forEach items="${requestScope.userList}" var="user">
			<tr>
				<td bgcolor="A4B6D7">${user.userId}</td>
				<td bgcolor="A4B6D7">${user.userName}</td>
				<td bgcolor="A4B6D7">${user.userPass}</td>
				<td bgcolor="A4B6D7">${user.userLimits ==0 ? "普通用户":"管理员用户"}</td>
				<td bgcolor="A4B6D7">${user.createDate}</td>

				<td bgcolor="A4B6D7"><a
					href="UserServlet?method=updateUser&userId=${user.userId}&limits=${user.userLimits}">更改权限</a>
					<a href="UserServlet?method=deleteUser&userId=${user.userId}">删除</a>
				</td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>

