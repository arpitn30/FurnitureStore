<%@page import="database.JDBC" %>
<%@page import="session.Session" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Balance</title>

	<link rel="stylesheet" href="static/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="static/bootstrap/css/bootstrap4.min.css">
  	<script src="static/js/jquery.min.js"></script>
  	<script src="static/js/popper.min.js"></script>
  	<script src="static/bootstrap/js/bootstrap4.min.js"></script>
	
	<link rel="stylesheet" href="static/css/Google-Style-Login.css">
	<script src="static/js/custom.js"></script>

</head>
<body style="background-image: url(static/img/walletBg.jpg); max-width: 100%;  background-size: cover;">
<jsp:include page="navbar.jsp"></jsp:include>

 	 <%		JDBC db = new JDBC();
			db.setConnection();
      %>   

 <div class="login-card">
 			<h5 class="underline" >Rs <%= db.getBalance(Session.getId()) %></h5>
	        <form class="form-signin" action="shop/user/addBalance" method="post">
	        	<input type="hidden" name="user_id" required="" value="<%= Session.getId() %>">
	            <input class="form-control" name="addBalance" type="text" required="" placeholder="Add Balance" autofocus="" ><br>
	            <button class="btn btn-primary btn-block btn-lg btn-signin" type="submit">Add Balance</button>
	    </form>
	    </div>  
</body>
</html>