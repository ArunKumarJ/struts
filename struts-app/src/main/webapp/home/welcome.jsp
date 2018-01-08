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
	<s:actionerror />
	<s:form action="doLogin">
		<table>
			<tr>
				<s:label value="User ID" name="userIdlbl"></s:label>
				<td><s:textfield id="userId" name="userId"></s:textfield></td>
			</tr>

			<tr>
				<s:label value="Password" name="passwordlbl"></s:label>
				<td><s:password id="password" name="password"></s:password></td>
			</tr>

			<tr>
				<td><s:submit value="Login" /></td>
			</tr>
			<tr>
				<td><s:a action="registerUser">registerUser</s:a></td>
			</tr>
		</table>
	</s:form>
</body>
</html>