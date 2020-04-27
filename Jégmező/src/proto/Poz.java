package proto;

import java.io.Serializable;

public class Poz implements Serializable {
    int x,y;

    public Poz(Poz p) {
        this.x=p.x;
        this.y=p.y;
    }

    public Poz(int x, int y) {
        this.x=x;
        this.y=y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
