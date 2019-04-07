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
package database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import models.Furniture;
import models.User;

/**
 * 
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
	
	public User getUser(String email) throws SQLException {
		User user = null;
		String qry = "SELECT * FROM `users` WHERE `email` = '" + email + "';";
		Statement statement = (Statement) connection.createStatement();
		ResultSet rs = statement.executeQuery(qry);
		while(rs.next())
			user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getLong(5), rs.getString(6));
		return user;
	}
	
	public boolean addUser(String name, String email, String password, String secQues) throws SQLException {
		String qry = "INSERT INTO users (name, email, password, balance, secQues) VALUES (?, ?, ?, ?, ?);";
		PreparedStatement st = (PreparedStatement) connection.prepareStatement(qry);
		
		st.setString(1, name);
		st.setString(2, email);
		st.setString(3, password);
		st.setLong(4, 0);
		st.setString(5, secQues);
		
		return st.execute();
	}
	
	public ArrayList<Furniture> getFurniture() throws SQLException{
		ArrayList<Furniture> list = new ArrayList<Furniture>();
		String qry = "SELECT * FROM `furniture`;";
		Statement statement = (Statement) connection.createStatement();
		ResultSet rs = statement.executeQuery(qry);
		
		while(rs.next()) {
			Furniture f = new Furniture(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
			list.add(f);
		}
		return list;
	}
	
	public Furniture getFurniture(int fid) throws SQLException {
		Furniture fur = null;
		String qry = "SELECT * FROM `furniture` WHERE `id` = " + fid + ";";
		Statement statement = (Statement) connection.createStatement();
		ResultSet rs = statement.executeQuery(qry);
		while(rs.next())
			fur = new Furniture(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
		return fur;
	}
	
	public boolean addFurniture(String name, String type, String room, int price) throws SQLException {
		String qry = "INSERT INTO `furniture` (`name`, `type`, `room`, `price`) VALUES (?, ?, ?, ?);";
		PreparedStatement st = (PreparedStatement) connection.prepareStatement(qry);
		
		st.setString(1, name);
		st.setString(2, type);
		st.setString(3, room);
		st.setInt(4, price);
		
		return st.execute();
	}
	
	public boolean deleteFurniture(int fid) throws SQLException {
		String qry = "DELETE FROM `furniture` WHERE `id`=?";
		PreparedStatement st = (PreparedStatement) connection.prepareStatement(qry);
		st.setInt(1, fid);
		return st.execute();
	}
	
	public boolean editFurniture(int fid, String name, String type, String room, int price) throws SQLException {
		String qry = "UPDATE `furniture` SET `name`=?, `type`=?, `room`=?, `price`=? WHERE `id`=?;";
		PreparedStatement st = (PreparedStatement) connection.prepareStatement(qry);
		
		st.setString(1, name);
		st.setString(2, type);
		st.setString(3, room);
		st.setInt(4, price);
		st.setInt(5, fid);
		return st.execute();
	}
	
	public boolean checkFurniture(String name) throws SQLException {
		String qry = "SELECT * FROM `furniture` WHERE `name` = '" + name + "';";
		Statement statement = (Statement) connection.createStatement();
		ResultSet rs = statement.executeQuery(qry);
		if(rs.next())
			return false;
		else
			return true;
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
