package proto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** A játék beállításakor használt JPanelt megvalósitó osztály.
 *  Itt lehet beállitani a játékosokat és a játékos karaktereinek tipusát.*/
public class AddPlayer extends JPanel {
    /**
     * chooseName - a JLabel kiírja, hogy itt lehet nevet adni a játékosnak.
     * chooseChar - a JLabel kiírja, hogy itt lehet tipust választani a játékos karakterének.
     * name - ebbe a JTextArea-ba lehet beirni billentyûzetrõl az új játékos nevét.
     * eszkimo - gomb, amelynek lenyomásával kiválasztható, hogy a játékos karakterének tipusa Eszkimo.
     * sk - gomb, amelynek lenyomásával kiválasztható, hogy a játékos karakterének tipusa Sarkkutato.
     * back - gomb, amelynek lenyomásával kiválasztható a menübe való visszalépés.
     * add - gomb, amelynek lenyomásával hozzáadható az új beállitott játékos a új játékhoz.
     * charac - éppen milyen karaktertipus lett kiválasztva a játékos hozzáadás során.
     */
    JLabel chooseName, chooseChar;
    JTextArea name;
    JButton eskimo, sk, back, add;
    String charac=new String("");

    /**
     * Az attribútum .swing elemek megvalósitása.
     * Mindegyik elem külön kerül létrehozásra és külön be lesznek állitva ezek legfontosabb tulajdonságai.
     * Az egyes elemek beállitása után, a grafikus elem felkerül a JPanle-re, amelyet éppen megvalósitunk.
     */
    public AddPlayer() {
        this.setBackground(new Color(189, 216, 235));
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

    /**
     * A grafikus gomb megvalósitása, amely lenyomásának hatására vissza lehet lépni a játék menüjébe.
     */
    class BackButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                MainFrame.Instance.changeState(State.NewGameS);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Az új játékos hozzáadása a játékhoz, miután meg lett nyomva a megfelelõ grafikus gomb és meg volt adva a
     * játékos karakterének tipusa. Nem lehet végrehajtani a játékos hozzáadását a játékhoz, ha nincs megadva ennek tipusa.
     */
    class AddButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String pname=name.getText();
            if(!charac.equals("")&&!pname.equals("")) {
                Karakter k;
                if(charac.equals("eskimo")) k=new Eszkimo();
                else k=new Sarkkutato();
                MainFrame.Instance.addNewPlayer(new Player(k, pname));
                try {
                    MainFrame.Instance.changeState(State.NewGameS);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    /**
     * Az új játékos karakter tipusának beállitása eszkimóra, miután meg lett nyomva a megfelelõ grafikus gomb.
     */
    class EskimoButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
           charac="eskimo";
           eskimo.setBackground(new Color(255, 26, 44));
            sk.setBackground( new Color(255, 255, 255));
        }
    }

    /**
     * Az új játékos karakter tipusának beállitása sarkkutatóra, miután meg lett nyomva a megfelelõ grafikus gomb.
     */
    class SkButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            charac="pole";
            sk.setBackground(new Color(255, 26, 44));
            eskimo.setBackground( new Color(255, 255, 255));
        }
    }
}
