package me.nickpierson.Sorts;

import java.util.Arrays;

public class SelectionSort extends Sort {

	@Override
	public String getName() {
		return "Selection Sort";
	}

	@Override
	public void sort(int[] values) {
		// temporary of course
		Arrays.sort(values);
	}
}
