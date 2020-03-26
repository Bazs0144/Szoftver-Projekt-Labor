package szkeleton;
import java.util.ArrayList;


public class Karakter {

    int ho;
    int munkak_szama;
    boolean vizben_van;
    Jegtabla jegtabla;
    ArrayList<Targy> zseb;

     public Karakter() {
        Szkeleton.printTabs(true);
        System.out.println("-------> Karakter() *konstruktor*");
        zseb= new ArrayList<Targy>();
        Szkeleton.printTabs(false);
        System.out.println("<------- Karakter() *konstruktor*");
    }

    public void takarit(int intensity) {
        Szkeleton.printTabs(true);
        System.out.println("-------> takarit(int intensity)");
        jegtabla.takaritas_volt(intensity);
        Szkeleton.printTabs(false);
		System.out.println("<------- takarit(int intensity)");
    }

    public void vizbe_esik() {
        Szkeleton.printTabs(true);
        System.out.println("------->  vizbe_esik()");
        vizben_van=true;
        Szkeleton.printTabs(false);
		System.out.println("<------- vizbe_esik()");
    }

    public boolean lep(Jegtabla jt) {
        Szkeleton.printTabs(true);
        System.out.println("------->  lep(Jegmezo jm)");
        if(jegtabla.szomszed_e(jt)) {
            jegtabla.lelepnek(this);
            jt.ralepnek(this);
            Szkeleton.printTabs(false);
            System.out.println("<---true---- lep(Jegmezo jm)");
            return true;
        } else {
            Szkeleton.printTabs(false);
            System.out.println("<---false---- lep(Jegmezo jm)");
            return false; }
    }

    public boolean menekit(Karakter k) {
        Szkeleton.printTabs(true);
        System.out.println("-------> menekit(Karakter k)");
       Jegtabla j1=k.getJegtabla();
       if(j1.szomszed_e(jegtabla)){
           j1.kiment(k,jegtabla);
           //jegtabla.ralepnek(k);
           Szkeleton.printTabs(false);
           System.out.println("<------true---- menekit(Karakter k)");
           return true;
        }
       else {
           Szkeleton.printTabs(false);
           System.out.println("<------false---- menekit(Karakter k)");
           return false;
       }

    }

    public boolean targy_felvetele() {
        Szkeleton.printTabs(true);
        System.out.println("-------> targy_felvetele()");
        Targy t=jegtabla.getTargy();
        if(jegtabla.elvesz(this, t)) {
            Szkeleton.printTabs(false);
            System.out.println("<---true---- targy_felvetele()");
            munkak_szama--;
            return true;
        }
        else {
            Szkeleton.printTabs(false);
            System.out.println("<---false---- targy_felvetele()");
            return false;
        }
    }

    public void targy_hozzaadasa(Targy t) {
        Szkeleton.printTabs(true);
    	 System.out.println("-----> targy_hozzaadasa(Targy t)");
        zseb.add(t);
        Szkeleton.printTabs(false);
        System.out.println("<------- targy_hozzaadasa(Targy t)");
    }

    public void sebzodik() {
        Szkeleton.printTabs(true);
        System.out.println("------->  sebzodik()");
        ho--;
        Szkeleton.printTabs(false);
		System.out.println("<------- sebzodik()");
    }

    public void ho_nov() {
        Szkeleton.printTabs(true);
        System.out.println("------->   ho_nov()");
        ho++;
        Szkeleton.printTabs(false);
		System.out.println("<-------  ho_nov()");
    }

    public Jegtabla getJegtabla() {
        Szkeleton.printTabs(true);
    	System.out.println("-------> getJegtabla()");
        Szkeleton.printTabs(false);
    	System.out.println("<-------jegtabla ----- getJegtabla()");
        return jegtabla;
    }

    public void setJegtabla(Jegtabla j) {
        Szkeleton.printTabs(true);
    	System.out.println("-------> setJegtabla(Jegtabla j)");
    	jegtabla=j;
        Szkeleton.printTabs(false);
    	System.out.println("<------- setJegtabla(Jegtabla j)");
    }

    public boolean van_munkaja() {
        return munkak_szama != 0;
    }

    public void hasznal(Targy t, Jegtabla hol) {
        Szkeleton.printTabs(true);
        System.out.println("------->  hasznal(Targy t, Jegtabla hol)");
        t.hasznaljak(this, hol);
        Szkeleton.printTabs(false);
        System.out.println("<-------  hasznal(Targy t, Jegtabla hol)");
    }
}