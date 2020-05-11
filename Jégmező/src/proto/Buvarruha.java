package proto;

import java.io.Serializable;

/**
 * A buvarruha implementalasaert felelos osztaly az Buvarruha, a Targy leszarmazottja.
 *
 */

public class Buvarruha extends Targy implements Serializable {
	
	/**
	 * A Buvarruha osztaly konstruktora.
	 */
	public Buvarruha() {
		Name = "Buvarruha";
	}

	/**
	 * A parameterkent kapott karakter hasznalja a targyat a parameterkent kapott jegtablan.
	 * Ha a karakter buvarruhat hasznal, nem eri viz, a vizben van attributuma hamisra lesz allitva.
	 * Az egyetlen targy amit vizbe esett karakter tud hasznalni.
	 */
	
	@Override
	public void hasznaljak(Karakter karakter, Jegtabla hol) {
        karakter.set_vizben_van(false);
	}
	
	public Poz getPoz() {
		return k.jegtabla.getPoz();
	}
	
}
