<%@page import="models.Furniture"%> 
<%@page import="database.JDBC" %>
<%@page import="session.Session" %>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Admin Home</title>
    
    <link rel="shortcut icon" type="image/png" href="static/img/favicon.png"/>
    <link rel="stylesheet" href="static/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="static/bootstrap/css/bootstrap4.min.css">
    <script src="static/bootstrap/js/bootstrap4.min.js"></script>
    <script src="static/js/jquery.min.js"></script>
    
    <link rel="stylesheet" href="static/css/Navbar-Apple.css">
    <script src="static/js/custom.js"></script>

</head>

<body>
<jsp:include page="adminnav.jsp"></jsp:include>
    <div class="container">
    
    <% if(request.getParameter("status") != null && request.getParameter("status").equals("added")) { %>
		<div class="alert alert-success" role="alert">
		<button type="button" class="close" data-dismiss="alert"><span>&times;</span></button>
		<strong>Success!</strong> Furniture Added to the Database</div>
	<% } %>
    
    	<table class="table table-hover">
		<thead class="thead-dark">
			<tr align="center">
				<th></th>
				<th>Furniture Name</th>
				<th>Furniture Type</th>
				<th>Room</th>
				<th>Price</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
    	<%
    		JDBC db = new JDBC();
			db.setConnection();
			ArrayList<Furniture> data = db.getFurniture();
			db.closeConnection();
        	for(Furniture fur: data){
        %> 
    		<tr align="center">
    			<td><img height="40px" width="40px" class="img-rounded img-responsive" src=<%= fur.getImage() %>></td>
    			<td><%= fur.getName() %></td>
    			<td><%= fur.getType() %></td>
    			<td><%= fur.getRoom() %></td>
    			<td><%= fur.getPrice() %></td>
    			<td><a class="btn btn-info" href="shop/admin/editFurniture?fid=<%= fur.getId() %>">Edit</a></td>
    			<td><a class="btn btn-success" href="shop/admin/deleteFurniture?fid=<%= fur.getId() %>">Delete</a></td>
    		</tr>    	
    	<% 
    		} 
		%>
		</tbody>
    	</table>
    </div>
</body>

</html>