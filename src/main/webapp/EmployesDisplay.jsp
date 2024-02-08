<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="project.models.*"%>
<%@page import="java.util.*"%>
<% List <Employe> liste = (List<Employe>)request.getAttribute("liste"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Confection-Matiere</title>
</head>
<body>
    <table border = "1">
		<tr>
			<th>Nom</th>
			<th>Prenom</th>
            <th>Poste</th>
			<th>Date de naissance</th>
			<th>Date d'embauche</th>
		</tr>
	<% for(Employe employe : liste) { %>
		<tr>
			<td><%=employe.getNom() %></td>
			<td><%=employe.getPrenom() %></td>
            <td><%=employe.getPoste().getDesignation() %></td>
			<td><%=employe.getDateDeNaissance() %></td>
			<td><%=employe.getDateEmbauche() %></td>
		</tr>
	<% } %>
	</table>
</body>
</html>