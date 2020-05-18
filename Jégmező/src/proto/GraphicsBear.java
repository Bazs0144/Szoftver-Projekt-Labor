package proto;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * A grafikus jegesmedve megjelenitését megvalósitó osztály.
 */
public class GraphicsBear extends GraphicsFigure {

	/**
	 * A Draw függvényt valósitja meg a jegesmedve grafikus elemre.
	 * @param g - Graphics objektum, amelyre kerül a megjelenitet, jegesmedvének megfelelõ kép.
	 * @param width - a megjelenitett kép szélessége
	 * @param height - a megjelenitett kép magassága
	 * @param num - ezt a paramétert a jegesmedve kirajzolása esetén nem használjuk.
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
