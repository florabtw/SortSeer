package me.nickpierson.SortSeer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import me.nickpierson.Utils.Constants;
import me.nickpierson.Utils.Point;

public class View extends JFrame {

	private Model model;
	private boolean showHelp = false;

	public View(Model model) {
		this.model = model;

		setTitle("SortSeer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		Screen screen = new Screen();
		getContentPane().add(screen);

		screen.start();

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void setShowHelp(boolean showHelp) {
		this.showHelp = showHelp;
	}

	public boolean getShowHelp() {
		return showHelp;
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
			Point[] points = model.getPoints();
			for (int i = 0; i < points.length; i++) {
				g.setColor(points[i].getColor());
				int pointY = getHeight() - points[i].getValue();
				g.fillRect(i * Constants.POINT_WIDTH, pointY, Constants.POINT_WIDTH, getHeight() - pointY);
			}

			g.setColor(Color.RED);

			g.setColor(Color.WHITE);

			// draw sort name
			String sortName = model.getSortName();
			drawCenteredString(sortName, g, 20);

			// draw number of points
			String numPoints = String.format("Number of Points: %d", Constants.NUM_POINTS);
			int numPointsWidth = SwingUtilities.computeStringWidth(g.getFontMetrics(), numPoints);
			g.drawString(numPoints, getWidth() - 20 - numPointsWidth, 20);

			// draw current sort speed
			String sortSpeed = "Sort Speed: " + model.getSpeed();
			int sortSpeedWidth = SwingUtilities.computeStringWidth(g.getFontMetrics(), sortSpeed);
			g.drawString(sortSpeed, getWidth() - 20 - sortSpeedWidth, 40);

			// draw time
			long sortTime = model.getSortTime();
			String time = String.format("Time: %02d:%02d:%03d", sortTime / 60000, (sortTime / 1000) % 60, sortTime % 1000);
			g.drawString(time, 20, 20);

			// draw comparisons
			String comparisons = String.format("Comparisons: %d", model.getComparisons());
			g.drawString(comparisons, 20, 40);

			// draw swaps
			String swaps = String.format("Swaps: %d", model.getSwaps());
			g.drawString(swaps, 20, 60);

			// draw help
			String help = "Press 'h' to toggle help";
			g.drawString(help, 20, 100);

			if (showHelp) {
				drawCenteredString("Press 's' to change sort", g, 100);
				drawCenteredString("Press 'v' to change speed", g, 120);
				drawCenteredString("Press 'r' to reset points", g, 140);
				drawCenteredString("Press 'x' to stop sorting", g, 160);
				drawCenteredString("Press 'Space' to start sorting", g, 180);
			}
		}

		private void drawCenteredString(String text, Graphics g, int y) {
			int textWidth = SwingUtilities.computeStringWidth(g.getFontMetrics(), text);
			g.drawString(text, getWidth() / 2 - (textWidth / 2), y);
		}
	}
}
