package proto;

import java.awt.Graphics;

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
