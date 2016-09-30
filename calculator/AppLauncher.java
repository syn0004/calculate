package com.calculator;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import com.calculator.Item;
import com.calculator.Order;
import com.calculator.OrderLine;

/**
 * Runnable Main class for inserting and calculating order totals
 * 
 * @author krishna
 *
 */
public class AppLauncher {

	public static void main(String[] args) throws Exception {

		Map<String, Order> cart = new HashMap<String, Order>();
		Order order1 = new Order();
		Order order2 = new Order();
		Order order3 = new Order();

		// Build Orders and store in a map
		order1.addLine(new OrderLine(new Item("book", new BigDecimal("12.49")), 1));
	    order1.addLine(new OrderLine(new Item("music CD", new BigDecimal("14.99")), 1));
		order1.addLine(new OrderLine(new Item("chocolate bar", new BigDecimal("0.85")), 1));

		cart.put("Order 1", order1);

		order2.addLine(new OrderLine(new Item("imported box of chocolate", new BigDecimal("10")), 1));
		order2.addLine(new OrderLine(new Item("imported bottle of perfume", new BigDecimal("47.50")), 1));

		cart.put("Order 2", order2);

		order3.addLine(new OrderLine(new Item("Imported bottle of perfume", new BigDecimal("27.99")), 1));
		order3.addLine(new OrderLine(new Item("bottle of perfume", new BigDecimal("18.99")), 1));
		order3.addLine(new OrderLine(new Item("packet of headache pills", new BigDecimal("9.75")), 1));
		order3.addLine(new OrderLine(new Item("box of importd chocolates", new BigDecimal("11.25")), 1));

		cart.put("Order 3", order3);

		// Call calculate method passing the orders
		new CalculatorService().calculatePrices(cart);

	}
}
