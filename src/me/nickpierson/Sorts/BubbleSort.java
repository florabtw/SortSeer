package me.nickpierson.Sorts;

public class BubbleSort extends Sort {

	@Override
	public String getName() {
		return "Bubble Sort";
	}

	@Override
	protected void sort(int[] values) {
		boolean swapped = true;
		while (swapped) {
			swapped = false;
			for (int i = 0; i < values.length - 1; i++) {
				if (values[i] > values[i + 1]) {
					swap(values, i, i + 1);
					swapped = true;
				}

				try {
					Thread.sleep(1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
