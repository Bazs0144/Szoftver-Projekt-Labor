package proto;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GameView extends Canvas {
    private ArrayList<GraphicsBuilding> buildings = new ArrayList<GraphicsBuilding>();
    private ArrayList<GraphicsFigure> figures = new ArrayList<GraphicsFigure>();
    private ArrayList<GraphicsField> fields =  new ArrayList<GraphicsField>();
    private ArrayList<GraphicsTool> tools = new ArrayList<GraphicsTool>();

    public void paint(Graphics g) {
        Graphics2D gd = (Graphics2D) g;
        gd.setStroke(new BasicStroke(5));
        if(fields.size() < 16) {
            for(int i = 0; i < 16; i++) {
                fields.add(new GraphicsStable());
            }
        }
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
                fields.get(i * 4 + i2).Draw(g, 100 + i2 * 120,20 + i * 120, 110, 110);
            }
        }
    }

    void setParameters(ArrayList<GraphicsBuilding> _buildings, ArrayList<GraphicsFigure> _figures,
                       ArrayList<GraphicsField> _fields, ArrayList<GraphicsTool> _tools) {
        buildings = _buildings;
        figures = _figures;
        fields = _fields;
        tools = _tools;
    }
}
