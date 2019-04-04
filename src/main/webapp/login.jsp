<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Log In</title>

    <!-- documentation at http://getbootstrap.com/, alternative themes at https://www.bootstrapcdn.com/bootswatch/ -->
    <link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>

    <script src="static/js/jquery-3.2.0.min.js"></script>
    <script src="static/bootstrap/js/bootstrap.min.js"></script>

	<link rel="stylesheet" href="static/css/Google-Style-Login.css">
	<link rel="stylesheet" href="static/css/login.css">
	
	<% if(request.getParameter("status") != null && request.getParameter("status").equals("false")) { %>
		<script>alert("Incorrect Login/Password");</script>
	<% } %>
	
	<% if(request.getParameter("status") != null && request.getParameter("status").equals("true")) { %>
		<script>alert("Registration Successful");</script>
	<% } %>

</head>
<body style="background-image: url(static/img/background.jpg); max-width: 100%;  background-size: cover;">

	<div class="container">

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
	        </form><a href="#" class="forgot-password">Forgot your password?</a>
	        <p> </p>
	    </div>
	    <div class="Register-card text-center"><strong><strong>Don't have an</strong> <strong>account?</strong> <a class="text-danger" href="shop/register"><strong>Register</strong> <strong>here</strong></a></strong>
	    </div>    
		</div>
</body>
</html>