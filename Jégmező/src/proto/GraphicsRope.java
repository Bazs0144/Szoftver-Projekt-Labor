package proto;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/**
 * A grafikus k�t�l megjelenit�s�t megval�sit� oszt�ly.
 */
public class GraphicsRope extends GraphicsTool {

	/**
	 * A Draw f�ggv�nyt val�sitja meg a k�t�l grafikus elemre.
	 * @param g - Graphics objektum, amelyre ker�l a megjelenitet, k�t�lnek megfelel� k�p.
	 * @param width - a megjelenitett k�p sz�less�ge
	 * @param height - a megjelenitett k�p magass�ga
	 */
	public void Draw(Graphics g, int width, int height){
		int x=poz.x;
		int y=poz.y;
		BufferedImage image = null;
		String path = ".\\src\\proto\\graphics\\kotel.png";
		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		image = Utils.resize(image, width, height);
		g.drawImage(image, x, y, null);
	}

}
