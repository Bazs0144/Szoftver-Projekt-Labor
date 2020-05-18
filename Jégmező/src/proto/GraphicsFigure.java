package proto;

import java.awt.Graphics;

/** A grafikus figura absztrakt osztályát valósitja meg.
 * Az osztály függvényeit a leszármazott osztályok valósitják meg.*/
public abstract class GraphicsFigure implements Drawable{
	Poz poz;

	public void setPoz(Poz poz) {
		this.poz = poz;
	}

	public void Draw(Graphics g, int width, int height, int num){

	}

	public void Draw(Graphics g, int x, int y, int width, int height){
		//ezt ne töröld
	}


}
