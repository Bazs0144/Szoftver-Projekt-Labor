package szkeleton;

public class Karakter {

    int ho;
    int munkak_szama;
    bool vizben_van;
    Jegtabla jegtabla;
    Targy[] zseb;


    public void takarit(Jegtabla j, int intensity) {
        System.out.println("------->  takarit(Jegtabla j, int intensity)");
		System.out.println("<------- takarit(Jegtabla j, int intensity)");
    }

    public void vizbe_esik() {
        System.out.println("------->  vizbe_esik()");
		System.out.println("<------- vizbe_esik()");
    }

    public void lep(Jegmezo jm) {
        System.out.println("------->  lep(Jegmezo jm)");
		System.out.println("<------- lep(Jegmezo jm)");
    }

    public boolean menekit(Karakter k) {
        return true;
    }

    public boolean targy_felvetele() {
        return true;
    }

    public boolean tárgy_hozzadasa(Targy t) {
        return true;
    }

    public boolean kias(j: Jegtabla) {

    }

    public void sebzodik() {
        System.out.println("------->  sebzodik()");
		System.out.println("<------- sebzodik()");
    }

    public void ho_nov() {
        System.out.println("------->   ho_nov()");
		System.out.println("<-------  ho_nov()");
    }

    public Jegtabla getJegtabla() {
        return Jegtabla;
    }

    public void setJegtabla(Jegtabla j) {
        jegtabla=j;
    }

    public boolean van_munkaja() {
        if (munkak_szama!=0) return true;
        return false;
    }

    public void hasznal(Targy t, Jegtabla hol) {

    }
}
