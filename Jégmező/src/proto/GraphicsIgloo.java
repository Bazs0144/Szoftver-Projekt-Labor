package proto;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GraphicsIgloo  extends GraphicsBuilding {
	
	public void Draw(Graphics g,  int x, int y){
		BufferedImage image = null;
		String path = ".\\proto\\resources\\iglu.png";
		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(image, x, y, null);
	}
}
