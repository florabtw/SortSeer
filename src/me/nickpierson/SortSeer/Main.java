package me.nickpierson.SortSeer;

public class Main {

	public static void main(String[] args) {
		// Trying to use MVC
		Model model = new Model();
		View view = new View(model);
		Controller controller = new Controller(model);
	}
}
