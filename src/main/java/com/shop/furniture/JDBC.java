/** *********************************************************************
*                        Aricent ALTRAN group Proprietary
*
*	This source code is the sole property of Aricent ALTRAN group. Any form
*	of utilization of this source code in whole or in part is  prohibited
*	without  written consent from Aricent ALTRAN group.
*
*	  File Name	            	:	JDBC.java
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
*	  Date(DD/MM/YYYY) 			:	Apr 2, 2019
*	  Modified by				:	Arpit Nandwani
*	  Description of change 	:
*
	**********************************************************************
*/
package com.shop.furniture;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * @author Arpit Nandwani
 *
 */
public class JDBC {

	Connection connection;
	Savepoint svpt;
	
	/**
	 * Set Up a connection with the database through MySQL Driver
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void setConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		
		String host = "localhost:3306";
		String dbName = "shop";
		
		String URL = "jdbc:mysql://" + host + "/" + dbName;
		String user = "root";
		String pass = "root";
		
		connection = (Connection) DriverManager.getConnection(URL, user, pass);
	}
	
	public ResultSet getUser(String email) throws SQLException {
		String qry = "SELECT * FROM `users` WHERE `email` = '" + email + "';";
		Statement statement = (Statement) connection.createStatement();
		ResultSet rs = statement.executeQuery(qry);
		return rs;
	}
	
	/**
	 * Close Connection
	 */
	public void closeConnection() {
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
