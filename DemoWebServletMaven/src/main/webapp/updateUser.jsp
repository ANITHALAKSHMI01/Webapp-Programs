<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update User</title>
</head>
<body>
	<%
		int id=Integer.parseInt(request.getParameter("id"));
	%>
	<form action="UpdateUser" method="get">
		User Id : <input type=number id="userId" name="id" value="<%=id%>" readonly> <br><br>
	    Email :<input type=email name="emailId" id="email"><br><br>
	    <button>Edit</button>
	</form>
</body>
</html>