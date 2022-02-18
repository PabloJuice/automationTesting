package taskTwo;

import java.util.Arrays;

public class ArraysTask {
	public static void main(String[] args) {
//		1) Find max number in array: 5, 9, 3, 2, 0, -4, -8.3, 3, -4
		System.out.println(findMaxNumberInArray(new double[]{5, 9, 3, 2, 0, -4, -8.3, 3, -4}));
//		2) Given array: {1, 6, 3, 3, 4, 5, 5, 6, 0}. Print array with only unique values, which are sorted.
		System.out.println(Arrays.toString(findUniqueElementsSorted(new double[]{1, 6, 3, 3, 4, 5, 5, 6, 0})));
//		3)Given an array, e.g. "12", "23", "34", "12", "56", "67“. Replace all values “12” to “replaced”
		System.out.println(Arrays.toString(replaceArrayElements(new String[]{"12", "23", "34", "12", "56", "67"},
																"12",
																"replaced")));
//		4) Print any array in reverse mode (from the end)
		System.out.println(Arrays.toString(reverseArray(new String[]{"12", "23", "34", "46", "56", "67"})));
	}

	public static double findMaxNumberInArray(double[] input) {
		double max;
		if (input.length > 0)
			max = input[0];
		else max = -1;
		for (double i : input) {
			if (max < i)
				max = i;
		}
		return max;
	}

	public static double[] findUniqueElementsSorted(double[] input) {
		return sortElements(findUniqueElements(input));
	}

	public static double[] findUniqueElements(double[] input) {
		double[] output = new double[input.length];
		int index = 0;
		for (int i = 0; i < input.length; i++) {
			int flag = 0;
			for (int j = 0; j < i; j++) {
				if (input[i] == input[j]) {
					flag = 1;
					break;
				}
			}
			if (flag == 0) {
				output[index] = input[i];
				index++;
			}
		}
		return cutDoubleArray(output, index);
	}

	public static double[] cutDoubleArray(double[] input, int index) {
		if (index < input.length) {
			double[] output = new double[index];
			for (int i = 0; i < index; i++) {
				output[i] = input[i];
			}
			return output;
		}
		return input;
	}

	public static double[] sortElements(double[] input) {
		double temp;
		for (int i = 1; i < input.length; i++) {
			for (int j = i; j > 0; j--) {
				if (input[j] < input[j - 1]) {
					temp = input[j];
					input[j] = input[j - 1];
					input[j - 1] = temp;
				}
			}
		}
		return input;
	}

	public static Object[] replaceArrayElements(Object[] input, Object oldValue, Object newValue) {
		if (input != null) {
			for (int i = 0; i < input.length; i++) {
				if (input[i].equals(oldValue)) {
					input[i] = newValue;
				}
			}
		}
		return input;
	}

	public static Object[] reverseArray(Object[] input) {
		Object[] output = new Object[input.length];
		for (int i = 0, j = output.length - 1; i < output.length; i++, j--) {
			output[i] = input[j];
		}
		return output;
	}
}
