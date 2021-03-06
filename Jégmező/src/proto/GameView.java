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
 * a GameViewt megvalosito osztaly.
 * Ez rajzolja ki a grafikus elemeket.
 */
public class GameView extends BufferedCanvas implements MouseListener, MouseMotionListener {
    /**
     * A GameView osztaly adattagjai
     * @param jegWidth:egy jegtabla szelessege.
     * @param jegHeight:egy jegtabla magassaga.
     * @param figWidth:egy figura szelessege.
     * @param figWidth:egy figura magassaga.
     * @param buildings: a palyan levo epuletek listaja.
     * @param figures: a palyan levo figurak listaja.
     * @param fields: a palyan levo mezok listaja.
     * @param tools: a palyan levo eszkozok listaja.
     */
    private int jegWidth = 110, jegHeight = 110;
    private int figWidth = 40, figHeight = 40;
    private ArrayList<GraphicsBuilding> buildings = new ArrayList<GraphicsBuilding>();
    private ArrayList<GraphicsFigure> figures = new ArrayList<GraphicsFigure>();
    private ArrayList<GraphicsField> fields = new ArrayList<GraphicsField>();
    private ArrayList<GraphicsTool> tools = new ArrayList<GraphicsTool>();

    public void paint (Graphics g) {
        update(g);
    }

    /** A kirajzolo fv */
    public void render(Graphics g) {
        Graphics2D gd = (Graphics2D) g;
        gd.setStroke(new BasicStroke(5));
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
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

    /** Parametereket beallitja betolteshez */
    void setParameters(ArrayList<GraphicsBuilding> _buildings, ArrayList<GraphicsFigure> _figures,
                       ArrayList<GraphicsField> _fields, ArrayList<GraphicsTool> _tools) {
        buildings = _buildings;
        figures = _figures;
        fields = _fields;
        tools = _tools;
    }

    /** Mezoket beallitja */
    void setFields() {
        fields.clear();
        ArrayList<Jegtabla> jeg = MainFrame.jt.getJegMezo().getJegtablak();
        for (Jegtabla j : jeg) {
            GraphicsField fl;
            if (j.type.equals("Stabil")) fl = new GraphicsStable();
            else if (j.type.equals("Instabil")) {
                fl = new GraphicsUnstable();
                if(j.isVizsgalt()) fl.kap = j.getKapacitas();
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

    /** Figurakat beallitja */
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

    /** Eszkozoket beallitja*/
    void setTools() {
        tools.clear();
        ArrayList<Jegtabla> jeg = MainFrame.jt.getJegMezo().getJegtablak();
        for (Jegtabla jg : jeg) {
            if (jg.getHoMennyiseg() == 0 && !jg.type.equals("Luk")) {
                Poz poz = jg.getPoz();
                Targy tr = jg.getTargy();
                GraphicsTool tl;
                if(tr!=null) {
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
    }

    /** Epitmenyeket beallitja */
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
	public void mouseClicked(MouseEvent e) {}

	/** Mouse event handler */
	@Override
	public void mousePressed(MouseEvent e) {
		//Tartomany ellenorzes
		if(e.getX() >= 100 && e.getX() <= 570)
			if(e.getY() >= 20 && e.getY() <= 490) {
				//Ez a 4 sor biztositja, hogy megtalalja a getJegtabla(x,y) a megfelelo jegtablat
				int x = (e.getX()-100)/120;
				int y = (e.getY()-20)/120;
				x = x*120+100;
				y = y*120+20;
				Poz p = new Poz(x, y);
				try {
					MainFrame.Instance.move(p);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				if(e.getX()<x+jegWidth&&e.getY()<y+jegHeight) {
				    Jegtabla j=MainFrame.Instance.getCurrentPlayer().getKarakter().getJegtabla();
				    Jegtabla kattintott=MainFrame.Instance.jt.getJegMezo().getJegtabla(x,y);
				    if(j.equals(kattintott))
				        if(j.getTargy()!=null) MainFrame.Instance.getCurrentPlayer().getKarakter().targy_felvetele();
                }
				this.repaint();
		}
        try {
            MainFrame.Instance.inGameRound();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mouseDragged(MouseEvent e) {		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}
}

