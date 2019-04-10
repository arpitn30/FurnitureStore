<%@page import="models.Furniture"%> 
<%@page import="database.JDBC" %>
<%@page import="session.Session" %>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

	<link rel="shortcut icon" type="image/png" href="static/img/favicon.png"/>
    <link href="static/css/card.css" rel="stylesheet"/>
    <link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="static/bootstrap/js/bootstrap.min.js"></script>
	<script src="static/js/jquery-3.2.0.min.js"></script>

</head>
<body>


    <nav class="navbar navbar-dark navbar-expand-md fixed-top bg-dark" style="height:45px;">
        <div class="container-fluid"><a class="navbar-brand" href="shop/">Furniture Store</a><button class="navbar-toggler" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navcol-1">
                <ul class="nav navbar-nav flex-grow-1 justify-content-between">
                    <!--li class="nav-item" role="presentation"><a class="nav-link active" href="#"><i class="fa fa-apple apple-logo"></i></a></li-->
                    <li class="nav-item" role="presentation"></li>
                    <li class="nav-item" role="presentation"><a class="nav-link active" href="#"><i class="fa fa-shopping-bag"></i>  View Cart</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link active" href="#"><i class="fa fa-history"></i>  View All Orders</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link active" href="#">iPhone</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link active" href="#">Watch</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link active" href="#">TV</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link active" href="#">Change Password</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link active" href="#">Support</a></li>
                    <% if(Session.getId() == -1) { %>
                    <li class="nav-item" role="presentation"><a class="nav-link active" href="shop/register"><i class="fa fa-user-circle-o"></i>  Register</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link active" href="shop/login"><i class="fa fa-sign-in"></i>  Login</a></li>
                    <% } else {%>
                    <li class="nav-item dropdown" role="presentation"><a class="nav-link active dropdown-toggle" data-toggle="dropdown" href=""><i class="fa fa-user-circle-o"></i> <%= Session.getName() %></a>
                    	<span class="caret"></span></a>
				        <ul class="dropdown-menu dropdown-dark dropdown-menu-right">
				          <li class="dropdown-item"><a href="shop/logout">Logout</a></li>
				        </ul>
                    </li>
                    <% } %>
                </ul>
            </div>
        </div>
    </nav>
    <br><br><br>



<div class="wrapper">
  <h1>Parallax Flipping Cards</h1>
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
					<div class="front" style="background-image: url(static/img/furniture/default.png)">
						<div class="inner">
							<p>Diligord</p>
              				<span>Lorem ipsum</span>
						</div>
					</div>
					<div class="back">
						<div class="inner">
						  <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Alias cum repellat velit quae suscipit c.</p><br>
						  <a class="btn btn-primary">Edit</a><br>
						  <a class="btn btn-primary">Delete</a>
						</div>
					</div>
				</div>
			</div>
			<% } %>
			
		</div>
 </div>
</body>
</html>