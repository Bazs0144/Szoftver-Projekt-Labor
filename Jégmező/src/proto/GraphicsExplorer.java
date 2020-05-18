package proto;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * A grafikus sarkkutató megjelenitését megvalósitó osztály.
 */
public class GraphicsExplorer extends GraphicsFigure {

	/**
	 * A Draw függvényt valósitja meg a sarkkutató grafikus elemre.
	 * @param g - Graphics objektum, amelyre kerül a megjelenitet, sarkkutatónak megfelelő kép.
	 * @param width - a megjelenitett kép szélessége
	 * @param height - a megjelenitett kép magassága
	 * @param num - a játékos sorszáma aki ezt a karaktert használja.
	 */
	public void Draw(Graphics g, int width, int height, int num){
		int x=poz.x;
		int y=poz.y;
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
