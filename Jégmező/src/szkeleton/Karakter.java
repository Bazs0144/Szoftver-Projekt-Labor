package szkeleton;
import java.util.List;

public class Karakter {

    int ho;
    int munkak_szama;
    boolean vizben_van;
    Jegtabla jegtabla;
    List<Targy> zseb;


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
        System.out.println("-------> menekit(Karakter k)");
       Jegtabla j1=k.getJegtabla();
       if(j1.szomszed_e(jegtabla)) j1.kiment(k,jegtabla);
        System.out.println("<------false---- menekit(Karakter k)");
       else return false;
       jegtabla.ralepnek(k);
        System.out.println("<------true---- menekit(Karakter k)");
        return true;
    }

    public bool targy_felvetele() {
        Targy t=jegtabla.getTargy();
        jegtabla.elvesz(this, t);
    }

    public boolean tárgy_hozzadasa(Targy t) {

    }

    public boolean kias(Jegtabla j) {

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
        return jegtabla;
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
