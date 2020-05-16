package proto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;


public class MainFrame extends Jatektabla {
	private JPanel currentPanel;
	private Player currentPlayer;
	private Menu menu;
	private SetupMEH setup;
	private View view;

	public MainFrame(){
		this.setTitle("IceField");
		this.setSize(800, 800);
		currentPanel =  new Menu();
		currentPanel.setBackground(Color.cyan);
		add(currentPanel);

		setResizable(true);
		setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
