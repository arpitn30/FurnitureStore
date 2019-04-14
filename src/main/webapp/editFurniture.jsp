<%@page import="models.Furniture"%>
<%@page import="database.JDBC" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Edit Furniture</title>
	
	<link rel="shortcut icon" type="image/png" href="static/img/favicon.png"/>
    <link rel="stylesheet" href="static/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="static/bootstrap/css/bootstrap4.min.css">
    <script src="static/bootstrap/js/bootstrap4.min.js"></script>
    <script src="static/js/jquery.min.js"></script>
    
    <link rel="stylesheet" href="static/css/Navbar-Apple.css">
    <link rel="stylesheet" href="static/css/form.css">
    <script src="static/js/custom.js"></script>
	
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
<jsp:include page="adminnav.jsp"></jsp:include>
<div class="container">

	<% if(request.getParameter("status") != null && request.getParameter("status").equals("exists")) { %>
		<div class="alert alert-warning" role="alert">
		<button type="button" class="close" data-dismiss="alert"><span>&times;</span></button>
		<strong>Failed!</strong> This Furniture already exists in the Database</div>
	<% } %>
	
	<div class="row register-form">
        <div class="col-md-6 offset-md-3">
            <form class="custom-form" action="shop/admin/editFurniture" method="post">
                <h1>Edit Furniture</h1>
                <div>
                    <div><input type="hidden" name="fid" required="" value="<%= fur.getId() %>"></div>
                </div>
                <div class="form-row form-group">
                    <div class="col-sm-4 label-column"><label class="col-form-label" for="name-input-field">Name </label></div>
                    <div class="col-sm-6 input-column"><input class="form-control" type="text" name="name" placeholder="Furniture Name" required="" value="<%= fur.getName() %>"></div>
                </div>
                <div class="form-row form-group">
                    <div class="col-sm-4 label-column"><label class="col-form-label" for="type-input-field">Type </label></div>
                    <div class="col-sm-6 input-column"><input class="form-control" type="text" name="type" placeholder="Type of Furniture" required="" value="<%= fur.getType() %>"></div>
                </div>
                <div class="form-row form-group">
                    <div class="col-sm-4 label-column"><label class="col-form-label" for="room-input-field">Room </label></div>
                    <div class="col-sm-6 input-column"><input class="form-control" type="text" name="room" placeholder="Room" required="" value="<%= fur.getRoom() %>"></div>
                </div>
                <div class="form-row form-group">
                    <div class="col-sm-4 label-column"><label class="col-form-label" for="price-input-field">Price </label></div>
                    <div class="col-sm-6 input-column"><input class="form-control" type="number" name="price" placeholder="Price of the Furniture" required="" value="<%= fur.getPrice() %>"></div>
                </div>
                <button class="btn btn-primary rounded shadow submit-button" type="submit">Edit Details</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>