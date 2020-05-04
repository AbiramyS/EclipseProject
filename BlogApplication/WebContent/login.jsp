<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Here</title>
</head>
<body>

<form action="LoginServlet" method="POST">

Email: <input type="text" name="email" placeholder="Please enter valid email"><br>
Password: <input type="password" name="password"><br>
<input type="submit" value="submit"><br>
<a href="register.jsp">Register</a>
</form>

</body>
</html>