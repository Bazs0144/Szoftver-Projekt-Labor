package szkeleton;

public class Karakter {

    int ho;
    int munkak_szama;
    bool vizben_van;
    Jegtabla jegtabla;
    Targy[] zseb;


    public void takarit(Jegtabla j, int intensity) {

    }

    public void vizbe_esik () {

    }

    public void lep(Jegmezo jm) {

    }

    public bool menekit(Karakter k) {
        return true;
    }

    public bool targy_felvetele() {
        return true;
    }

    public bool tárgy_hozzadasa(Targy t) {
        return true;
    }

    public bool kias(j: Jegtabla) {

    }

    public void sebzodik() {

    }

    public void ho_nov() {

    }

    public Jegtabla getJegtabla() {
        return Jegtabla;
    }

    public void setJegtabla(Jegtabla j) {
        jegtabla=j;
    }

    public bool van_munkaja() {
        return true;
    }

    public void hasznal(Targy t, Jegtabla hol) {

    }
}
