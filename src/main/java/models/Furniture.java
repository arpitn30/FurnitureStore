/** *********************************************************************
*                        Aricent ALTRAN group Proprietary
*
*	This source code is the sole property of Aricent ALTRAN group. Any form
*	of utilization of this source code in whole or in part is  prohibited
*	without  written consent from Aricent ALTRAN group.
*
*	  File Name	            	:	Furniture.java
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
public class Furniture {

	private int id;
	private String name;
	private String type;
	private String room;
	private int price;
	private String image;
	
	public Furniture() {
		this.name = "";
		this.type = "";
		this.room = "";
		this.price = 0;
	}	

	/**
	 * Parameterized constructor
	 * @param id
	 * @param name
	 * @param type
	 * @param room
	 * @param price
	 * @param image
	 */
	public Furniture(int id, String name, String type, String room, int price,
			String image) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.room = room;
		this.price = price;
		if(image == null)
			this.image = "static/img/furniture/default.png";
		else 
			this.image = "static/img/furniture/" + image + ".png";
	}

	/*
	 * Getter Setter for the member variables
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
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the room
	 */
	public String getRoom() {
		return room;
	}

	/**
	 * @param room the room to set
	 */
	public void setRoom(String room) {
		this.room = room;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
	
}
