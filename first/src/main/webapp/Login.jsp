<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>
</head>
<body>
<h1>Login Form</h1>
<div align="center">
${error}
<form action="/login" method="post">

User name <input type="text" name="username"><br><br>
password <input type="password" name="password"><br><br>

<input type="submit" value="Login"  ><br><br><br>

<a href="reg.jsp">Not a registered user? click here</a>
</form>

</div>
</body>
</html>