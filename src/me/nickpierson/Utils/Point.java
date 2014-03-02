package me.nickpierson.Utils;

import java.awt.Color;

public class Point {

	private int value;
	private Color color = Color.CYAN;

	public Point(int value) {
		setValue(value);
	}

	public void deselect() {
		color = Color.CYAN;
	}

	public void setSelected() {
		color = Color.RED;
	}

	public void setCompleted() {
		color = Color.GREEN;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public Color getColor() {
		return color;
	}
}
