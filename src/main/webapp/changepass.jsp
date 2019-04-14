<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

	<link rel="shortcut icon" type="image/png" href="static/img/favicon.png"/>
    <link rel="stylesheet" href="static/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="static/bootstrap/css/bootstrap4.min.css">
    <script src="static/bootstrap/js/bootstrap4.min.js"></script>
    <script src="static/js/jquery.min.js"></script>
    
    <link rel="stylesheet" href="static/css/Navbar-Apple.css">
    <link rel="stylesheet" href="static/css/Login-Form-Dark.css">

	<% if(request.getParameter("status") != null && request.getParameter("status").equals("mismatch")) { %>
		<script>alert("The passwords don't match");</script>
	<% } %>
	
	<% if(request.getParameter("status") != null && request.getParameter("status").equals("incorrect")) { %>
		<script>alert("The Old Password entered is Incorrect");</script>
	<% } %>
	
	<% if(request.getParameter("status") != null && request.getParameter("status").equals("true")) { %>
		<script>alert("Changed Password Successfully");</script>
	<% } %>

</head>
<body class="login-dark">
<jsp:include page="navbar.jsp"></jsp:include>
	<div>
        <form action="shop/user/changePass" method="post">
            <h2 class="sr-only">Change Password</h2>
            <div class="form-group"><input class="form-control" type="password" name="oldpass" required="" placeholder="Old Password"></div>
            <div class="form-group"><input class="form-control" type="password" name="newpass" required="" placeholder="New Password"></div>
            <div class="form-group"><input class="form-control" type="password" name="newpass2" required="" placeholder="Retype New Password"></div>
            <div class="form-group"><button class="btn btn-primary btn-block" type="submit">Log In</button></div>
        </form>
    </div>
</body>
</html>