package proto;

import java.io.Serializable;

public abstract class Figura implements Serializable {
    /**
     * vizben_van: vízben van-e a karakter, ha igen igaz, ha nem hamis
     * jegtabla: ezen a jégtáblán áll a figura
     * Name: a figura neve
     */
    boolean vizben_van;
    Jegtabla jegtabla;
    public String Name;

    /**
     *A figura átlép egy másik jégtáblára
     * @param jt erre a jégtáblára lép
     * @return ha siekrült igazzal tér vissza, ha nem hamissal
     */
    public abstract boolean lep(Jegtabla jt) throws Exception;

    /**
     * A figura sebződik, absztrakt függvény
     */
    public abstract void sebzodik();

    /**
     * A figurának beállítja a hőmérsékletét
     * @param ho erre az értékre állítja be
     */
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

    /**
     *Abztrakt függvény, akkro hívodik meg amikor a figura vízbe esik
     */
    public abstract void vizbe_esik() throws Exception;

    /**
     *Visszaadja, hogy a figura vízben van-e
     */
    public boolean get_vizben_van() {
        return vizben_van;
    }

    /**
     * Beállítja hogy a figura vízben van-e
     * @param van erre állítj be
     */
    public void set_vizben_van(boolean van) {
        vizben_van=van;
    }
}
