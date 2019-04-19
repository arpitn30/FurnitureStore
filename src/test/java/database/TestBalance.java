/** *********************************************************************
*                        Aricent ALTRAN group Proprietary
*
*	This source code is the sole property of Aricent ALTRAN group. Any form
*	of utilization of this source code in whole or in part is  prohibited
*	without  written consent from Aricent ALTRAN group.
*
*	  File Name	            	:	TestBalance.java
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
*	  Date(DD/MM/YYYY) 			:	Apr 19, 2019
*	  Modified by				:	
*	  Description of change 	:
*
	**********************************************************************
*/
package database;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestBalance {

	static JDBC db;
	
	@BeforeClass
	public static void init() throws ClassNotFoundException, SQLException {
		db = new JDBC();
		db.setConnection();
	}
	
	@Before
	public void setBalance() throws SQLException {
		db.setBalance(1, 10000000);
	}
	
	@AfterClass
	public static void close() {
		db.closeConnection();
	}
	
	@Test
	public void testGetBalance() throws SQLException {
		assertEquals(10000000, db.getBalance(1));
	}
	
	@Test
	public void testGetBalance2() throws SQLException {
		// Get balance non-existing user_id
		assertEquals(0, db.getBalance(-1));
	}

	@Test
	public void testAddBalance() throws SQLException {
		assertEquals(1, db.addBalance(1, 100));
		assertEquals(10000100, db.getBalance(1));
	}
	
	@Test
	public void testAddBalance2() throws SQLException {
		assertEquals(0, db.addBalance(1, -2));
	}
}
