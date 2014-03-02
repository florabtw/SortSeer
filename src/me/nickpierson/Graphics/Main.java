package me.nickpierson.Graphics;

import javax.swing.JFrame;

import me.nickpierson.Utils.PointManager;

public class Main {

	public static void main(String[] args) {
		PointManager pm = new PointManager();

		JFrame frame = new JFrame("Title here");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Screen screen = new Screen(pm);
		frame.getContentPane().add(screen);

		screen.start();

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
