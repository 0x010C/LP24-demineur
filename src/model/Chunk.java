package model;
import java.util.ArrayList;
import java.util.Random;

import control.GameControllerListener;
import control.WindowManager;

public class Chunk implements GameControllerListener {

	/* Attributes */
	private ArrayList<ArrayList<Case>> cases;
	private int sizeX, sizeY;
	private int nbBombs;
	private int seed;
	
	/* Constructors */
	public Chunk(int sizeX, int sizeY, int nbBombs) {
		Random r = new Random();
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.nbBombs = nbBombs;
		this.seed = r.nextInt(1000000);
		
		this.generateChunk();
	}
	public Chunk(int sizeX, int sizeY, int nbBombs, int seed) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.nbBombs = nbBombs;
		this.seed = seed;
		
		this.generateChunk();
	}
	
	/* Getters */
	public int getSeed() {
		return seed;
	}
	
	/* Methods */
	public void generateChunk() {
		Random r = new Random(seed);
		int i, j;
        int count = 0;
		
		/* Initialization of our table */
		cases = new ArrayList<ArrayList<Case>>(); //the X-axe of our 2-dimensions table
		for(i=0;i<sizeX;i++) {
			cases.add(new ArrayList<Case>()); //the Y-axe of our 2-dimensions table
			for(j=0;j<sizeY;j++) {
				cases.get(i).add(new Case(Case.Content.empty)); //creation of an empty and hidden case
			}
		}
		
		/* Place all bombs */
		i = this.nbBombs;
		while(i > 0) {
			int alea = r.nextInt(sizeX*sizeY - 1);
			if(cases.get(alea%sizeX).get(alea/sizeX).getContent() != Case.Content.bomb) {
				cases.get(alea%sizeX).get(alea/sizeX).setContent(Case.Content.bomb);
				i--;
            }
        }

		/* Place all numbers */
		for(i=0;i<sizeX;i++) {
            for(j=0;j<sizeY;j++) {
                if(cases.get(i).get(j).getContent() != Case.Content.bomb) { //if it's not a bomb, we count the bombs around
                	count = 0;
                    if(i != 0 && j != 0 && cases.get(i-1).get(j-1).getContent() == Case.Content.bomb)
                        count++;
                    if(i != 0 && cases.get(i-1).get(j).getContent() == Case.Content.bomb)
                        count++;
                    if(i != 0 && j != sizeY-1 && cases.get(i-1).get(j+1).getContent() == Case.Content.bomb)
                    	count++;
                    if(j != 0 && cases.get(i).get(j-1).getContent() == Case.Content.bomb)
                        count++;
                    if(j != sizeY-1 && cases.get(i).get(j+1).getContent() == Case.Content.bomb)
                        count++;
                    if(i != sizeX-1 && j != 0 && cases.get(i+1).get(j-1).getContent() == Case.Content.bomb)
                        count++;
                    if(i != sizeX-1 && cases.get(i+1).get(j).getContent() == Case.Content.bomb)
                        count++;
                    if(i != sizeX-1 && j != sizeY-1 && cases.get(i+1).get(j+1).getContent() == Case.Content.bomb)
                        count++;

                    if(count > 0) { //and we set the correct number
                    	switch(count) {
                    		case 1 : cases.get(i).get(j).setContent(Case.Content.one);
                    				 break;
                    		case 2 : cases.get(i).get(j).setContent(Case.Content.two);
                    				 break;
                    		case 3 : cases.get(i).get(j).setContent(Case.Content.three);
                    				 break;
                    		case 4 : cases.get(i).get(j).setContent(Case.Content.four);
                    				 break;
                    		case 5 : cases.get(i).get(j).setContent(Case.Content.five);
                    				 break;
                    		case 6 : cases.get(i).get(j).setContent(Case.Content.six);
                    				 break;
                    		case 7 : cases.get(i).get(j).setContent(Case.Content.seven);
                    				 break;
                    		case 8 : cases.get(i).get(j).setContent(Case.Content.eight);
                    				 break;
                    	}
                    }
                }
            }
        }
	}
	public void revealing(int x, int y) {
		System.out.print("x=");
		System.out.println(x);
		System.out.print("y=");
		System.out.println(y);
		if(cases.get(x).get(y).getState() == Case.State.hidden)
			cases.get(x).get(y).setState(Case.State.open);
		
		WindowManager.udc.updateCase(x, y, cases.get(x).get(y).getContent(), cases.get(x).get(y).getState());

		if(cases.get(x).get(y).getContent() == Case.Content.empty) {
			if(x-1 >= 0) {
				if(cases.get(x-1).get(y).getState() == Case.State.hidden)
					revealing(x-1,y);
			}
			if(y-1 >= 0) {
				if(cases.get(x).get(y-1).getState() == Case.State.hidden)
				revealing(x,y-1);
			}
			if(x+1 < this.sizeX) {
				if(cases.get(x+1).get(y).getState() == Case.State.hidden)
				revealing(x+1,y);
			}
			if(y+1 < this.sizeY) {
				if(cases.get(x).get(y+1).getState() == Case.State.hidden)
				revealing(x,y+1);
			}
		}
	}
	public void flagging(int x, int y) {
		if(cases.get(x).get(y).getState() != Case.State.open) {
			if(cases.get(x).get(y).getState() == Case.State.hidden)
				cases.get(x).get(y).setState(Case.State.flag);
			else if(cases.get(x).get(y).getState() == Case.State.flag)
				cases.get(x).get(y).setState(Case.State.ask);
			else
				cases.get(x).get(y).setState(Case.State.hidden);
		}
		
		WindowManager.udc.updateCase(x, y, cases.get(x).get(y).getContent(), cases.get(x).get(y).getState());
	}
	public Case.State getState(int x, int y) {
		return cases.get(x).get(y).getState();
	}
	public Case.Content getContent(int x, int y) {
		return cases.get(x).get(y).getContent();
	}
}
