package ui;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Towers {
	public final static String SAVE_PATH_FILE = "data/startTowers.tm";
	public final static String SAVE_PATH_FILE1 = "data/endTower.tm";
	
	public static ArrayList<Integer> numbers;
	public static int starts;
	public static int temps;
	public static int ends;
	public static int number;
	
	public Towers() {
		numbers = new ArrayList<Integer>();
	}

	public void importData() throws IOException{
		 BufferedReader br = new BufferedReader(new FileReader(SAVE_PATH_FILE));
		 String line = br.readLine();
		 
		 while(line!=null){
			 
			 String[] parts = line.split("\n");
			 
		     for (int i = 0; i < parts.length; i++) {
		    	 int num = Integer.parseInt(parts[i]);
		    	 numbers.add(num);
			     line = br.readLine();
			}
		 }
	  br.close();
	}
	
	public ArrayList<Integer> getNumbers(){
		return numbers;
	}
	
	public void hanoi(int num, int start,int temp,int end) throws FileNotFoundException{
		 
		if(num == 1) {
			showMessage(start,temp,end);
		}
		else {
			hanoi(num-1,start, end, temp);
			showMessage(start,temp,end);
			hanoi(num-1,temp, start, end);
		}
	}

	public void asignNumber(int start) {
		starts = start;
		number = start;
		temps = 0;
		ends = 0; 
		
	}
	
	public void showMessage(int start, int temp, int end) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(SAVE_PATH_FILE1);
		
		if(starts == number) {
			pw.println(starts+" "+temps+" "+ends);
		}
		
		if(start == 1 && end == 3) {
			ends += 1;
			starts -= 1;
			pw.println(starts+" "+temps+" "+ends);
			
			if(ends == number) {
				pw.println(" \n");
			}
		}
		else if(start == 1 && end == 2) {
			temps += 1;
			starts -= 1;
			pw.println(starts+" "+temps+" "+ends);
		}
		if(start == 2 && end == 3) {
			ends += 1;
			temps -= 1;
			pw.println(starts+" "+temps+" "+ends);
		}
		else if(start == 2 && end == 1) {
			temps -= 1;
			starts += 1;
			pw.println(starts+" "+temps+" "+ends);
		}
		if(start == 3 && end == 1) {
			ends -= 1;
			starts += 1;
			pw.println(starts+" "+temps+" "+ends);
		}
		else if(start == 3 && end == 2) {
			temps += 1;
			ends -= 1;
			pw.println(starts+" "+temps+" "+ends);
		}
		pw.close();
	}
}
