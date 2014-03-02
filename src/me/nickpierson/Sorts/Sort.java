package me.nickpierson.Sorts;

public abstract class Sort {

	public void run(final int[] values) {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				sort(values);
			}
		});
		thread.start();
	}

	public synchronized void swap(int[] values, int index1, int index2) {
		int temp = values[index1];
		values[index1] = values[index2];
		values[index2] = temp;
	}

	protected abstract void sort(int[] values);

	public abstract String getName();
}
