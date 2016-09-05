<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>sendMessage</title>
</head>
<script language="javascript">
	function check() {
		var title = document.getElementById("title").value;
		var content = document.getElementById("content").value;
		if (title == "" || title == null) {
			document.getElementById("titleSpan").innerHTML = "帖子主题不允许为空！";
			return false;
		}
		if (content == "" || content == null) {
			document.getElementById("contentSpan").innerHTML = "帖子内容不允许为空！";
			return false;
		}
		return true;

	}
</script>

<body>
	<form name="sendform" method="post" onsubmit="return check()"
		action="../MessageServlet?method=sendMessage">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<input type="hidden" name="writer"
				value="<%=session.getAttribute("userName")%>">
			<tr>
				<td height="22"><span class="STYLE4">帖子主题:</span></td>
				<td height="22"><input name="title" id="title" type="text"
					style="width: 100px; height: 16px; border: solid 1px #000000; color: #666666"><span
					style="color: red" id="titleSpan">请输入帖子标题</span></td>
			</tr>
			<tr>
				<td height="22"><span class="STYLE4">帖子内容:</span></td>
				<td height="22"><textarea name="content" id="content"
						type="text" style="border: solid 1px #000000; color: #666666"
						rows="5"></textarea><span style="color: red" id="contentSpan">请输入帖子内容</span></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" name="Submit1" value="发送"><input
					type="reset" name="Submit2" value="重置"></td>
			</tr>
		</table>
	</form>
</body>
</html>