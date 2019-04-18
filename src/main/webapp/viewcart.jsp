<%@page import="models.Furniture"%>
<%@page import="models.Order"%> 
<%@page import="database.JDBC" %>
<%@page import="database.Local" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Cart</title>

	<link rel="shortcut icon" type="image/png" href="static/img/favicon.png"/>
	<link rel="stylesheet" href="static/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="static/bootstrap/css/bootstrap4.min.css">
  	<script src="static/js/jquery.min.js"></script>
  	<script src="static/js/popper.min.js"></script>
  	<script src="static/bootstrap/js/bootstrap4.min.js"></script>
	
	<link rel="stylesheet" href="static/css/Navbar-Apple.css">
	<link href="static/css/index.css" rel="stylesheet"/>
	<script src="static/js/custom.js"></script>

	<script type="text/javascript">
		function setEditURL(id){
			var edit = document.getElementById('edit' + id);
			edit.href = edit.getAttribute("href") + getQuantity(id);
			return;
		}
		
		function getQuantity(id){
			return document.getElementById("quantity" + id).value;
		}
	</script>

</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>

<div class="container">

	<% if(request.getParameter("status") != null && request.getParameter("status").equals("deleted")) { %>
		<div class="alert alert-danger" role="alert">
		<button type="button" class="close" data-dismiss="alert"><span>&times;</span></button>
		<strong>Success!</strong> Item Deleted from the Cart</div>
	<% } %>
	
	<% if(request.getParameter("status") != null && request.getParameter("status").equals("lowbalance")) { %>
		<div class="alert alert-danger" role="alert">
		<button type="button" class="close" data-dismiss="alert"><span>&times;</span></button>
		<strong>Error!</strong> Your account balance is insufficient!</div>
	<% } %>
	
	<% if(request.getParameter("status") != null && request.getParameter("status").equals("false")) { %>
		<div class="alert alert-danger" role="alert">
		<button type="button" class="close" data-dismiss="alert"><span>&times;</span></button>
		<strong>Error!</strong> Invalid quantity</div>
	<% } %>

   <div class="row">
      <% 	JDBC db = new JDBC();
			db.setConnection();
      		for(Order order: Local.getCart()){ 
      			Furniture fur = db.getFurniture(order.getFurniture_id());
      %>     
      <div class="col-md-4">
         <div class="card">
            <div class="embed-responsive embed-responsive-4by3">
            	<img class="card-img-top embed-responsive-item" src="<%= fur.getImage() %>" alt="Card image cap">
           	</div>
            <div class="card-body">
               <h5 class="card-title border-bottom pb-3" align="center"><%= fur.getName() %></h5>
               <p class="card-text" align="center"><strong>Price:</strong> Rs <%= fur.getPrice() %><br><strong>Total Cost:</strong> Rs <%= order.getTotalAmount() %></p>
               <input class="form-control" id="quantity<%= fur.getId() %>" type="number" placeholder="Quantity" value=<%= order.getQuantity() %>><br>
               <a href="shop/user/editCart?fid=<%= fur.getId() %>&quantity=" class="btn btn-info float-left" id="edit<%= fur.getId() %>" onclick="setEditURL(<%= fur.getId() %>)">Edit</a>
               <a href="shop/user/deleteFromCart?fid=<%= fur.getId() %>" class="btn btn-danger float-right">Delete</a>
            </div>
         </div>
      </div>
      <% }
      	 db.closeConnection();
      %>    
   </div>
</div>

<% if(!Local.getCart().isEmpty()) { %>
<div class="col-md-8 offset-md-2" align="center">
	<form action="shop/user/purchase">
		<button class="btn btn-success rounded submit-button" type="submit" >Buy Now</button>
	</form>
</div><br>
<% } %>

</body>
</html>