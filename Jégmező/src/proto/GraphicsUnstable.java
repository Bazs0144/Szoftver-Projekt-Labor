package proto;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/**
 * A grafikus instabil j�gt�bla megjelenit�s�t megval�sit� oszt�ly.
 */
public class GraphicsUnstable extends GraphicsField {
	/**
	 * A Draw f�ggv�nyt val�sitja meg a s�tor �pitm�ny grafikus elemre.
	 * @param g - Graphics objektum, amelyre ker�l a megjelenitet, s�tor �pitm�nynek megfelel� k�p.
	 * @param width - a megjelenitett k�p sz�less�ge
	 * @param height - a megjelenitett k�p magass�ga
	 */
	public void Draw(Graphics g,  int x, int y, int width, int height){
		BufferedImage image = null;
		String path = ".\\src\\proto\\graphics\\instabil.png";
		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		image = Utils.resize(image, width, height);
		g.drawImage(image, x, y, null);

		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString(ho.toString(), x+width-18, y+height-8);
		if(kap!=0) {
			g.setColor(new Color(230, 0, 0));
			g.drawString(kap.toString(), x+8, y+height-8);
		}
		if(befagy) {
			g.setColor(new Color(134, 64, 206));
			g.drawRect(x+width-30, y+height-20, 5,5);
		}
		g.setColor(new Color(0, 0, 0));
	}

}
