package me.nickpierson.SortSeer;

import java.util.Random;

import me.nickpierson.Sorts.BubbleSort;
import me.nickpierson.Sorts.SelectionSort;
import me.nickpierson.Sorts.Sort;
import me.nickpierson.Utils.Constants;

public class Model {

	public enum Speed {
		OFF("Off", 0), FAST("Fast", 1), MEDIUM("Medium", 10), SLOW("Slow", 20);

		private String name;
		private int sleepTime;

		private Speed(String name, int millis) {
			this.name = name;
			this.sleepTime = millis;
		}

		public String getName() {
			return name;
		}

		public int getSleepTime() {
			return sleepTime;
		}
	}

	private int[] points = new int[Constants.NUM_POINTS];
	private Random myRand = new Random();
	private Speed sortSpeed = Speed.OFF;

	private Sort[] sorts = { new BubbleSort(), new SelectionSort() };
	private int currSort = 0;

	public Model() {
		resetPoints();
	}

	public void sort() {
		if (!sorts[currSort].isSorting()) {
			sorts[currSort].run(points, sortSpeed);
		}
	}

	public void nextSort() {
		if (!sorts[currSort].isSorting()) {
			currSort = (currSort + 1) % sorts.length;
		}
	}

	public void nextSpeed() {
		if (!sorts[currSort].isSorting()) {
			Speed[] allSpeeds = Speed.values();
			sortSpeed = allSpeeds[(sortSpeed.ordinal() + 1) % allSpeeds.length];
		}
	}

	public String getSortName() {
		return sorts[currSort].getName();
	}

	public String getSpeed() {
		return sortSpeed.getName();
	}

	public void resetPoints() {
		if (!sorts[currSort].isSorting()) {
			for (int i = 0; i < points.length; i++) {
				points[i] = myRand.nextInt(points.length) + 1;
			}
		}
	}

	public int[] getPoints() {
		return points;
	}
}
