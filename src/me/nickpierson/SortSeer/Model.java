package me.nickpierson.SortSeer;

import java.util.Random;

public class Model {

	int[] points = new int[Constants.NUM_POINTS];
	Random myRand = new Random();

	public Model() {
		resetPoints();
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
