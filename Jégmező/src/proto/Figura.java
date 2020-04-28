package proto;

import java.io.Serializable;

public abstract class Figura implements Serializable {
    boolean vizben_van;
    Jegtabla jegtabla;
    public String Name;


    public abstract boolean lep(Jegtabla jt) throws Exception;
    public abstract void sebzodik();
    public abstract void setHo(int ho);

    /**
     * Beállítja a jégtáblát amin áll a figura
     * @param j: erre a jégtáblára állítja be
     */
    public void setJegtabla(Jegtabla j) {
        jegtabla=j;
    }

    /**
     * Visszaadja a jégtáblát amin áll a figura
     */
    public Jegtabla getJegtabla() {
        return jegtabla;
    }

    public abstract void vizbe_esik();

    public boolean get_vizben_van() {
        return vizben_van;
    }

    public void set_vizben_van(boolean van) {
        vizben_van=van;
    }
}
