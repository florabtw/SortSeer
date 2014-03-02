package me.nickpierson.SortSeer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {

	private Model model;
	private View view;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;

		view.addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_SPACE:
			model.nextSort();
			break;
		case KeyEvent.VK_S:
			model.nextSpeed();
			break;
		case KeyEvent.VK_R:
			model.resetPoints();
			break;
		case KeyEvent.VK_ENTER:
			model.sort();
			break;
		}
	}
}
