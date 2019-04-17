<%@page import="models.Furniture"%> 
<%@page import="database.JDBC" %>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>

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
		function setAddURL(id){
			var add = document.getElementById('add' + id);
			add.href = add.getAttribute("href") + getQuantity(id);
			return;
		}
		
		function setBuyURL(id){
			var buy = document.getElementById('buy' + id);
			buy.href = buy.getAttribute("href") + getQuantity(id);
			return;
		}
		
		function getQuantity(id){
			return document.getElementById("quantity" + id).value;
		}
	</script>

</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<jsp:include page="searchbar.jsp"></jsp:include>
	<%
    	JDBC db = new JDBC();
		db.setConnection();
		ArrayList<Furniture> data;
		if(request.getParameter("name") == null)
			data = db.getFurniture();
		else
			data = db.getFurniture(request.getParameter("name"), request.getParameter("type"), request.getParameter("room"), request.getParameter("min"), request.getParameter("max"));
		db.closeConnection();
	%> 
<div class="container">
	
	<% if(request.getParameter("status") != null && request.getParameter("status").equals("added")) { %>
		<div class="alert alert-success" role="alert">
		<button type="button" class="close" data-dismiss="alert"><span>&times;</span></button>
		<strong>Success!</strong> Item Added to Cart</div>
	<% } %>
	
	<% if(request.getParameter("status") != null && request.getParameter("status").equals("false")) { %>
		<div class="alert alert-danger" role="alert">
		<button type="button" class="close" data-dismiss="alert"><span>&times;</span></button>
		<strong>Error!</strong> Invalid quantity</div>
	<% } %>

   <div class="row">
      <% for(Furniture fur: data){ %>     
      <div class="col-md-4">
         <div class="card">
         	<div class="embed-responsive embed-responsive-4by3">
            	<img class="card-img-top embed-responsive-item" src="<%= fur.getImage() %>" alt="Card image cap">
           	</div>
            <div class="card-body">
               <h5 class="card-title border-bottom pb-3" align="center"><%= fur.getName() %></h5>
               <p class="card-text" align="center">Rs <%= fur.getPrice() %></p>
               <input class="form-control" id="quantity<%= fur.getId() %>" type="number" placeholder="Quantity" value=1><br>
               <a href="shop/user/addToCart?fid=<%= fur.getId() %>&quantity=" class="btn btn-info float-left" id="add<%= fur.getId() %>" onclick="setAddURL(<%= fur.getId() %>)">Add to Cart</a>
               <a href="shop/user/buyNow?fid=<%= fur.getId() %>&quantity=" class="btn btn-success float-right" id="buy<%= fur.getId() %>" onclick="setBuyURL(<%= fur.getId() %>)"> Buy Now </a>
            </div>
         </div>
      </div>
      <% } %>    
   </div>
</div>

</body>
</html>