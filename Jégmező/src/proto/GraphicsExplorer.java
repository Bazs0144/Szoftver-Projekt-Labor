package proto;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GraphicsExplorer extends GraphicsFigure {

	//a num a játékos sorszáma
	public void Draw(Graphics g, int x, int y, int width, int height, int num){
		BufferedImage image = null;
		String path = ".\\src\\proto\\graphics\\sarkkutato.png";
		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		image = Utils.resize(image, width, height);
		g.drawImage(image, x, y, null);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 12));
		g.drawString(String.valueOf(num), x+15, y+15);
	}

}
