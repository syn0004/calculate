package com.calculator;

import java.math.BigDecimal;

/**
 * represents an item, contains a price and a description.
 * 
 * @author krishna
 * @version 1.0
 */
public class Item {

	private String description;
	/**
	 * {@link BigDecimal} is used to model the price
	 */
	private BigDecimal price;

	/**
	 * Creates a new Item for the order
	 * 
	 * @param description
	 *            The description of the item
	 * @param price
	 *            The price of the item
	 */
	public Item(String description, BigDecimal price) {
		super();
		this.description = description;
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public BigDecimal getPrice() {
		return price;
	}
}
