package proto;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class EquipmentPanel extends Canvas {
    private ArrayList<GraphicsTool> charctersTools;

    public void setCharactersTools(ArrayList<GraphicsTool> _list) {
        charctersTools = _list;
    }
    public void paint(Graphics g) {
        int i = 0;
        for (GraphicsTool item: charctersTools) {
            item.Draw(g, 0, i * 60, 60, 60);
        }
    }

    EquipmentPanel() {
        this.setBackground(new Color(189, 216, 235));
        this.setPreferredSize(new Dimension(new Dimension(70, 700)));
    }


}
