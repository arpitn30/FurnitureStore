/***********************************************************************
                         Aricent Altran Group Proprietary

This source code is the sole property of Aricent Altran Group. Any form of 
utilization of this source code in whole or in part is  prohibited without 
 written consent from
Aricent Altran Group

	  File Name	          	    : Order.java
	  Principal Author      	: Gagan Preet kaur
	  Subsystem Name       	    :
	  Module Name           	: models
	  Date of First Release 	:
	  Author					: 
	  Description           	:


	  Change History

	  Version      				: 1.0
	  Date(DD/MM/YYYY) 			: Apr 10, 2019
	  Modified by				: Gagan Preet Kaur
	  Description of change 	:

***********************************************************************/
package models;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Gagan Preet Kaur
 *
 */
public class Order {

	int id;
	int fid;
	int uid;
	int quantity;
	Date orderDate;
	long totalAmount;
	SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
	
	
	/**
	 * @param id
	 * @param fid
	 * @param uid
	 * @param quantity
	 * @param orderDate
	 */
	public Order(int id, int fid, int uid, int quantity, Date orderDate, long totalAmount) {
		this.id = id;
		this.fid = fid;
		this.uid = uid;
		this.quantity = quantity;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
	}
	
	/**
	 * @param fid
	 * @param uid
	 * @param quantity
	 * @param date
	 * @param orderDate
	 */
	public Order(int fid, int uid, int quantity, long totalAmount) {
		this.fid = fid;
		this.uid = uid;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
	}
	
	
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
	 * @return the fid
	 */
	public int getFid() {
		return fid;
	}
	/**
	 * @param fid the fid to set
	 */
	public void setFid(int fid) {
		this.fid = fid;
	}
	/**
	 * @return the uid
	 */
	public int getUid() {
		return uid;
	}
	/**
	 * @param uid the uid to set
	 */
	public void setUid(int uid) {
		this.uid = uid;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the orderDate
	 */
	public Date getOrderDate() {
		return orderDate;
	}
	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
}
