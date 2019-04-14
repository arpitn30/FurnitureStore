<%@page import="models.Furniture"%>
<%@page import="database.JDBC" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Add Furniture</title>
	
	<link rel="shortcut icon" type="image/png" href="static/img/favicon.png"/>
    <link rel="stylesheet" href="static/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="static/bootstrap/css/bootstrap4.min.css">
    <script src="static/bootstrap/js/bootstrap4.min.js"></script>
    <script src="static/js/jquery.min.js"></script>
    
    <link rel="stylesheet" href="static/css/form.css">
    
    <% if(request.getParameter("status") != null && request.getParameter("status").equals("exists")) { %>
		<script>alert("This Product already exists");</script>
	<% } %>
	
	<% 
		Furniture fur = null;
		JDBC db = new JDBC();
		db.setConnection();
		if(request.getParameter("fid") != null){
			fur = db.getFurniture(Integer.parseInt(request.getParameter("fid")));
		}
		if(fur == null)
			fur = new Furniture();
	%>
</head>
<body style="background-image: url(static/img/background.jpg); max-width: 100%;  background-size: cover;">
<div class="row register-form">
        <div class="col-md-8 col-md-offset-2">
            <form class="form-horizontal custom-form" action="shop/admin/editFurniture" method="post">
                <h1>Edit Furniture</h1>
                <div>
                <input type="hidden" name="fid" value=<%= fur.getId() %>>
                </div>
                <div class="form-group">
                    <div class="col-sm-4 label-column">
                        <label class="control-label" for="name-input-field">Name </label>
                    </div>
                    <div class="col-sm-6 input-column">
                        <input class="form-control" type="text" name="name" placeholder="Furniture Name" required="" value=<%= fur.getName() %>>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4 label-column">
                        <label class="control-label" for="type-input-field">Type </label>
                    </div>
                    <div class="col-sm-6 input-column">
                        <input class="form-control" type="text" name="type" placeholder="Type of Furniture" required="" value=<%= fur.getType() %>>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4 label-column">
                        <label class="control-label" for="room-input-field">Room </label>
                    </div>
                    <div class="col-sm-6 input-column">
                        <input class="form-control" type="text" name="room" placeholder="Room" required="" value=<%= fur.getRoom() %>>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4 label-column">
                        <label class="control-label" for="price-input-field">Price </label>
                    </div>
                    <div class="col-sm-6 input-column">
                        <input class="form-control" type="number" name="price" placeholder="Price of the Furniture" required="" value=<%= fur.getPrice() %>>
                    </div>
                </div>
                <button class="btn btn-primary submit-button" type="submit">Edit Furniture</button>
            </form>
        </div>
    </div>
</body>
</html>