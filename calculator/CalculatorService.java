package com.calculator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import com.calculator.Order;

/**
 * Contains the logic for calculating taxes and price of the order items.
 * 
 * @author krishna
 *
 */
public class CalculatorService {

	/**
	 * receives a collection of orders. Calculate total price and tax iterating
	 * through order lines of each order
	 * 
	 * Print total tax and price on the console for each order
	 * 
	 * @param o
	 *            The map of Orders
	 */
	public Map<String, String> calculatePrices(Map<String, Order> o) {

		BigDecimal grandtotal = new BigDecimal(0);
		Map<String, String> priceList = new HashMap<>();
		Consumer<Object> printToConsole = System.out::println;

		// Iterate through the orders
		for (Map.Entry<String, Order> entry : o.entrySet()) {

			printToConsole.accept("*******" + entry.getKey() + "*******");

			Order r = entry.getValue();
			BigDecimal totalTax = new BigDecimal(0);
			BigDecimal total = new BigDecimal(0);
			MathContext mc = new MathContext(2); // Precision on digits

			// Iterate through the items in the order
			for (int i = 0; i < r.getOrderSize(); i++) {
				BigDecimal tax = new BigDecimal(0);
                // Extra 5% tax on imported items
				if (r.getOrder(i).getItem().getDescription().contains("imported")) {
					BigDecimal bg1 = new BigDecimal("0.15");
					tax = r.getOrder(i).getItem().getPrice().multiply(bg1, mc);
				} else {
					BigDecimal bg1 = new BigDecimal("0.10");
					tax = r.getOrder(i).getItem().getPrice().multiply(bg1, mc);
				}

				// Calculate the total price
				BigDecimal totalprice = r.getOrder(i).getItem().getPrice().add(tax).setScale(2, BigDecimal.ROUND_HALF_UP);

				// Print out the item's total price
				printToConsole.accept(r.getOrder(i).getItem().getDescription() + ": " + totalprice);

				// Keep a running total
				totalTax = totalTax.add(tax).setScale(2, BigDecimal.ROUND_HALF_UP);
				total = total.add(r.getOrder(i).getItem().getPrice());
			}

			// Print out the total taxes
			printToConsole.accept("Sales Tax: " + totalTax);
			printToConsole.accept("Total before taxes: " + total);

			total = total.add(totalTax);
			

			// Print out the total amount
			System.out.println("Total after taxes: " + total);
			grandtotal = grandtotal.add(total).setScale(2, BigDecimal.ROUND_HALF_UP);
			priceList.put("grandtotal", grandtotal.toString());
		}
		printToConsole.accept("************************************");
		printToConsole.accept("Sum of orders after taxes: " + grandtotal);
		return priceList;
	}
}