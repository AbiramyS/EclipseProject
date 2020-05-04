<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Post</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/PostServlet" method="POST">

PostTitle:<input type="text" name="posttitle"><br>
PostContent:<input type="text" name="postcontent"><br>
PostDate: <input type="date" name="postdate">
PostImage: <input type="image" name="postimage">
<input type="submit" value="submit">


</form>

</body>
</html>