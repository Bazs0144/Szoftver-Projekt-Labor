package proto;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GraphicsBear extends GraphicsFigure {
	
	public void Draw(Graphics g, int x, int y, int width, int height){
		BufferedImage image = null;
		String path = ".\\proto\\resources\\medve.png";
		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		image = Utils.resize(image, width, height);
		g.drawImage(image, x, y, null);
	}
}
