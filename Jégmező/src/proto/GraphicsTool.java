package proto;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/** A grafikus tárgyak absztrakt osztályát valósitja meg.
 * Az osztály függvényeit a leszármazott osztályok valósitják meg.*/
public abstract class GraphicsTool implements Drawable{
	Poz poz;
	public void Draw(Graphics g, int width, int height) { }

	public void Draw(Graphics g, int x, int y, int width, int height){
		//ezt ne töröld
	}
}
