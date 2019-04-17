/** *********************************************************************
*                        Aricent ALTRAN group Proprietary
*
*	This source code is the sole property of Aricent ALTRAN group. Any form
*	of utilization of this source code in whole or in part is  prohibited
*	without  written consent from Aricent ALTRAN group.
*
*	  File Name	            	:	Admin.java
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
*	  Date(DD/MM/YYYY) 			:	Apr 4, 2019
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
import session.Session;

/**
 * 
 *
 */
@Path("/admin")
public class Admin {

	private static final String USER = "root@altran.com";
	private static String PASS = "superuser";

	@GET
	public Response homepage() throws URISyntaxException {
		if (Session.isAdmin())
			return Response.seeOther(new URI("../adminindex.jsp")).build();
		else
			return Response.seeOther(new URI("../adminlogin.jsp")).build();
	}

	@GET
	@Path("home")
	public Response homepage(@QueryParam("status") String status)
			throws URISyntaxException {
		if (Session.isAdmin())
			return Response
					.seeOther(new URI("../adminindex.jsp?status=" + status))
					.build();
		else
			return Response.seeOther(new URI("../adminlogin.jsp")).build();
	}

	@GET
	@Path("/login")
	public Response login() throws URISyntaxException {
		return Response.seeOther(new URI("../adminlogin.jsp")).build();
	}

	@POST
	@Path("/login")
	public Response login(@FormParam("email") String email,
			@FormParam("password") String pass)
			throws ClassNotFoundException, SQLException, URISyntaxException {

		if (USER.equals(email) && PASS.equals(pass)) {
			Session.setId(0);
			Session.setName("Admin");
			return Response.seeOther(new URI("admin/")).build();
		}

		return Response.seeOther(new URI("../adminlogin.jsp?status=false"))
				.build();
	}

	@GET
	@Path("/addFurniture")
	public Response addFurniture() throws URISyntaxException {
		if (!Session.isAdmin())
			return Response.seeOther(new URI("admin/login")).build();

		return Response.seeOther(new URI("../addFurniture.jsp")).build();
	}

	@POST
	@Path("/addFurniture")
	public Response addFurniture(@FormParam("name") String name,
			@FormParam("type") String type, @FormParam("room") String room,
			@FormParam("price") int price)
			throws ClassNotFoundException, SQLException, URISyntaxException {
		if (!Session.isAdmin())
			return Response.seeOther(new URI("admin/login")).build();

		JDBC db = new JDBC();
		db.setConnection();
		if (db.checkFurniture(name))
			return Response
					.seeOther(new URI("../addFurniture.jsp?status=exists"))
					.build();

		db.addFurniture(name, type, room, price);

		return Response.seeOther(new URI("admin/home?status=added")).build();
	}

	@GET
	@Path("/editFurniture")
	public Response editFurniture(@QueryParam("fid") int fid)
			throws URISyntaxException {
		if (!Session.isAdmin())
			return Response.seeOther(new URI("admin/login")).build();

		return Response.seeOther(new URI("../editFurniture.jsp?fid=" + fid))
				.build();
	}

	@POST
	@Path("/editFurniture")
	public Response editFurniture(@FormParam("fid") int fid,
			@FormParam("name") String name, @FormParam("type") String type,
			@FormParam("room") String room, @FormParam("price") int price)
			throws ClassNotFoundException, SQLException, URISyntaxException {
		if (!Session.isAdmin())
			return Response.seeOther(new URI("admin/login")).build();

		if (fid == 0)
			addFurniture(name, type, room, price);

		else {
			JDBC db = new JDBC();
			db.setConnection();

			db.editFurniture(fid, name, type, room, price);
		}
		return Response.seeOther(new URI("admin/")).build();
	}

	@GET
	@Path("/deleteFurniture")
	public Response deleteFurniture(@QueryParam("fid") int fid)
			throws ClassNotFoundException, SQLException, URISyntaxException {
		if (!Session.isAdmin())
			return Response.seeOther(new URI("admin/login")).build();

		JDBC db = new JDBC();
		db.setConnection();
		db.deleteFurniture(fid);
		return Response.seeOther(new URI("admin/")).build();
	}

	@GET
	@Path("changePass")
	public Response changePassword() throws URISyntaxException {
		if (!Session.isAdmin())
			return Response.seeOther(new URI("admin/login")).build();

		return Response.seeOther(new URI("../adminpass.jsp")).build();
	}

	@POST
	@Path("changePass")
	public Response changePassword(@FormParam("oldpass") String oldpass,
			@FormParam("newpass") String newpass,
			@FormParam("newpass2") String newpass2)
			throws URISyntaxException, ClassNotFoundException, SQLException {
		if (!Session.isAdmin())
			return Response.seeOther(new URI("admin/login")).build();

		if (!newpass.equals(newpass2))
			return Response
					.seeOther(new URI("../adminpass.jsp?status=mismatch"))
					.build();

		if (PASS.equals(oldpass))
			return Response
					.seeOther(new URI("../adminpass.jsp?status=incorrect"))
					.build();

		PASS = newpass;

		return Response.seeOther(new URI("../adminpass.jsp?status=true"))
				.build();
	}
}
