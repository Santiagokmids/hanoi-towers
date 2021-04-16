package ui;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

	private Towers tower;

	public Main(){
		tower = new Towers();
	}

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Main objMain = new Main();
		objMain.startApp();
	}

	public void startApp() throws ClassNotFoundException, IOException {
		boolean loadNumbers;
		
		try {
			loadNumbers = tower.loadData();
		}
		catch (ClassNotFoundException | IOException e) {
			loadNumbers = false;
		}

		if(loadNumbers) {
			int start = 0;
			int temp = 0;
			int end = 0;
			ArrayList<Integer> num = tower.getNumbers();

			for (int i = 0; i < num.size()-1; i++) {
				start = num.get(i);
				tower.hanoi(num.get(i),start,temp,end);

			}
		}
	}
}
