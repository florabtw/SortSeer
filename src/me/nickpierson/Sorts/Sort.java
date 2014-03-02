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

	protected abstract void sort(int[] values);

	public abstract String getName();
}
