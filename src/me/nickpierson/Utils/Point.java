package me.nickpierson.Utils;

import java.awt.Color;

public class Point {

	private int value;
	private Color color = Constants.DEFAULT;

	public Point(int value) {
		setValue(value);
	}

	public void deselect() {
		color = Constants.DEFAULT;
	}

	public void setSelected() {
		color = Constants.SELECTED;
	}

	public void setCompleted() {
		color = Constants.COMPLETED;
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
