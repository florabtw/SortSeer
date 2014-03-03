package me.nickpierson.Sorts;

import me.nickpierson.Utils.Point;

public class MergeSort extends Sort {

	@Override
	public String getName() {
		return "Merge Sort";
	}

	@Override
	protected void sort(Point[] points) {
		mergeSort(points, 0, points.length);

		if (isSorting) {
			for (Point point : points) {
				point.setCompleted();
			}
		}
	}

	int stack = 0;

	protected void mergeSort(Point[] points, int begin, int end) {
		if (end - begin < 2) {
			return;
		}

		int middle = (end + begin) / 2;
		mergeSort(points, begin, middle);
		mergeSort(points, middle, end);
		merge(points, begin, middle, end);
	}

	protected void merge(Point[] points, int begin, int middle, int end) {
		Point[] newPoints = new Point[end - begin];
		int leftIndex = begin;
		int rightIndex = middle;
		for (int i = 0; i < end - begin; i++) {
			if (!isSorting) {
				points[leftIndex].deselect();
				points[rightIndex].deselect();
				return;
			}

			if (leftIndex != middle) {
				points[leftIndex].setSelected();
			}

			if (rightIndex != end) {
				points[rightIndex].setSelected();
			}

			if (leftIndex != middle && rightIndex != end) {
				comparisons++;
			}

			int toDeselect;
			if (leftIndex < middle && (rightIndex == end || points[leftIndex].getValue() <= points[rightIndex].getValue())) {
				newPoints[i] = points[leftIndex];
				toDeselect = leftIndex;
				leftIndex++;
			} else {
				newPoints[i] = points[rightIndex];
				toDeselect = rightIndex;
				rightIndex++;
			}

			sleep();

			points[toDeselect].deselect();
		}

		int counter = 0;
		for (int i = begin; i < end; i++) {
			swaps++;
			points[i] = newPoints[counter++];
		}
	}
}
