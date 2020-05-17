package proto;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GameView extends Canvas {
    private int jegWidth=110, jegHeight =110;
    private int figWidth=40, figHeight=40;
    private ArrayList<GraphicsBuilding> buildings = new ArrayList<GraphicsBuilding>();
    private ArrayList<GraphicsFigure> figures = new ArrayList<GraphicsFigure>();
    private ArrayList<GraphicsField> fields =  new ArrayList<GraphicsField>();
    private ArrayList<GraphicsTool> tools = new ArrayList<GraphicsTool>();

    public void paint(Graphics g) {
        Graphics2D gd = (Graphics2D) g;
        gd.setStroke(new BasicStroke(5));
      setFields();
      setFigures();

        for(int i = 0; i < 4; i++) {
            for(int i2 = 0; i2 < 4; i2++) {
                if(!(i2 + 1 == 4)) {
                    gd.drawLine(100 + i2 * 120 + 55, 20 + i * 120 + 55,
                            100 + (i2 + 1) * 120 + 55, 20 + i * 120 + 55);
                }
                if(!(i + 1 == 4)) {
                    gd.drawLine(100 + i2 * 120 + 55, 20 + i * 120 + 55,
                            100 + i2 * 120 + 55, 20 + (i + 1) * 120 + 55);
                }
                fields.get(i * 4 + i2).Draw(g, 100 + i2 * 120,20 + i * 120, jegWidth, jegHeight);

            }
        }
        for(int i=0; i<figures.size(); i++) figures.get(i).Draw(g ,figWidth,figHeight,i);
    }

    void setParameters(ArrayList<GraphicsBuilding> _buildings, ArrayList<GraphicsFigure> _figures,
                       ArrayList<GraphicsField> _fields, ArrayList<GraphicsTool> _tools) {
        buildings = _buildings;
        figures = _figures;
        fields = _fields;
        tools = _tools;
    }

    void setFields() {
        fields.clear();
        ArrayList<Jegtabla> jeg=MainFrame.jt.getJegMezo().getJegtablak();
        for(Jegtabla j: jeg) {
            GraphicsField fl;
            if (j.type.equals("Stabil")) fl= new GraphicsStable();
            else if (j.type.equals("Instabil"))  {
                fl=new GraphicsUnstable();
                fl.kap=j.getKapacitas();
            }
            else fl=new GraphicsHole();
            fl.ho=j.getHoMennyiseg();
            fields.add(fl);
        }

        for(int i = 0; i < 4; i++) {
            for (int i2 = 0; i2 < 4; i2++)
                jeg.get(i * 4 + i2).setPoz(new Poz(100 + i2 * 120, 20 + i * 120));
        }
    }

    void setFigures() {
        figures.clear();
        ArrayList<Player> pl=MainFrame.jt.getPlayers();
        int eltolas=0;
        for(Player p: pl) {
            Karakter k=p.getKarakter();
            Poz poz=k.jegtabla.getPoz();
            GraphicsFigure fg;
            if (k.Name.equals("Eskimo")) fg=new GraphicsEskimo();
            else  fg=new GraphicsExplorer();
            fg.setPoz(new Poz(poz.x+eltolas, poz.y));
            figures.add(fg);
            eltolas+=jegWidth/figures.size()/2;
        }

        Jegesmedve jm=MainFrame.jt.getJegesmedve();
        Poz poz=jm.getPoz();
        GraphicsFigure medve=new GraphicsBear();
        medve.setPoz(new Poz(poz.x+jegWidth/2+figWidth/3,poz.y+jegHeight/2-figHeight/2));
        figures.add(medve);
    }
}
