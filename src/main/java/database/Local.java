/***********************************************************************
                         Aricent Altran Group Proprietary

This source code is the sole property of Aricent Altran Group. Any form of 
utilization of this source code in whole or in part is  prohibited without 
 written consent from
Aricent Altran Group

	  File Name	          	    : Local.java
	  Principal Author      	:
	  Subsystem Name       	    :
	  Module Name           	: database
	  Date of First Release 	:
	  Author					: 
	  Description           	:


	  Change History

	  Version      				: 1.0
	  Date(DD/MM/YYYY) 			: Apr 10, 2019
	  Modified by				:
	  Description of change 	:

***********************************************************************/
package database;

import java.util.ArrayList;
import java.util.Iterator;

import models.Order;

/**
 * 
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
	 * @param cart
	 *            the cart to set
	 */
	public static void setCart(ArrayList<Order> cart) {
		Local.cart = cart;
	}

	/**
	 * Add an item to the cart and if the item already exists in the cart then
	 * update the quantity of that item in the cart
	 * 
	 * @param furniture_id
	 * @param user_id
	 * @param quantity
	 * @param totalAmount
	 */
	public static void addToCart(int furniture_id, int user_id, int quantity,
			long totalAmount) {
		if(quantity <= 0 || totalAmount <= 0)
			return ;
		Iterator<Order> itr = cart.iterator();
		while (itr.hasNext()) {
			Order item = itr.next();
			if (item.getFurniture_id() == furniture_id) {
				item.setQuantity(item.getQuantity() + quantity);
				item.setTotalAmount(item.getTotalAmount() + totalAmount);
				return;
			}
		}
		Local.cart.add(new Order(furniture_id, user_id, quantity, totalAmount));
	}

	/**
	 * Delete an item from the cart
	 * 
	 * @param furniture_id
	 */
	public static void deleteFromCart(int furniture_id) {
		Iterator<Order> itr = cart.iterator();
		while (itr.hasNext()) {
			if (itr.next().getFurniture_id() == furniture_id)
				itr.remove();
		}
	}

	/**
	 * Edit the quantity and total amount of a quantity in the cart
	 * 
	 * @param furniture_id
	 * @param quantity
	 * @param totalAmount
	 */
	public static void editCart(int furniture_id, int quantity,
			long totalAmount) {
		if(quantity <= 0 || totalAmount <= 0)
			return ;
		Iterator<Order> itr = cart.iterator();
		while (itr.hasNext()) {
			Order item = itr.next();
			if (item.getFurniture_id() == furniture_id) {
				item.setQuantity(quantity);
				item.setTotalAmount(totalAmount);
			}
		}
	}

	public static void clearCart() {
		Local.cart.clear();
	}
}
