package proto;

import javax.swing.JPanel;

public class MainFrame extends Jatektabla {
	private JPanel currentPanel;
	private Player currentPlayer;
	private Menu menu;
	private Setup setup;
	private View view;
	
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	
	public void startGame(){}
	
	public void loadGame(){}
	
	public void endGame(){}
	
	public void dig(){}
	
	public void move(Poz p) {}
	
	public void use(int index) {}
	
	public void endTurn(){}
	
	public void Ability(){}
}
