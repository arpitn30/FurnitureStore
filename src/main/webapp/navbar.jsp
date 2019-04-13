<%@page import="session.Session" %>

	<nav class="navbar navbar-dark navbar-expand-md fixed-top bg-dark" style="height:45px;">
        <div class="container-fluid"><img src="static/img/favicon.png" height="2.5%" width="2.5%">&nbsp;&nbsp;<a class="navbar-brand" href="shop/">Furniture Store</a>
        <button class="navbar-toggler" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navcol-1">
                <ul class="nav navbar-nav flex-grow-1 justify-content-between">
                    <!--li class="nav-item" role="presentation"><a class="nav-link active" href="#"><i class="fa fa-apple apple-logo"></i></a></li-->
                    <li class="nav-item"></li>
                    <li class="nav-item"><a class="nav-link active" href="shop/user/"><i class="fa fa-home"></i>  Home</a></li>
                    <li class="nav-item"><a class="nav-link active" href="shop/user/viewcart"><i class="fa fa-shopping-bag"></i>  View Cart</a></li>
                    <li class="nav-item"><a class="nav-link active" href="shop/user/vieworders"><i class="fa fa-history"></i>  View All Orders</a></li>
                    <li class="nav-item"><a class="nav-link active" href="shop/user/wallet"><i class="fa fa-btc"></i> Wallet</a></li>
                    <li class="nav-item"><a class="nav-link active" href="shop/changepass"><i class="fa fa-hashtag"></i> Change Password</a></li>
                    <% if(Session.getId() == -1) { %>
                    <li class="nav-item"><a class="nav-link active" href="shop/register"><i class="fa fa-user-circle-o"></i>  Register</a></li>
                    <li class="nav-item"><a class="nav-link active" href="shop/login"><i class="fa fa-sign-in"></i>  Login</a></li>
                    <% } else {%>
                    <li class="nav-item"><a class="nav-link active" href="#"><i class="fa fa-sign-out"></i> Logout</a></li>
                    <li class="nav-item dropdown"><a class="nav-link dropdown-toggle active" data-toggle="dropdown" aria-expanded="false" href="#"><i class="fa fa-user-circle-o"></i> <%= Session.getName() %></a>
                        <ul class="dropdown-menu dropdown-dark dropdown-menu-right" role="menu">
                        <li><a class="dropdown-item" href="shop/logout"><i class="fa fa-sign-out"></i> Logout</a></li>
                        </ul>
                    </li>
                    <% } %>
                </ul>
            </div>
        </div>
    </nav>
    <br><br><br>