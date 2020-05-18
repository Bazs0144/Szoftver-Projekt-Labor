package proto;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/**
 * A grafikus stabil j�gt�bla megjelenit�s�t megval�sit� oszt�ly.
 */
public class GraphicsStable extends GraphicsField {

	/**
	 * A Draw f�ggv�nyt val�sitja meg a stabil j�gt�bla grafikus elemre.
	 * Ha a j�gt�bla be van fagyva vagy tal�lhat� rajta h�, ezt is grafikusan jelezz�k.
	 * @param g - Graphics objektum, amelyre ker�l a megjelenitet, stabil j�gt�bl�nak megfelel� k�p.
	 * @param width - a megjelenitett k�p sz�less�ge
	 * @param height - a megjelenitett k�p magass�ga
	 * @param x - a j�gt�bla sz�less�gi koordin�t�ja
	 * @param y - a j�gt�bla magass�gi koordin�t�ja
	 */
	public void Draw(Graphics g,  int x, int y, int width, int height){
		BufferedImage image = null;
		String path = ".\\src\\proto\\graphics\\stabil.png";
		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		image = Utils.resize(image, width, height);
		g.drawImage(image, x, y, null);


		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString(ho.toString(), x+width-18, y+height-8);
		if(befagy) {
			g.setColor(new Color(134, 64, 206));
			g.drawRect(x+width-30, y+height-20, 5,5);
		}
		g.setColor(new Color(0, 0, 0));
	}
}
