<%@ page language="java" pageEncoding="GB2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>next page</title>

</head>
<body>
	<p>
		»¶Ó­£¬<font color="red"><s:property value="username" />
		</font>
	</p>
	<p>
		<%=request.getAttribute("password")%>
	</p>
	<br>
	<h1>µÇÂ¼³É¹¦£¡£¡£¡</h1>

	<div align="center">
		<s:form name="viewBlog" method="post" action="viewBlog"
			namespace="/jee">
			<s:submit key="viewBlog" value="submit" />
			<br>
		</s:form>
	</div>
	<br>
	<font color="red"><a href="index.jsp">·µ»Ø</a>
	</font>
</body>
</html>
