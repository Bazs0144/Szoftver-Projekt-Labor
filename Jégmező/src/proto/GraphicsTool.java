package proto;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GraphicsTool implements Drawable{
	
	public void Draw(Graphics g,  int x, int y){
		BufferedImage image = null;
		String path = ".\\proto\\resources\\alkatresz.png";
		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(image, x, y, null);
	}

}
