package proto;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * A grafikus étel megjelenitését megvalósitó osztály.
 */
public class GraphicsFood extends GraphicsTool {

	/**
	 * A Draw függvényt valósitja meg az étel grafikus elemre.
	 * @param g - Graphics objektum, amelyre kerül a megjelenitet, ételnek megfelelõ kép.
	 * @param width - a megjelenitett kép szélessége
	 * @param height - a megjelenitett kép magassága
	 */
	public void Draw(Graphics g, int width, int height){
		int x=poz.x;
		int y=poz.y;
		BufferedImage image = null;
		String path = ".\\src\\proto\\graphics\\etel.png";
		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		image = Utils.resize(image, width, height);
		g.drawImage(image, x, y, null);
	}


}
