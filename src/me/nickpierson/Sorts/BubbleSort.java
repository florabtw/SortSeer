package me.nickpierson.Sorts;

import me.nickpierson.Utils.Point;

public class BubbleSort extends Sort {

	@Override
	public String getName() {
		return "Bubble Sort";
	}

	@Override
	protected void sort(Point[] points) {
		boolean swapped;
		for (int j = points.length - 1; j > 0; j--) {
			swapped = false;
			for (int i = 0; i < j; i++) {
				points[i].setSelected();
				points[i + 1].setSelected();
				comparisons++;

				if (points[i].getValue() > points[i + 1].getValue()) {
					swaps++;
					swap(points, i, i + 1);
					swapped = true;
				}

				// stop sorting if flag is ever false
				if (!isSorting) {
					points[i].deselect();
					points[i + 1].deselect();
					return;
				}

				sleep();

				points[i].deselect();
				points[i + 1].deselect();
			}

			points[j].setCompleted();

			if (!swapped) {
				for (Point point : points) {
					point.setCompleted();
				}
				break;
			}
		}
	}
}
