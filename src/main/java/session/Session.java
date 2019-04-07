/** *********************************************************************
*                        Aricent ALTRAN group Proprietary
*
*	This source code is the sole property of Aricent ALTRAN group. Any form
*	of utilization of this source code in whole or in part is  prohibited
*	without  written consent from Aricent ALTRAN group.
*
*	  File Name	            	:	Session.java
*	  Principal Author      	:	Arpit Nandwani
*	  Subsystem Name        	:
*	  Module Name           	:	Session
*	  Date of First Release 	:	
*	  Author					:	
*	  Description           	:
*
*
*	  Change History
*
*	  Version      				:	1.0
*	  Date(DD/MM/YYYY) 			:	Mar 20, 2019
*	  Modified by				:	Arpit Nandwani
*	  Description of change 	:
*
	**********************************************************************
*/
package session;

/**
 * @author Arpit Nandwani
 *
 */
public class Session {
	private static int id = -1;
	private static String name = null;
	/**
	 * @return the id
	 */
	public static int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public static void setId(int id) {
		Session.id = id;
	}
	
	
	/**
	 * @return the name
	 */
	public static String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public static void setName(String name) {
		Session.name = name;
	}
	
	public static void reset() {
		Session.id = -1;
		Session.name = null;
	}
}
