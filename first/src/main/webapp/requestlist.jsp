<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

<link rel="stylesheet" type="text/css"
 href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />

</head>
<body>
 <div class="container">
  <header>
   <h1>Hi Admin, welcome to List of Requests page</h1>
  </header>
  <div class="starter-template">
   <h1>Products List</h1>
  
   <table
    class="table table-striped table-hover table-condensed table-bordered">
    <tr>
     <th>User Id</th>
     <th>User Name</th>
     <th>Product Id</th>
     <th>Product Name</th>
     
    </tr>
    <c:forEach var="request" items="${requests}">
     <tr>
      <td>${request.uid}</td>
      <td>${request.uname}</td>
      <td>${request.pid }</td>
      <td>${request.pname}</td>
      
      
     </tr>
    </c:forEach>
   </table>
   
  </div>

 </div>

 <script type="text/javascript"
  src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>