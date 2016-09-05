<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>sendMessage</title>
</head>
<script language="javascript">
	function check() {
		var content = document.getElementById("content").value;
		if (content == "" || content == null) {
			document.getElementById("contentSpan").innerHTML = "回复内容不允许为空！";
			return false;
		}
		return true;
	}
</script>

<body>
	<form name="sendform" method="post"
		action="RevertServlet?method=sendRevert" onsubmit="return check()">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<input type="hidden" name="writer"
				value="<%=session.getAttribute("userName")%>">
			<input type="hidden" name="messageId"
				value="<%=request.getAttribute("messageId")%>">
			<tr>
				<td height="22"><span class="STYLE4">回复内容:</span></td>
				<td height="22"><textarea name="content" id="content"
						type="text" style="border: solid 1px #000000; color: #666666"
						rows="5"></textarea> <span style="color: red" id="contentSpan">请输入帖子内容</span></td>
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