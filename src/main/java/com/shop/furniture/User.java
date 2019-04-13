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

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import database.JDBC;
import database.Local;
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
	@Path("viewcart")
	public Response viewcart() throws URISyntaxException {
		return Response.seeOther(new URI("../viewcart.jsp")).build();
	}
	
	@GET
	@Path("addToCart")
	public Response addToCart(@QueryParam("fid") int fid, @QueryParam("quantity") int quantity) throws SQLException, ClassNotFoundException, URISyntaxException {
		JDBC db = new JDBC();
		db.setConnection();
		long totalAmount = db.getFurniture(fid).getPrice() * quantity;
		db.closeConnection();
		Local.addToCart(fid, Session.getId(), quantity, totalAmount);
		return Response.seeOther(new URI("../index.jsp")).build();
	}
	
	@GET
	@Path("editCart")
	public Response editCart(@QueryParam("fid") int fid, @QueryParam("quantity") int quantity) throws URISyntaxException {
		Local.editCart(fid, quantity);
		return Response.seeOther(new URI("../viewcart.jsp")).build();
	}
	
	
	@GET
	@Path("deleteFromCart")
	public Response deleteFromCart(@QueryParam("fid") int fid) throws URISyntaxException, ClassNotFoundException, SQLException {
		Local.deleteFromCart(fid);
		return Response.seeOther(new URI("../viewcart.jsp")).build();
	}
	
	@GET
	@Path("buyNow")
	public Response buyNow(@QueryParam("fid") int fid, @QueryParam("quantity") int quantity) throws ClassNotFoundException, SQLException, URISyntaxException {
	     addToCart(fid,quantity);
	     return Response.seeOther(new URI("../payment.jsp")).build();
	}
	
	@GET
	@Path("purchase")
	public Response purchase() {
		return null;
		
	}
	
}
