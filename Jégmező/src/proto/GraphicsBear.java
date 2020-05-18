package proto;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * A grafikus jegesmedve megjelenit�s�t megval�sit� oszt�ly.
 */
public class GraphicsBear extends GraphicsFigure {

	/**
	 * A Draw f�ggv�nyt val�sitja meg a jegesmedve grafikus elemre.
	 * @param g - Graphics objektum, amelyre ker�l a megjelenitet, jegesmedv�nek megfelel� k�p.
	 * @param width - a megjelenitett k�p sz�less�ge
	 * @param height - a megjelenitett k�p magass�ga
	 * @param num - ezt a param�tert a jegesmedve kirajzol�sa eset�n nem haszn�ljuk.
	 */
	public void Draw(Graphics g, int width, int height, int num){
		int x=poz.x;
		int y=poz.y;
		BufferedImage image = null;
		String path = ".\\src\\proto\\graphics\\medve.png";
		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		image = Utils.resize(image, width, height);
		g.drawImage(image, x, y, null);
	}
}
