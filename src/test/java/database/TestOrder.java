/***********************************************************************
                         Aricent Altran Group Proprietary

This source code is the sole property of Aricent Altran Group. Any form of 
utilization of this source code in whole or in part is  prohibited without 
 written consent from
Aricent Altran Group

	  File Name	          	    : TestOrder.java
	  Principal Author      	: 
	  Subsystem Name       	    :
	  Module Name           	: database
	  Date of First Release 	:
	  Author					: 
	  Description           	:


	  Change History

	  Version      				: 1.0
	  Date(DD/MM/YYYY) 			: Apr 18, 2019
	  Modified by				: 
	  Description of change 	:

***********************************************************************/
package database;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import models.Order;

public class TestOrder {

	static JDBC db;

	@BeforeClass
	public static void init() throws ClassNotFoundException, SQLException {
		db = new JDBC();
		db.setConnection();
	}
	
	@AfterClass
	public static void close() {
		db.closeConnection();
	}
	
	@Test
	public void testAddOrder() throws SQLException {
		db.addOrder(1, 1, 2, 24000);
		ArrayList<Order> list = db.getOrders(1);
		assertEquals(2, list.get(0).getQuantity());
	}

	@Test
	public void testGetTypes() throws SQLException {

		ArrayList<String> list = db.getTypes();
		assertTrue(list.contains("Bed"));
	}

	@Test
	public void testGetRooms() throws SQLException {

		ArrayList<String> list = db.getRooms();
		assertTrue(list.contains("Bed"));
	}
}
