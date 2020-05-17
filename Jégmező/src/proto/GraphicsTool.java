package proto;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class GraphicsTool implements Drawable{
	
	public void Draw(Graphics g,  int x, int y, int width, int height) { }
}
