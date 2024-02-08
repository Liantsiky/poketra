<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="project.models.*"%>
<%@page import="java.util.*"%>
<% List <Taille> liste = (List<Taille>)request.getAttribute("liste"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display tailles</title>
</head>
<body>
	<ul>
	<% for(Taille taille : liste) { %>
		<li><% out.println(taille.getDesignation()); %></li>
	<% } %>
	</ul>
</body>
</html>