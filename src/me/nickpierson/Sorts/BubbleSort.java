package me.nickpierson.Sorts;

import me.nickpierson.Utils.Point;

public class BubbleSort extends Sort {

	@Override
	public String getName() {
		return "Bubble Sort";
	}

	@Override
	protected void sort(Point[] values) {
		boolean swapped;
		for (int j = values.length - 1; j > 0; j--) {
			swapped = false;
			for (int i = 0; i < j; i++) {
				values[i].setSelected();
				values[i + 1].setSelected();
				comparisons++;

				if (values[i].getValue() > values[i + 1].getValue()) {
					swaps++;
					swap(values, i, i + 1);
					swapped = true;
				}

				// stop sorting if flag is ever false
				if (!isSorting) {
					values[i].reset();
					values[i + 1].reset();
					return;
				}

				sleep();

				values[i].reset();
				values[i + 1].reset();
			}

			if (!swapped) {
				break;
			}
		}
	}
}
