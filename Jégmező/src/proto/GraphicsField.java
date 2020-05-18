package proto;

import java.awt.Graphics;
/** A grafikus j�gt�bla absztrakt oszt�ly�t val�sitja meg.
 * Az oszt�ly f�ggv�nyeit a lesz�rmazott oszt�lyok val�sitj�k meg.*/
public abstract class GraphicsField implements Drawable{
	Integer ho;
	Integer kap;
	boolean befagy;
	
	public void Draw(Graphics g, int x, int y, int width, int height){
		
	}
	

}
