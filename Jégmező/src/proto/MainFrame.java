package proto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainFrame extends Jatektabla {
	private JPanel currentPanel;
	private Player currentPlayer;
	private Menu menu;
	private SetupMEH setup;
	private View view;
	private JButton button1, button2;
	private JTextArea text, text2;

	public MainFrame(){
		this.setTitle("IceField");
		this.setSize(800, 800);
		currentPanel =  new JPanel(null);
		currentPanel.setBackground(Color.cyan);
		add(currentPanel );

		text = new JTextArea();
		text.append("  ICEFIELD\n");
		text.setBounds(100, 70, 550, 100);
		text.setEditable(false);
		text.setFont(new Font("Serif", Font.BOLD, 96));
		text.setBackground(Color.cyan);
		currentPanel.add(text);

		text2 = new JTextArea();
		text2.append(" THE GAME");
		text2.setBounds(220, 170, 350, 100);
		text2.setEditable(false);
		text2.setFont(new Font("Serif", Font.BOLD, 50));
		text2.setBackground(Color.cyan);
		currentPanel.add(text2);

		button1 = new JButton();
		button1.setText("New Game");
		button1.setBounds(250, 350, 250, 100);
		button1.addActionListener(new OkButtonActionListener1());
		button1.setBackground( new Color(250,180,200));
		button1.setFont(new Font("Arial", Font.PLAIN, 40));
		currentPanel.add(button1);

		button2 = new JButton();
		button2.setText("Load Game");
		button2.setBounds(250, 500, 250, 100);
		button2.addActionListener(new OkButtonActionListener2());
		button2.setBackground( new Color(250,180,200));
		button2.setFont(new Font("Arial", Font.PLAIN, 40));
		currentPanel.add(button2);


		setResizable(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public class OkButtonActionListener1 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}

	public class OkButtonActionListener2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
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
