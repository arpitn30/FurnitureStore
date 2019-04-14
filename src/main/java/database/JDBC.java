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
import models.Order;
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
			user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
		return user;
	}
	
	public void addUser(String name, String email, String password, String secQues) throws SQLException {
		String qry = "INSERT INTO users (name, email, password, secQues) VALUES (?, ?, ?, ?);";
		PreparedStatement st = (PreparedStatement) connection.prepareStatement(qry);
		st.setString(1, name);
		st.setString(2, email);
		st.setString(3, password);
		st.setString(4, secQues);
		st.execute();
		
		int user_id = this.getUser(email).getId();
		qry = "INSERT INTO `wallet` (`user_id`, `balance`) VALUES (?, ?);";
		st = (PreparedStatement) connection.prepareStatement(qry);
		st.setInt(1, user_id);
		st.setLong(2, 0);
		st.execute();
	}
	
	public long getBalance(int user_id) throws SQLException {
		long balance = 0;
		String qry = "SELECT `balance` FROM `wallet` where `user_id` = " + user_id + ";";
		Statement statement = (Statement) connection.createStatement();
		ResultSet rs = statement.executeQuery(qry);
		while(rs.next())
			balance = rs.getLong("balance");
		return balance;
	}
	
	public boolean addBalance(int user_id, long balance) throws SQLException {
		balance += this.getBalance(user_id);
		
		String qry = "UPDATE `wallet` SET `balance`=? WHERE `user_id`=?;";
		PreparedStatement st = (PreparedStatement) connection.prepareStatement(qry);
		st.setLong(1, balance);
		st.setInt(2, user_id);
		return st.execute();
	}
	
	public ArrayList<Furniture> getFurniture() throws SQLException{
		ArrayList<Furniture> list = new ArrayList<Furniture>();
		String qry = "SELECT * FROM `furniture`;";
		Statement statement = (Statement) connection.createStatement();
		ResultSet rs = statement.executeQuery(qry);
		
		while(rs.next()) {
			Furniture f = new Furniture(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6));
			list.add(f);
		}
		return list;
	}
	
	public Furniture getFurniture(int fid) throws SQLException {
		Furniture fur = null;
		String qry = "SELECT * FROM `furniture` WHERE `furniture_id` = " + fid + ";";
		Statement statement = (Statement) connection.createStatement();
		ResultSet rs = statement.executeQuery(qry);
		while(rs.next())
			fur = new Furniture(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6));
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
		String qry = "DELETE FROM `furniture` WHERE `furniture_id`=?";
		PreparedStatement st = (PreparedStatement) connection.prepareStatement(qry);
		st.setInt(1, fid);
		return st.execute();
	}
	
	public boolean editFurniture(int fid, String name, String type, String room, int price) throws SQLException {
		String qry = "UPDATE `furniture` SET `name`=?, `type`=?, `room`=?, `price`=? WHERE `furniture_id`=?;";
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
			return true;
		else
			return false;
	}
	/**
	 * 
	 */
	public ArrayList<Order> getOrders() throws SQLException{ 
		ArrayList<Order> pastOrders = new ArrayList<Order>();
		String qry = "SELECT * FROM `orders`;";
		Statement statement = (Statement) connection.createStatement();
		ResultSet rs = statement.executeQuery(qry);
		
		while(rs.next()) {
			Order o = new Order(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getTimestamp(5), rs.getLong(6));
			pastOrders.add(o);
		}
		return pastOrders;
	}
	
	/**
	 * 
	 * @param orderId
	 * @param furnitureId
	 * @param userId
	 * @param quantity
	 * @param orderDate
	 * @param totalAmount
	 * @return
	 * @throws SQLException
	 */
	
	public boolean addOrder(int furnitureId,int userId,int quantity, long totalAmount) throws SQLException {
		String qry = "INSERT INTO `orders` (`furniture_id`, `user_id`, `quantity` , `totalAmount`) VALUES (?, ?, ?, ?);";
		PreparedStatement st = (PreparedStatement) connection.prepareStatement(qry);
		
		st.setInt(1, furnitureId);
		st.setInt(2, userId);
		st.setInt(3, quantity);
		st.setLong(4, totalAmount);
		return st.execute();
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
