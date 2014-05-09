import java.util.ArrayList;
import java.util.Random;

public class Chunk {

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
	
	/* Methods */
	public void generateChunk() {
		
	}
	
}
