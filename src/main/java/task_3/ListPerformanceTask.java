package task_3;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
import java.util.function.Consumer;

public class ListPerformanceTask {
	public static void main(String[] args) {
		//	4) Check performance for some List operations (get(i), insertAfter(i), ..)
		//	for different collection implementations.
		Set<String> setForTestOne = new HashSet<>();
		Set<String> setForTestTwo = new LinkedHashSet<>();

		for (int i = 0; i < 10000; i++) {
			setForTestOne.add(String.valueOf(UUID.randomUUID()));
			setForTestTwo.add(String.valueOf(UUID.randomUUID()));
		}

		System.out.printf(
				"Avg time for collection1 in test One is %s ms%n",
				checkPerformanceByConsumer(setForTestOne::contains, 1)
		);
		System.out.printf(
				"Avg time for collection2 in test One is %s ms%n",
				checkPerformanceByConsumer(setForTestTwo::contains, 1)
		);
		System.out.printf(
				"Avg time for collection1 in test Two is %s ms%n",
				checkPerformanceByConsumer(setForTestOne::add, 1)
		);
		System.out.printf(
				"Avg time for collection2 in test Two is %s ms%n",
				checkPerformanceByConsumer(setForTestTwo::add, 1)
		);
	}

	public static double checkPerformanceByConsumer(Consumer<String> consumer, int tries) {
		long result = 0;
		for (int i = 0; i < tries; i++) {
			String random = UUID.randomUUID().toString();
			long startTime = System.currentTimeMillis();
			consumer.accept(random);
			result += System.currentTimeMillis() - startTime;
		}
		return result / ((double) tries);
	}
}
