package proto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPlayer extends JPanel {
    JLabel chooseName, chooseChar;
    JTextArea name;
    JButton eskimo, sk, back, add;
    String charac=new String("");


    public AddPlayer() {
        this.setBackground(Color.cyan);
        GridBagLayout gl=new GridBagLayout();
        this.setLayout(gl);
        GridBagConstraints c = new GridBagConstraints();

        chooseName = new JLabel("Choose your name: ");
        chooseName.setFont(new Font("Serif", Font.BOLD, 30));
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.WEST;
        c.insets = new Insets(10, 10, 10, 10);
        this.add(chooseName, c);

        name = new JTextArea(1, 20);
        c.fill = GridBagConstraints.NONE;
        name.setPreferredSize(new Dimension(4, 9));
        name.setFont(new Font("Serif", Font.BOLD, 20));
        c.gridx = 2;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 2;
        c.insets = new Insets(10, 10, 10, 10);
        this.add(name, c);

        chooseChar = new JLabel("Choose your character: ");
        chooseChar.setFont(new Font("Serif", Font.BOLD, 30));
        c.gridx = 1;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 4;
        c.fill = GridBagConstraints.CENTER;
        c.insets = new Insets(10, 10, 10, 10);
        this.add(chooseChar, c);

        eskimo = new JButton("Eskimo");
        eskimo.setBackground( new Color(250, 255, 255));
        eskimo.setFont(new Font("Arial", Font.PLAIN, 30));
        c.gridx = 0;
        c.gridy = 2;
        c.gridheight = 1;
        c.gridwidth = 2;
        eskimo.addActionListener(new EskimoButtonActionListener());
        c.insets = new Insets(10, 10, 10, 10);
        this.add(eskimo, c);

        sk = new JButton("Polar explorer");
        sk.setBackground( new Color(255, 255, 255));
        sk.setFont(new Font("Arial", Font.PLAIN, 30));
        c.gridx = 2;
        c.gridy = 2;
        c.gridheight = 1;
        c.gridwidth = 2;
        sk.addActionListener(new SkButtonActionListener());
        c.insets = new Insets(10, 10, 10, 10);
        this.add(sk, c);

        add = new JButton("Add Player");
        add.setBackground( new Color(250,180,200));
        add.setFont(new Font("Arial", Font.PLAIN, 30));
        c.gridx = 0;
        c.gridy = 3;
        c.gridheight = 1;
        c.gridwidth = 4;
        c.fill = GridBagConstraints.CENTER;
        c.insets = new Insets(10, 10, 10, 10);
        add.addActionListener(new AddButtonActionListener());
        this.add(add, c);

        back = new JButton("Back to Menu");
        back.setBackground( new Color(250,180,200));
        back.setFont(new Font("Arial", Font.PLAIN, 30));
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 4;
        c.insets = new Insets(10, 10, 10, 10);
       back.addActionListener(new BackButtonActionListener());
        this.add(back, c);

    }

    class BackButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            MainFrame.Instance.changeState(State.NewGameS);
        }
    }

    class AddButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String pname=name.getText();
            if(!charac.equals("")&&!pname.equals("")) {
                Karakter k;
                if(charac.equals("eskimo")) k=new Eszkimo();
                else k=new Sarkkutato();
                MainFrame.Instance.addNewPlayer(new Player(k, pname));
                MainFrame.Instance.changeState(State.NewGameS);
            }
        }
    }

    class EskimoButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
           charac="eskimo";
           eskimo.setBackground(new Color(255, 26, 44));
            sk.setBackground( new Color(255, 255, 255));
        }
    }

    class SkButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            charac="pole";
            sk.setBackground(new Color(255, 26, 44));
            eskimo.setBackground( new Color(255, 255, 255));
        }
    }
}
