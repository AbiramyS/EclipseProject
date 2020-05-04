<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ page import="com.model.User, com.DAO.UserDAO, com.DAOImpl.UserDAOImpl" %>
<%
User u=new User();
UserDAO userdao=new UserDAOImpl();


%>

<form action="EditUserServlet" method="POST">

FirstName: <input type="text" name="firstname"  value= "<%=u.getFirstName() %>"><br>
MiddleName: <input type="text" name="middlename" value= "<%=u.getMiddleName()%>"><br>
LastName: <input type="text" name="lastname" value= "<%=u.getLastName()%>"> <br>
Email: <input type="text" name="email" value= "<%=u.getEmail()%>"><br>
Password:<input type="password" name="password" value= "<%=u.getPassword()%>"><br>
AddressLine: <input type="text" name="address" value= "<%=u.getAddressline()%>"><br>
Street: <input type="text" name="street" value= "<%=u.getStreet()%>"><br>
City: <input type="text" name="city" value= "<%=u.getCity()%>"><br>
State: <input type="text" name="state" value= "<%=u.getState()%>"><br>
ZipCode:<input type="text" name="zipcode" value= "<%=u.getZipcode()%>"><br>
ProfileImage: <input type="image" name="image" value= "<%=u.getProfileImage()%>"><br>
UserStatus: <input type="text" name="userstatus" value= "<%=u.getStatus()%>"><br>
<input type="submit" value="EditUser">
</form>

</body>
</html>