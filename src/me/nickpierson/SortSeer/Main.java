package me.nickpierson.SortSeer;

public class Main {

	public static void main(String[] args) {
		// Trying to use MVC
		Model model = new Model();
		View view = new View(model);
		new Controller(model, view);
	}
}
