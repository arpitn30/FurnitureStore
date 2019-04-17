/** *********************************************************************
*                        Aricent ALTRAN group Proprietary
*
*	This source code is the sole property of Aricent ALTRAN group. Any form
*	of utilization of this source code in whole or in part is  prohibited
*	without  written consent from Aricent ALTRAN group.
*
*	  File Name	            	:	Session.java
*	  Principal Author      	:	
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
*	  Modified by				:	
*	  Description of change 	:
*
	**********************************************************************
*/
package session;

/**
 * 
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
	 * @param id
	 *            the id to set
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
	 * @param name
	 *            the name to set
	 */
	public static void setName(String name) {
		Session.name = name;
	}

	/**
	 * Check if Session is set
	 * 
	 * @return
	 */
	public static boolean isSet() {
		if (Session.id == -1)
			return false;
		else
			return true;
	}

	/**
	 * Check if the logged in user is admin
	 * 
	 * @return
	 */
	public static boolean isAdmin() {
		if (Session.id == 0)
			return true;
		else
			return false;
	}

	/**
	 * Reset Session
	 */
	public static void reset() {
		Session.id = -1;
		Session.name = null;
	}
}
