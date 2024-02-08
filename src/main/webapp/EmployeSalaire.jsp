<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="project.models.*"%>
<%@page import="java.util.*"%>
<% List <EmployeSalaire> liste = (List<EmployeSalaire>)request.getAttribute("liste"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Matieres correspondants</title>
</head>

<jsp:include page="index.jsp" /> 
<body>

<div class="flex flex-col flex-1">
   	<main class="h-full pb-16 overflow-y-auto">
   	<div class="container grid px-6 mx-auto">
<h4
              class="mb-4 text-lg font-semibold text-gray-600 dark:text-gray-300"
            >
              Liste des employes avec leur niveau
            </h4>
            <div class="w-full mb-8 overflow-hidden rounded-lg shadow-xs">
              <div class="w-full overfloout.println(lookMatiere.getMatiere().getDesignation()); w-x-auto">
                <table class="w-full whitespace-no-wrap">
                  <thead>
                    <tr
                      class="text-xs font-semibold tracking-wide text-left text-gray-500 uppercase border-b dark:border-gray-700 bg-gray-50 dark:text-gray-400 dark:bg-gray-800"
                    >
                      <th class="px-4 py-3">Employe </th>
                      <th class="px-4 py-3">Poste</th>
                      <th class="px-4 py-3">Niveau</th>
                      <th class="px-4 py-3">Salaire de base</th>
                      <th class="px-4 py-3">Salaire</th>

                    </tr>
                  </thead>
                  <tbody
                    class="bg-white divide-y dark:divide-gray-700 dark:bg-gray-800"
                  >
                    
					<% for(EmployeSalaire employeSalaire : liste) { %>
                    <tr class="text-gray-700 dark:text-gray-400">
                      
                      <td class="px-4 py-3 text-sm">
                       <%=employeSalaire.getEmploye().getNom() %> <%=employeSalaire.getEmploye().getPrenom() %>
                      </td>
                      <td class="px-4 py-3 text-sm">
                       <%=employeSalaire.getPoste().getDesignation() %>
                      </td>
                      <td class="px-4 py-3 text-sm">
                       <%=employeSalaire.getNiveau() %>
                      </td>
                      <td class="px-4 py-3 text-sm">
                       <%=employeSalaire.getPoste().getTauxHoraire() %>
                      </td>
                      <td class="px-4 py-3 text-sm">
                       <%=employeSalaire.getSalaire() %>
                      </td>
                    </tr>
						<% } %>
                    
                  </tbody>
                </table>
              </div>
         
	
		
	
	</div>
</div>
</main>
</div>
	
</body>
</html>