package proto;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GraphicsExplorer extends GraphicsFigure {

	//a num a játékos sorszáma
	public void Draw(Graphics g, int x, int y, int num){
		BufferedImage image = null;
		String path = ".\\proto\\resources\\sarkkutato.png";
		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(image, x, y, null);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 12));
		g.drawString(String.valueOf(num), x+15, y+15);
	}

}
