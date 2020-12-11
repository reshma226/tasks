<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Page</title>
</head>
<body>
<div class="container">
  <header>
   <h1>Hi ${name}, welcome </h1>
  </header>
  <div class="starter-template">
 

<h1>User Page</h1>

<form action="/products" >
<input type="submit" value="Products">
</form>

<form action="/cart" >
<input type="submit" value="cart">
</form>

</div>
</div>
</body>
</html>