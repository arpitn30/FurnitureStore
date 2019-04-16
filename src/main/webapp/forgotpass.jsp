<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Forgot Password</title>
	
	<link rel="shortcut icon" type="image/png" href="static/img/favicon.png"/>
	<link rel="stylesheet" href="static/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="static/bootstrap/css/bootstrap4.min.css">
  	<script src="static/js/jquery.min.js"></script>
  	<script src="static/bootstrap/js/bootstrap4.min.js"></script>
    
    <link rel="stylesheet" href="static/css/form.css">
	<script src="static/js/custom.js"></script>
    
</head>

<body style="background-image: url(static/img/background.jpg); max-width: 100%;  background-size: cover;">
<div class="container">
	
	<% if(request.getParameter("status") != null && request.getParameter("status").equals("notexists")) { %>
		<div class="alert alert-danger" role="alert">
		<button type="button" class="close" data-dismiss="alert"><span>&times;</span></button>
		<strong>Error!</strong> This email is not registered!</div>
	<% } %>
	
	<% if(request.getParameter("status") != null && request.getParameter("status").equals("mismatch")) { %>
		<div class="alert alert-warning" role="alert">
		<button type="button" class="close" data-dismiss="alert"><span>&times;</span></button>
		<strong>Failed!</strong> The two passwords do not match</div>
	<% } %>
	
	<% if(request.getParameter("status") != null && request.getParameter("status").equals("incorrect")) { %>
		<div class="alert alert-danger" role="alert">
		<button type="button" class="close" data-dismiss="alert"><span>&times;</span></button>
		<strong>Error!</strong> The Old Password entered is Incorrect!</div>
	<% } %>
	
	<div class="row register-form">
        <div class="col-md-8 offset-md-2">
            <form class="custom-form" action="shop/forgotPass" method="post">
                <h1>Forgot Password</h1>
                <div class="form-row form-group">
                    <div class="col-sm-4 label-column"><label class="col-form-label" for="email-input-field">Email </label></div>
                    <div class="col-sm-6 input-column"><input class="form-control" type="email" name="email" required="" placeholder="Email" inputmode="email"></div>
                </div>
                <div class="form-row form-group">
                    <div class="col-sm-4 label-column"><label class="col-form-label">Security Question</label></div>
                    <div class="col-sm-6 input-column"><label class="col-form-label">What is the name of your best friend?</label></div>
                </div>
                <div class="form-row form-group">
                    <div class="col-sm-4 label-column"><label class="col-form-label" for="secQues-input-field">Answer</label></div>
                    <div class="col-sm-6 input-column"><input class="form-control" type="text" name="secQues" required="" placeholder="Answer to the security question"></div>
                </div>
                <div class="form-row form-group">
                    <div class="col-sm-4 label-column"><label class="col-form-label" for="password-input-field">New Password </label></div>
                    <div class="col-sm-6 input-column"><input class="form-control" type="password" name="password" required="" placeholder="New Password"></div>
                </div>
                <div class="form-row form-group">
                    <div class="col-sm-4 label-column"><label class="col-form-label" for="password2-input-field">Repeat New Password </label></div>
                    <div class="col-sm-6 input-column"><input class="form-control" type="password" name="password2" required="" placeholder="Retype New Password"></div>
                </div>
                <button class="btn rounded shadow submit-button" type="submit">Change Password</button>
             </form>
        </div>
    </div>
</div>
</body>

</html>