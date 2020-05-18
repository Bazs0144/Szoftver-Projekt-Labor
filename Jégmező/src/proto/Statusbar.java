package proto;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A Statusbart megvalosito osztaly.
 */
public class Statusbar extends JPanel {
	/**
	 * A Statusbar osztaly adattagjai
	 * @param name: A kiirt jatekos neve.
	 * @param ab: Egy fix string.
	 * @param temp: A kiirt jatekos homerseklete.
	 * @param act: A kiirt jatekos munkaszama.
	 * @param NameL: A nevkiirasra hasznalatos label.
	 * @param TempL: A hokiirasra hasznalatos label.
	 * @param ActL: A munkaszamkiirasra hasznalatos label.
	 *
	 */
	private String name;
	private String ab = "ability";
	private int temp;
	private int act;
	JLabel NameL, TempL, ActL;

	/** Konstruktor */
	public Statusbar() {
		Player pl=MainFrame.Instance.getCurrentPlayer();
		name=pl.getName();
		temp=pl.getKarakter().ho;
		act=pl.getKarakter().munkak_szama;

		this.setBackground(new Color(189, 216, 235));
		this.setPreferredSize(new Dimension(730, 150));
		currentLabel();
		temperatureLabel();
		actionsLabel();
		buttonsLabel();
	}

	/**  Az aktualis jatekos labelt beallito fv */
	void currentLabel() {
		JPanel current = new JPanel();
		current.setLayout(new BorderLayout());
		current.setPreferredSize(new Dimension(730, 27));
		current.setBackground(new Color(189, 216, 235));

		JPanel textHolder = new JPanel();
		textHolder.setBackground(new Color(189, 216, 235));
		NameL = new JLabel("  current player: " + name);
		NameL.setFont(new Font("Arial", Font.BOLD, 18));

		textHolder.add(NameL);
		current.add(textHolder, BorderLayout.WEST);
		this.add(current);
	}

	/**  Az aktualis jatekos homerseklet labelt beallito fv */
	void temperatureLabel() {
		JPanel temperature = new JPanel();
		temperature.setLayout(new BorderLayout());
		temperature.setPreferredSize(new Dimension(730, 27));
		temperature.setBackground(new Color(189, 216, 235));

		JPanel textHolder = new JPanel();
		textHolder.setBackground(new Color(189, 216, 235));
		TempL = new JLabel("  temperature: " + temp);
		TempL.setForeground(new Color(230, 0, 0));
		TempL.setFont(new Font("Arial", Font.BOLD, 18));

		textHolder.add(TempL);
		temperature.add(textHolder, BorderLayout.WEST);
		this.add(temperature);
	}

	/**  Az aktualis jatekos munkak labelt beallito fv */
	void actionsLabel() {
		JPanel actions = new JPanel();
		actions.setLayout(new BorderLayout());
		actions.setPreferredSize(new Dimension(730, 27));
		actions.setBackground(new Color(189, 216, 235));

		JPanel textHolder = new JPanel();
		textHolder.setBackground(new Color(189, 216, 235));
		ActL = new JLabel("  actions left: " + act);
		ActL.setFont(new Font("Arial", Font.BOLD, 18));

		textHolder.add(ActL);
		actions.add(textHolder, BorderLayout.WEST);

		this.add(actions);
	}

	/** Az aktualis jatekos akcioit kezelo gombokat tartalmazo label beallitasa */
	void buttonsLabel() {
		JPanel buttons = new JPanel();
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
		buttons.setPreferredSize(new Dimension(730, 40));
		buttons.setBackground(new Color(189, 216, 235));

		JButton dig = new JButton("  dig Snow  ");
		dig.setFont(new Font("Arial", Font.BOLD, 22));
		dig.setBackground(new Color(189, 216, 235));
		dig.setBorder(new LineBorder(Color.WHITE, 3));
		dig.addActionListener(new digButtonActionListener());

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

	/**A statusbart frissito fv*/
	public void refresh() {
		Player pl=MainFrame.Instance.getCurrentPlayer();
		name=pl.getName();
		temp=pl.getKarakter().ho;
		act=pl.getKarakter().munkak_szama;
		TempL.setText("  temperature: " + temp);
		NameL.setText("  current player: " + name);
		ActL.setText("  actions left: " + act);

	}

	/** A dig gomb action listenerje */
	class digButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				MainFrame.Instance.getCurrentPlayer().getKarakter().takarit(1);
				MainFrame.Instance.inGameRound();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}


