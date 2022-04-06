package com.pablojuice.task_8;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CalculatorDivideTest {

	@Test
	public void calculatorDivideTest() {
		Assert.assertEquals(Calculator.divide(1, 1), 1d);
		Assert.assertEquals(Calculator.divide(4, 2), 2d);
		Assert.assertEquals(Calculator.divide(9, 3), 3d);
	}

	@Test
	@Parameters({"a", "b"})
	public void calculatorMultiplyTest(int a, int b){
		double expected = a * b;
		Assert.assertEquals(Calculator.multiply(a, b), expected);
	}
}
