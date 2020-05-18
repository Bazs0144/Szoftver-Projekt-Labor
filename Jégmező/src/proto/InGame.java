package proto;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

/**
 * Az ingame panel megvalositasa, ami tartalmazza a drawfieldet es a statusbart
 */
public class InGame extends JPanel {
    /**
     * Az InGame osztaly adattagjai
     * @param v: a gameView aktiv peldanya.
     * @param p: a statusbar aktiv peldanya.
     */
    GameView v;
    Statusbar p;

    /** Konstruktor */
    public InGame() {
        this.setPreferredSize(new Dimension(730, 700));
        this.setBackground(new Color(189, 216, 235));
        this.setLayout(new BorderLayout());

        p = new Statusbar();
        this.add(p, BorderLayout.NORTH);

        v = new GameView();
        this.add(v, BorderLayout.CENTER);
    }

    /** Statusbar beallitasa */
    public void setP(Statusbar p) {
        this.p = p;
    }
    /** Visszaadja a drawfieldet */
    GameView getDrawfield(){ return v; }
    /** Visszaadja a statusbart*/
    Statusbar getStatusBar(){ return p; }

}




