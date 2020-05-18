package proto;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/**
 * A grafikus luk megjelenit�s�t megval�sit� oszt�ly.
 */
public class GraphicsHole extends GraphicsField {

	/**
	 * A Draw f�ggv�nyt val�sitja meg a luk grafikus elemre.
	 * @param g - Graphics objektum, amelyre ker�l a megjelenitet, luknak megfelel� k�p.
	 * @param width - a megjelenitett k�p sz�less�ge
	 * @param height - a megjelenitett k�p magass�ga
	 * @param x - a j�gt�bla sz�less�gi koordin�t�ja
	 * @param y - a j�gt�bla magass�gi koordin�t�ja
	 */
	public void Draw(Graphics g, int x, int y, int width, int height){
		BufferedImage image = null;
		String path = ".\\src\\proto\\graphics\\luk.png";
		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		image = Utils.resize(image, width, height);
		g.drawImage(image, x, y, null);
	}

}
