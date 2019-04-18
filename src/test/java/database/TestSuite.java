/***********************************************************************
                         Aricent Altran Group Proprietary

This source code is the sole property of Aricent Altran Group. Any form of 
utilization of this source code in whole or in part is  prohibited without 
 written consent from
Aricent Altran Group

	  File Name	          	    : TestSuite.java
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

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({TestCart.class, TestUser.class, TestFurniture.class, TestOrder.class})

public class TestSuite {

	public void printInit() {
		System.out.println("Run Test Suite");
	}
	
}
