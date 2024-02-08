<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="project.models.*"%>
<%@page import="java.util.*"%>
<% List <Look> looksliste = (List<Look>)request.getAttribute("looks"); %>
<% List <Taille> taillesliste = (List<Taille>)request.getAttribute("tailles"); %>
<% List <Matiere> matieresliste = (List<Matiere>)request.getAttribute("matieres"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Confection-Matiere</title>
</head>
<body>
	<h1>Insertion Quantite de confection</h1>

    <form action="confectionMatiereInsert.do" method="post">
        <%-- <p>Designation: <input type="text" name="designation"></p> --%>
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
         <p>Matiere: 
        <select name = "idMatiere">
            <% for (Matiere matiere : matieresliste) { %>
                <option value="<% out.print(matiere.getId()); %>"><% out.print(matiere.getDesignation()); %></option>
            <% } %>
        </select> 
        
         <p>Quantite: <input type="number" step="0.1" name="quantite"></p>
         
        <p><input type="submit" value="OK"></p>
    </form>
</body>
</html>