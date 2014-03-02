package me.nickpierson.Sorts;

import me.nickpierson.Utils.Point;

public class SelectionSort extends Sort {

	@Override
	public String getName() {
		return "Selection Sort";
	}

	@Override
	protected void sort(Point[] values) {
		for (int j = 0; j < values.length - 1; j++) {
			int minIndex = j;
			values[minIndex].setSelected();
			for (int i = j + 1; i < values.length; i++) {
				values[i].setSelected();
				comparisons++;
				if (values[i].getValue() < values[minIndex].getValue()) {
					values[minIndex].reset();
					minIndex = i;
					values[minIndex].setSelected();
				}

				if (!isSorting) {
					values[i].reset();
					values[minIndex].reset();
					return;
				}

				sleep();

				if (i != minIndex) {
					values[i].reset();
				}
			}

			if (minIndex != j) {
				swaps++;
				swap(values, j, minIndex);
			}

			values[j].reset();
		}
	}
}
