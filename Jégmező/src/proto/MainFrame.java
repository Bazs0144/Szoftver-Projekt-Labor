package proto;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class MainFrame extends JFrame {
	static MainFrame Instance;
	static Jatektabla jt;
	private State state;
	private JPanel currentPanel;
	private Player currentPlayer;
	private Menu menu=new Menu();
	private NewGame newGame;
	private AddPlayer addPlayer;
	private ArrayList<Player> newPlayers= new ArrayList<Player>();
	private SetupMEH setup;
	private View view;

	public MainFrame(){
        Instance=this;
		state=State.MenuS;
		this.setTitle("IceField");
		this.setSize(800, 800);
		currentPanel =  menu;
		currentPanel.setVisible(true);
		add(currentPanel);
		setResizable(true);
		setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}



	public void changeState(State s) throws Exception {
		state=s;
		if(state.equals(State.MenuS)) {
			currentPanel.setVisible(false);
			this.remove(currentPanel);
			currentPanel=new Menu();
			currentPanel.setVisible(true);
			this.add(currentPanel);
		}

		else if(state.equals(State.NewGameS)) {
			currentPanel.setVisible(false);
			this.remove(currentPanel);
			currentPanel=new NewGame();
			currentPanel.setVisible(true);
			this.add(currentPanel);

		}

		else if(state.equals(State.AddPlayerS)) {
			currentPanel.setVisible(false);
			this.remove(currentPanel);
			currentPanel=new AddPlayer();
			currentPanel.setVisible(true);
			this.add(currentPanel);
		}

		else if(state.equals(State.InGameS)) {
			currentPanel.setVisible(false);
			this.remove(currentPanel);
			currentPanel.setVisible(false);
			currentPanel= new View();
			jt=new Jatektabla(4,4,newPlayers);
			currentPanel.setVisible(true);
			this.add(currentPanel);
		}
	}

	public ArrayList<Player> getNewPlayers() {
		return newPlayers;
	}

	public void addNewPlayer(Player p) {
		newPlayers.add(p);
	}

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
