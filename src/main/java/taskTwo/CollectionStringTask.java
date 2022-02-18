package taskTwo;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class CollectionStringTask {
	public static void main(String[] args) {
		//	3) Given: String with big text (more than 1000 words).
		//	Write a method that calculates the numbers of words for each letter that starts the word.
		System.out.println(calculateNumberOfWordsByLetter("Write a method that calculates the numbers of " +
																  "words for each letter that starts the word."));
	}

	public static Map<Character, Integer> calculateNumberOfWordsByLetter(String text) {
		List<String> words = List.of(text.trim().toLowerCase(Locale.ROOT).split(" "));
		Map<Character, Integer> output = new HashMap<>();
		for(String s : words){
			char firstLetter = s.charAt(0);
			if (output.containsKey(firstLetter)){
				output.put(s.charAt(0), output.get(firstLetter) + 1);
			}else {
				output.put(s.charAt(0), 1);
			}
		}
		return output;
	}
}
