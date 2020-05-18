package proto;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/** A grafikus t�rgyak absztrakt oszt�ly�t val�sitja meg.
 * Az oszt�ly f�ggv�nyeit a lesz�rmazott oszt�lyok val�sitj�k meg.*/
public abstract class GraphicsTool implements Drawable{
	Poz poz;
	public void Draw(Graphics g, int width, int height) { }

	public void Draw(Graphics g, int x, int y, int width, int height){
		//ezt ne t�r�ld
	}
}
