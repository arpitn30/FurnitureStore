/** *********************************************************************
*                        Aricent ALTRAN group Proprietary
*
*	This source code is the sole property of Aricent ALTRAN group. Any form
*	of utilization of this source code in whole or in part is  prohibited
*	without  written consent from Aricent ALTRAN group.
*
*	  File Name	            	:	UserDAO.java
*	  Principal Author      	:	
*	  Subsystem Name        	:
*	  Module Name           	:	models
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
package models;

/**
 *
 *
 */
public interface UserDAO {

	/*
	 * Getter Setter for member variables
	 */
	/**
	 * @return the id
	 */
	public int getId();

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id);

	/**
	 * @return the name
	 */
	public String getName();

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name);

	/**
	 * @return the email
	 */
	public String getEmail();

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email);

	/**
	 * @return the password
	 */
	public String getPassword();

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password);

	/**
	 * @return the secQues
	 */
	public String getSecQues();

	/**
	 * @param secQues
	 *            the secQues to set
	 */
	public void setSecQues(String secQues);
}
