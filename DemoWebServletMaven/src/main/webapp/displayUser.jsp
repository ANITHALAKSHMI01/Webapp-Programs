<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.chainsys.model.Demo" %>
    <%@ page import="java.util.List" %>
     <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Details</title>
</head>
<body>
	<table border="1px" cellspacing="0px">
	<thead>
		<tr>
			<th>User Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Edit</th>
			<th>Delete</th>
	   </tr>
	</thead>
	<tbody>
			<%
			List<Demo> list=(ArrayList<Demo>)request.getAttribute("list");
			 if (list != null && !list.isEmpty())
			  {
				  try
				  {
				  		for (Demo demo : list)
				  		{
				
			%>
			<tr>
				<td><%=demo.getId()%></td>
				<td><%=demo.getName()%></td>
				<td><%=demo.getEmail()%></td>
				<td>
					<form action="updateUser.jsp">
                         <input type="hidden" name="id" value="<%= demo.getId()%>">
							<button>Edit</button>
					</form>
				</td>
				<td>
					<form action="DemoServlet1" method="post">
                     <input type="hidden" name="deleteId" value="<%=demo.getId()%>">
                     <input type="submit" id="button" name="delete" value="Delete" class="button">
                </form>
				</td>
			<%
			   }
				  		
				  }
				  catch (Exception e) 
				  { 
						e.printStackTrace();
				  }
			  } 
				else 
				{
	        %>
	        </tr>
	        <tr>
	            <td colspan="15">No Records found</td>
	        </tr>
	        <%
	        }
	        %>
		</tbody>
</table>
</body>
</html>