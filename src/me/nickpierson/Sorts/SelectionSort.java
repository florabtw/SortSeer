package me.nickpierson.Sorts;

public class SelectionSort extends Sort {

	@Override
	public String getName() {
		return "Selection Sort";
	}

	@Override
	protected void sort(int[] values) {
		for (int j = 0; j < values.length - 1; j++) {
			int minIndex = j;
			selected.add(minIndex);
			for (int i = j + 1; i < values.length; i++) {
				selected.add(i);
				comparisons++;
				if (values[i] < values[minIndex]) {
					selected.remove(Integer.valueOf(minIndex));
					minIndex = i;
					selected.add(minIndex);
				}

				if (!isSorting) {
					selected.clear();
					return;
				}

				sleep();

				selected.remove(Integer.valueOf(i));
			}

			if (minIndex != j) {
				swaps++;
				swap(values, j, minIndex);
			}

			selected.clear();
		}
	}
}
