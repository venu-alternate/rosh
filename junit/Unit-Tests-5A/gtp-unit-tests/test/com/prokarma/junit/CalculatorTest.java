package com.prokarma.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import junit.framework.Assert;

import org.junit.Test;

import com.prokarma.junit.Calculator;

public class CalculatorTest {

  private Calculator calc;
  
  @Test
  public void testAdd() {
	    calc = new Calculator();
	    assertEquals(calc.add(2, 2),4);
	  }
  
  
  @Test
  public final void testSubtract() {
	  calc = new Calculator();

	  assertEquals(calc.subtract(60, 30), 30);

	  }

	  // test case method name should start with test.
  @Test
	  public final void testMultiply() {
	  calc = new Calculator();

	  assertEquals(calc.multiply(100, 3), 300);

	  }

	  // test case method name should start with test.
  @Test
	  public final void testDivide() {
	  calc = new Calculator();

	  assertEquals(calc.divide(333, 3), 111);

	  try {

	  assertEquals(calc.divide(100, 0), 20);
	  calc = new Calculator();

	  } catch (Exception e) {

	  // Exception is expected so asserting for true.

	  assertTrue(true);

	  }

  }


 
  

}
