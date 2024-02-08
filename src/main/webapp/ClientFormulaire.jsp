<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Client</title>
</head>
<body>
	<h1>Insertion Client</h1>
    <form action="clientInsert.do" method="post">
    		<p>Nom:  <input type="text" name="nom"></p> 
    		 <p>Look: 
		       <select name = "genre">
		         	<option value="true">Homme</option>
		            <option value="false">Femme</option>
		       </select> 
            <p>Date de Naissance: <input type="date" name="dateDeNaissance"></p>
            <p><input type="submit" value="OK"></p>
    </form>
</body>
</html>