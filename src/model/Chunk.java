package model;
import java.util.ArrayList;
import java.util.Random;

import view.MainFrame;

import control.GameListener;
import control.WindowManager;

public class Chunk implements GameListener {

	/* Attributes */
	private ArrayList<ArrayList<Case>> cases;
	private int sizeX, sizeY;
	private int nbBombs;
	private int seed;
	private boolean multiChunk;
	private int nbOpen;

	/* Constructors */
	public Chunk(int sizeX, int sizeY, int nbBombs) {
		Random r = new Random();
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.nbBombs = nbBombs;
		this.seed = r.nextInt(1000000);
		this.multiChunk = false;
		this.nbOpen = 0;
		
		this.generateChunk();
	}
	public Chunk(int sizeX, int sizeY, int nbBombs, int seed) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.nbBombs = nbBombs;
		this.seed = seed;
		this.multiChunk = false;
		this.nbOpen = 0;
		
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
		while(this.multiChunk == false && this.nbOpen == 0 && cases.get(x).get(y).getContent() != Case.Content.empty)
		{
			Random r = new Random();
			this.seed = r.nextInt(1000000);
			this.generateChunk();
		}
		if(this.nbOpen == 0) {
			WindowManager.chrono.start();
			if(WindowManager.hardMode)
				MainFrame.hardChrono.start();
		}
		
		if(cases.get(x).get(y).getState() == Case.State.open && cases.get(x).get(y).getContent() != Case.Content.empty && cases.get(x).get(y).getContent() != Case.Content.bomb) {
			int count = 0;
			if(x-1 >= 0) {
				if(cases.get(x-1).get(y).getState() == Case.State.flag)
					count++;
			}
			if(x-1 >= 0 && y-1 >= 0) {
				if(cases.get(x-1).get(y-1).getState() == Case.State.flag)
					count++;
			}
			if(y-1 >= 0) {
				if(cases.get(x).get(y-1).getState() == Case.State.flag)
					count++;
			}
			if(y-1 >= 0 && x+1 < this.sizeX) {
				if(cases.get(x+1).get(y-1).getState() == Case.State.flag)
					count++;
			}
			if(x+1 < this.sizeX) {
				if(cases.get(x+1).get(y).getState() == Case.State.flag)
					count++;
			}
			if(x+1 < this.sizeX && y+1 < this.sizeY) {
				if(cases.get(x+1).get(y+1).getState() == Case.State.flag)
					count++;
			}
			if(y+1 < this.sizeY) {
				if(cases.get(x).get(y+1).getState() == Case.State.flag)
					count++;
			}
			if(y+1 < this.sizeY && x-1 >= 0) {
				if(cases.get(x-1).get(y+1).getState() == Case.State.flag)
					count++;
			}
			
			if(count == 1 && cases.get(x).get(y).getContent() == Case.Content.one)
				revealingAround(x, y);
			else if(count == 2 && cases.get(x).get(y).getContent() == Case.Content.two)
				revealingAround(x, y);
			else if(count == 3 && cases.get(x).get(y).getContent() == Case.Content.three)
				revealingAround(x, y);
			else if(count == 4 && cases.get(x).get(y).getContent() == Case.Content.four)
				revealingAround(x, y);
			else if(count == 5 && cases.get(x).get(y).getContent() == Case.Content.five)
				revealingAround(x, y);
			else if(count == 6 && cases.get(x).get(y).getContent() == Case.Content.six)
				revealingAround(x, y);
			else if(count == 7 && cases.get(x).get(y).getContent() == Case.Content.seven)
				revealingAround(x, y);
		}
		
		if(cases.get(x).get(y).getState() == Case.State.hidden)
		{
			cases.get(x).get(y).setState(Case.State.open);
			this.nbOpen++;
			if(WindowManager.hardMode) {
				MainFrame.hardChrono.stop();
				MainFrame.hardChrono.start();
			}
			
			if(cases.get(x).get(y).getContent() == Case.Content.bomb)
			{
				cases.get(x).get(y).setContent(Case.Content.explode);
				cases.get(x).get(y).setState(Case.State.hidden);
				WindowManager.udc.updateCase(x, y, cases.get(x).get(y).getContent(), cases.get(x).get(y).getState());
				this.revealingAllBomb();
				
				WindowManager.udc.loose();
			}
			else if(this.sizeX*this.sizeY-this.nbBombs == this.nbOpen) {
				WindowManager.udc.updateCase(x, y, cases.get(x).get(y).getContent(), cases.get(x).get(y).getState());
				WindowManager.udc.win();
			}
			else
				WindowManager.udc.updateCase(x, y, cases.get(x).get(y).getContent(), cases.get(x).get(y).getState());
				
		}
		
		if(cases.get(x).get(y).getContent() == Case.Content.empty) {
			revealingAround(x, y);
		}
		
		
	}
	public void revealingAround(int x, int y) {
		if(x-1 >= 0) {
			if(cases.get(x-1).get(y).getState() == Case.State.hidden)
				revealing(x-1,y);
		}
		if(x-1 >= 0 && y-1 >= 0) {
			if(cases.get(x-1).get(y-1).getState() == Case.State.hidden)
				revealing(x-1,y-1);
		}
		if(y-1 >= 0) {
			if(cases.get(x).get(y-1).getState() == Case.State.hidden)
				revealing(x,y-1);
		}
		if(y-1 >= 0 && x+1 < this.sizeX) {
			if(cases.get(x+1).get(y-1).getState() == Case.State.hidden)
				revealing(x+1,y-1);
		}
		if(x+1 < this.sizeX) {
			if(cases.get(x+1).get(y).getState() == Case.State.hidden)
				revealing(x+1,y);
		}
		if(x+1 < this.sizeX && y+1 < this.sizeY) {
			if(cases.get(x+1).get(y+1).getState() == Case.State.hidden)
				revealing(x+1,y+1);
		}
		if(y+1 < this.sizeY) {
			if(cases.get(x).get(y+1).getState() == Case.State.hidden)
				revealing(x,y+1);
		}
		if(y+1 < this.sizeY && x-1 >= 0) {
			if(cases.get(x-1).get(y+1).getState() == Case.State.hidden)
				revealing(x-1,y+1);
		}
	}
	public void revealingAllBomb() {
		for(int x=0;x<this.sizeX;x++) {
			for(int y=0;y<this.sizeY;y++) {
				if(cases.get(x).get(y).getContent() == Case.Content.bomb)
					WindowManager.udc.updateCase(x, y, cases.get(x).get(y).getContent(), Case.State.open);
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
