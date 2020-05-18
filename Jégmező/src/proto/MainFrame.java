package proto;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
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
			if(!loaded)jt=new Jatektabla(4,4,newPlayers);
			currentPlayer = jt.getFirstPlayer();
			currentPlayer.kor_kezdes();
			currentPanel= new View();
			view= (View) currentPanel;
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
	
	public void move(Poz p) throws Exception {
		if(!jt.game_over)
		currentPlayer.getKarakter().lep(jt.getJegMezo().getJegtabla(p.x, p.y));
		jt.getJegesmedve().megesz();
	}
	
	public void use(int index) {}
	
	public void endTurn() throws Exception{

		if(currentPlayer.getKarakter().get_munkakszama() == 0) {
			currentPlayer = jt.setNextPlayer(currentPlayer);
		}
	}

	public void refreshGame() {
		view.getDrawField().repaint();
		view.refreshStatus();
	}
	 public void inGameRound() throws Exception {
		 if(!jt.game_over) {
			 view.refreshStatus();
			jt.game_over=jt.check_game_over();
			if(jt.game_over) {
				jt.game_over=true;
				gameOver();
			}
			if(!jt.game_over) {
				Player current = jt.getPlayers().get(jt.act_index);
				if (!current.getKarakter().van_munkaja()) {
					if (jt.act_index == jt.getPlayers().size() - 1) {
						jt.act_index = 0;
						jt.kor++;
						jt.medveLep();
					} else jt.act_index++;
					current=jt.getPlayers().get(jt.act_index);
					jt.next_player(current);
					currentPlayer=current;
					if(current.getKarakter().vizbeKerultKor!=jt.kor&&current.getKarakter().get_vizben_van()) {
						jt.game_over=true;
						gameOver();
					}
				}
			}

		}

	}

	void gameOver() {
		JTextPane textPane=new JTextPane();
		StyledDocument style = textPane.getStyledDocument();
		SimpleAttributeSet align= new SimpleAttributeSet();
		StyleConstants.setAlignment(align, StyleConstants.ALIGN_CENTER);
		style.setParagraphAttributes(0, style.getLength(), align, false);
		textPane.setText("Game Over");
		textPane.setEditable(false);
		textPane.setFont(new Font("Arial", Font.BOLD, 96));
		textPane.setBackground(new Color(235, 43, 37));
		currentPanel.add(textPane, BorderLayout.CENTER);

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
