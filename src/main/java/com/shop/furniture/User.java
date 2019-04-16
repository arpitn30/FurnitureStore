/** *********************************************************************
*                        Aricent ALTRAN group Proprietary
*
*	This source code is the sole property of Aricent ALTRAN group. Any form
*	of utilization of this source code in whole or in part is  prohibited
*	without  written consent from Aricent ALTRAN group.
*
*	  File Name	            	:	User.java
*	  Principal Author      	:	Arpit Nandwani
*	  Subsystem Name        	:
*	  Module Name           	:	com.shop.furniture
*	  Date of First Release 	:	
*	  Author					:	
*	  Description           	:
*
*
*	  Change History
*
*	  Version      				:	1.0
*	  Date(DD/MM/YYYY) 			:	Apr 4, 2019
*	  Modified by				:	Arpit Nandwani
*	  Description of change 	:
*
	**********************************************************************
*/
package com.shop.furniture;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import database.JDBC;
import database.Local;
import models.Order;
import session.Session;

/**
 * 
 *
 */
@Path("/user")
public class User {

	@GET
	public Response home() throws URISyntaxException {
		return Response.seeOther(new URI("/")).build();
	}
	
	@GET
	@Path("changePass")
	public Response changePassword() throws URISyntaxException{
		if(!Session.isSet())
			return Response.seeOther(new URI("/login")).build();
		
		return Response.seeOther(new URI("../changepass.jsp")).build();
	}
	
	@POST
	@Path("changePass")
	public Response changePassword(@FormParam("oldpass") String oldpass, @FormParam("newpass") String newpass, @FormParam("newpass2") String newpass2) throws URISyntaxException, ClassNotFoundException, SQLException{
		if(!Session.isSet())
			return Response.seeOther(new URI("/login")).build();
		
		if(!newpass.equals(newpass2))
			return Response.seeOther(new URI("../changepass.jsp?status=mismatch")).build();
		
		JDBC db = new JDBC();
		db.setConnection();
		if(!db.getUser(Session.getId()).getPassword().equals(oldpass))
			return Response.seeOther(new URI("../changepass.jsp?status=incorrect")).build();
		db.updatePassword(Session.getId(), newpass);
		db.closeConnection();
		
		return Response.seeOther(new URI("../changepass.jsp?status=true")).build();
	}
	
	@GET
	@Path("viewCart")
	public Response viewcart() throws URISyntaxException {
		if(!Session.isSet())
			return Response.seeOther(new URI("/login")).build();
		
		return Response.seeOther(new URI("../viewcart.jsp")).build();
	}
	
	@GET
	@Path("addToCart")
	public Response addToCart(@QueryParam("fid") int fid, @QueryParam("quantity") int quantity) throws SQLException, ClassNotFoundException, URISyntaxException {
		if(!Session.isSet())
			return Response.seeOther(new URI("/login")).build();
		if(quantity < 1) {
			return Response.seeOther(new URI("/home?status=false")).build();
		}
		JDBC db = new JDBC();
		db.setConnection();
		long totalAmount = db.getFurniture(fid).getPrice() * quantity;
		db.closeConnection();
		Local.addToCart(fid, Session.getId(), quantity, totalAmount);
		return Response.seeOther(new URI("/home?status=added")).build();
	}
	
	@GET
	@Path("editCart")
	public Response editCart(@QueryParam("fid") int fid, @QueryParam("quantity") int quantity) throws URISyntaxException, ClassNotFoundException, SQLException {
		if(!Session.isSet())
			return Response.seeOther(new URI("/login")).build();
		
		if(quantity < 1)
			return Response.seeOther(new URI("../viewcart.jsp?status=false")).build();
		
		JDBC db = new JDBC();
		db.setConnection();
		long totalAmount = db.getFurniture(fid).getPrice() * quantity;
		db.closeConnection();
		Local.editCart(fid, quantity, totalAmount);
		return Response.seeOther(new URI("user/viewCart")).build();
	}
	
	@GET
	@Path("deleteFromCart")
	public Response deleteFromCart(@QueryParam("fid") int fid) throws URISyntaxException, ClassNotFoundException, SQLException {
		if(!Session.isSet())
			return Response.seeOther(new URI("/login")).build();
		
		Local.deleteFromCart(fid);
		return Response.seeOther(new URI("../viewcart.jsp?status=deleted")).build();
	}
	
	@GET
	@Path("buyNow")
	public Response buyNow(@QueryParam("fid") int fid, @QueryParam("quantity") int quantity) throws ClassNotFoundException, SQLException, URISyntaxException {
		if(!Session.isSet())
			return Response.seeOther(new URI("/login")).build(); 
		
		addToCart(fid, quantity);
	    return purchase();
	}
	
	@GET
	@Path("purchase")
	public Response purchase() throws SQLException, URISyntaxException, ClassNotFoundException {
		if(!Session.isSet())
			return Response.seeOther(new URI("/login")).build();
		
		JDBC db = new JDBC();
		db.setConnection();
		
		long cost = 0;
		for(Order item : Local.getCart()) {
			cost += item.getTotalAmount();
		}
		if(cost > db.getBalance(Session.getId()))
			return Response.seeOther(new URI("../viewcart.jsp?status=lowbalance")).build();
		
		for(Order item : Local.getCart()) {
			db.addOrder(item.getFurniture_id(), item.getUser_id(), item.getQuantity(), item.getTotalAmount());
			db.addBalance(Session.getId(), (-1 * item.getTotalAmount()));
		}
		db.closeConnection();
		Local.clearCart();
		return Response.seeOther(new URI("../vieworders.jsp?status=success")).build();
	}

	@GET
	@Path("viewOrders")
	public Response viewOrders() throws URISyntaxException {
		if(!Session.isSet())
			return Response.seeOther(new URI("/login")).build();
		
		return Response.seeOther(new URI("../vieworders.jsp")).build();
	}
	
	@GET
	@Path("wallet")
	public Response addBalance() throws URISyntaxException
	{
		return Response.seeOther(new URI("../wallet.jsp")).build();

	}
	
	@POST
	@Path("addBalance")
	public Response addBalance(@FormParam("user_id") int user_id, @FormParam("addBalance") int addBalance) throws ClassNotFoundException, SQLException, URISyntaxException
	{
		JDBC db = new JDBC();
		db.setConnection();
		db.addBalance(user_id, addBalance);
		db.closeConnection();
		return Response.seeOther(new URI("user/wallet")).build();
		
		
	}
}
