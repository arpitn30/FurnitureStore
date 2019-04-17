/***********************************************************************
                         Aricent Altran Group Proprietary

This source code is the sole property of Aricent Altran Group. Any form of 
utilization of this source code in whole or in part is  prohibited without 
 written consent from
Aricent Altran Group

	  File Name	          	    : TestUser.java
	  Principal Author      	: Gagan Preet kaur
	  Subsystem Name       	    :
	  Module Name           	: database
	  Date of First Release 	:
	  Author					: 
	  Description           	:


	  Change History

	  Version      				: 1.0
	  Date(DD/MM/YYYY) 			: Apr 17, 2019
	  Modified by				: Gagan Preet Kaur
	  Description of change 	:

***********************************************************************/
package database;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import models.Furniture;

/**
 * @author Gagan Preet Kaur
 *
 */
public class TestUser {
	static JDBC db;
	
	@BeforeClass
	public static void init() throws ClassNotFoundException, SQLException
	{
		db = new JDBC();
		db.setConnection();
	}

	
	@Test
	public void testGetUser() throws SQLException {
		assertEquals("Arpit", db.getUser(1).getName());
	}
	
	@Test
	public void testGetUser2() throws SQLException {
		assertEquals("gagan", db.getUser("gagan@altran.com").getSecQues());
	}
	
//	@Test
//	public void testAddUser() throws SQLException {
//		db.addUser("Vanessa", "vv@altran.com", "passsword", "amrutha");
//		int user_id = db.getUser("vv@altran.com").getId();
//		assertEquals(0, db.getBalance(user_id));
//	}
//	
	@Test
	public void testUpdatePassword() throws SQLException
	{
		db.updatePassword(2,"123456");
		assertEquals("123456", db.getUser(2).getPassword());
	}
//	@Test
//	public void testgetBalance() throws SQLException
//	{
//		assertEquals(100000000, db.getBalance(1));
//	}
//	@Test
//	public void testaddBalance() throws SQLException
//	{
//		db.addBalance(1, 10000000);
//		assertEquals(100000000, db.getBalance(1));
//	}
	
	@Test
	public void testgetFurniture() throws SQLException
	{
		ArrayList<Furniture> list = db.getFurniture("", "Bed", "", "0", Integer.toString(Integer.MAX_VALUE));
		assertEquals("Bed", list.get(0).getType());
	}
	
	
	@Test
	public void testgetFurniture2() throws SQLException
	{
		assertEquals("SportsCar Bed", db.getFurniture(1).getName());
	}
	
	@Test
	public void testaddFurniture() throws SQLException
	{
		//db.addFurniture("Plastic Chair", "Chair", "Kids", 10000);
		int furniture_id = db.getFurniture("Plastic Chair", "Chair", "Kids", "0", "10000").get(0).getId();
		assertEquals("Plastic Chair", db.getFurniture(furniture_id).getName());
	}
	
	@Test
	public void testDeleteFurniture() throws SQLException
	{
		//db.deleteFurniture(8);
		assertFalse("false", db.deleteFurniture(8));
	}
	
	
}
