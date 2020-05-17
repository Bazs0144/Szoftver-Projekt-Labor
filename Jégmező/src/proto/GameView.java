package proto;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameView extends Canvas {
    public void paint(Graphics g) {
        this.setBackground(new Color(189, 216, 235));
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(".\\src\\proto\\graphics\\stabil.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        img = Utils.resize(img, 100, 100);
        g.drawImage(img, 20, 30, null);
    }
}
