package me.nickpierson.Sorts;

import me.nickpierson.Utils.Point;

public class SelectionSort extends Sort {

	@Override
	public String getName() {
		return "Selection Sort";
	}

	@Override
	protected void sort(Point[] points) {
		for (int j = 0; j < points.length - 1; j++) {
			int minIndex = j;
			points[minIndex].setSelected();
			for (int i = j + 1; i < points.length; i++) {
				points[i].setSelected();
				comparisons++;
				if (points[i].getValue() < points[minIndex].getValue()) {
					points[minIndex].deselect();
					minIndex = i;
					points[minIndex].setSelected();
				}

				if (!isSorting) {
					points[i].deselect();
					points[minIndex].deselect();
					return;
				}

				sleep();

				if (i != minIndex) {
					points[i].deselect();
				}
			}

			if (minIndex != j) {
				swaps++;
				swap(points, j, minIndex);
			}

			points[j].setCompleted();
		}

		points[points.length - 1].setCompleted();
	}
}
