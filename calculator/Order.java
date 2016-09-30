package com.calculator;

import java.util.ArrayList;
import java.util.List;

import com.calculator.OrderLine;

/**
 * represents an order which contains a list of orderLines.
 * 
 * @author krishna See {@link #OrderLine() } for more information.
 *
 */
public class Order {

	private List<OrderLine> orderLines = new ArrayList<>();

	public void addLine(OrderLine o) throws IllegalArgumentException {
		if (o == null) {
			System.err.println("ERROR - Order is NULL");
			throw new IllegalArgumentException("Order is NULL");
		}
		orderLines.add(o);
	}

	/**
	 * 
	 * @return size of the order list
	 */
	public int getOrderSize() {
		return orderLines.size();
	}

	/**
	 * 
	 * @param i
	 *            index of the order in list
	 * @return order from the list
	 */
	public OrderLine getOrder(int i) {
		return orderLines.get(i);
	}

	/**
	 * clears the list
	 */
	public void clearOrder() {
		this.orderLines.clear();
	}
}

