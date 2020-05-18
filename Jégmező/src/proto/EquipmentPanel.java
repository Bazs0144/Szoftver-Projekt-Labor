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

public class EquipmentPanel extends Canvas implements MouseListener, MouseMotionListener {
    private ArrayList<GraphicsTool> charactersTools = new ArrayList<>();

    public void setCharactersTools(ArrayList<GraphicsTool> _list) {
        charactersTools = _list;
    }
    public void paint(Graphics g) {
        setTools();
        if(charactersTools.size() == 0) return;
        for (GraphicsTool item: charactersTools) item.Draw(g,60, 60);
    }

    EquipmentPanel() {
        this.setBackground(new Color(189, 216, 235));
        this.setPreferredSize(new Dimension(new Dimension(70, 700)));
    }

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

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        System.out.println(mouseEvent.getX() + " " + mouseEvent.getY());
        Poz katt=new Poz(mouseEvent.getX(), mouseEvent.getY());
        Karakter k=MainFrame.Instance.getCurrentPlayer().getKarakter();
        ArrayList<Targy> t=k.getTargyak();
        for(int i=0; i<t.size(); i++) {
            Targy targy=t.get(i);
            if(katt.y<(i+1)*60&&katt.y>i*60) {
                try {
                    System.out.println("hasznal");
                    k.hasznal(k.getTargyak().get(i), k.getJegtabla());
                    MainFrame.Instance.inGameRound();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.repaint();
        }
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
