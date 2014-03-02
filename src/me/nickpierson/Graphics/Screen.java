package me.nickpierson.Graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import me.nickpierson.Utils.Constants;
import me.nickpierson.Utils.PointManager;

public class Screen extends JPanel {

	PointManager pm;

	public Screen(PointManager pm) {
		setPreferredSize(new Dimension(Constants.NUM_POINTS * Constants.POINT_WIDTH, Constants.NUM_POINTS * 2));
		this.pm = pm;
	}

	public void start() {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					runLoop();
				}
			}
		});
		thread.start();
	}

	public void runLoop() {
		repaint();

		try {
			Thread.sleep(20);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void paint(Graphics g) {
		// set background to black
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());

		// draw points (as skyscrapers...)
		int[] points = pm.getPoints();
		g.setColor(Color.CYAN);
		for (int i = 0; i < points.length; i++) {
			int pointY = getHeight() - points[i];
			g.fillRect(i * Constants.POINT_WIDTH, pointY, Constants.POINT_WIDTH, getHeight() - pointY);
		}
	}
}
