<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="project.models.*"%>
<%@page import="java.util.*"%>
<% List <Type> liste = (List<Type>)request.getAttribute("liste"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Type</title>
</head>
<body>
	<ul>
	<% for(Type type : liste) { %>
		<li><% out.println(type.getDesignation()); %></li>
	<% } %>
	</ul>
</body>
</html>