package proto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** A j�t�k be�ll�t�sakor haszn�lt JPanelt megval�sit� oszt�ly.
 *  Itt lehet be�llitani a j�t�kosokat �s a j�t�kos karaktereinek tipus�t.*/
public class AddPlayer extends JPanel {
    /**
     * chooseName - a JLabel ki�rja, hogy itt lehet nevet adni a j�t�kosnak.
     * chooseChar - a JLabel ki�rja, hogy itt lehet tipust v�lasztani a j�t�kos karakter�nek.
     * name - ebbe a JTextArea-ba lehet beirni billenty�zetr�l az �j j�t�kos nev�t.
     * eszkimo - gomb, amelynek lenyom�s�val kiv�laszthat�, hogy a j�t�kos karakter�nek tipusa Eszkimo.
     * sk - gomb, amelynek lenyom�s�val kiv�laszthat�, hogy a j�t�kos karakter�nek tipusa Sarkkutato.
     * back - gomb, amelynek lenyom�s�val kiv�laszthat� a men�be val� visszal�p�s.
     * add - gomb, amelynek lenyom�s�val hozz�adhat� az �j be�llitott j�t�kos a �j j�t�khoz.
     * charac - �ppen milyen karaktertipus lett kiv�lasztva a j�t�kos hozz�ad�s sor�n.
     */
    JLabel chooseName, chooseChar;
    JTextArea name;
    JButton eskimo, sk, back, add;
    String charac=new String("");

    /**
     * Az attrib�tum .swing elemek megval�sit�sa.
     * Mindegyik elem k�l�n ker�l l�trehoz�sra �s k�l�n be lesznek �llitva ezek legfontosabb tulajdons�gai.
     * Az egyes elemek be�llit�sa ut�n, a grafikus elem felker�l a JPanle-re, amelyet �ppen megval�situnk.
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
     * A grafikus gomb megval�sit�sa, amely lenyom�s�nak hat�s�ra vissza lehet l�pni a j�t�k men�j�be.
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
     * Az �j j�t�kos hozz�ad�sa a j�t�khoz, miut�n meg lett nyomva a megfelel� grafikus gomb �s meg volt adva a
     * j�t�kos karakter�nek tipusa. Nem lehet v�grehajtani a j�t�kos hozz�ad�s�t a j�t�khoz, ha nincs megadva ennek tipusa.
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
     * Az �j j�t�kos karakter tipus�nak be�llit�sa eszkim�ra, miut�n meg lett nyomva a megfelel� grafikus gomb.
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
     * Az �j j�t�kos karakter tipus�nak be�llit�sa sarkkutat�ra, miut�n meg lett nyomva a megfelel� grafikus gomb.
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
