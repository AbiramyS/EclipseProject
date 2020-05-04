<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Comment</title>
</head>
<body>

<%@page import= "com.model.* "%>
<%  

Comment c=new Comment();
%>  

<form action="EditCommentServlet" method="POST">
Comment:<input type="text" name="comment"  value= "<%=c.getComment() %>"><br>
CommentDate: <input type="date" name="commentdate" value= "<%=c.getCommentDate() %>"><br>
<input type="submit" value="Edit">
</form>

</body>
</html>