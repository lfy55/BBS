<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
<head>
<base href="<%=basePath%>">
<title>用户登录</title>

<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	overflow: hidden;
}

.STYLE1 {
	font-size: 12px;
	color: #a1c8c6;
}

.STYLE4 {
	color: #FFFFFF;
	font-size: 12px;
}

.STYLE5 {
	color: #72AC27;
	font-size: 26pt;
}

-->
a {
	text-decoration: none;
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>

<body>

	<table width="100%" height="100%" border="0" cellpadding="0"
		cellspacing="0">
		<tr>
			<td bgcolor="035551"><a
				href="main/AdminAction!langZ_U?request_locale=en_US"><font
					color="#CCCCFF">ENGLISH</font></a> <a
				href="main/AdminAction!langZ_U?request_locale=zh_CN"><font
					color="#CCCCFF">中文</font></a></td>
		</tr>
		<tr>
			<td height="311" background="images/login_03.gif"><table
					width="758" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td height="210" background="images/login1.jpg"><table
								width="100%" height="190" border="0" cellpadding="0"
								cellspacing="0">
								<tr>
									<td width="38%" height="98">&nbsp;</td>
									<td width="62%">&nbsp;</td>
								</tr>
								<tr>
									<td>&nbsp;</td>
									<td><table width="83%" height="51" border="0" align="left">
											<tr>
												<td><div
														style="font-family: 宋体; color: #FFFFFF; filter: Glow(Color =    #000000, Strength =    2); WIDTH: 100%; FONT-WEIGHT: bold; FONT-SIZE: 19pt; margin-top: 5pt">
														<div align="center" class="STYLE5">南邮BBS管理系统</div>
													</div></td>
											</tr>
										</table></td>
								</tr>
							</table></td>
					</tr>
					<tr>
						<td height="101"><table width="100%" border="0"
								cellspacing="0" cellpadding="0">
								<tr>
									<td width="446" height="101" background="images/login_06.gif">&nbsp;</td>
									<td width="156">
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<form name="form1" method="post"
												action="LoginAndRegisterServlet?method=login"
												onsubmit="return checkLoginFRM()">
												<tr>
													<td width="29%" height="22"><span class="STYLE4">userName:</span></td>
													<td width="71" height="22"><input
														name="admin.userName" type="text" id="username"
														style="width: 100px; height: 16px; border: solid 1px #000000; color: #666666"></td>
												</tr>
												<tr>
													<td height="22"><span class="STYLE4"> password:</span></td>
													<td height="22"><input name="admin.password"
														type="password" id="pwd"
														style="width: 100px; height: 16px; border: solid 1px #000000; color: #666666"></td>
												</tr>

												<tr>
													<td><input type="submit" name="Submit" value="登录"></td>
													<td><input type="reset" name="Submit2" value="重置"></td>
												</tr>
											</form>
										</table>

									</td>
									<td width="156" background="images/login_09.gif">&nbsp;</td>
								</tr>
							</table></td>
				</table></td>
		</tr>
		<tr>
			<td bgcolor="1f7d78">&nbsp;</td>
		</tr>
		<tr>
			<td bgcolor="1f7d78"><div align="center">
					<span class="STYLE1">-- BBS管理系统 CopyRight 2016 --</span>
				</div></td>
		</tr>
	</table>

</body>
</html>