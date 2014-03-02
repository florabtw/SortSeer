package me.nickpierson.SortSeer;

import java.util.Random;

import me.nickpierson.Sorts.BubbleSort;
import me.nickpierson.Sorts.SelectionSort;
import me.nickpierson.Sorts.Sort;
import me.nickpierson.Utils.Constants;

public class Model {

	private int[] points = new int[Constants.NUM_POINTS];
	private Random myRand = new Random();

	private Sort[] sorts = { new BubbleSort(), new SelectionSort() };
	private int currSort = 0;

	public Model() {
		resetPoints();
	}

	public void sort() {
		sorts[currSort].sort(points);
	}

	public void nextSort() {
		currSort = (currSort + 1) % sorts.length;
	}

	public String getSortName() {
		return sorts[currSort].getName();
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
