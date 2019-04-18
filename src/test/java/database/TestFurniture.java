/***********************************************************************
                         Aricent Altran Group Proprietary

This source code is the sole property of Aricent Altran Group. Any form of 
utilization of this source code in whole or in part is  prohibited without 
 written consent from
Aricent Altran Group

	  File Name	          	    : TestFurniture.java
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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import models.Furniture;

public class TestFurniture {

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
	public void testGetFurniture() throws SQLException {
		ArrayList<Furniture> list = db.getFurniture("", "Bed", "", "0",
				Integer.toString(Integer.MAX_VALUE));
		assertEquals("Bed", list.get(0).getType());
	}

	@Test
	public void testGetFurniture2() throws SQLException {
		assertEquals("SportsCar Bed", db.getFurniture(1).getName());
	}

	@Test
	public void testAddFurniture() throws SQLException {
		try {
			db.addFurniture("Plastic Chair", "Chair", "Kids", 10000);
		} catch (SQLException e) {
			System.out.println(e);
		}
		int furniture_id = db
				.getFurniture("Plastic Chair", "Chair", "Kids", "0", "10000")
				.get(0).getId();
		assertEquals("Plastic Chair", db.getFurniture(furniture_id).getName());
	}

	/**
	 * Negative Test Case
	 * @throws SQLException
	 */
	@Test
	public void testDeleteFurniture() throws SQLException {
		assertFalse(db.deleteFurniture(0));
	}

	@Test
	public void testEditFurniture() throws SQLException {
		try {
			db.addFurniture("Plastic Chair", "Chair", "Kids", 10000);
		} catch (SQLException e) {
			System.out.println(e);
		}
		db.editFurniture(9, "Plastic Kursi", "Chair", "Kids", 10000);
		assertEquals("Plastic Kursi", db.getFurniture(9).getName());
	}

	@Test
	public void testCheckFurniture() throws SQLException {

		assertTrue(db.checkFurniture("SportsCar Bed"));
	}
}
