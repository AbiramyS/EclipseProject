<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Users List</title>
</head>
<body>

<%@ page import="com.controller.*, com.DAO.UserDAO, com.model.User, com.DAOImpl.UserDAOImpl"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>

<h1>Users List</h1> 

<%  
UserDAO userdao=new UserDAOImpl();
List<User> list=userdao.getListOfUser();
request.setAttribute("list",list);
%>  
<table border="1" width="90">
<tr>
<th>First Name</th>
<th>Middle Name</th>
<th>Last Name</th>
<th>Email</th>
<th>Address</th>
<th>Street</th>
<th>City</th>
<th>State</th>
<th>Zipcode</th>
<th>Edit</th>
<th>Delete</th>
</tr>

<c:forEach items="${list}" var="u">

<tr>

<td>${u.getFirstName()}</td>
<td>${u.getMiddleName()}</td>
<td>${u.getLastName()}</td>
<td>${u.getEmail()}</td>
<td>${u.getAddressline()}</td>
<td>${u.getStreet()}</td>
<td>${u.getCity()}</td>
<td>${u.getState()}</td>
<td>${u.getZipcode()}</td>

<td><a href="edituser.jsp?id=${u.getUserId()}">Edit</a></td>  
<td><a href="deleteuser.jsp?id=${u.getUserId()}">Delete</a></td> 
</tr>
</c:forEach>
</table>

<br/><a href="register.jsp">Add New User</a>

</body>
</html>