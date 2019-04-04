<%@page import="models.Furniture"%> 
<%@page import="database.JDBC" %>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>header</title>
    <link rel="stylesheet" href="static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="static/css/Navbar-Apple.css">
    
    <script src="static/js/jquery.min.js"></script>
    <script src="static/bootstrap/js/bootstrap.min.js"></script>
</head>

<body>
    <nav class="navbar navbar-dark navbar-expand-md fixed-top bg-dark" style="height:45px;">
        <div class="container-fluid"><a class="navbar-brand" href="#">OFS</a><button class="navbar-toggler" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse"
                id="navcol-1">
                <ul class="nav navbar-nav flex-grow-1 justify-content-between">
                    <li class="nav-item" role="presentation"><a class="nav-link active" href="#"><i class="fa fa-apple apple-logo"></i></a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link active" href="#">Mac</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link active" href="#">iPad</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link active" href="#">iPhone</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link active" href="#">Watch</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link active" href="#">TV</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link active" href="#">Music</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link active" href="#">Support</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link active" href="#"><i class="fa fa-search"></i></a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link active" href="#"><i class="fa fa-shopping-bag"></i></a></li>
                </ul>
            </div>
        </div>
    </nav>
    <br><br><br>
    <div>
    	<table width="100%">
    	<%
    		JDBC db = new JDBC();
			db.setConnection();
			ArrayList<Furniture> data = db.getFurniture();
			db.closeConnection();
        	for(Furniture fur: data){
        %> 
    		<tr>
    			<td><%= fur.getName() %></td>
    			<td><%= fur.getType() %></td>
    			<td><%= fur.getRoom() %></td>
    			<td><%= fur.getPrice() %></td>
    		</tr>    	
    	<% 
    		} 
    	%> 
    	</table>
    </div>
</body>

</html>