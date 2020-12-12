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
   <h1>Hi ${name}, welcome </h1>
  </header>
  <div class="starter-template">
   <h1>Products List</h1>
     
   <table
    class="table table-striped table-hover table-condensed table-bordered">
    <tr>
     <th>Id</th>
     <th>Name</th>
     <th>Price(per piece)</th>
     <th>Quantity Remaining</th>
     
    </tr>
    <c:forEach var="product" items="${products}">
     <tr>
      <td>${product.id}</td>
      <td>${product.name}</td>
      <td>${product.price }</td>
      <td>${product.quantity}</td>
      
      
     </tr>
    </c:forEach>
   </table>
   
  </div>

 </div>

 <script type="text/javascript"
  src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>