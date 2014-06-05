package control;

import model.Case;
import model.Chunk;

public class GameManager {
	Chunk chunk;
	public GameManager(int sizeX, int sizeY, int nbBombs) {
		chunk = new Chunk(sizeX, sizeY, nbBombs);
	}
	
	public void setController(GameController gc) {
		gc.add(chunk);
	}
}
