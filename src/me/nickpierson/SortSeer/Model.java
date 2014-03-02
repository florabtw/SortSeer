package me.nickpierson.SortSeer;

import java.util.Random;

import me.nickpierson.Sorts.BubbleSort;
import me.nickpierson.Sorts.Sort;
import me.nickpierson.Utils.Constants;

public class Model {

	int[] points = new int[Constants.NUM_POINTS];
	Random myRand = new Random();

	Sort[] sorts = { new BubbleSort() };
	int currSort = 0;

	public Model() {
		resetPoints();
	}

	public void sort() {
		sorts[currSort].sort(points);
	}

	public void resetPoints() {
		for (int i = 0; i < points.length; i++) {
			points[i] = myRand.nextInt(points.length) + 1;
		}
	}

	public int[] getPoints() {
		return points;
	}
}
