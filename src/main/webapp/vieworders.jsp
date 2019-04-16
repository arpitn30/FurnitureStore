<%@page import="models.Furniture"%>
<%@page import="models.Order"%> 
<%@page import="database.JDBC" %>
<%@page import="session.Session" %>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Orders</title>

	<link rel="shortcut icon" type="image/png" href="static/img/favicon.png"/>
	<link rel="stylesheet" href="static/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="static/bootstrap/css/bootstrap4.min.css">
  	<script src="static/js/jquery.min.js"></script>
  	<script src="static/js/popper.min.js"></script>
  	<script src="static/bootstrap/js/bootstrap4.min.js"></script>
    
    <link rel="stylesheet" href="static/css/Navbar-Apple.css">
	<script src="static/js/custom.js"></script>

</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>

	<div class="container">
	
	<% if(request.getParameter("status") != null && request.getParameter("status").equals("success")) { %>
		<div class="alert alert-success" role="alert">
		<button type="button" class="close" data-dismiss="alert"><span>&times;</span></button>
		<strong>Success!</strong> Your order has been successfully placed</div>
	<% } %>
	
    	<table class="table table-hover">
    	<thead class="thead-dark">
    		<tr align="center">
	    		<th></th>
	    		<th>Furniture Name</th>
	    		<th>Furniture Price</th>
	    		<th>Quantity</th>
	    		<th>Total Cost</th>
	    		<th>Order Date</th>
        	</tr>
        </thead>
        <tbody>
    	<%
    		JDBC db = new JDBC();
			db.setConnection();
			ArrayList<Order> data = db.getOrders(Session.getId());
        	for(Order order: data){
        		Furniture fur = db.getFurniture(order.getFurniture_id());
        %> 
    		<tr align="center">
    			<td><img height="45px" width="45px" class="img-circle img-responsive" src=<%= fur.getImage() %>></td>
    			<td><%= fur.getName() %></td>
    			<td>Rs <%= fur.getPrice() %></td>
    			<td><%= order.getQuantity() %></td>
    			<td>Rs <%= order.getTotalAmount() %></td>
    			<td><%= order.getOrderDate() %></td>
    		</tr>    	
    	<% 
    		}
        	db.closeConnection();
    	%> 
    	</tbody>
    	</table>
    </div>

</body>
</html>