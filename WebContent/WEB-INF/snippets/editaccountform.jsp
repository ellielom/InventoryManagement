<%@ page language="java"  import="testpack.EditAccount" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<span align=left><a href="/PROG32758-Assignment4/Home"> << Back to Home</a></span>

<br><br>
<%@ taglib tagdir="/WEB-INF/tags" prefix="e" %>
	<e:errormessage color="red">${param.msg}</e:errormessage>
<form method=post>
	<table align=center>
		<tr>
			<td>Username:</td>
			<td><input type="text" name="username" value="${username}"> </td>
		</tr>
		<tr>
			<td>Full Name:</td>
			<td><input type="text" name="fullname" value="${fullname}"> </td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="password" name="password1" value="${password}"> </td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="password" name="password2" value="${password}"> </td>
		</tr>		
		<tr>
			<td colspan=2 align=center><input type="submit" value="Edit"></td>
		</tr>
	</table>
</form>
