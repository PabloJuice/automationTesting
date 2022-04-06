package com.pablojuice.task_8;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorMultiplyTest {

	@DataProvider
	public static Object[][] calculatorAddDataProvider() {
		return new Object[][]{
				{1,2},
				{3,4},
				{1,7},
				{1,6},
				{1,2},
				{3,2},
				{1,345}
		};
	}

	@Test()
	public void calculatorMultiplyTest() {
		Assert.assertEquals(Calculator.multiply(1, 1), 1d);
		Assert.assertEquals(Calculator.multiply(2, 2), 4d);
		Assert.assertEquals(Calculator.multiply(3, 3), 9d);
	}

	@Test(dataProvider = "calculatorAddDataProvider")
	public void calculatorMultiplyTest(int a, int b){
		double expected = a * b;
		Assert.assertEquals(Calculator.multiply(a, b), expected);
	}
}
