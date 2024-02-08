<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert montant</title>
</head>
<jsp:include page="index.jsp" /> 
<body>
	<div class="flex flex-col flex-1">
   	<main class="h-full pb-16 overflow-y-auto">
	    <form action="confectionPriceCompareResult.do" method="post">
	      <div class="container px-6 mx-auto grid">
          <h2 class="my-6 text-2xl font-semibold text-gray-700 dark:text-gray-200">
            Inserer deux (2) montants 
          </h2>
          <div class="px-4 py-3 mb-8 bg-white rounded-lg shadow-md dark:bg-gray-800">
            <label class="block text-sm">
              <span class="text-gray-700 dark:text-gray-400">Minimum</span>
              <input
                class="block w-full mt-1 text-sm dark:border-gray-600 dark:bg-gray-700 focus:border-purple-400 focus:outline-none focus:shadow-outline-purple dark:text-gray-300 dark:focus:shadow-outline-gray form-input"
                type="text"
                name = "minimum"
              />
            </label>  
             <label class="block text-sm">
              <span class="text-gray-700 dark:text-gray-400">Maximum</span>
              <input
                class="block w-full mt-1 text-sm dark:border-gray-600 dark:bg-gray-700 focus:border-purple-400 focus:outline-none focus:shadow-outline-purple dark:text-gray-300 dark:focus:shadow-outline-gray form-input"
                type="text"
                name = "maximum"
              />
            </label>  
            <div>         
              <center><button
                  class="px-4 py-2 text-sm font-medium leading-5 text-white transition-colors duration-150 bg-purple-600 border border-transparent rounded-lg active:bg-purple-600 hover:bg-purple-700 focus:outline-none focus:shadow-outline-purple"
                >
                  Inserer
              </button><center>
            </div>
          </div>
	      </div> 
     	</form>
	  </main>
	</div>
</body>
</html>