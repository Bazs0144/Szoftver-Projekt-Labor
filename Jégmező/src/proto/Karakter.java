package proto;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * A Karaketer az Eszkimó és Sarkkutató ősosztálya, egyenlőre nem absztrakt, hogy általános teszteléseket el tudjunk rajta végezni
 */
public class Karakter extends Figura implements Serializable {
    /**
     * A Karakter osztály adattagjai:
     * - int ho : A Karakter hőmérséklete
     * - int vizbeKerultKor : a kör amikor a karakter beleesett a vizbe
     * - ArrayList<Targy> zseb : azoknak a tárgyaknak a listája amik a karakternél vannak
     */
    int ho;
    int vizbeKerultKor;
    int munkak_szama=4;
    ArrayList<Targy> zseb;

    /**
     * A Karakter konstruktora, létrehozza a zseb listát és kiírja a meghívását
     */
     public Karakter() {
        zseb= new ArrayList<Targy>();
        Name = "Karakter";
    }

    /**
     * @return visszadja a karakternél levo targyakat
     */
    public ArrayList<Targy> getTargyak() {
        return zseb;
    }

    /**
     * @return Visszadja hany munkaja van a karakternek
     */
    public int get_munkakszama() {
        return munkak_szama;
    }

    /**
     * Beallitja hany munkaja van a karakternek
     * @param msz erre allitja be
     */
    public void set_munkak_szama(int msz) {
    	munkak_szama = msz;
    }
    /**
     * A Karakter takarít azon a jégtáblán amin áll, meghívja a jégtáblán a takaritas_volt függvényt
     * @param intensity : ez adja meg hogy mennyi hómennyiséget távolít el a jégtábláról
     */
    public void takarit(int intensity) throws Exception{
        if(munkak_szama > 0) {
            munkak_szama--;
            jegtabla.takaritas_volt(intensity);
        }
    }

    /**
     * Ha a karakter vízbeesik, átváltja a saját vizben_van adattagját igazra
     */
    @Override
    public void vizbe_esik() throws Exception {
        vizben_van=true;
        munkak_szama=zseb.size();
        for(Targy t: zseb) hasznal(t, jegtabla);
        munkak_szama=0;
    }

    /**
     * A Karakter át akar lépni egy másik jégtáblára, előbb megkérdezi, a jégtáblától amin áll, hogy szomszédja-e a jégtábla amire lépni akar, ha igen átlép, ha nem akkor nem
     * @param jt : erre a jégtáblára akar átlépni
     * @return ha át tudott lépni igazzal tér vissza, ha nem akkor hamissal
     */
    @Override
    public boolean lep(Jegtabla jt) throws Exception{
        if(munkak_szama > 0)
        if(jegtabla.szomszed_e(jt)) {
        	munkak_szama--;
        	System.out.println(munkak_szama);
            jegtabla.lelepnek(this);
            jt.ralepnek(this);
            return true;
        } else {
            return false; }
        return false;
    }

    /**
     * A karakter kimenekít kötél segítségével egy másik karaktert a vízből ,de csak akkor tudja ha a jégtábla ahonnan kimenekíti szomszédos vele
     * @param k : a Karakter akit ki kell menekíteni
     * @return igazzal tér vissza ha sikerült kimenekíteni, hamissal ha nem
     */
    public boolean menekit(Karakter k) throws Exception{
       Jegtabla j1=k.getJegtabla();
        if(munkak_szama <= 0) throw new Exception();
       if(j1.szomszed_e(jegtabla)){
           j1.kiment(k,jegtabla);
           munkak_szama--;
           k.set_vizben_van(false);
           return true;
        }
       else {
           return false;
       }
    }

    /**
     * A Karakter megpróbálja felvenni a tárgyat ami azon a jégtáblán áll amin áll, ehhez meghívja a jégtábla elvesz föggvényét
     * @return ha sikeült elvenni igazzal tér vissza, ha nem akkor hamissal
     */
    public boolean targy_felvetele(){
        Targy t=jegtabla.getTargy();
        if(munkak_szama >0) {
            if(jegtabla.elvesz(this, t)) {
                munkak_szama--;
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }

    /**
     * Hozzáadja a zsebében lévő tárgyakhoz a paraméterül kapott tárgyat
     * @param t : ezt a tárgyat adja hozzá
     */
    public void targy_hozzaadasa(Targy t) {
        zseb.add(t);
        t.setKarakter(this);
    }

    /**
     * Ha olyan tárgyat használt a karakter ami elhasználható (pl. Étel) akkor használat után kiveszi a tárgyai közül
     * @param t: ezt a tárgyat veszi ki
     */
    public void targy_elhasznalasa(Targy t) {
        zseb.remove(t);
    }

    /**
     * A karakternek csökken eggyel a hőmérséklete
     */
    @Override
    public void sebzodik() {
        ho--;
    }

    /**
     * A karakternek nő eggyel a hőmérséklete
     */
    public void ho_nov() {
        ho++;
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
    public void hasznal(Targy t, Jegtabla hol) throws Exception{
        if(munkak_szama>0)
        t.hasznaljak(this, hol);
    }

    /**
     * Megprobóál kiásni egy tárgyat a jégből, ha sikerül visszatér igazzal ,ha nem hamissal
     */
    public boolean kias() {
        if(jegtabla.getHoMennyiseg() == 0) {
            jegtabla.setBefagyva(false);
            return true;
        }
        return false;
    }

    /**
     * Visszadja a karakter hőmennyiségét
     * @return a karakter hője
     */
    public int getHo() {
        return ho;
    }

    /**
     * beállítja a karakter hőmennyiségét
     * @param ho erre állítja be
     */
    public void setHo(int ho) {
        this.ho=ho;
    }
    
    public Poz getPoz() {
		return jegtabla.getPoz();
	}

}
