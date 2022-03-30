package com.pablojuice.task_4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GenericTask {
	//Make two different comparators for your Custom class (simple java class with few fields).
	// End users should be able to use ‘min’, ‘max’, ‘sotr’ methods with that comparators.

	public static void main(String[] args) {
		List<People> people = new ArrayList<>();
		people.add(new People(80d, 195d));
		people.add(new People(90d, 165d));
		people.add(new People(72d, 181d));
		people.add(new People(60d, 172d));
		people.add(new People(63d, 156d));
		people.add(new People(77d, 167d));
		people.add(new People(56d, 155d));
		people.add(new People(120d, 199d));
		people.add(new People(101d, 191d));
		Comparator<People> peopleComparator = Comparator.comparingDouble(People::getHeight)
				.thenComparingDouble(People::getWeight);

		System.out.println(sort(people, peopleComparator));
		System.out.println(min(people, peopleComparator));
		System.out.println(max(people, peopleComparator));
	}

	public static <T> List<T> sort(Collection<T> collection, Comparator<T> comparator) {
		if (collection == null || comparator == null) {
			return null;
		}
		return collection.stream().sorted(comparator).collect(Collectors.toList());
	}

	public static <T> T min(Collection<T> collection, Comparator<T> comparator) {
		List<T> list = sort(collection, comparator);
		if (list == null || list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	public static <T> T max(Collection<T> collection, Comparator<T> comparator) {
		List<T> list = sort(collection, comparator);
		if (list == null || list.isEmpty()) {
			return null;
		}
		return list.get(list.size() - 1);
	}

	private static class People {
		private Double weight;
		private Double height;

		public People(Double weight, Double height) {
			this.weight = weight;
			this.height = height;
		}

		public Double getWeight() {
			return weight;
		}

		public void setWeight(Double weight) {
			this.weight = weight;
		}

		public Double getHeight() {
			return height;
		}

		public void setHeight(Double height) {
			this.height = height;
		}

		@Override
		public String toString() {
			return "People{" +
					"weight=" + weight +
					", height=" + height +
					'}';
		}
	}
}
