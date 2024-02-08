<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="project.models.*"%>
<%@page import="java.util.*"%>
<% List <Look> looksliste = (List<Look>)request.getAttribute("looks"); %>
<% List <Taille> taillesliste = (List<Taille>)request.getAttribute("tailles"); %>
<% List <Type> typesliste = (List<Type>)request.getAttribute("types"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Confection-Time</title>
</head>
<body>
	<h1>Insertion Temps de confection</h1>
    <form action="confectionTimeInsert.do" method="post">
       
        <p>Look: 
        <select name = "idLook">
            <% for (Look look : looksliste) { %>
                <option value="<% out.print(look.getId()); %>"><% out.print(look.getDesignation()); %></option>
            <% } %>
        </select> 
         <p>Taille: 
        <select name = "idTaille">
            <% for (Taille taille : taillesliste) { %>
                <option value="<% out.print(taille.getId()); %>"><% out.print(taille.getDesignation()); %></option>
            <% } %>
        </select> 
         <p>Look: 
        <select name = "idType">
            <% for (Type type : typesliste) { %>
                <option value="<% out.print(type.getId()); %>"><% out.print(type.getDesignation()); %></option>
            <% } %>
        </select> 
        
         <p>Temps (minutes): <input type="number"  name="temps"></p>
         
        <p><input type="submit" value="OK"></p>
    </form>
</body>
</html>