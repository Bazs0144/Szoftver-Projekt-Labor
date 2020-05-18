package proto;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Az aktuális soron levõ játékos tulajdonában levõ tárgyak megjelenítését megvalósitó osztály.
 */
public class EquipmentPanel extends Canvas implements MouseListener, MouseMotionListener {
    /**
     * charactersTools - a grafikus tárgyak listája, amelyek megfelelnek a jelen soron levõ játékos karakterének tulajdonában
     * található tárgyaknak.
     */
    private ArrayList<GraphicsTool> charactersTools = new ArrayList<>();

    public void setCharactersTools(ArrayList<GraphicsTool> _list) {
        charactersTools = _list;

    }

    /**
     * Kirajzolja a grafikus tárgyakat a charactersTools listából.
     * @param g - graphics objektum, amelyre kerül a megjelenitet, tárgyaknak megfelelõ kép.
     */
    public void paint(Graphics g) {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        setTools();
        if(charactersTools.size() == 0) return;
        for (GraphicsTool item: charactersTools) item.Draw(g,60, 60);
    }

    /**
     * a grafikus tárgyak panel-jének beállitása az osztály konstruktorában.
     */
    EquipmentPanel() {
        this.setBackground(new Color(189, 216, 235));
        this.setPreferredSize(new Dimension(new Dimension(70, 700)));
    }

    /**
     * Grafikus tárgyak hozzáadása a charactersTools listához, a megvalósitott tárgy tipusának függvényében.
     */
    public void setTools( ) {
        charactersTools.clear();

        ArrayList<Targy> targyak = MainFrame.Instance.getCurrentPlayer().getKarakter().getTargyak();
            for(int i=0; i<targyak.size(); i++) {
                Targy t=targyak.get(i);
                GraphicsTool tl;
                if (t.Name.equals("Alkatresz")) tl = new GraphicsPart();
                else if (t.Name.equals("Aso")) tl = new GraphicsSpade();
                else if (t.Name.equals("Buvarruha")) tl = new GraphicsDivingSuit();
                else if (t.Name.equals("Etel")) tl = new GraphicsFood();
                else if (t.Name.equals("Kotel")) tl = new GraphicsRope();
                else if (t.Name.equals("Lapat")) tl = new GraphicsShovel();
                else tl = new GraphicsTentTool();
                 tl.poz =new Poz(0, i * 60);
                charactersTools.add(tl);
        }
    }




    public void refreshTools() {
        this.repaint();
    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }


    /**
     * Egy grafikus tárgyra való kattintáskor, ez kiválasztásra, majd használatra kerül.
     * @param mouseEvent
     */
    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        Poz katt=new Poz(mouseEvent.getX(), mouseEvent.getY());
        Karakter k=MainFrame.Instance.getCurrentPlayer().getKarakter();
        ArrayList<Targy> t=k.getTargyak();
        for(int i=0; i<t.size(); i++) {
            Targy targy=t.get(i);
            if(katt.y<(i+1)*60&&katt.y>i*60) {
                try {
                    k.hasznal(k.getTargyak().get(i), k.getJegtabla());
                    MainFrame.Instance.inGameRound();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        this.repaint();
        }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
