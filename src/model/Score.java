package model;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Score{
	private ArrayList<Integer> al;
	private ArrayList<String> tree;
	
	public ArrayList<Integer> Reading (String filePath) {
		try {
			al = new ArrayList<Integer>();
			
			/* Creation of the scanner above the file */
			Scanner scanner = new Scanner(new File(filePath));
			
			/* Parsing of the file */
			while (scanner.hasNext()) {
				al.add(scanner.nextInt());
			}
			
			/* Closing of the scanner */
			scanner.close();
			
			return al;
		} catch (IOException e) {
			System.out.println ("Error appears : " + e.getMessage());
			return al;
		}
	}
	
	public void AddingScore(int x, int y, int bombs, int value){
		String filePath;
		int tmp;
		
		al = new ArrayList<Integer>();
		
		// x must be bigger than y because the file are written according to this way : greaterCoordinates_mallerCoordinate_nbOfBombs.score 
		if(x<y) {
			tmp = x;
			x = y;
			y = tmp;
		}
		
		/* Initialization of filePath */
		filePath = ("scores/" + x + "_" + y + "_" + bombs + ".score");
		
		// Check if the file exists or not
		this.CreateIfNotCreated(filePath);
		
		al = this.Reading(filePath);
		
		/* Checking where to put the score and update of the ArrayList */
		switch (al.size()) {
		case 0:
			al.add(value);
			break;
		case 1:
			if(al.get(0) >= value) {
				al.add(al.get(0));
				al.set(0, value);
			}
			break;
		case 2:
			if(al.get(0) >= value) {
				al.add(al.get(1));
				al.set(1, al.get(0));
				al.set(0, value);
			} else if(al.get(1) >= value) {
				al.add(al.get(1));
				al.set(1, value);
			} else {
				al.set(2, value);
			}
			break;
		case 3:
			if(al.get(0) >= value) {
				al.set(2, al.get(1));
				al.set(1, al.get(0));
				al.set(0, value);
			} else if(al.get(1) >= value) {
				al.set(2, al.get(1));
				al.set(1, value);
			} else if(al.get(2) >= value) {
				al.set(2, value);
			}
			break;
		default:
			System.out.println ("Error appears : ");
		}
				
		/* Writing of the scores into the file, deleting the old content */
		try {
			// Creation of the FileWriter
			FileWriter fw = new FileWriter (new File(filePath));
			
			for (int v : al) {
				fw.write (String.valueOf (v) + "\n");
			}
			// Closing of the FileWriter
			fw.close();
		} catch (IOException e) {
			System.out.println ("Error appears : " + e.getMessage());
		}
		
	}
	
	public void CreateIfNotCreated(String filePath) {
		File file = new File(filePath);
		int i;
		if(file.exists() == false) {
			/* Creation of the file writing in it 9999 as the three scores*/
			try {
				// Creation of the file
				file.createNewFile();
			} catch (IOException e) {
				System.out.println ("Error appears : " + e.getMessage());
			}
		}
	}
	
	public ArrayList<String> Tree(String filePath){
		tree = new ArrayList<String>();
		
		File file = new File(filePath);
		File[] arbo = file.listFiles();

		for (File f : arbo) {
			tree.add(f.toString());
		}
		// 100X100, 1 mine
		
		return tree;
	}
}
