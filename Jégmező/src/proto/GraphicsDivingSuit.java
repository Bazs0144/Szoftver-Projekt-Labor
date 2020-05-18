package proto;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * A grafikus búvárruha megjelenitését megvalósitó osztály.
 */
public class GraphicsDivingSuit extends GraphicsTool {

	/**
	 * A Draw függvényt valósitja meg a búvárruha grafikus elemre.
	 * @param g - Graphics objektum, amelyre kerül a megjelenitet, búvárruhának megfelelõ kép.
	 * @param width - a megjelenitett kép szélessége
	 * @param height - a megjelenitett kép magassága
	 */
	public void Draw(Graphics g, int width, int height){
		int x=poz.x;
		int y=poz.y;
		BufferedImage image = null;
		String path = ".\\src\\proto\\graphics\\buvarruha.png";
		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		image = Utils.resize(image, width, height);
		g.drawImage(image, x, y, null);
	}

}
