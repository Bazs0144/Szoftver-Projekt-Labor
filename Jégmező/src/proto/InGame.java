package proto;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class InGame extends JPanel {
    public InGame() {
        this.setPreferredSize(new Dimension(730, 700));
        this.setBackground(new Color(189, 216, 235));
        this.setLayout(new BorderLayout());

        Statusbar p = new Statusbar();// a harom adat es a ket gomb
        this.add(p, BorderLayout.NORTH);

        GameView v = new GameView();
        this.add(v, BorderLayout.CENTER);
    }
}




