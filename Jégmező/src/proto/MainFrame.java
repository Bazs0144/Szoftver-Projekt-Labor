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
import java.util.Random;
import java.util.Scanner;

/**
 * A mainframet megvalosito osztaly, ez kezeli az ablakot, valamint az ablakban a valtozo paneleket.
 */
public class MainFrame extends JFrame {
	/**
	 * A MainFrame osztaly adattagjai
	 * @param Instance: sasjat maga, hogy ne lehessen duplikalva.
	 * @param jt: az aktualis jatektabla.
	 * @param loaded: be van e toltve.
	 * @param state: a statusza, hogy melyik panelt jelezze ki eppen.
	 * @param currentPanel: az aktualisan kijelzett panel.
	 * @param currentPlayer: az aktualisan kijelzett jatekos.
	 * @param menu: a menu panel egy instance-a.
	 * @param newGame: a newGame panel egy instance-a.
	 * @param addPlayer: az addPlayer panel egy instance-a.
	 * @param newPlayers: a panelrõl beolvasott uj jatekosok listaja.
	 * @param view: a View egy instance-a.
	 */
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

	/** konstruktor*/
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



	/** A parameter hatasara egy masik panelre valt a mainframe*/
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

	/** Visszaadja az ujjonnan felvett jatekosokat*/
	public ArrayList<Player> getNewPlayers() {
		return newPlayers;
	}


	/** Hozzaad egy uj jatekost */
	public void addNewPlayer(Player p) {
		newPlayers.add(p);
	}

	/** Visszaadja az aktualis jatekost*/
	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	/** Elinditja a jatekot*/
	public void startGame(){}
	
	public void loadGame(){}
	
	public void endGame(){}
	
	public void dig(){}

	/** A karaktert lepteti*/
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

	/** Frissiti a jatekot (ujrarajzolja) */
	public void refreshGame() {
		view.getDrawField().repaint();
		view.refreshStatus();
		view.refreshTools();
	}
	/** Leptet egyet a jatekbeli koron */
	 public void inGameRound() throws Exception {
		 if(!jt.game_over) {
			 refreshGame();
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
						hoviharRand();
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

	/** Veget vet a jateknak, es kiirja hogy game over*/
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

	/** Veletlenszeru helyeken hovihart okoz*/
	protected static void hoviharRand() {
		Random r = new Random();
		int mennyi = 1 + r.nextInt(3)+1;
		Jegmezo jm = jt.getJegMezo();
		ArrayList<Jegtabla> ja = jm.getJegtablak();
		for (int i = 0; i < mennyi; i++) {
			ja.get(r.nextInt(ja.size())).hovihar_volt();
		}
	}
	
	public void Ability(){}

	/** A gomb nyomasara elmenti a jatekot*/
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



	/**A gomb nyomasara betolti a jatekot */
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
