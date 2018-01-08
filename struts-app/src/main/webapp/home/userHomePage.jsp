<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<s:head />
</head>
<body>
	<div>
		<div style="float: right;">
			<div>
				Howdy,
				<s:property value="#session.SESSION_USER_INFO.userName" />
			</div>

			<div>
				<s:a>Logout</s:a>
			</div>
		</div>
	</div>
</body>
</html>