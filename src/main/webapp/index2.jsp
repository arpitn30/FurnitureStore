<%@page import="models.Furniture"%> 
<%@page import="database.JDBC" %>
<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>Furniture</title>

	<link rel="shortcut icon" type="image/png" href="static/img/favicon.png"/>
	<link rel="stylesheet" href="static/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="static/css/Navbar-Apple.css">
    <link rel="stylesheet" href="static/css/card.css">
    <link rel="stylesheet" href="static/bootstrap/css/bootstrap4.min.css">
    <script src="static/bootstrap/js/bootstrap4.min.js"></script>
	<script src="static/js/jquery.min.js"></script>

</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>

<div class="wrapper">
  <div class="cols">
  
  		<%
    		JDBC db = new JDBC();
			db.setConnection();
			ArrayList<Furniture> data = db.getFurniture();
			db.closeConnection();
        	for(Furniture fur: data){
        %> 
			<div class="col" ontouchstart="this.classList.toggle('hover');">
				<div class="container">
					<div class="front" style="background-image: url(<%= fur.getImage() %>);">
						<div class="inner">
						</div>
					</div>
					<div class="back">
						<div class="inner">
						  <span><%= fur.getName() %></span>
						  <p class="card-text">Price: Rs <%= fur.getPrice() %><br>Room: <%= fur.getRoom() %><br> Type: <%= fur.getType() %></p>
               			  <input class="form-control" id="quantity<%= fur.getId() %>" type="number" placeholder="Quantity" value=1><br>
               			  <a href="shop/user/addToCart?fid=<%= fur.getId() %>&quantity=" class="btn btn-info float-left" id="add<%= fur.getId() %>" onclick="setAddURL(<%= fur.getId() %>)">Add to Cart</a>
               			  <a href="shop/user/buyNow?fid=<%= fur.getId() %>&quantity=" class="btn btn-success float-right" id="buy<%= fur.getId() %>" onclick="setBuyURL(<%= fur.getId() %>)"> Buy Now </a>
						</div>
					</div>
				</div>
			</div>
			<% } %>
			
		</div>
 </div>
</body>
</html>