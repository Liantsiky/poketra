<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="project.models.*"%>
<%@page import="java.util.*"%>
<% List <Matiere> liste = (List<Matiere>)request.getAttribute("liste"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Matiere</title>
</head>
<body>
	<ul>
	<% for(Matiere matiere : liste) { %>
		<li><% out.println(matiere.getDesignation()); %></li>
	<% } %>
	</ul>
</body>
</html>