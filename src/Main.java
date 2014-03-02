import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Title here");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Screen screen = new Screen();
		frame.getContentPane().add(screen);

		screen.start();

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
