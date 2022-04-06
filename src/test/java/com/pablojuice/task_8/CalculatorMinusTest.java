package com.pablojuice.task_8;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorMinusTest {

	@Test
	public void calculatorMinusTest() {
		Assert.assertEquals(Calculator.minus(5, 1), 4d);
		Assert.assertEquals(Calculator.minus(10, 2), 8d);
		Assert.assertEquals(Calculator.minus(30, 30), 0d);
	}
}
