package com.pablojuice.task_8;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorAddTest {

	@Test
	public void calculatorAddTest() {
		Assert.assertEquals(Calculator.add(1, 1), 2d);
		Assert.assertEquals(Calculator.add(2, 2), 4d);
		Assert.assertEquals(Calculator.add(3, 3), 6d);
	}
}
