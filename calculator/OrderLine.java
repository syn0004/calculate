package com.calculator;

import com.calculator.Item;

/**
 * represents an order line which contains the @link Item and the quantity.
 * 
 * @author krishna See {@link #Item(String, BigDecimal)} for more information.
 *
 */
public class OrderLine {

	private int quantity;
	private Item item;

	/**
	 * 
	 * @param item
	 *            Item of the order
	 * @param quantity
	 *            Quantity of the item
	 */
	public OrderLine(Item item, int quantity) throws IllegalArgumentException {
		if (item == null || quantity < 0) {
			System.err.println("ERROR - Item is NULL");
			throw new IllegalArgumentException("Item is NULL");
		}
		this.item = item;
		this.quantity = quantity;
	}

	/**
	 * 
	 * @return item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * 
	 * @return quantity
	 */
	public int getQuantity() {
		return quantity;
	}
}

