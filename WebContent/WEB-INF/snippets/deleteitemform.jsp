<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<span align=left><a href="/PROG32758-Assignment4/Home"> << Back to Home</a></span>

	<table align=center>
	<form method=post>
	Are you sure you want to delete this item? 
	<th> Item ID:</th><th> Name: </th><th> Quantity: </th><th> User ID: </th>
	<tr>
		<td> ${item.id} </td> <td>${item.name}</td><td>${item.qty }</td><td>${item.uid}</td>
	</tr>
	<tr>
		<td colspan=2 align=center> <input type=submit value=Delete> </td>
	</tr>
	</form>
	</table>
