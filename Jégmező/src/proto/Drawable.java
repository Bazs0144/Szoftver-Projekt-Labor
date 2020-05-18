package proto;

import java.awt.Graphics;
/** Az �sszes kirajzolhat� elem k�z�s interf�sze.
 * A grafikus t�rgyak, figur�k, �pitm�nyek �s j�gt�bl�k megval�sitj�k a Draw f�ggv�nyt.*/
public interface Drawable {

	public void Draw(Graphics g,  int x, int y, int width, int height);


}
