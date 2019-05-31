<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    

<span align=left><a href="/PROG32758-Assignment4/Home"> << Back to Home</a></span>

<br><br>
<%@ taglib tagdir="/WEB-INF/tags" prefix="e" %>
	<e:errormessage color="red">${param.msg}</e:errormessage>
<form method=post>
	<table align=center>
		<th align=center colspan=2> Item ID: ${item.id}
		</th>
		<tr>
			<td>Item Name:</td>
			<td><input type="text" name="iname" value="${item.name}"> </td>
		</tr>
		<tr>
			<td>Item Qty:</td>
			<td><input type="text" name="iqty" value="${item.qty}"> </td>
		</tr>
		<tr>
			<td colspan=2 align=center><input type="submit" value="Edit"></td>
		</tr>
	</table>
</form>
    