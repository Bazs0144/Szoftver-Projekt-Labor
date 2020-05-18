package proto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class MainFrame extends JFrame {
	static MainFrame Instance;
	static Jatektabla jt;
	static boolean loaded;
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
			if(!loaded)jt=new Jatektabla(4,4,newPlayers);
			currentPlayer = jt.getFirstPlayer();
			currentPlayer.kor_kezdes();

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
	
	public void endTurn() throws Exception{

		if(currentPlayer.getKarakter().get_munkakszama() == 0) {
			currentPlayer = jt.setNextPlayer(currentPlayer);
			jt.medveLep();
		}
	}
	
	public void Ability(){}

	public static class save implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				File f = new File("Saved.ser");
				if (!f.exists())
					f.createNewFile();
				if (f.exists()) {
					FileOutputStream fs = new FileOutputStream(f);
					ObjectOutputStream out = new ObjectOutputStream(fs);
					out.writeObject(MainFrame.jt);
					out.close();
					JOptionPane.showMessageDialog(Instance, "Save succesful");
				}
			} catch (Exception err) {
				JOptionPane.showMessageDialog(Instance, "Save failed");
			}
		}
	}

	public static class load implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			File f = new File( "Saved.ser");

			if (f.exists()) {
				try {
					FileInputStream fs = new FileInputStream(f);
					ObjectInputStream in = new ObjectInputStream(fs);
					MainFrame.jt = (Jatektabla) in.readObject();
					in.close();
					MainFrame.loaded = true;
					Instance.changeState(State.InGameS);
				} catch (IOException | ClassNotFoundException ex) {
					ex.printStackTrace();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

		}
	}
}
