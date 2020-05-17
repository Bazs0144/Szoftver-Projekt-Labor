package proto;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EquipmentPanel extends Canvas {
    

    public void paint(Graphics g) {


        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(".\\src\\proto\\graphics\\alkatresz.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        img = Utils.resize(img, 60, 60);
        g.drawImage(img, 0, 0, null);
    }

    EquipmentPanel() {
        this.setBackground(new Color(189, 216, 235));
        this.setPreferredSize(new Dimension(new Dimension(70, 700)));
    }
}
