package proto;

import java.io.Serializable;

/**
 * Az osztály a jegtablak egyertelmu beazonositasara hasznalhato, akkor is, ha a jegmezo nem teglalap alaku
 */
public class Poz implements Serializable {
    /**
     * x,y koordinatak
     */
    int x,y;

    /**
     * Egyszeru konsturktor, lemasol egy masik poziciot
     * @param p ezt masolja
     */
    public Poz(Poz p) {
        this.x=p.x;
        this.y=p.y;
    }

    /**
     * Masik konstruktor, adattagok beallitasaval
     * @param x az x koordinata
     * @param y az y koodrinata
     */
    public Poz(int x, int y) {
        this.x=x;
        this.y=y;
    }

    /**
     * Ballitja az X koordinatat
     * @param x erre
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Beallitja az Y koordinatat
     * @param y erre
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return Visszaadja az X koordinatat
     */
    public int getX() {
        return x;
    }

    /**
     * @return Visszaadja az Y koordinatat
     */
    public int getY() {
        return y;
    }
}
