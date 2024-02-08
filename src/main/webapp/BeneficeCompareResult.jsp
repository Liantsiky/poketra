<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="project.models.*"%>
<%@page import="java.util.*"%>
<% List <ModeleBenefice> liste = (List<ModeleBenefice>)request.getAttribute("liste"); %>
<% double min = (double) request.getAttribute("minimum"); %>
<% double max = (double) request.getAttribute("maximum"); %>

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
              Liste sac compris dont le benefice est compris entre <%=min %>  et <%=max %>
            </h4>
            <div class="w-full mb-8 overflow-hidden rounded-lg shadow-xs">
              <div class="w-full overfloout.println(lookMatiere.getMatiere().getDesignation()); w-x-auto">
                <table class="w-full whitespace-no-wrap">
                  <thead>
                    <tr
                      class="text-xs font-semibold tracking-wide text-left text-gray-500 uppercase border-b dark:border-gray-700 bg-gray-50 dark:text-gray-400 dark:bg-gray-800"
                    >
                      <th class="px-4 py-3">Modele</th>
                      <th class="px-4 py-3">Prix total</th>

                    </tr>
                  </thead>
                  <tbody
                    class="bg-white divide-y dark:divide-gray-700 dark:bg-gray-800"
                  >
                    
					<% for(ModeleBenefice modeleBenefice : liste) { %>
                    <tr class="text-gray-700 dark:text-gray-400">
                      
                      <td class="px-4 py-3 text-sm">
                       <%=modeleBenefice.getModele().getId() %>
                      </td>
                      <td class="px-4 py-3 text-sm">
                       <%=modeleBenefice.getBenefice() %>
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