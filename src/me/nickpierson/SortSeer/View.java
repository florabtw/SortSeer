package me.nickpierson.SortSeer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import me.nickpierson.Utils.Constants;

public class View extends JFrame {

	private Model model;

	public View(Model model) {
		this.model = model;

		setTitle("SortSeer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Screen screen = new Screen();
		getContentPane().add(screen);

		screen.start();

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public class Screen extends JPanel {

		public Screen() {
			setPreferredSize(new Dimension(Constants.NUM_POINTS * Constants.POINT_WIDTH, Constants.NUM_POINTS * 2));
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
			int[] points = model.getPoints();
			g.setColor(Color.CYAN);
			for (int i = 0; i < points.length; i++) {
				int pointY = getHeight() - points[i];
				g.fillRect(i * Constants.POINT_WIDTH, pointY, Constants.POINT_WIDTH, getHeight() - pointY);
			}

			// draw sort name
			g.setColor(Color.WHITE);
			String sortName = model.getSortName();
			int nameWidth = SwingUtilities.computeStringWidth(g.getFontMetrics(), sortName);
			g.drawString(sortName, getWidth() / 2 - (nameWidth / 2), 20);
		}
	}
}
