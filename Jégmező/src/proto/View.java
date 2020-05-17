package proto;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class View extends JPanel{

	public boolean valid;
	private ArrayList<GraphicsBuilding> buildings = new ArrayList<GraphicsBuilding>();
	private ArrayList<GraphicsFigure> figures = new ArrayList<GraphicsFigure>(); 
	private ArrayList<GraphicsField> fields =  new ArrayList<GraphicsField>();
	private ArrayList<GraphicsTool> tools = new ArrayList<GraphicsTool>();
	private Statusbar statusbar;
	private InGame gamePanel;
	private EquipmentPanel ep;
	private String currentPlayer;
	private int currentRound = 1;
	ArrayList<JPanel> charactersTools = new ArrayList<>(); //Eszkozok listaja

	public View() {
		//this.setPreferredSize(new Dimension(800, 800));
		this.setLayout(new BorderLayout());
		this.setBackground(new Color(189, 216, 235));

		gameState(); // két felső sarokban lévő szöveg kiírása

		gamePanel = new InGame();//a lenyegi resz
		this.add(gamePanel, BorderLayout.CENTER);

		savePanel();//a mentes gombot tartalmazza

		ep = new EquipmentPanel();
		this.add(ep, BorderLayout.EAST);

		this.setVisible(true);
	}

	void gameState() {
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());

		JPanel west = new JPanel();
		JPanel center = new JPanel();
		JPanel east = new JPanel();

		JLabel round = new JLabel();
		round.setFont(new Font("Arial", Font.BOLD, 43));
		east.setBackground(new Color(189, 216, 235));

		JLabel player = new JLabel();
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

	void setFields(JLabel p1, JLabel p2) {
		p2.setText(currentPlayer + "'s objects:");
		p1.setText("Round " + currentRound);
	}

	void savePanel() {
		JPanel sg = new JPanel();
		sg.setLayout(new BorderLayout());
		sg.setPreferredSize(new Dimension(730, 50));
		sg.setBackground(new Color(189, 216, 235));

		JButton save = new JButton("Save Game");
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

	public void refreshStatus(Player p){
		
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