<%@ page language="java"  pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>�û���¼</title>
    

  </head>

  <body >
  <table width="66%" height="68%" border="0" cellpadding="5" cellspacing="5">
  <tr>
    <td valign="top"><p>��ӭ�û���&nbsp;<%=session.getAttribute("userName") %>&nbsp;���롵���� </p>
    	<p><img src="images/ny.jpg" alt="����У��" align="right"></p>
      <h2><br>BBS����ϵͳ </h2>
      <p class="td2">��ϵ��:��Ǭ��</p>
      <p class="td2">�绰:025-88888888</p>
      <p class="td2">�ֻ�:15888888888</p>
      <p class="td2">����:6666666666@qq.com</p>
      <p class="td2">��ַ:�Ͼ�����ϼ��<a href="mailto:zsqk_55@163.com"></a></p>
      <p class="welcome">&nbsp;</p></td>
  </tr>
</table>
<p class="welcome">&nbsp;</p>
  </body>
</html>

