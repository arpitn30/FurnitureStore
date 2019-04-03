/** *********************************************************************
*                        Aricent ALTRAN group Proprietary
*
*	This source code is the sole property of Aricent ALTRAN group. Any form
*	of utilization of this source code in whole or in part is  prohibited
*	without  written consent from Aricent ALTRAN group.
*
*	  File Name	            	:	Login.java
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
*	  Date(DD/MM/YYYY) 			:	Mar 28, 2019
*	  Modified by				:	Arpit Nandwani
*	  Description of change 	:
*
	**********************************************************************
*/
package com.shop.furniture;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * @author Arpit Nandwani
 *
 */
@Path("/")
public class Login {

	@GET
	public Response homepage() throws URISyntaxException {
		return Response.seeOther(new URI("../index.jsp")).build();
	}
	
	/**
	 * Opens the Login view when users visits the page
	 * @return
	 * @throws URISyntaxException
	 */
	@GET
	@Path("/login")
	public Response login() throws URISyntaxException {
		return Response.seeOther(new URI("../login.jsp")).build();
	}
	
	@POST
	@Path("/login")
	public Response login(@FormParam("email") String email, @FormParam("password") String pass) throws URISyntaxException, ClassNotFoundException, SQLException {
		JDBC db = new JDBC();
		db.setConnection();
		ResultSet rs = db.getUser(email);
		try {
		while(rs.next()) {
			if(rs.getString("password").equals(pass)) {
				Session.setSession(rs.getInt("id"));
				return Response.seeOther(new URI("../index.jsp")).build();
			}
		}
		
		return Response.seeOther(new URI("../login.jsp?status=false")).build();
		}
		finally {
			db.closeConnection();
		}
	}
	
	@GET
	@Path("/register")
	public Response register() throws URISyntaxException {
		return Response.seeOther(new URI("../register.jsp")).build();
	}
	
	@POST
	@Path("/register")
	public Response register(@FormParam("name") String name,@FormParam("email") String email, @FormParam("password") String pass, @FormParam("password2") String pass2, @FormParam("secQues") String secQues) throws ClassNotFoundException, SQLException, URISyntaxException {
		JDBC db = new JDBC();
		db.setConnection();
		ResultSet rs = db.getUser(email);
		if(rs.next())
			return Response.seeOther(new URI("../register.jsp?status=exists")).build();
		
		if(!pass.equals(pass2))
			return Response.seeOther(new URI("../register.jsp?status=mismatch")).build();
		
		db.addUser(name, email, pass, secQues);
		
		return Response.seeOther(new URI("../login.jsp?status=true")).build();
	}
	
}
