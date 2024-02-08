<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="project.models.*"%>
<%@page import="java.util.*"%>
<% List <ConfectionTime> liste = (List<ConfectionTime>)request.getAttribute("liste"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Confection-Time</title>
</head>
<body>
    <table border = "1">
		<tr>
			<th>Id</th>
			<th>Look</th>
			<th>Taille</th>
			<th>Type</th>
			<th>Temps</th>
		</tr>
	<% for(ConfectionTime confectionTime : liste) { %>
		<tr>
			<td><% out.println(confectionTime.getId()); %></td>
			<td><% out.print(confectionTime.getLook().getDesignation()); %></td>
			<td><% out.print(confectionTime.getTaille().getDesignation()); %></td>
			<td><% out.print(confectionTime.getType().getDesignation()); %></td>
			<td><% out.print(confectionTime.getTemps()); %></td>
		</tr>
	<% } %>
	</table>
</body>
</html>