package me.nickpierson.Sorts;

import me.nickpierson.Utils.Point;

public class InsertionSort extends Sort {

	@Override
	public String getName() {
		return "Insertion Sort";
	}

	@Override
	protected void sort(Point[] points) {
		for (int i = 1; i < points.length; i++) {
			int j = i;
			points[j].setSelected();
			while (j > 0 && points[j - 1].getValue() > points[j].getValue()) {
				comparisons++;
				swaps++;
				swap(points, j, j - 1);
				j--;

				if (!isSorting) {
					points[j].deselect();
					return;
				}

				sleep();
			}

			// while loop terminates on comparison, unless j is 0
			if (j != 0) {
				comparisons++;
			}

			points[j].deselect();
		}

		for (Point point : points) {
			point.setCompleted();
		}
	}
}
