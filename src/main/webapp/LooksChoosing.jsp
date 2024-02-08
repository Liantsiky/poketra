<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="project.models.*"%>
<%@page import="java.util.*"%>
<% List <Look> looksliste = (List<Look>)request.getAttribute("liste"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LooksChoosing</title>
</head>

<jsp:include page="index.jsp" /> 
<body>
<div class="flex flex-col flex-1">
   	<main class="h-full pb-16 overflow-y-auto">
	    <form action="looksChoosingResult.do" method="post">
	      <div class="container px-6 mx-auto grid">
          <h2 class="my-6 text-2xl font-semibold text-gray-700 dark:text-gray-200">
            Choisir un look pour voir les matieres correspondantes
          </h2>
          <div class="px-4 py-3 mb-8 bg-white rounded-lg shadow-md dark:bg-gray-800">
          
          
            
             <label class="block mt-4 text-sm">
                <span class="text-gray-700 dark:text-gray-400">
                  Look
                </span>
                <select
                  class="block w-full mt-1 text-sm dark:text-gray-300 dark:border-gray-600 dark:bg-gray-700 form-select focus:border-purple-400 focus:outline-none focus:shadow-outline-purple dark:focus:shadow-outline-gray"
                  name="idLook"
                >
                 	<% for (Look look : looksliste) { %>
                		<option value="<% out.print(look.getId()); %>"><% out.print(look.getDesignation()); %></option>
            		<% } %>
                </select>
              </label>
         
            <div>         
              <center><button
                  class="px-4 py-2 text-sm font-medium leading-5 text-white transition-colors duration-150 bg-purple-600 border border-transparent rounded-lg active:bg-purple-600 hover:bg-purple-700 focus:outline-none focus:shadow-outline-purple"
                >
                  Rechercher
              </button><center>
            </div>
          </div>
	      </div> 
     	</form>
	  </main>
	</div>
	
</body>
</html>