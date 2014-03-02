package me.nickpierson.SortSeer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {

	Model model;
	View view;

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
		model.resetPoints();
	}
}
