<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="project.models.*"%>
<%@page import="java.util.*"%>
<% List <ConfectionMatiere> liste = (List<ConfectionMatiere>)request.getAttribute("liste"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Confection-Matiere</title>
</head>
<body>
    <table border = "1">
		<tr>
			<th>Id</th>
			<th>Look</th>
			<th>Taille</th>
			<th>Matiere</th>
			<th>Quantite</th>
		</tr>
	<% for(ConfectionMatiere confectionMatiere : liste) { %>
		<tr>
			<td><% out.println(confectionMatiere.getId()); %></td>
			<td><% out.print(confectionMatiere.getLook().getDesignation()); %></td>
			<td><% out.print(confectionMatiere.getTaille().getDesignation()); %></td>
			<td><% out.print(confectionMatiere.getMatiere().getDesignation()); %></td>
			<td><% out.print(confectionMatiere.getQuantite()); %></td>
		</tr>
	<% } %>
	</table>
</body>
</html>