package me.nickpierson.Sorts;

import java.util.Random;

import me.nickpierson.Utils.Point;

public class QuickSort extends Sort {

	Random rand = new Random();

	@Override
	public String getName() {
		return "Quicksort";
	}

	@Override
	protected void sort(Point[] points) {
		quicksort(points, 0, points.length - 1);

		/*
		 * last point doesn't always get set to complete because every point but the last one will at some time fall into a left quicksort and only points that
		 * make it into a left quicksort get set to complete
		 */
		if (isSorting) {
			points[points.length - 1].setCompleted();
		}
	}

	protected void quicksort(Point[] points, int left, int right) {
		if (left < right) {
			int pivot = rand.nextInt(right - left) + left;
			int pivotNewIndex = partition(points, left, right, pivot);
			quicksort(points, left, pivotNewIndex - 1);

			if (isSorting) {
				for (int i = left; i < pivotNewIndex; i++) {
					points[i].setCompleted();
				}
			}

			quicksort(points, pivotNewIndex + 1, right);
		}
	}

	protected int partition(Point[] points, int left, int right, int pivot) {
		int pivotValue = points[pivot].getValue();
		swaps++;
		swap(points, pivot, right);
		int storeIndex = left;

		points[right].setSelected();

		for (int i = left; i <= right; i++) {
			if (!isSorting) {
				points[right].deselect();
				return storeIndex;
			}

			points[i].setSelected();

			sleep();

			comparisons++;
			if (points[i].getValue() < pivotValue) {
				swaps++;
				swap(points, i, storeIndex);
				points[storeIndex].deselect();
				storeIndex++;
			} else {
				points[i].deselect();
			}

		}

		swaps++;
		swap(points, storeIndex, right);
		points[storeIndex].setCompleted();
		return storeIndex;
	}
}
