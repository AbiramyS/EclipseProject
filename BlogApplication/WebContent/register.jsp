<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Here</title>
</head>
<body>

<form action="RegisterServlet" method="POST">

FirstName: <input type="text" name="firstname"><br>
MiddleName: <input type="text" name="middlename"><br>
LastName: <input type="text" name="lastname"><br>
Email: <input type="text" name="email"><br>
Password:<input type="password" name="password"><br>
AddressLine: <input type="text" name="address"><br>
Street: <input type="text" name="street"><br>
City: <input type="text" name="city"><br>
State: <input type="text" name="state"><br>
ZipCode:<input type="text" name="zipcode"><br>
ProfileImage: <input type="file" name="image"><br>
UserStatus: <input type="text" name="userstatus"><br>
<input type="submit" value="submit"><br>
<a href="login.jsp">Login</a>
</form>

</body>
</html>