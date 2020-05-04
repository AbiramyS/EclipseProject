<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Post</title>
</head>
<body>
 <%@page import="com.model.*"  %>

<%  

Post p=new Post();
%>  
  


<form action="EditPostServlet" method="POST">

PostTitle:<input type="text" name="posttitle" value= "<%=p.getPostTitle() %>"><br>
PostContent:<input type="text" name="postcontent" value= "<%=p.getPostContent()%>"><br>
PostDate: <input type="date" name="postdate" value="<%=p.getPostDate() %>"><br>
PostImage: <input type="image" name="postimage" value= "<%=p.getPostImage()%>"><br>
<input type="submit" value="EditPost">


</form>

</body>
</html>