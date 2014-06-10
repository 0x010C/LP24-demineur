package control;

import view.MainFrame;

public interface ButtonListener {
	public void startGame(int sizeX, int sizeY, int nbBombes);
	public void openFrame(WindowManager.Frame frame);
	public void switchCard(MainFrame.Card newCard);
	public void abrogateGame();
}