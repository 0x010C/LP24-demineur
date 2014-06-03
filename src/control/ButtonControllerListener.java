package control;

import view.MainFrame;

public interface ButtonControllerListener {
	public void startGame(int sizeX, int sizeY, int nbBombes);
	public void openFrame(WindowManager.Frame frame);
	public void switchCard(MainFrame.Card newCard);
}