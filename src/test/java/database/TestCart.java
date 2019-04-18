/** *********************************************************************
*                        Aricent ALTRAN group Proprietary
*
*	This source code is the sole property of Aricent ALTRAN group. Any form
*	of utilization of this source code in whole or in part is  prohibited
*	without  written consent from Aricent ALTRAN group.
*
*	  File Name	            	:	TestCart.java
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
*	  Date(DD/MM/YYYY) 			:	Apr 17, 2019
*	  Modified by				:	
*	  Description of change 	:
*
	**********************************************************************
*/
package database;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * 
 *
 */
public class TestCart {

	@Test
	public void testAddToCart() {
		Local.addToCart(1, 1, 5, 5000);
		assertEquals(1, Local.getCart().get(0).getUser_id());
	}

	@Test
	public void testDeleteFromCart() {
		Local.addToCart(1, 1, 5, 5000);
		Local.addToCart(2, 1, 3, 30000);
		Local.deleteFromCart(2);
		assertEquals(1, Local.getCart().size());
	}

	@Test
	public void testClearCart() {
		Local.addToCart(1, 1, 5, 5000);
		Local.addToCart(2, 1, 3, 30000);
		Local.clearCart();
		assertTrue(Local.getCart().isEmpty());
	}
}
