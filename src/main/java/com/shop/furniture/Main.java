/** *********************************************************************
*                        Aricent ALTRAN group Proprietary
*
*	This source code is the sole property of Aricent ALTRAN group. Any form
*	of utilization of this source code in whole or in part is  prohibited
*	without  written consent from Aricent ALTRAN group.
*
*	  File Name	            	:	Login.java
*	  Principal Author      	:	
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
*	  Date(DD/MM/YYYY) 			:	Mar 28, 2019
*	  Modified by				:	
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
import models.User;
import session.Session;

/**
 * 
 *
 */
@Path("/")
public class Main {

	@GET
	public Response homepage() throws URISyntaxException {
		return Response.seeOther(new URI("../index.jsp")).build();
	}

	@GET
	@Path("/home")
	public Response homepage(@QueryParam("status") String status)
			throws URISyntaxException {
		return Response.seeOther(new URI("../index.jsp?status=" + status))
				.build();
	}

	/**
	 * Opens the Login view when users visits the page
	 * 
	 * @return
	 * @throws URISyntaxException
	 */
	@GET
	@Path("/login")
	public Response login() {
		try {
			return Response.seeOther(new URI("../login.jsp")).build();
		} catch (URISyntaxException e) {
			System.out.println(e);
			return Response.status(404).entity("Error 404: Page Not Found")
					.build();
		}
	}

	@POST
	@Path("/login")
	public Response login(@FormParam("email") String email,
			@FormParam("password") String pass) {
		JDBC db = new JDBC();
		User user = null;
		try {
			try {
				db.setConnection();
				user = db.getUser(email);
				db.closeConnection();
			} catch (ClassNotFoundException e) {
				System.out.println(e);
				return Response.status(500)
						.entity("Error 500: Internal Server Error").build();
			} finally {
				db.closeConnection();
			}
			if (user == null)
				return Response.seeOther(new URI("../login.jsp?status=false"))
						.build();
			if (user.getPassword().equals(pass)) {
				Session.setId(user.getId());
				Session.setName(user.getName());
				return Response.seeOther(new URI("/")).build();
			}
			return Response.seeOther(new URI("../login.jsp?status=false"))
					.build();
		} catch (URISyntaxException e) {
			System.out.println(e);
			return Response.status(404).entity("Error 404: Page Not Found")
					.build();
		}
		catch(SQLException e) {
			System.out.println(e);
			return Response.status(500)
					.entity("Error 500: Internal Server Error").build();
		}
	}

	@GET
	@Path("/register")
	public Response register() {
		try {
		return Response.seeOther(new URI("../register.jsp")).build();
		} catch (URISyntaxException e) {
			System.out.println(e);
			return Response.status(404).entity("Error 404: Page Not Found")
					.build();
		}
	}

	@POST
	@Path("/register")
	public Response register(@FormParam("name") String name,
			@FormParam("email") String email,
			@FormParam("password") String pass,
			@FormParam("password2") String pass2,
			@FormParam("secQues") String secQues) {
		JDBC db = new JDBC();
		try {
			try {
				db.setConnection();
				User user = db.getUser(email);
				if (user != null)
					return Response
							.seeOther(new URI("../register.jsp?status=exists"))
							.build();
				if (!pass.equals(pass2))
					return Response
							.seeOther(
									new URI("../register.jsp?status=mismatch"))
							.build();
				db.addUser(name, email, pass, secQues);
				db.closeConnection();
			} catch (ClassNotFoundException e) {
				System.out.println(e);
				return Response.status(500)
						.entity("Error 500: Internal Server Error").build();
			} finally {
				db.closeConnection();
			}
			return Response.seeOther(new URI("../login.jsp?status=true"))
					.build();
		} catch (URISyntaxException e) {
			System.out.println(e);
			return Response.status(404).entity("Error 404: Page Not Found")
					.build();
		}
		catch(SQLException e) {
			System.out.println(e);
			return Response.status(500)
					.entity("Error 500: Internal Server Error").build();
		}
	}

	@GET
	@Path("/logout")
	public Response logout() {
		Session.reset();
		try {
			return Response.seeOther(new URI("/")).build();
		} catch (URISyntaxException e) {
			System.out.println(e);
			return Response.status(404).entity("Error 404: Page Not Found")
					.build();
		}
	}

	@GET
	@Path("/forgotPass")
	public Response forgotPassword() {
		try {
			return Response.seeOther(new URI("../forgotpass.jsp")).build();
		} catch (URISyntaxException e) {
			System.out.println(e);
			return Response.status(404).entity("Error 404: Page Not Found")
					.build();
		}
	}

	@POST
	@Path("/forgotPass")
	public Response forgotPassword(@FormParam("email") String email,
			@FormParam("secQues") String secQues,
			@FormParam("password") String pass,
			@FormParam("password2") String pass2) {
		try {
		if (!pass.equals(pass2))
			return Response
					.seeOther(new URI("../forgotpass.jsp?status=mismatch"))
					.build();

		JDBC db = new JDBC();
		User user = null;
			try {
				db.setConnection();
				user = db.getUser(email);
				if (user == null)
					return Response
							.seeOther(new URI(
									"../forgotpass.jsp?status=notexists"))
							.build();
				if (!user.getSecQues().equalsIgnoreCase(secQues))
					return Response
							.seeOther(new URI(
									"../forgotpass.jsp?status=incorrect"))
							.build();
				db.updatePassword(user.getId(), pass);
				db.closeConnection();
			} catch (ClassNotFoundException e) {
				System.out.println(e);
				return Response.status(500)
						.entity("Error 500: Internal Server Error").build();
			} finally {
				db.closeConnection();
			}
			return Response.seeOther(new URI("../login.jsp?status=password"))
					.build();
		} catch (URISyntaxException e) {
			System.out.println(e);
			return Response.status(404).entity("Error 404: Page Not Found")
					.build();
		}
		catch(SQLException e) {
			System.out.println(e);
			return Response.status(500)
					.entity("Error 500: Internal Server Error").build();
		}
	}

	@POST
	@Path("/search")
	public Response search(@FormParam("category") String category,
			@FormParam("search") String search) {
		String name = "";
		String type = "";
		String room = "";
		int minPrice = 0;
		int maxPrice = Integer.MAX_VALUE;

		if (category.equals("all"))
			name = search;
		else if (category.equals("types"))
			type = search;
		else if ((category.equals("rooms")))
			room = search;
		try {
			if (Session.isAdmin())
				return Response.seeOther(new URI("../adminindex.jsp?name="
						+ name + "&type=" + type + "&room=" + room + "&min="
						+ minPrice + "&max=" + maxPrice)).build();
			else
				return Response.seeOther(new URI("../index.jsp?name=" + name
						+ "&type=" + type + "&room=" + room + "&min=" + minPrice
						+ "&max=" + maxPrice)).build();
		} catch (URISyntaxException e) {
			System.out.println(e);
			return Response.status(404).entity("Error 404: Page Not Found")
					.build();
		}
	}

	@POST
	@Path("/filter")
	public Response filter(@FormParam("type") String type,
			@FormParam("room") String room, @FormParam("min") String minPrice,
			@FormParam("max") String maxPrice) {
		if (type.equals("all"))
			type = "";

		if (room.equals("all"))
			room = "";

		if (minPrice.equals("") || minPrice == null)
			minPrice = "0";

		if (maxPrice.equals("") || maxPrice == null)
			maxPrice = Integer.toString(Integer.MAX_VALUE);

		try {
			if (Session.isAdmin())
				return Response.seeOther(new URI(
						"../adminindex.jsp?name=&type=" + type + "&room=" + room
								+ "&min=" + minPrice + "&max=" + maxPrice))
						.build();
			else
				return Response.seeOther(new URI(
						"../index.jsp?name=&type=" + type + "&room=" + room
								+ "&min=" + minPrice + "&max=" + maxPrice))
						.build();
		} catch (URISyntaxException e) {
			System.out.println(e);
			return Response.status(404).entity("Error 404: Page Not Found")
					.build();
		}
	}
}
