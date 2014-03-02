package me.nickpierson.Sorts;

import me.nickpierson.SortSeer.Model;

public abstract class Sort {

	Model.Speed speed;
	private boolean isSorting;

	public void run(final int[] values, Model.Speed speed) {
		this.speed = speed;
		isSorting = true;

		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				sort(values);
				isSorting = false;
			}
		});
		thread.start();
	}

	public synchronized void swap(int[] values, int index1, int index2) {
		int temp = values[index1];
		values[index1] = values[index2];
		values[index2] = temp;
	}

	public void sleep() {
		try {
			Thread.sleep(speed.getSleepTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isSorting() {
		return isSorting;
	}

	protected abstract void sort(int[] values);

	public abstract String getName();
}
