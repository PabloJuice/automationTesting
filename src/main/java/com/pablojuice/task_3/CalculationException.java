package com.pablojuice.task_3;

//	1) Make your own Exception implementation. Use it in your CalcApp
public class CalculationException extends Exception {
	public CalculationException(String message) {
		super("CalculationException :c " + message);
	}
}
