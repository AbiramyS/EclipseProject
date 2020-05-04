<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Post</title>
</head>
<body>
<%@ page import="com.controller.*, com.DAO.PostDAO, com.model.Post, com.DAOImpl.PostDAOImpl"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>

<%  
PostDAO postdao=new PostDAOImpl();
List<Post> list=postdao.getListOfPost();
request.setAttribute("list",list);
%> 

<table border="1" width="90">
<tr>
<th>PostTitle</th>
<th>PostContent</th>
<th>Edit</th>
<th>Delete</th>
</tr>

<c:forEach items="${list}" var="p">
<tr>
<td>${p.getPostTitle()}</td>
<td>${p.getPostContent()}</td>

<td><a href="editpost.jsp?id=${p.getPostId()}">Edit</a></td>  
<td><a href="deletepost.jsp?id=${p.getPostId()}">Delete</a></td> 
</tr>
</c:forEach>

</table>


</body>
</html>