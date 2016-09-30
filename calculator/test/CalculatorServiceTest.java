package com.calculator.test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.calculator.CalculatorService;
import com.calculator.Item;
import com.calculator.Order;
import com.calculator.OrderLine;

import junit.framework.TestCase;


/**
 * @author krishna
 *
 */
public class CalculatorServiceTest extends TestCase {

     Map<String, String> priceList = new HashMap<String,String>();
     String grandTotal = null;

     /**
      * Build order with grandTotal of 31.12. Store the return total from method logic to a local variable to assert
      * @throws Exception 
      * @throws IllegalArgumentException 
      * 
      */ 
     protected void setUp() throws IllegalArgumentException{ 
          Map<String, Order> cart = new HashMap<String, Order>();
          Order order1 = new Order();
          order1.addLine(new OrderLine(new Item("book", new BigDecimal("12.49")), 1));
  	      order1.addLine(new OrderLine(new Item("music CD", new BigDecimal("14.99")), 1));
  		  order1.addLine(new OrderLine(new Item("chocolate bar", new BigDecimal("0.85")), 1));
  		  cart.put("order 1", order1);
  		  priceList = new CalculatorService().calculatePrices(cart);
  		  for(String total : priceList.values()) {
  			  grandTotal = total;
  		  }
     } 
     
     /**
      * Asserts the grandtotal returned from calculator service
      */
     public void testGrandTotal() { 
         assertEquals("31.12", grandTotal);
    } 
     
     /**
      * Test for an exception when an orderLine is not constructed properly
      */
     public void testOrderLineConstruction() { 
          try { 
               new OrderLine(null, 2);
               fail("Should raise an Illegal Argument Exception");
          } 
          catch (IllegalArgumentException success) {
          } 
     } 
     
    /**
     * Test to conclude total is calculated
     */
     public void testOrderName() {
    	 assertNotNull(grandTotal);
     }

}
