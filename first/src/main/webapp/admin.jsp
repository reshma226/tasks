<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
</head>
<body>
<h1>Hi ${name}</h1>

<form action="/users" >
<input type="submit" value="User List">

</form>
<form action="/inventory" >
<input type="submit" value="Product List">

</form>
<form action="/requests" >

<input type="submit" value="Request List">
</form>

</body>
</html>