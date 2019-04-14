<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Log In</title>

	<link rel="shortcut icon" type="image/png" href="static/img/favicon.png"/>
    <link rel="stylesheet" href="static/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="static/bootstrap/css/bootstrap4.min.css">
    <script src="static/bootstrap/js/bootstrap4.min.js"></script>
    <script src="static/js/jquery.min.js"></script>
	
	<link rel="stylesheet" href="static/css/Google-Style-Login.css">
	<link rel="stylesheet" href="static/css/login.css">
	<script src="static/js/custom.js"></script>

</head>
<body>

	<div class="container">

	<% if(request.getParameter("status") != null && request.getParameter("status").equals("false")) { %>
		<div class="alert alert-danger" role="alert">
		<button type="button" class="close" data-dismiss="alert"><span>&times;</span></button>
		<strong>Error!</strong> Incorrect Login/Password</div>
	<% } %>
	
	<% if(request.getParameter("status") != null && request.getParameter("status").equals("true")) { %>
		<div class="alert alert-success" role="alert">
		<button type="button" class="close" data-dismiss="alert"><span>&times;</span></button>
		<strong>Success!</strong> Registration Successful</div>
	<% } %>
	
	<% if(request.getParameter("status") != null && request.getParameter("status").equals("password")) { %>
		<div class="alert alert-success" role="alert">
		<button type="button" class="close" data-dismiss="alert"><span>&times;</span></button>
		<strong>Success!</strong> Password Successfully Changed</div>
	<% } %>

	    <div class="login-card">
	        <form class="form-signin" action="shop/login" method="post">
	            <input class="form-control" name="email" type="text" required="" placeholder="Email address" autofocus="" id="inputEmail">
	            <input class="form-control" name="password" type="password" required="" placeholder="Password" id="inputPassword">
	            <div class="checkbox">
	                <div class="checkbox">
	                    <label>
	                        <input type="checkbox">Remember me</label>
	                </div>
	            </div>
	            <button class="btn btn-danger btn-block btn-lg btn-signin" type="submit">LOGIN </button>
	        </form><a href="shop/forgotPass" class="forgot-password">Forgot your password?</a>
	    </div>
	    <div class="Register-card text-center"><strong>Don't have an account? <a class="text-danger" href="shop/register">Register here</a></strong>
	    </div>    
		</div>
</body>
</html>