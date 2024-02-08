<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="project.models.*"%>
<%@page import="java.util.*"%>
<% List <Poste> postesliste = (List<Poste>)request.getAttribute("postes"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Employe</title>
</head>
<body>
	<h1>Insertion Employe</h1>
    <form action="employeInsert.do" method="post">
            <p>Nom: <input type="text" name="nom"></p>
            <p>Prenom: <input type="text" name="prenom"></p>
            <p>Poste: 
		        <select name = "idPoste">
		            <% for (Poste poste : postesliste) { %>
		                <option value="<% out.print(poste.getId()); %>"><% out.print(poste.getDesignation()); %></option>
		            <% } %>
		        </select> 
            <p>Date de naissance: <input type="date" name="dateDeNaissance"></p>     
            <p>Date d'embauche: <input type="date" name="dateEmbauche"></p>     
            	
            <p><input type="submit" value="OK"></p>
    </form>
</body>
</html>