package proto;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

/**
 * A Viewt megvalosito osztaly, ez biztositja a ralatast a jatektablara
 */

public class View extends JPanel{

	/**
	 * A View osztaly adattagjai
	 * @param valid: tarolja hogy valid-e a view.
	 * @param buildings: tarolja a megjelenitendo epitmenyek graphics-at.
	 * @param figures: tarolja a megjelenitendo figurak graphics-at.
	 * @param fields: tarolja a megjelenitendo mezok graphics-at.
	 * @param tools: tarolja a megjelenitendo targyak graphics-at.
	 * @param gamePanel: az aktiv jatekablak.
	 * @param ep: az aktiv felszerelesablak.
	 * @param currentPlayer: az aktiv jatekos neve.
	 * @param drawField: az aktiv jegmezot megjelenito view.
	 * @param statusbar: a megjelenitendo statusbar.
	 * @param currentRound: az aktualis kor szama.
	 * @param player: jatekost kiiro label.
	 * @param round: kort kiiro label.
	 * @param charactersTools: az aktiv karakter targyai.
	 */

	public boolean valid;
	private ArrayList<GraphicsBuilding> buildings = new ArrayList<GraphicsBuilding>();
	private ArrayList<GraphicsFigure> figures = new ArrayList<GraphicsFigure>(); 
	private ArrayList<GraphicsField> fields =  new ArrayList<GraphicsField>();
	private ArrayList<GraphicsTool> tools = new ArrayList<GraphicsTool>();
	private InGame gamePanel;
	private EquipmentPanel ep;
	private String currentPlayer;
	private GameView drawField;
	private Statusbar statusbar;
	private int currentRound = 1;
	private JLabel player, round;
	ArrayList<GraphicsTool> charactersTools = new ArrayList<>(); //Eszkozok listaja

	/** Konstruktora */
	public View() {
		int index=MainFrame.jt.act_index;
		currentPlayer=MainFrame.jt.getPlayers().get(index).getName();
		currentRound=MainFrame.jt.kor;
		this.setLayout(new BorderLayout());
		this.setBackground(new Color(189, 216, 235));

		gameState(); // két felső sarokban lévő szöveg kiírása

		gamePanel = new InGame();//a lenyegi resz
		this.add(gamePanel, BorderLayout.CENTER);

		drawField = gamePanel.getDrawfield();
		drawField.setParameters(buildings, figures, fields, tools);

		statusbar = gamePanel.getStatusBar();

		savePanel();//a mentes gombot tartalmazza

		ep = new EquipmentPanel();
	//	ep.setCharactersTools(charactersTools);
		this.add(ep, BorderLayout.EAST);

		this.setVisible(true);
	}

	/** A view jatekstadiumba allitasa */
	void gameState() {
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());

		JPanel west = new JPanel();
		JPanel center = new JPanel();
		JPanel east = new JPanel();

		round = new JLabel();
		round.setFont(new Font("Arial", Font.BOLD, 43));
		east.setBackground(new Color(189, 216, 235));

		player = new JLabel();
		player.setFont(new Font("Arial", Font.BOLD, 25));
		west.setBackground(new Color(189, 216, 235));

		setFields(round, player);
		center.setBackground(new Color(189, 216, 235));
		west.add(round);
		east.add(player);

		p.add(center, BorderLayout.CENTER);
		p.add(west, BorderLayout.WEST);
		p.add(east, BorderLayout.EAST);

		p.setPreferredSize(new Dimension(730, 50));
		p.setBackground(new Color(189, 216, 235));

		this.add(p, BorderLayout.NORTH);
	}
	/** Parameterkent kapott labelek beallitasa az aktualis korre es jatekosra.*/
	void setFields(JLabel p1, JLabel p2) {
		p2.setText(currentPlayer + "'s objects:");
		p1.setText("Round " + currentRound);
	}

	/** A mentes gomb paneljenek letrehozasa */
	void savePanel() {
		JPanel sg = new JPanel();
		sg.setLayout(new BorderLayout());
		sg.setPreferredSize(new Dimension(730, 50));
		sg.setBackground(new Color(189, 216, 235));

		JButton save = new JButton("Save Game");
		save.addActionListener(new MainFrame.save());
		save.setFont(new Font("Arial", Font.BOLD, 30));
		save.setBackground(new Color(189, 216, 235));
		save.setBorder(null);

		JPanel labelHolder = new JPanel();
		labelHolder.setBackground(new Color(189, 216, 235));
		labelHolder.add(save);

		JPanel spaceHolder = new JPanel();
		spaceHolder.setBackground(new Color(189, 216, 235));

		sg.add(spaceHolder, BorderLayout.CENTER);
		sg.add(labelHolder, BorderLayout.EAST);

		this.add(sg, BorderLayout.SOUTH);
	}

	/** A view statuszanak es statusbarjanak frissitese */
	public void refreshStatus(){
		int index=MainFrame.jt.act_index;
		currentPlayer=MainFrame.jt.getPlayers().get(index).getName();
		currentRound=MainFrame.jt.kor;
		setFields(round,player);
		gamePanel.getStatusBar().refresh();
	}

	/** Az eszkozok ujrakifestese */
	public void refreshTools() {
		ep.repaint();
	}

	/** A kirajzolt jatekterulet lekerese */
	public GameView getDrawField() {
		return drawField;
	}

	public void addBuilding(GraphicsBuilding g){
		
	}
	
	public void AddTool(GraphicsTool g){
		
	}
	
	public void AddField(GraphicsField g){
		
	}
	
	public void addFigure(GraphicsFigure g){
		
	}
	
	public void validate(){
		
	}
	
	public void clear(){
		
	}
	
	public void paint(){
		
	}
}
