<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="project.models.*"%>
<%@page import="java.util.*"%>
<% List <Anciennete> liste = (List<Anciennete>)request.getAttribute("liste"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Anciennete</title>
</head>
<body>
    <table border = "1">
		<tr>
			<th>Designation</th>
			<th>Annee Minimum</th>
			<th>Annee Maximum</th>
			<th>Taux d'augmentation</th>
		</tr>
	<% for(Anciennete anciennete : liste) { %>
		<tr>
			<td><%=anciennete.getDesignation() %></td>
			<td><%=anciennete.getAnneeMin() %></td>
			<td><%=anciennete.getAnneeMax() %></td>
			<td><%=anciennete.getTauxAugmentation() %> %</td>
		
		</tr>
	<% } %>
	</table>
</body>
</html>