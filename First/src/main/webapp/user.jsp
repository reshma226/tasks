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
 
    <div class="starter-template">
 

<h3>User Page</h3>
<table>
<tr>
<td><h3>Hai ${name}, welcome </h3></td>
<td><form action="/products" >
<input type="submit" value="Products">
</form>
</td>
<td></td>
<td>
<form action="/cart" >
<input type="submit" value="cart">
</form>
</td>
<td></td>
<td>
<form action="/logout" >
<input type="submit" value="logout">
</form>
</td>

</tr>
</table>
</div>

</div>
</body>
</html>