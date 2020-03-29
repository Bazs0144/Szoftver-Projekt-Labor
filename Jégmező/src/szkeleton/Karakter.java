package szkeleton;
import java.util.ArrayList;

/**
 * A Karaketer az Eszkimó és Sarkkutató ősosztálya, egyenlőre nem absztrakt, hogy általános teszteléseket el tudjunk rajta végezni
 */
public class Karakter {
    /**
     * A Karakter osztály adattagjai:
     * - int ho : A Karakter hőmérséklete
     * - int munkak_szama : hány munkája van még vissza a körben
     * - boolean vizben_van : ha igaz vízben van, ha nem akkor nem
     * - Jegtabla jegtabla : ezen a Jégtáblán áll a Karakter
     * - ArrayList<Targy> zseb : azoknak a tárgyaknak a listája amik a karakternél vannak
     */
    int ho;
    int munkak_szama;
    boolean vizben_van;
    Jegtabla jegtabla;
    ArrayList<Targy> zseb;

    /**
     * A Karakter konstruktora, létrehozza a zseb listát és kiírja a meghívását
     */
     public Karakter() {
         Szkeleton.printFunction("-------> Karakter() *konstruktor*", true, this);
        zseb= new ArrayList<Targy>();
         Szkeleton.printFunction("<------- Karakter() *konstruktor*", false, this);
    }

    /**
     * A Karakter takarít azon a jégtáblán amin áll, meghívja a jégtáblán a takaritas_volt függvényt
     * @param intensity : ez adja meg hogy mennyi hómennyiséget távolít el a jégtábláról
     */
    public void takarit(int intensity) {
        Szkeleton.printFunction("-------> takarit(int intensity)", true, this);
        jegtabla.takaritas_volt(intensity);
        Szkeleton.printFunction("<------- takarit(int intensity)", false, this);
    }

    /**
     * Ha a karakter vízbeesik, átváltja a saját vizben_van adattagját igazra
     */
    public void vizbe_esik() {
        Szkeleton.printFunction("------->  vizbe_esik()", true, this);
        vizben_van=true;
        Szkeleton.printFunction("<------- vizbe_esik()", false, this);
    }

    /**
     * A Karakter át akar lépni egy másik jégtáblára, előbb megkérdezi, a jégtáblától amin áll, hogy szomszédja-e a jégtábla amire lépni akar, ha igen átlép, ha nem akkor nem
     * @param jt : erre a jégtáblára akar átlépni
     * @return ha át tudott lépni igazzal tér vissza, ha nem akkor hamissal
     */
    public boolean lep(Jegtabla jt) {
        Szkeleton.printFunction("------->  lep(Jegmezo jm)", true, this);
        if(jegtabla.szomszed_e(jt)) {
            jegtabla.lelepnek(this);
            jt.ralepnek(this);
            munkak_szama--;
            Szkeleton.printFunction("<---true---- lep(Jegmezo jm)", false, this);
            return true;
        } else {
            Szkeleton.printFunction("<---false---- lep(Jegmezo jm)", false, this);
            return false; }
    }

    /**
     * A karakter kimenekít kötél segítségével egy másik karaktert a vízből ,de csak akkor tudja ha a jégtábla ahonnan kimenekíti szomszédos vele
     * @param k : a Karakter akit ki kell menekíteni
     * @return igazzal tér vissza ha sikerült kimenekíteni, hamissal ha nem
     */
    public boolean menekit(Karakter k) {
        Szkeleton.printFunction("-------> menekit(Karakter k)", true, this);
       Jegtabla j1=k.getJegtabla();
       if(j1.szomszed_e(jegtabla)){
           j1.kiment(k,jegtabla);
           munkak_szama--;
           //jegtabla.ralepnek(k);
           Szkeleton.printFunction("<------true---- menekit(Karakter k)", false, this);
           return true;
        }
       else {
           Szkeleton.printFunction("<------false---- menekit(Karakter k)", false, this);
           return false;
       }

    }

    /**
     * A Karakter megpróbálja felvenni a tárgyat ami azon a jégtáblán áll amin áll, ehhez meghívja a jégtábla elvesz föggvényét
     * @return ha sikeült elvenni igazzal tér vissza, ha nem akkor hamissal
     */
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

    /**
     * Hozzáadja a zsebében lévő tárgyakhoz a paraméterül kapott tárgyat
     * @param t : ezt a tárgyat adja hozzá
     */
    public void targy_hozzaadasa(Targy t) {
        Szkeleton.printFunction("-----> targy_hozzaadasa(Targy t)", true, this);
        zseb.add(t);
        t.setKarakter(this);
        Szkeleton.printFunction("<------- targy_hozzaadasa(Targy t)", true, this);
    }

    /**
     * Ha olyan tárgyat használt a karakter ami elhasználható (pl. Étel) akkor használat után kiveszi a tárgyai közül
     * @param t: ezt a tárgyat veszi ki
     */
    public void targy_elhasznalasa(Targy t) {
        Szkeleton.printFunction("  ------> targy_elhasznalasa(Targy t)", true, this);
        zseb.remove(t);
        Szkeleton.printFunction(" <------ targy_elhasznalasa(Targy t)", true, this);
    }

    /**
     * A karakternek csökken eggyel a hőmérséklete
     */
    public void sebzodik() {
        Szkeleton.printFunction("------->  sebzodik()", true, this);
        ho--;
        Szkeleton.printFunction("<------- sebzodik()", false, this);
    }

    /**
     * A karakternek nő eggyel a hőmérséklete
     */
    public void ho_nov() {
        Szkeleton.printFunction("------->   ho_nov()", true, this);
        ho++;
        Szkeleton.printFunction("<-------  ho_nov()", false, this);
    }

    /**
     * Visszaadja a jégtáblát amin áll a karakter
     */
    public Jegtabla getJegtabla() {
        Szkeleton.printFunction("-------> getJegtabla()", true, this);
        Szkeleton.printFunction("<--jegtabla-- getJegtabla()", false, this);
        return jegtabla;
    }

    /**
     * Beállítja a jégtáblát amin áll a karakter
     * @param j: erre a jégtáblára állítja be
     */
    public void setJegtabla(Jegtabla j) {
        Szkeleton.printFunction("-------> setJegtabla(Jegtabla j)", true, this);
    	jegtabla=j;
        Szkeleton.printFunction("<------- setJegtabla(Jegtabla j)", false, this);
    }

    /**
     *Visszaadja, hogy van-e munkája a karakternek, ha van akkor igazzal tér vissza, ha nincs akkor hamissal.
     */
    public boolean van_munkaja() {
        return munkak_szama != 0;
    }

    /**
     * A karakter meghívja egy tárgya a használják függvényét
     * @param t: ezt a tárgyat használja
     * @param hol: ezen a jégtáblán használja
     */
    public void hasznal(Targy t, Jegtabla hol) {
        Szkeleton.printFunction("------->  hasznal(Targy t, Jegtabla hol)", true, this);
        t.hasznaljak(this, hol);
        Szkeleton.printFunction("<-------  hasznal(Targy t, Jegtabla hol)", false, this);
    }
}