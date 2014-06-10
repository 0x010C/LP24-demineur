package control;

import model.Case;

public interface UpdateDisplayListener {
	public void updateCase(int x, int y, Case.Content content, Case.State state);
	public void loose();
	public void win();
}
