package task_2;

import task_3.CalculationException;

public class Calculator {
	public static void main(String[] args) throws Exception {
		//Task 1. Implement a simple calculator with 4 operations.
		// Each operation - different method. Use it in the main method.
		double a = 10d;
		double b = 5d;

		System.out.printf("%.2f + %.2f = %.2f%n", a, b, add(a, b));
		System.out.printf("%.2f - %.2f = %.2f%n", a, b, minus(a, b));
		System.out.printf("%.2f * %.2f = %.2f%n", a, b, multiply(a, b));
		System.out.printf("%.2f / %.2f = %.2f%n", a, b, divide(a, b));
	}

	public static double add(double a, double b) throws CalculationException {
		return a + b;
	}

	public static double minus(double a, double b) throws CalculationException {
		double result = a - b;
		if (result < 0)
			throw new CalculationException("Result of minus is negative, " +
												   "but you always should stay positive");
		return result;
	}

	public static double multiply(double a, double b) throws CalculationException {
		return a * b;
	}

	public static double divide(double a, double b) throws CalculationException {
		if (b == 0)
			throw new CalculationException("Dividing by zero is restricted");
		return a / b;
	}
}
