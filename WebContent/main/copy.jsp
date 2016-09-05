<%@ page language="java"  pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户登录</title>
    

  </head>

  <body >
  <table width="66%" height="68%" border="0" cellpadding="5" cellspacing="5">
  <tr>
    <td valign="top"><p>欢迎用户：&nbsp;<%=session.getAttribute("userName") %>&nbsp;进入〉〉〉 </p>
    	<p><img src="images/ny.jpg" alt="南邮校徽" align="right"></p>
      <h2><br>BBS管理系统 </h2>
      <p class="td2">联系人:宋乾坤</p>
      <p class="td2">电话:025-88888888</p>
      <p class="td2">手机:15888888888</p>
      <p class="td2">邮箱:6666666666@qq.com</p>
      <p class="td2">地址:南京市栖霞区<a href="mailto:zsqk_55@163.com"></a></p>
      <p class="welcome">&nbsp;</p></td>
  </tr>
</table>
<p class="welcome">&nbsp;</p>
  </body>
</html>

