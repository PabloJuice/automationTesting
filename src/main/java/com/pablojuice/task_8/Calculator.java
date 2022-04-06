package com.pablojuice.task_8;

public class Calculator {

	public static <N extends Number> double add(N a, N b) {
		return a.doubleValue() + b.doubleValue();
	}

	public static <N extends Number> double minus(N a, N b) {
		return a.doubleValue() - b.doubleValue();
	}

	public static <N extends Number> double multiply(N a, N b) {
		return a.doubleValue() * b.doubleValue();
	}

	public static <N extends Number> double divide(N a, N b) {
		return a.doubleValue() / b.doubleValue();
	}
}
