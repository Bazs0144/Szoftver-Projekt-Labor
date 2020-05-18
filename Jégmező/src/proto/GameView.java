package proto;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GameView extends Canvas implements MouseListener {
    private int jegWidth = 110, jegHeight = 110;
    private int figWidth = 40, figHeight = 40;
    private ArrayList<GraphicsBuilding> buildings = new ArrayList<GraphicsBuilding>();
    private ArrayList<GraphicsFigure> figures = new ArrayList<GraphicsFigure>();
    private ArrayList<GraphicsField> fields = new ArrayList<GraphicsField>();
    private ArrayList<GraphicsTool> tools = new ArrayList<GraphicsTool>();

    public void paint(Graphics g) {
        Graphics2D gd = (Graphics2D) g;
        gd.setStroke(new BasicStroke(5));
        this.addMouseListener(this);
        setFields();
        setFigures();
        setTools();
        setBuildings();

        for (int i = 0; i < 4; i++) {
            for (int i2 = 0; i2 < 4; i2++) {
                if (!(i2 + 1 == 4)) {
                    gd.drawLine(100 + i2 * 120 + 55, 20 + i * 120 + 55,
                            100 + (i2 + 1) * 120 + 55, 20 + i * 120 + 55);
                }
                if (!(i + 1 == 4)) {
                    gd.drawLine(100 + i2 * 120 + 55, 20 + i * 120 + 55,
                            100 + i2 * 120 + 55, 20 + (i + 1) * 120 + 55);
                }
                fields.get(i * 4 + i2).Draw(g, 100 + i2 * 120, 20 + i * 120, jegWidth, jegHeight);

            }
        }
        for (int i = 0; i < figures.size(); i++) figures.get(i).Draw(g, figWidth, figHeight, i);
        for (int i = 0; i < tools.size(); i++) tools.get(i).Draw(g, figWidth, figHeight);
        for (int i = 0; i < buildings.size(); i++) buildings.get(i).Draw(g, figWidth, figHeight);
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
        ArrayList<Jegtabla> jeg = MainFrame.jt.getJegMezo().getJegtablak();
        for (Jegtabla j : jeg) {
            GraphicsField fl;
            if (j.type.equals("Stabil")) fl = new GraphicsStable();
            else if (j.type.equals("Instabil")) {
                fl = new GraphicsUnstable();
                fl.kap = j.getKapacitas();
            } else fl = new GraphicsHole();
            fl.ho = j.getHoMennyiseg();
            fl.befagy = (j.get_befagyva() && j.getHoMennyiseg() == 0);
            fields.add(fl);
        }

        for (int i = 0; i < 4; i++) {
            for (int i2 = 0; i2 < 4; i2++)
                jeg.get(i * 4 + i2).setPoz(new Poz(100 + i2 * 120, 20 + i * 120));
        }
    }

    void setFigures() {
        figures.clear();
        ArrayList<Player> pl = MainFrame.jt.getPlayers();
        int eltolas = 0;
        for (Player p : pl) {
            Karakter k = p.getKarakter();
            Poz poz = k.jegtabla.getPoz();
            GraphicsFigure fg;
            if (k.Name.equals("Eskimo")) fg = new GraphicsEskimo();
            else fg = new GraphicsExplorer();
            fg.setPoz(new Poz(poz.x + jegWidth - figWidth - eltolas, poz.y));
            figures.add(fg);
            eltolas += jegWidth / figures.size() / 3;
        }

        Jegesmedve jm = MainFrame.jt.getJegesmedve();
        Poz poz = jm.getPoz();
        GraphicsFigure medve = new GraphicsBear();
        medve.setPoz(new Poz(poz.x + jegWidth / 2 + figWidth / 3, poz.y + jegHeight / 2 - figHeight / 2));
        figures.add(medve);
    }

    void setTools() {
        tools.clear();
        ArrayList<Jegtabla> jeg = MainFrame.jt.getJegMezo().getJegtablak();
        for (Jegtabla jg : jeg) {
            if (jg.getHoMennyiseg() == 0 && !jg.type.equals("Luk")) {
                Poz poz = jg.getPoz();
                Targy tr = jg.getTargy();
                GraphicsTool tl;
                if (tr.Name.equals("Alkatresz")) tl = new GraphicsPart();
                else if (tr.Name.equals("Aso")) tl = new GraphicsSpade();
                else if (tr.Name.equals("Buvarruha")) tl = new GraphicsDivingSuit();
                else if (tr.Name.equals("Etel")) tl = new GraphicsFood();
                else if (tr.Name.equals("Kotel")) tl = new GraphicsRope();
                else if (tr.Name.equals("Lapat")) tl = new GraphicsShovel();
                else tl = new GraphicsTentTool();
                tl.poz = new Poz(poz.x, poz.y);
                tools.add(tl);
            }
        }
    }

    void setBuildings() {
        buildings.clear();
        ArrayList<Jegtabla> jeg = MainFrame.jt.getJegMezo().getJegtablak();
        for (Jegtabla jg : jeg) {
            if (jg.getHoMennyiseg() == 0 && !jg.type.equals("Luk")) {
                Poz poz = jg.getPoz();
                Epitmeny ep = jg.getEpitmeny();
                GraphicsBuilding bd;
                if(ep!=null){
                    if (ep.getName().equals("Iglu")) bd = new GraphicsIgloo();
                    else bd = new GraphicsTent();
                    bd.poz=new Poz(poz.x+jegWidth/2-figWidth/2, poz.y+jegHeight/2-figHeight/2);
                    buildings.add(bd);
                }
            }
        }
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		//Tartomany ellenorzes
		if(e.getX() >= 100 && e.getX() <= 570)
			if(e.getY() >= 20 && e.getY() <= 490) {
				//Konverzio raw inputrol a jegtablak koordinata rendszerere
				//X:0-3, Y:0-3
				int x = (e.getX()-100)/120;
				int y = (e.getY()-20)/120;
				if(x >= 0 && x <= 3 && y >= 0 && y <= 3) {
					//A megadott koordinatakon levo jegtabla eltarolasa a konnyebb olvashatosagert.
					Jegtabla here = MainFrame.Instance.jt.getJegMezo().getJegtabla(x, y);
					try {
						//Lepesi kiserlet.
						MainFrame.Instance.getCurrentPlayer().getKarakter().lep(here);
					} catch (Exception e1) {}
			}
		}	
		
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
}

