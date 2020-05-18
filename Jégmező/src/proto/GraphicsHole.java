package proto;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/**
 * A grafikus luk megjelenitését megvalósitó osztály.
 */
public class GraphicsHole extends GraphicsField {

	/**
	 * A Draw függvényt valósitja meg a luk grafikus elemre.
	 * @param g - Graphics objektum, amelyre kerül a megjelenitet, luknak megfelelõ kép.
	 * @param width - a megjelenitett kép szélessége
	 * @param height - a megjelenitett kép magassága
	 * @param x - a jégtábla szélességi koordinátája
	 * @param y - a jégtábla magassági koordinátája
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
