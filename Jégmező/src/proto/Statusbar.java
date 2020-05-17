package proto;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Statusbar extends JPanel {
	private String name;
	private String ab = "ability";
	private int temp;
	private int act;

	public Statusbar() {
		this.setBackground(new Color(189, 216, 235));
		this.setPreferredSize(new Dimension(730, 150));
		currentLabel();
		temperatureLabel();
		actionsLabel();
		buttonsLabel();
	}

	void currentLabel() {
		JPanel current = new JPanel();
		current.setLayout(new BorderLayout());
		current.setPreferredSize(new Dimension(730, 27));
		current.setBackground(new Color(189, 216, 235));

		JPanel textHolder = new JPanel();
		textHolder.setBackground(new Color(189, 216, 235));
		JLabel l = new JLabel("  current player: " + name);
		l.setFont(new Font("Arial", Font.BOLD, 18));

		textHolder.add(l);
		current.add(textHolder, BorderLayout.WEST);
		this.add(current);
	}

	void temperatureLabel() {
		JPanel temperature = new JPanel();
		temperature.setLayout(new BorderLayout());
		temperature.setPreferredSize(new Dimension(730, 27));
		temperature.setBackground(new Color(189, 216, 235));

		JPanel textHolder = new JPanel();
		textHolder.setBackground(new Color(189, 216, 235));
		JLabel l = new JLabel("  temperature: " + temp);
		l.setForeground(new Color(230, 0, 0));
		l.setFont(new Font("Arial", Font.BOLD, 18));

		textHolder.add(l);
		temperature.add(textHolder, BorderLayout.WEST);
		this.add(temperature);
	}

	void actionsLabel() {
		JPanel actions = new JPanel();
		actions.setLayout(new BorderLayout());
		actions.setPreferredSize(new Dimension(730, 27));
		actions.setBackground(new Color(189, 216, 235));

		JPanel textHolder = new JPanel();
		textHolder.setBackground(new Color(189, 216, 235));
		JLabel l = new JLabel("  actions left: " + act);
		l.setFont(new Font("Arial", Font.BOLD, 18));

		textHolder.add(l);
		actions.add(textHolder, BorderLayout.WEST);

		this.add(actions);
	}

	void buttonsLabel() {
		JPanel buttons = new JPanel();
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
		buttons.setPreferredSize(new Dimension(730, 40));
		buttons.setBackground(new Color(189, 216, 235));

		JButton dig = new JButton("  dig Snow  ");
		dig.setFont(new Font("Arial", Font.BOLD, 22));
		dig.setBackground(new Color(189, 216, 235));
		dig.setBorder(new LineBorder(Color.WHITE, 3));

		JButton ability = new JButton("  " + ab + "  ");
		ability.setBorder(new LineBorder(Color.WHITE, 3));
		ability.setFont(new Font("Arial", Font.BOLD, 22));
		ability.setBackground(new Color(189, 216, 235));

		JLabel spaceHolder1 = new JLabel("    ");
		JLabel spaceHolder2 = new JLabel("        ");

		buttons.add(spaceHolder1);
		buttons.add(dig);
		buttons.add(spaceHolder2);
		buttons.add(ability);

		this.add(buttons);
	}
}


