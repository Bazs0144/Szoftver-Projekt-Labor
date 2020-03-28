package szkeleton;
import java.util.ArrayList;


public class Karakter {

    int ho;
    int munkak_szama;
    boolean vizben_van;
    Jegtabla jegtabla;
    ArrayList<Targy> zseb;

     public Karakter() {
         Szkeleton.printFunction("-------> Karakter() *konstruktor*", true, this);
        zseb= new ArrayList<Targy>();
         Szkeleton.printFunction("<------- Karakter() *konstruktor*", false, this);
    }

    public void takarit(int intensity) {
        Szkeleton.printFunction("-------> takarit(int intensity)", true, this);
        jegtabla.takaritas_volt(intensity);
        Szkeleton.printFunction("<------- takarit(int intensity)", false, this);
    }

    public void vizbe_esik() {
        Szkeleton.printFunction("------->  vizbe_esik()", true, this);
        vizben_van=true;
        Szkeleton.printFunction("<------- vizbe_esik()", false, this);
    }

    public boolean lep(Jegtabla jt) {
        Szkeleton.printFunction("------->  lep(Jegmezo jm)", true, this);
        if(jegtabla.szomszed_e(jt)) {
            jegtabla.lelepnek(this);
            jt.ralepnek(this);
            Szkeleton.printFunction("<---true---- lep(Jegmezo jm)", false, this);
            return true;
        } else {
            Szkeleton.printFunction("<---false---- lep(Jegmezo jm)", false, this);
            return false; }
    }

    public boolean menekit(Karakter k) {
        Szkeleton.printFunction("-------> menekit(Karakter k)", true, this);
       Jegtabla j1=k.getJegtabla();
       if(j1.szomszed_e(jegtabla)){
           j1.kiment(k,jegtabla);
           //jegtabla.ralepnek(k);
           Szkeleton.printFunction("<------true---- menekit(Karakter k)", false, this);
           return true;
        }
       else {
           Szkeleton.printFunction("<------false---- menekit(Karakter k)", false, this);
           return false;
       }

    }

    public boolean targy_felvetele() {
        Szkeleton.printFunction("-------> targy_felvetele()", true, this);
        Targy t=jegtabla.getTargy();
        if(jegtabla.elvesz(this, t)) {
            Szkeleton.printFunction("<---true---- targy_felvetele()", false, this);
            munkak_szama--;
            return true;
        }
        else {
            Szkeleton.printFunction("<---false---- targy_felvetele()", false, this);
            return false;
        }
    }

    public void targy_hozzaadasa(Targy t) {
        Szkeleton.printFunction("-----> targy_hozzaadasa(Targy t)", true, this);
        zseb.add(t);
        Szkeleton.printFunction("<------- targy_hozzaadasa(Targy t)", true, this);
    }

    public void targy_elhasznalasa(Targy t) {
        Szkeleton.printFunction("  ------> targy_elhasznalasa(Targy t)", true, this);
        zseb.remove(t);
        Szkeleton.printFunction(" <------ targy_elhasznalasa(Targy t)", true, this);
    }

    public void sebzodik() {
        Szkeleton.printFunction("------->  sebzodik()", true, this);
        ho--;
        Szkeleton.printFunction("<------- sebzodik()", false, this);
    }

    public void ho_nov() {
        Szkeleton.printFunction("------->   ho_nov()", true, this);
        ho++;
        Szkeleton.printFunction("<-------  ho_nov()", false, this);
    }

    public Jegtabla getJegtabla() {
        Szkeleton.printFunction("-------> getJegtabla()", true, this);
        Szkeleton.printFunction("<--jegtabla-- getJegtabla()", false, this);
        return jegtabla;
    }

    public void setJegtabla(Jegtabla j) {
        Szkeleton.printFunction("-------> setJegtabla(Jegtabla j)", true, this);
    	jegtabla=j;
        Szkeleton.printFunction("<------- setJegtabla(Jegtabla j)", false, this);
    }

    public boolean van_munkaja() {
        return munkak_szama != 0;
    }

    public void hasznal(Targy t, Jegtabla hol) {
        Szkeleton.printFunction("------->  hasznal(Targy t, Jegtabla hol)", true, this);
        t.hasznaljak(this, hol);
        Szkeleton.printFunction("<-------  hasznal(Targy t, Jegtabla hol)", false, this);
    }
}