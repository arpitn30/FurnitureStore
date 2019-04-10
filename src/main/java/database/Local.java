/***********************************************************************
                         Aricent Altran Group Proprietary

This source code is the sole property of Aricent Altran Group. Any form of 
utilization of this source code in whole or in part is  prohibited without 
 written consent from
Aricent Altran Group

	  File Name	          	    : Local.java
	  Principal Author      	: Gagan Preet kaur
	  Subsystem Name       	    :
	  Module Name           	: database
	  Date of First Release 	:
	  Author					: 
	  Description           	:


	  Change History

	  Version      				: 1.0
	  Date(DD/MM/YYYY) 			: Apr 10, 2019
	  Modified by				: Gagan Preet Kaur
	  Description of change 	:

***********************************************************************/
package database;

import java.util.ArrayList;

import models.Order;

/**
 * @author Gagan Preet Kaur
 *
 */
public class Local {
	private static ArrayList<Order> cart = new ArrayList<Order>();

	/**
	 * @return the cart
	 */
	public static ArrayList<Order> getCart() {
		return cart;
	}

	/**
	 * @param cart the cart to set
	 */
	public static void setCart(ArrayList<Order> cart) {
		Local.cart = cart;
	}
	
	public static void addToCart(Order order) {
		Local.cart.add(order);
	}
	
	public static void deleteFromCart(int fid) {
		
	}
	
	public static void clearCart() {
		Local.cart.clear();
	}
}
