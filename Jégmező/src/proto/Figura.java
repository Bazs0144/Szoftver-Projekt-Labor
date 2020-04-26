package proto;

public abstract class Figura {
    boolean vizben_van;
    Jegtabla jegtabla;


    public abstract boolean lep(Jegtabla jt);
    public abstract void sebzodik();
    public abstract void setHo(int ho);

    /**
     * Beállítja a jégtáblát amin áll a figura
     * @param j: erre a jégtáblára állítja be
     */
    public void setJegtabla(Jegtabla j) {
        Szkeleton.printFunction("-------> setJegtabla(Jegtabla j)", true, this);
        jegtabla=j;
        Szkeleton.printFunction("<------- setJegtabla(Jegtabla j)", false, this);
    }

    /**
     * Visszaadja a jégtáblát amin áll a figura
     */
    public Jegtabla getJegtabla() {
        Szkeleton.printFunction("-------> getJegtabla()", true, this);
        Szkeleton.printFunction("<--jegtabla-- getJegtabla()", false, this);
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
