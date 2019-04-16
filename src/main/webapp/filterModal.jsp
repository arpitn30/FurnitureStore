<%@page import="database.JDBC" %>

<%
	JDBC db = new JDBC();
	db.setConnection();
%>

<!-- The Modal -->
<div class="modal fade" id="filterForm">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title"><i class="fa fa-filter"></i>  Filter</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        <form class="form-horizontal" action="shop/filter" method="post">
        	<div class="form-group">
	        	<label class="control-label col-sm-2" for="type">Type:</label>
	        	<select class="form-control" id="type" name="type">
	        		<option value="all">All Types</option>
	        		<% for(String type : db.getTypes()) { %>
	        		<option value="<%= type %>"><%= type %></option>
	        		<% } %>
	        	</select>
        	</div>
        	<div class="form-group">
	        	<label class="control-label col-sm-2" for="room">Room:</label>
	        	<select class="form-control" id="room" name="room">
	        		<option value="all">All Types</option>
	        		<% for(String room : db.getRooms()) { %>
	        		<option value="<%= room %>"><%= room %></option>
	        		<% } %>
	        	</select>
        	</div>
        	<div class="form-inline">
        		<label class="control-label">Price Range:</label>
        		<span class="px-2">  </span>
        		<input type="number" class="form-control form-control-sm" name="min" placeholder="Min">
        		<span class="px-2"> - </span>
        		<input type="number" class="form-control form-control-sm" name="max" placeholder="Max">
        	</div>
        	<br>
        	<div class="form-group" style="text-align: center;">
        	<button class="btn btn-warning submit-button" type="submit">Advance Search</button>
        	</div>
        	
        </form>
      </div>

    </div>
  </div>
</div>