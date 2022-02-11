package taskOne;

public class Calculator {
	public static void main(String[] args) {
		//Task 1. Implement a simple calculator with 4 operations.
		// Each operation - different method. Use it in the main method.
		double a = 10d;
		double b = 5d;

		System.out.printf("%.2f + %.2f = %.2f%n", a, b, add(a, b));
		System.out.printf("%.2f - %.2f = %.2f%n", a, b, minus(a, b));
		System.out.printf("%.2f * %.2f = %.2f%n", a, b, multiply(a, b));
		System.out.printf("%.2f / %.2f = %.2f%n", a, b, divide(a, b));
	}

	public static double add(double a, double b) {
		return a + b;
	}

	public static double minus(double a, double b) {
		return a - b;
	}

	public static double multiply(double a, double b) {
		return a * b;
	}

	public static double divide(double a, double b) {
		return a / b;
	}
}
