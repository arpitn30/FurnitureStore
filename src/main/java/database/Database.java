/** *********************************************************************
*                        Aricent ALTRAN group Proprietary
*
*	This source code is the sole property of Aricent ALTRAN group. Any form
*	of utilization of this source code in whole or in part is  prohibited
*	without  written consent from Aricent ALTRAN group.
*
*	  File Name	            	:	Database.java
*	  Principal Author      	:	
*	  Subsystem Name        	:
*	  Module Name           	:	database
*	  Date of First Release 	:	
*	  Author					:	
*	  Description           	:
*
*
*	  Change History
*
*	  Version      				:	1.0
*	  Date(DD/MM/YYYY) 			:	Apr 17, 2019
*	  Modified by				:	
*	  Description of change 	:
*
	**********************************************************************
*/
package database;

import java.sql.SQLException;
import java.util.ArrayList;

import models.Furniture;
import models.Order;
import models.User;

/**
 * @author Arpit Nandwani
 *
 */
public interface Database {

	/**
	 * Set Up a connection with the database through MySQL Driver
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void setConnection() throws ClassNotFoundException, SQLException;

	/**
	 * Gets User from the database using the user_id
	 * 
	 * @param user_id
	 * @return
	 * @throws SQLException
	 */
	public User getUser(int user_id) throws SQLException;

	/**
	 * Gets User from the database using the email
	 * 
	 * @param email
	 * @return
	 * @throws SQLException
	 */
	public User getUser(String email) throws SQLException;

	/**
	 * Add User to the database
	 * 
	 * @param name
	 * @param email
	 * @param password
	 * @param secQues
	 * @throws SQLException
	 */
	public void addUser(String name, String email, String password,
			String secQues) throws SQLException;

	/**
	 * Update password in the database for the given user_id
	 * 
	 * @param user_id
	 * @param password
	 * @return 
	 * @throws SQLException
	 */
	public int updatePassword(int user_id, String password)
			throws SQLException;

	/**
	 * Get balance from the database for the given user_id
	 * 
	 * @param user_id
	 * @return
	 * @throws SQLException
	 */
	public long getBalance(int user_id) throws SQLException;

	/**
	 * Set balance in the database for the given user_id
	 * 
	 * @param user_id
	 * @param balance
	 * @return
	 * @throws SQLException
	 */
	public int setBalance(int user_id, long balance) throws SQLException;
	
	/**
	 * Update balance in the database for the given user_id
	 * 
	 * @param user_id
	 * @param balance
	 * @return
	 * @throws SQLException
	 */
	public int addBalance(int user_id, long balance) throws SQLException;

	/**
	 * Get details of all the furniture from the database
	 * 
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Furniture> getFurniture() throws SQLException;

	/**
	 * Get details of the furniture from the database for the given details
	 * 
	 * @param name
	 * @param type
	 * @param room
	 * @param min
	 * @param max
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Furniture> getFurniture(String name, String type,
			String room, String min, String max) throws SQLException;

	/**
	 * Get details of the furniture from the database for the given furniture_id
	 * 
	 * @param fid
	 * @return
	 * @throws SQLException
	 */
	public Furniture getFurniture(int fid) throws SQLException;

	/**
	 * Add a furniture to the database
	 * 
	 * @param name
	 * @param type
	 * @param room
	 * @param price
	 * @return
	 * @throws SQLException
	 */
	public boolean addFurniture(String name, String type, String room,
			int price) throws SQLException;

	/**
	 * Delete a furniture from the database for the given furniture_id
	 * 
	 * @param fid
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteFurniture(int fid) throws SQLException;

	/**
	 * Edit furniture details in the database for the given furniture_id
	 * 
	 * @param fid
	 * @param name
	 * @param type
	 * @param room
	 * @param price
	 * @return
	 * @throws SQLException
	 */
	public boolean editFurniture(int fid, String name, String type, String room,
			int price) throws SQLException;

	/**
	 * Check if a furniture with the given name exists in the database
	 * 
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public boolean checkFurniture(String name) throws SQLException;

	/**
	 * Get all orders from the database
	 * 
	 * @param user_id
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Order> getOrders(int user_id) throws SQLException;

	/**
	 * Add an order to the database
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
	public boolean addOrder(int furnitureId, int userId, int quantity,
			long totalAmount) throws SQLException;

	/**
	 * Get all the types of furniture from the database
	 * 
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<String> getTypes() throws SQLException;

	/**
	 * Get all the rooms of the furnitures from the database
	 * 
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<String> getRooms() throws SQLException;

	/**
	 * Close Connection
	 */
	public void closeConnection();

}
