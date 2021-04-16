package ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Towers {
	public final static String SAVE_PATH_FILE = "data/startTowers.txt";
	public final static String SAVE_PATH_FILE1 = "data/endTowers.txt";
	
	public static ArrayList<Integer> numbers;
	public static int starts;
	public static int temps;
	public static int ends;
	
	public Towers() {
		numbers = new ArrayList<Integer>();
	}

	@SuppressWarnings("unchecked")
	public boolean loadData() throws IOException, ClassNotFoundException{
		File f = new File(SAVE_PATH_FILE);
		boolean loaded = false;
		
		if(f.exists()){
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			numbers = (ArrayList<Integer>)ois.readObject();
			ois.close();
			loaded = true;
		}
		return loaded;
	}
	
	public ArrayList<Integer> getNumbers(){
		return numbers;
	}
	
	public void hanoi(int num, int start,int temp,int end) {

		if(num == 1) {
			start--;
			end++;
			System.out.println(start+" "+temp+" "+end+"\n");
		}
		else {
			hanoi(num - 1,start, end, temp);
			start--;
			temp++;
			System.out.println(start+" "+temp+" "+end);
			
			hanoi(num - 1,temp, start, end);
			temp--;
			end++;
			System.out.println(start+" "+temp+" "+end);
		}
	}


}
