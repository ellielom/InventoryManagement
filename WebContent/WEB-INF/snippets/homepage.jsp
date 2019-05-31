<%@ page import="testpack.Item,java.util.ArrayList" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib tagdir="/WEB-INF/tags" prefix="el" %>
	<%@ taglib uri="http://greeting.tag" prefix="e" %>
<table class="center" width="70%">
	<tr>
	<td>
		
		<e:myGreetTag colour="blue" size="18px">Welcome: ${name} </e:myGreetTag>
	</td>
		<td align=right>
			<a href="EditAccount">Edit Account</a> 
			<a href="Logout">LogOut</a>
		</td>
	</tr>
	<tr>
		<td colspan=2 align=center>	<el:errormessage color="red">${param.msg}</el:errormessage></td>
	</tr>
	<tr>
		<td colspan=2 align=center>
			<h2>List of Items</h2>
			
			<table class="center">
				<tr><th>Actions</th><th>Item Name</th><th>Quantity</th></tr>
			
				<c:forEach var="item" items="${allItems }">
				
							<tr>
								<td>
									<a href="ViewItem?id=${item.id }">View</a> 
									<a href="EditItem?id=${item.id }">Edit</a> 
									<a href="DeleteItem?id=${item.id }">Delete</a>
								</td>
								<td> ${item.name}</td>
								<td> ${item.qty }</td>
							</tr>
				</c:forEach>
				</table>
			
		</td>
	</tr>
	<tr></tr>
	<tr>
		<td colspan=2 align=center><a href=AddItem>Add New Item</a></td>
	</tr>
</table>

<br><br>