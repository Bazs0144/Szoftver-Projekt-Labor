package proto;

import java.io.Serializable;

/**
 * Az sátor implementálásáért felelős osztály a Sator, a Tárgy leszármazottja.
 *
 */
public class Sator extends Targy implements Epitmeny, Serializable {
	
	/**
	 * A Sátor osztály adattagjai:
	 * @param all: igaz értéket tárol, ha a sátor használatban van.
	 * @param hasznalhato: a játékosok száma, ennyi játékos körével egyenlő a játékkör. Ez továbbra egyenlő a sátor használhatóságának idejével.
	 * @param hasznalatban:a sátor felállításától eltelt idő (eltelt játékos körök száma).A sátor felállításakor az értéke 0, a használódik függvény pedig minden
						alkalommal eggyel növeli az értéket, amikor a next_player függvény meghívódik (amikor egy másik játékos elkezdi a körét). Az érték a hasznalhato attribútum
						által tárolt értékig növekszik, ezután a sátor már nem tud karaktert megvédeni a hóvihartól.
	 */
	private boolean all;
	private int hasznalhato;
	private int hasznalatban;

	/**
	 * A Sator konstruktora
	 * @param kor megadja hany korig hasznalhato
	 */
	public Sator(int kor) {
		all = false;
		Name = "Sator";
		hasznalhato = kor;
		hasznalatban = 0;
	}
	
	/** A sátor véd a hóvihar ellen, ha éppen áll .*/
    @Override
    public boolean megvedHovihartol() {
    	if(all)
        return true;
    	else return false;
    }

    /** A sátor nem véd a hóvihar ellen.*/
    @Override
    public boolean megvedMedvetol() {
        return false;
    }

    @Override
	public String getName(){
    	return "Sator";
	}
    
    /** A sátor felállitasa a paraméterként kapott jégtáblára, a paraméterként kapott karakter álltal.
     * Ha a karakter vizben van vagy a sátor már nem használható, a sátor felállitása nem valósitható meg.*/
    public void hasznaljak(Karakter k, Jegtabla j) {
    	if(k.get_vizben_van() || k.get_munkakszama() <= 0) return;
    	if(hasznalatban < hasznalhato) {
    	j.epitmenyKeszul(this);
    	all = true;
    	k.targy_elhasznalasa(this);
    	k.set_munkak_szama(k.get_munkakszama()-1);
    	}
    }
    
    /** Minden kör esetén a sátor használódik.*/
    public void hasznalodik() {
		hasznalatban++;
		if (hasznalatban > hasznalhato) all = false;
	}
	
    public Poz getPoz() {
		return k.jegtabla.getPoz();
	}
}
