
<%@ page language="java"  pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<html>
	<head>
		<base href="<%=basePath%>">

		<title>南京邮电大学BBS系统</title>
			<script src="js/menu.js"></script>
			<script src="js/jquery-1.6.3.js"></script>
			<script src="js/login.js"></script>
			<style type="text/css">
				<!--
				body {
					margin-left: 0px;
					margin-top: 0px;
					margin-right: 0px;
					margin-bottom: 0px;
				}
				.STYLE1 {
					color: #FFFFFF;
					font-weight: bold;
					font-size: 12px;
				}
				.STYLE2 {
					font-size: 12px;
					color: #03515d;
				}
				a:link {font-size:12px; text-decoration:none; color:#03515d;}
				a:visited{font-size:12px; text-decoration:none; color:#03515d;}
				.STYLE3 {font-size: 12px}
				-->
			</style>


		</head>

		<body>
			<s:property value="admin.username"/>
				<s:property value="admin.password"/>
					<table width="1156"  border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td align="center" valign="top">
								<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td height="33" background="images/main_21.gif">&nbsp;</td>
									</tr>

									<tr>
										<td height="20" background="images/main_25.gif" id="td1" onClick="show(1)"><table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td width="13%">&nbsp;</td>
												<td width="72%" height="20"><div align="center">
													<table width="100%" height="21" border="0" cellpadding="0" cellspacing="0">
														<tr>
															<td><div align="center">111<img src="images/top_8.gif" width="16" height="16"></div></td>
															<td valign="middle"><div align="center" class="STYLE1">论坛用户管理</div></td>
															</tr>
														</table>
													</div>
												</td>
												<td width="15%">&nbsp;</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr id="show1">
									<td align="center" valign="top"><table width="145" border="0" align="center" cellpadding="0" cellspacing="0">
										<tr>
											<td><table width="130" border="0" align="center" cellpadding="0" cellspacing="0">
												<tr>
													<td width="41" height="35"><div align="center"><img src="images/left_1.gif" width="31" height="31"></div></td>
													<td width="89" height="35"><table width="100%" border="0" cellspacing="0" cellpadding="0">
														<tr>
															<td height="23" style="cursor:hand" onMouseOver="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#adb9c2'; "onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'"><span class="STYLE2">&nbsp;<a href="UserServlet?method=List" target="hsgmain">系统用户管理</a></span></td>
															</tr>
														</table></td>
													</tr>

												</table></td>
											</tr>
										</table></td>
									</tr>

									<tr>
										<td height="20" background="images/main_25.gif" id="td2" onClick="show(2)">
											<table width="100%" border="0" cellspacing="0" cellpadding="0">
												<tr>
													<td width="13%">&nbsp;</td>
													<td width="72%" height="20"><div align="center">
														<table width="100%" height="21" border="0" cellpadding="0" cellspacing="0">
															<tr>
																<td><div align="center"><img src="images/top_8.gif" width="16" height="16"></div></td>
																<td valign="middle"><div align="center" class="STYLE1">论坛帖子管理</div></td>
																</tr>
															</table>
														</div></td>
														<td width="15%">&nbsp;</td>
													</tr>
												</table></td>
											</tr>
											<tr id="show2" style="display:none">
												<td align="center" valign="top"><table width="145" border="0" align="center" cellpadding="0" cellspacing="0">
													<tr>
														<td><table width="130" border="0" align="center" cellpadding="0" cellspacing="0">
															<tr>
																<td width="41" height="35"><div align="center"><img src="images/left_1.gif" width="31" height="31"></div></td>
																<td width="89" height="35"><table width="100%" border="0" cellspacing="0" cellpadding="0">
																	<tr>
																		<td height="23" style="cursor:hand" onMouseOver="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#adb9c2'; "onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'"><span class="STYLE2">&nbsp;<a href="MessageServlet?method=List" target="hsgmain">系统帖子管理</a></span></td>
																		</tr>
																	</table></td>
																</tr>

															</table>
														</td>
													</tr>
												</table></td>
											</tr>


													</table></td>
												</tr>
											</table>
										</body>
									</html>

