<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Register</title>
	<link rel="shortcut icon" type="image/png" href="static/img/favicon.png"/>
    <script src="static/js/jquery.min.js"></script>
    <script src="static/bootstrap/js/bootstrap4.min.js"></script>
    <link rel="stylesheet" href="static/bootstrap/css/bootstrap4.min.css">
    <link rel="stylesheet" href="static/css/form.css">
    
    <% if(request.getParameter("status") != null && request.getParameter("status").equals("exists")) { %>
		<script>alert("This email is already registered");</script>
	<% } %>
	
	<% if(request.getParameter("status") != null && request.getParameter("status").equals("mismatch")) { %>
		<script>alert("The passwords don't match");</script>
	<% } %>
    
</head>

<body style="background-image: url(static/img/background.jpg); max-width: 100%;  background-size: cover;">
	<div class="row register-form">
        <div class="col-md-8 offset-md-2">
            <form class="custom-form" action="shop/register" method="post">
                <h1>Register Form</h1>
                <div class="form-row form-group">
                    <div class="col-sm-4 label-column"><label class="col-form-label" for="name-input-field">Name </label></div>
                    <div class="col-sm-6 input-column"><input class="form-control" type="text" name="name" required="" placeholder="Name"></div>
                </div>
                <div class="form-row form-group">
                    <div class="col-sm-4 label-column"><label class="col-form-label" for="email-input-field">Email </label></div>
                    <div class="col-sm-6 input-column"><input class="form-control" type="email" name="email" required="" placeholder="Email" inputmode="email"></div>
                </div>
                <div class="form-row form-group">
                    <div class="col-sm-4 label-column"><label class="col-form-label" for="password-input-field">Password </label></div>
                    <div class="col-sm-6 input-column"><input class="form-control" type="password" name="password" required="" placeholder="Password"></div>
                </div>
                <div class="form-row form-group">
                    <div class="col-sm-4 label-column"><label class="col-form-label" for="password2-input-field">Repeat Password </label></div>
                    <div class="col-sm-6 input-column"><input class="form-control" type="password" name="password2" required="" placeholder="Retype Password"></div>
                </div>
                <div class="form-row form-group">
                    <div class="col-sm-4 label-column"><label class="col-form-label" for="password2-input-field">Security Question</label></div>
                    <div class="col-sm-6 input-column"><label class="col-form-label">What is the name of your best friend?</label></div>
                </div>
                <div class="form-row form-group">
                    <div class="col-sm-4 label-column"><label class="col-form-label" for="secQues-input-field">Answer</label></div>
                    <div class="col-sm-6 input-column"><input class="form-control" type="text" name="secQues" required="" placeholder="Answer to the security question"></div>
                </div>
                <div class="form-check"><input class="form-check-input" type="checkbox" required="" id="formCheck-2"><label class="form-check-label" for="formCheck-2">I've read and accept the terms and conditions</label></div>
                <button class="btn rounded shadow submit-button" type="submit">Register</button>
             </form>
        </div>
    </div>
</body>

</html>