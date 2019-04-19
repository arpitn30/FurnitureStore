/** *********************************************************************
*                        Aricent ALTRAN group Proprietary
*
*	This source code is the sole property of Aricent ALTRAN group. Any form
*	of utilization of this source code in whole or in part is  prohibited
*	without  written consent from Aricent ALTRAN group.
*
*	  File Name	            	:	TestSuite.java
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

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestSuite {

	public static void main(String[] args) {
		 Result result = JUnitCore.runClasses(TestSuiteUtil.class);

	      for (Failure failure : result.getFailures()) 
	      {
	         System.out.println(failure.toString());
	      }
			
	      System.out.println("Result: " + result.wasSuccessful());

	}

}
