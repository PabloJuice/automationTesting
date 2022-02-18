package taskTwo;

import java.util.*;

public class CollectionTask {
	public static void main(String[] args) {
		//	1) Implement an application to work with a list.
		//	In the 1st half of the list replace all elements E1 with E2
		System.out.println(replaceInFirstHalfOfList(Arrays.asList("12", "23", "34", "12", "56", "67"), "12", "21"));

		//	2) Input: matrix of integers.
		//	a) Print out matrix in reverse order.
		List<List<Integer>> matrix = Arrays.asList(
				Arrays.asList(1, 2, 3, 4, 5),
				Arrays.asList(6, 7, 8, 9, 10),
				Arrays.asList(1, 2, 3, 4, 5),
				Arrays.asList(6, 7, 8, 9, 10)
		);
		System.out.println(reverseIntMatrix(matrix));
		//	b) Print out matrix with unique values (delete duplicates)
		System.out.println(deleteDuplicateValuesInMatrix(matrix));
	}

	public static List<List<Integer>> reverseIntMatrix(List<List<Integer>> input) {
		List<List<Integer>> output = new ArrayList<>();
		for (int i = 0; i < input.get(0).size(); i++) {
			output.add(new ArrayList<>());
		}
		for (int i = 0; i < input.get(0).size(); i++) {
			for (List<Integer> integers : input) {
				output.get(i).add(integers.get(i));
			}
		}
		return output;
	}

	public static List<List<Integer>> deleteDuplicateValuesInMatrix(List<List<Integer>> input) {
		Set<Integer> uniqueValues = new HashSet<>();
		List<List<Integer>> output = new ArrayList<>();
		for (List<Integer> list : input) {
			output.add(new ArrayList<>());
			for (Integer i : list) {
				if (!uniqueValues.contains(i)) {
					output.get(output.size() - 1).add(i);
					uniqueValues.add(i);
				}
			}
			if (output.get(output.size() - 1).isEmpty())
				output.remove(output.size() - 1);
		}
		return output;
	}

	public static List<Object> replaceInFirstHalfOfList(List<Object> input, Object oldValue, Object newValue) {
		List<Object> output = new ArrayList<>(input.subList(0, (input.size() - 1) / 2));
		output.replaceAll(o -> {
			if (o.equals(oldValue))
				return newValue;
			return o;
		});
		output.addAll(input.subList((input.size() - 1) / 2, input.size()));
		return output;
	}
}
