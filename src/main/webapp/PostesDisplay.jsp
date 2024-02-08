<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="project.models.*"%>
<%@page import="java.util.*"%>
<% List <Poste> liste = (List<Poste>)request.getAttribute("liste"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Poste</title>
</head>
<body>
	<ul>
	<% for(Poste poste : liste) { %>
		<li><% out.println(poste.getDesignation()); %></li>
	<% } %>
	</ul>
</body>
</html>