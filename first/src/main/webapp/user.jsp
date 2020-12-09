<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Page</title>
</head>
<body>
<h1>Hai ${name} </h1>
<h1>User Page</h1>

<form action="/products" >
<input type="submit" value="Products">
</form>

<form action="/cart" >
<input type="submit" value="cart">
</form>


</body>
</html>