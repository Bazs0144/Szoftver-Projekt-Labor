package proto;

import java.awt.Graphics;
/** Az összes kirajzolható elem közös interfésze.
 * A grafikus tárgyak, figurák, épitmények és jégtáblák megvalósitják a Draw függvényt.*/
public interface Drawable {

	public void Draw(Graphics g,  int x, int y, int width, int height);


}
