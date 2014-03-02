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

	public abstract void sort(int[] values);
}
