package proto;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class InGame extends JPanel {
    GameView v;
    Statusbar p;

    public InGame() {
        this.setPreferredSize(new Dimension(730, 700));
        this.setBackground(new Color(189, 216, 235));
        this.setLayout(new BorderLayout());

        p = new Statusbar();
        this.add(p, BorderLayout.NORTH);

        v = new GameView();
        this.add(v, BorderLayout.CENTER);
    }



    GameView getDrawfield(){ return v; }

    Statusbar getStatusBar(){ return p; }

}




