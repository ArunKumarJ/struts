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
	<s:form action="doRegister">
		<table>
			<tr>
				<s:label value="User Name" name="userNamelbl"></s:label>
				<td><s:textfield id="userName" name="userName"></s:textfield></td>
			</tr>
			<tr>
				<s:label value="User ID" name="userIdlbl"></s:label>
				<td><s:textfield id="userId" name="userId"></s:textfield></td>
			</tr>

			<tr>
				<s:label value="Password" name="passwordlbl"></s:label>
				<td><s:textfield id="password" name="password"></s:textfield></td>
			</tr>
			<tr>
				<s:label value="e-mail" name="emailAddresslbl"></s:label>
				<td><s:textfield id="emailAddress" name="emailAddress"></s:textfield></td>
			</tr>
			<tr>
				<s:label value="Mobile No." name="mobileNolbl"></s:label>
				<td><s:textfield id="mobileNo" name="mobileNo"></s:textfield></td>
			</tr>
			<tr>
				<td><s:submit value="Register" /></td>
			</tr>
		</table>
	</s:form>
</body>
</html>