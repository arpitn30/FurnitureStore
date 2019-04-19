/***********************************************************************
                         Aricent Altran Group Proprietary

This source code is the sole property of Aricent Altran Group. Any form of 
utilization of this source code in whole or in part is  prohibited without 
 written consent from
Aricent Altran Group

	  File Name	          	    : TestUser.java
	  Principal Author      	: 
	  Subsystem Name       	    :
	  Module Name           	: database
	  Date of First Release 	:
	  Author					: 
	  Description           	:


	  Change History

	  Version      				: 1.0
	  Date(DD/MM/YYYY) 			: Apr 17, 2019
	  Modified by				: 
	  Description of change 	:

***********************************************************************/
package database;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestUser {
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
	public void testGetUser() throws SQLException {
		assertEquals("Arpit", db.getUser(1).getName());
	}

	@Test
	public void testGetUser2() throws SQLException {
		assertEquals("gagan", db.getUser("gagan@altran.com").getSecQues());
	}
	
	@Test
	public void testGetUser3() throws SQLException {
		assertEquals(null, db.getUser("nonexistant@altran.com"));
	}

	@Test(expected = SQLException.class)
	public void testAddUser() throws SQLException {
		db.addUser("Vanessa", "vv@altran.com", "passsword", "amrutha");
		int user_id = db.getUser("vv@altran.com").getId();
		assertEquals(0, db.getBalance(user_id));
	}

	@Test
	public void testUpdatePassword() throws SQLException {
		assertEquals(1, db.updatePassword(2, "123456"));
		assertEquals("123456", db.getUser(2).getPassword());
	}
	
	@Test
	public void testUpdatePassword2() throws SQLException {
		assertEquals(0, db.updatePassword(2, ""));
	}
}
