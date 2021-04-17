package ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	private Towers tower;

	public Main() throws FileNotFoundException{
		tower = new Towers();
	}

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Main objMain = new Main();
		objMain.startApp();
	}

	public void startApp() throws ClassNotFoundException, IOException {

		tower.importData();
		
		ArrayList<Integer> num = tower.getNumbers();

		for (int i = 1; i <= num.get(0); i++) {

			tower.asignNumber(num.get(i));
			tower.hanoi(num.get(i),1,2,3);

		}
	}
}
