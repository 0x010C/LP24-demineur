package model;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Score{
	private ArrayList<Integer> al;
	private ArrayList<String> tree;
	private String[] array;
	
	public ArrayList<Integer> Reading (String filePath) {
		/* The function reads the file and return an ArrayList of integers of the numbers in it */
		try {
			al = new ArrayList<Integer>();
			
			/* Creation of the scanner above the file */
			Scanner scanner = new Scanner(new File(filePath));
			
			/* Parsing of the file */
			int i=0;
			while (scanner.hasNext()) {
				al.add(scanner.nextInt());
				i++;
			}
			while(i<3) {
				al.add(-1);
				i++;
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
		/* Add the score to the correct file according to the parameters */
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
			if(al.get(0) >= value || al.get(0) == -1) {
				al.add(al.get(0));
				al.set(0, value);
			}
			break;
		case 2:
			if(al.get(0) >= value || al.get(0) == -1) {
				al.add(al.get(1));
				al.set(1, al.get(0));
				al.set(0, value);
			} else if(al.get(1) >= value  || al.get(1) == -1) {
				al.add(al.get(1));
				al.set(1, value);
			} else {
				al.set(2, value);
			}
			break;
		case 3:
			if(al.get(0) >= value || al.get(0) == -1) {
				al.set(2, al.get(1));
				al.set(1, al.get(0));
				al.set(0, value);
			} else if(al.get(1) >= value || al.get(1) == -1) {
				al.set(2, al.get(1));
				al.set(1, value);
			} else if(al.get(2) >= value || al.get(2) == -1) {
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
		/* Check if a file exists and if it is false, create it */
		File file = new File(filePath);
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
	
	public int getSizeTreeHumanReadable(String filePath){
		/* Return the number of files in the directory scores */
		File file = new File(filePath);
		File[] arbo = file.listFiles();
		
		return arbo.length;
	}
	
	public String[] TreeHumanReadable(String filePath){
		/* Create an array of String with the name the type of which is "8 X 8, 10 mines" for each files in the directory scores */
		tree = new ArrayList<String>();
		int i, tmp;
		String tmpX, tmpY, tmpBomb;
		
		
		File file = new File(filePath);
		File[] arbo = file.listFiles();
		Arrays.sort(arbo);
		array = new String[arbo.length];
		
		/* Converting the Objects File into Strings */
		for(File f : arbo) {
			tree.add(f.toString());
		}
		
		/* Converting the relative path into human readable path */
		// scores/8_8_10.score   -->   8 X 8, 10 mines
		
		for(i = 0; i < tree.size(); i ++){
			tmpX = tree.get(i).substring(tree.get(i).indexOf("/")+1, tree.get(i).indexOf("_"));
			tmpY = tree.get(i).substring(tree.get(i).indexOf("_")+1, tree.get(i).lastIndexOf("_"));
			tmpBomb = tree.get(i).substring(tree.get(i).lastIndexOf("_")+1, tree.get(i).indexOf("."));
			
			// to know if a "s" is necessary at the end of the word "mine"
			tmp = Integer.parseInt(tmpBomb);
			if (tmp == 1) {
				tree.set(i, tmpX + " X " + tmpY + ", " + tmpBomb + " mine");
			} else {
				tree.set(i, tmpX + " X " + tmpY + ", " + tmpBomb + " mines");
			}			
		}
		
		tree.toArray(array);
		
		return array;
	}
	
	public String HumanReadableToFilePath(String hr){
		/* 8 X 8, 10 mines   -->   scores/8_8_10.score */
		String tmpX, tmpY, tmpBomb;
		
		tmpX = hr.substring(0, hr.indexOf("X")-1);
		tmpY = hr.substring(hr.indexOf("X")+2, hr.indexOf(","));
		tmpBomb = hr.substring(hr.indexOf(",")+2, hr.indexOf("m")-1);
		
		return "scores/" + tmpX + "_" + tmpY + "_" + tmpBomb + ".score";
	}
	
}
