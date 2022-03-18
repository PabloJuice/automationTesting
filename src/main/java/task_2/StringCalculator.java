package task_2;

import java.util.Arrays;

public class StringCalculator {
	public static void main(String[] args) {
		String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do " +
				"eiusmod tempor incididunt ut labore et dolore magna aliqua.";
		//Task 2. Given a string, find the number of words in it.
		System.out.println(
				calculateNumberOfWordsInString(text)
		);

		//Task 3. Given a string, show number of chars in each word
		System.out.println(Arrays.toString(calculateNumberOfCharsInEachWord(text)));

		//Task 4. Create function which takes 2 parameters:
		//1st(String) – text; 2nd (int) - index of word.
		// Function should return number of chars in word by its index in text
		System.out.println(calculateNumberOfCharsInSpecificWord(text, 5));
	}

	public static int calculateNumberOfWordsInString(String s) {
		if (s == null)
			return 0;
		return splitStringByWord(s).length;
	}

	private static String[] splitStringByWord(String s) {
		if (s == null)
			return new String[]{};
		return s.trim().split(" ");
	}

	public static int[] calculateNumberOfCharsInEachWord(String text) {
		int[] result = new int[]{0};
		if (text == null)
			return result;
		String[] textSplitted = splitStringByWord(text);
		result = new int[textSplitted.length];
		for (int i = 0; i < textSplitted.length; i++) {
			result[i] = calculateNumberOfCharsInWord(textSplitted[i]);
		}
		return result;
	}

	public static int calculateNumberOfCharsInWord(String word) {
		if (word == null)
			return 0;
		return word.trim()
				.replace(".", "")
				.replace(",", "")
				.length();
	}

	public static int calculateNumberOfCharsInSpecificWord(String text, int index) {
		if (text == null || index < 0)
			return 0;
		return calculateNumberOfCharsInWord(splitStringByWord(text)[index]);
	}
}
