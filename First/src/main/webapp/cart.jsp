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
  
   <div class="starter-template">
 

<h1>User Page</h1>
<table>
<tr>
<td><h1>Hi ${name}, welcome </h1></td>
<td><form action="/products" >
<input type="submit" value="Products">
</form>
</td>
<td>
<form action="/cart" >
<input type="submit" value="cart">
</form>
</td>
<td>
<form action="/logout" >
<input type="submit" value="logout">
</form>
</td>

</tr>
</table>
</div>
  <div class="starter-template">
   <h1>cart</h1>

   <table
    class="table table-striped table-hover table-condensed table-bordered">
    <tr>
     <th>Id</th>
     <th>product Name</th>
     <th>Price(per piece)</th>
     <th>Quantity</th>
     <th></th>
     <th></th>
     
    </tr>
    <c:forEach var="cart" items="${cart}">
     <tr>
      <td>${cart.id}</td>
      <td>${cart.pname}</td>
      <td>${cart.price }</td>
      <td>${cart.quantity}</td>
      
      
     </tr>
    </c:forEach>
   </table>
   
  </div>

 </div>

 <script type="text/javascript"
  src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>