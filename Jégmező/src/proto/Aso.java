package proto;

import java.io.Serializable;

/**
 * Az Aso implementalasaert felelos osztaly az Aso, a Targy leszarmazottja.
 *
 */

public class Aso extends Targy implements Serializable {
	
	private int tartossag;
	/**
	 * Az Aso osztaly konstruktora.
	 */
	public Aso() {
		Name = "Aso";
		tartossag = 3;
	}
	/**
	 * A parameterkent kapott karakter hasznalja az asot, hogy 2-t takaritson a jegtablarol.
	 * Ha a karakter vizben van, nem tudja hasznalni az asot.
	 * Ha mar haromszor hasznalta, akkor az aso hasznalhatatlan, ekkor nem megy vegbe a takaritas.
	 * Ha meg hasznalhato az aso, a tartossagi erteke kisebb mint harom, az asot hasznalo karakter takaritani kezd.
	 * Minden hasznalat utan a tartossag erteke eggyel novekszik.
	 */
	@Override
	public void hasznaljak(Karakter karakter, Jegtabla hol) throws Exception{
        if(karakter.vizben_van) return;
		karakter.takarit(2);
        tartossag--;
        if(tartossag<=0) karakter.targy_elhasznalasa(this);
	}
	
	public Poz getPoz() {
		return k.jegtabla.getPoz();
	}
}
