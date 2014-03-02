package me.nickpierson.Sorts;

public class BubbleSort extends Sort {

	@Override
	public String getName() {
		return "Bubble Sort";
	}

	@Override
	protected void sort(int[] values) {
		boolean swapped;
		for (int j = values.length - 1; j > 0; j--) {
			swapped = false;
			for (int i = 0; i < j; i++) {
				selected.add(i);
				selected.add(i + 1);
				comparisons++;

				if (values[i] > values[i + 1]) {
					swaps++;
					swap(values, i, i + 1);
					swapped = true;
				}

				// stop sorting if flag is ever false
				if (!isSorting) {
					selected.clear();
					return;
				}

				sleep();

				selected.clear();
			}

			if (!swapped) {
				break;
			}
		}
	}
}
