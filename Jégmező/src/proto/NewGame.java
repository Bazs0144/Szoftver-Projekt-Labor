package proto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Az uj jatek elkezdesehez hasznalhato interfaceert felelos osztaly
 */
public class NewGame extends JPanel {
    /**
     * A NewGame osztaly adattagjai
     * @param players: A cimlabel.
     * @param start: A start gomb.
     * @param back: A visszalepes gomb.
     * @param add: A hozzaadas gomb, ami Addplayerre navigal.
     * @param playerNames: A jatekosok neveit tarolo lista.
     * @param listModel: A jatekosok neveit megjelenito listaelem.
     */
    private JLabel players;
    private JButton start, back, add;
    ArrayList <String> playerNames;
    DefaultListModel listModel;

    /** Konstruktor */
   public NewGame() {

       this.setBackground(new Color(189, 216, 235));
       GridBagLayout gl=new GridBagLayout();
       this.setLayout(gl);
       GridBagConstraints c = new GridBagConstraints();
       c.fill = GridBagConstraints.NONE;

       players = new JLabel("Players");
       players.setFont(new Font("Serif", Font.BOLD, 60));
       c.weightx = 0.2;
       c.gridx = 1;
       c.gridy = 0;
       c.gridheight = 1;
       c.gridwidth = 1;
       c.insets = new Insets(10, 10, 10, 10);
       this.add(players, c);

       start = new JButton("Start Game");
       start.setBackground( new Color(250,180,200));
       start.setFont(new Font("Arial", Font.PLAIN, 30));
       c.gridx = 2;
       c.gridy = 2;
       c.gridheight = 1;
       c.gridwidth = 1;
       c.insets = new Insets(10, 10, 10, 10);
       start.addActionListener(new StartButtonActionListener());
       this.add(start, c);

       back = new JButton("Back to Menu");
       back.setBackground( new Color(250,180,200));
       back.setFont(new Font("Arial", Font.PLAIN, 30));
       c.gridx = 0;
       c.gridy = 2;
       c.insets = new Insets(10, 10, 10, 10);
       back.addActionListener(new BackButtonActionListener());
       this.add(back, c);

       add = new JButton("Add Player");
       add.setBackground( new Color(250,180,200));
       add.setFont(new Font("Arial", Font.PLAIN, 30));
       c.gridx = 1;
       c.gridy = 2;
       c.insets = new Insets(10, 10, 10, 10);
       add.addActionListener(new AddButtonActionListener());
       this.add(add, c);

       playerNames=new ArrayList<String>();
       listModel = new DefaultListModel();
      if(MainFrame.Instance.getNewPlayers().size()>0) {
          for(Player p : MainFrame.Instance.getNewPlayers())  listModel.addElement(p.getName() + " - "+ p.getKarakter().Name) ;
      }else listModel.addElement("No players yet");

        JList jatekosok= new JList(listModel);
       jatekosok.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
       jatekosok.setLayoutOrientation(JList.VERTICAL);
       jatekosok.setVisibleRowCount(-1);
       c.gridx = 1;
       c.gridy = 1;
       c.weighty=1;
       JScrollPane listScroller = new JScrollPane(jatekosok);
       listScroller.createVerticalScrollBar();
       listScroller.setPreferredSize(new Dimension(300, 500));
       this.add(listScroller, c);

    }

    /** A visszalepes gomb actionlistenerje */
    public class BackButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                MainFrame.Instance.changeState(State.MenuS);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    /** A start gomb actionlistenerje */
    public class StartButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                MainFrame.Instance.changeState(State.InGameS);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    /** A hozzaadas gomb actionlistenerje */
    public class AddButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                MainFrame.Instance.changeState(State.AddPlayerS);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }


}
