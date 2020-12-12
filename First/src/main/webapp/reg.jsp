<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
Registration page
<div align="center">

<form action="/register" method="post">
First name <input type="text" name="firstName"><br><br>
Last name <input type="text" name="lastName"><br><br>
User name <input type="text" name="username"><br><br>
password <input type="password" name="password"><br><br>
Mail id <input type="email" name="mail"><br><br>
phone number <input type="number" name="phoneno"><br><br>
<input type="submit" value="Register"  ><br><br><br>

</form>

</div>
</body>
</html>