package controller;

public class Controller implements IController{
	private static Controller instance = null;
	
	public static synchronized IController instance() {
		if(instance == null) {
			instance = new Controller();
		}
		return instance;
	}
}
