package proto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

public class Menu extends JPanel{
	private MenuMEH MEH = new MenuMEH();
	private JButton button1, button2;
	private JTextArea text, text2;
	
	public Menu (){
		this.setBackground(Color.cyan);
		GridBagLayout gl=new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		this.setPreferredSize(new Dimension(3, 5));
		c.fill = GridBagConstraints.NONE;

		this.setLayout(gl);
		text = new JTextArea();
		text.append("ICEFIELD\n");
		text.setEditable(false);
		text.setFont(new Font("Serif", Font.BOLD, 96));
		text.setBackground(Color.cyan);
		c.weightx = 0.2;
		c.gridx = 1;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(10, 10, 10, 10);
		this.add(text, c);

		text2 = new JTextArea();
		text2.append("THE GAME");
		text2.setEditable(false);
		text2.setFont(new Font("Serif", Font.BOLD, 50));
		text2.setBackground(Color.cyan);
		c.weightx = 0.2;
		c.gridx = 1;
		c.gridy = 1;
		c.gridheight = 1;
		c.gridwidth = 1;
		this.add(text2, c);

		button1 = new JButton();
		button1.setText("New Game");
		button1.addActionListener(new MenuMEH.OkButtonActionListener1());
		button1.setBackground( new Color(250,180,200));
		button1.setFont(new Font("Arial", Font.PLAIN, 40));
		c.gridx = 1;
		c.gridy = 2;
		c.gridheight = 1;
		c.gridwidth = 1;
		this.add(button1, c);

		button2 = new JButton();
		button2.setText("Load Game");
		button2.addActionListener(new MenuMEH.OkButtonActionListener2());
		button2.setBackground( new Color(250,180,200));
		button2.setFont(new Font("Arial", Font.PLAIN, 40));
		c.gridx = 1;
		c.gridy = 3;
		c.gridheight = 1;
		c.gridwidth = 1;
		this.add(button2,c);

	}

}
