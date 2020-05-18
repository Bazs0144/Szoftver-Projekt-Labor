package proto;

import java.awt.Graphics;
/** A grafikus jégtábla absztrakt osztályát valósitja meg.
 * Az osztály függvényeit a leszármazott osztályok valósitják meg.*/
public abstract class GraphicsField implements Drawable{
	Integer ho;
	Integer kap;
	boolean befagy;
	
	public void Draw(Graphics g, int x, int y, int width, int height){
		
	}
	

}
