package szkeleton;
import java.util.ArrayList;


public class Karakter {

    int ho;
    int munkak_szama;
    boolean vizben_van;
    Jegtabla jegtabla;
    ArrayList<Targy> zseb;

     public Karakter() {
        System.out.println("-------> Karakter() *konstruktor*");
        zseb= new ArrayList<Targy>();
        System.out.println("<------- Karakter() *konstruktor*");
    }

    public void takarit(int intensity) {
        System.out.println("-------> takarit(int intensity)");
        jegtabla.takaritas_volt(intensity);
		System.out.println("<------- takarit(int intensity)");
    }

    public void vizbe_esik() {
        System.out.println("------->  vizbe_esik()");
        vizben_van=true;
		System.out.println("<------- vizbe_esik()");
    }

    public boolean lep(Jegtabla jt) {
        System.out.println("------->  lep(Jegmezo jm)");
        if(jegtabla.szomszed_e(jt)) {
            jegtabla.lelepnek(this);
            jt.ralepnek(this);
            System.out.println("<---true---- lep(Jegmezo jm)");
            return true;
        } else {
            System.out.println("<---false---- lep(Jegmezo jm)");
            return false; }
    }

    public boolean menekit(Karakter k) {
        System.out.println("-------> menekit(Karakter k)");
       Jegtabla j1=k.getJegtabla();
       if(j1.szomszed_e(jegtabla)){
           j1.kiment(k,jegtabla);
           jegtabla.ralepnek(k);
           System.out.println("<------true---- menekit(Karakter k)");
           return true;
        }
       else {
           System.out.println("<------false---- menekit(Karakter k)");
           return false;
       }

    }

    public boolean targy_felvetele() {
        Targy t=jegtabla.getTargy();
        if(jegtabla.elvesz(this, t)) {
            System.out.println("<---true---- targy_felvetele()");
            munkak_szama--;
            return true;
        }
        else {
            System.out.println("<---false---- targy_felvetele()");
            return false;
        }
    }

    public void targy_hozzaadasa(Targy t) {
    	 System.out.println("-----> targy_hozzaadasa(Targy t)");
        zseb.add(t);
        System.out.println("<------- targy_hozzaadasa(Targy t)");
    }

    public void sebzodik() {
        System.out.println("------->  sebzodik()");
        ho--;
		System.out.println("<------- sebzodik()");
    }

    public void ho_nov() {
        System.out.println("------->   ho_nov()");
        ho++;
		System.out.println("<-------  ho_nov()");
    }

    public Jegtabla getJegtabla() {
    	System.out.println("-------> getJegtabla()");
    	System.out.println("<-------jegtabla ----- getJegtabla()");
        return jegtabla;
    }

    public void setJegtabla(Jegtabla j) {
    	System.out.println("-------> setJegtabla(Jegtabla j)");
    	jegtabla=j;
    	System.out.println("<------- setJegtabla(Jegtabla j)");
    }

    public boolean van_munkaja() {
        return munkak_szama != 0;
    }

    public void hasznal(Targy t, Jegtabla hol) {
        System.out.println("------->  hasznal(Targy t, Jegtabla hol)");
        t.hasznaljak(this, hol);
        System.out.println("<-------  hasznal(Targy t, Jegtabla hol)");
    }
}