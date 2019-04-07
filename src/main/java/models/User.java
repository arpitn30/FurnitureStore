/** *********************************************************************
*                        Aricent ALTRAN group Proprietary
*
*	This source code is the sole property of Aricent ALTRAN group. Any form
*	of utilization of this source code in whole or in part is  prohibited
*	without  written consent from Aricent ALTRAN group.
*
*	  File Name	            	:	User.java
*	  Principal Author      	:	Arpit Nandwani
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
*	  Date(DD/MM/YYYY) 			:	Apr 4, 2019
*	  Modified by				:	Arpit Nandwani
*	  Description of change 	:
*
	**********************************************************************
*/
package models;

/**
 * 
 *
 */
public class User {

	private int id;
	private String name;
	private String email;
	private String password;
	private long balance;
	private String secQues;
	
	/**
	 * @param id
	 * @param name
	 * @param email
	 * @param password
	 * @param balance
	 * @param secQues
	 */
	public User(int id, String name, String email, String password, long balance, String secQues) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.balance = balance;
		this.secQues = secQues;
	}
	/**
	 * @param name
	 * @param email
	 * @param password
	 * @param balance
	 * @param secQues
	 */
	public User(String name, String email, String password, long balance, String secQues) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.balance = balance;
		this.secQues = secQues;
	}
	
	/*
	 * Getter Setter for member variables
	 */
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the balance
	 */
	public long getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(long balance) {
		this.balance = balance;
	}
	/**
	 * @return the secQues
	 */
	public String getSecQues() {
		return secQues;
	}
	/**
	 * @param secQues the secQues to set
	 */
	public void setSecQues(String secQues) {
		this.secQues = secQues;
	}
}
