package task_4;

import java.util.Comparator;

public class GenericTask {
	//Make two different comparators for your Custom class (simple java class with few fields).
	// End users should be able to use ‘min’, ‘max’, ‘sotr’ methods with that comparators.

	public static void main(String[] args) {

	}

	private static class People{
		public static final Comparator<People> minComparator = new Comparator<People>() {
			@Override
			public int compare(People o1, People o2) {
				int i = o1.getHeight().compareTo(o2.getHeight());
				if (i != 0) return i;
				i = o1.getWeight().compareTo(o2.getWeight());
				return i;
			}
		};
		public static final Comparator<People> maxComparator = new Comparator<People>() {
			@Override
			public int compare(People o1, People o2) {
				int i = o1.getHeight().compareTo(o2.getHeight());
				if (i != 0) return i;
				i = o1.getWeight().compareTo(o2.getWeight());
				return i;
			}
		};
		public static final Comparator<People> sortComparator = new Comparator<People>() {
			@Override
			public int compare(People o1, People o2) {
				int i = o1.getHeight().compareTo(o2.getHeight());
				if (i != 0) return i;
				i = o1.getWeight().compareTo(o2.getWeight());
				return i;
			}
		};
		private Double weight;
		private Double height;

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
	}
}
