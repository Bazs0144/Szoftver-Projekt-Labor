package proto;
/**
 * A búvárruha implementálásáért felelõs osztály az Buvarruha, a Targy leszármazottja.
 *
 */

public class Buvarruha extends Targy {
	
	/**
	 * A Buvarruha osztály konstruktora.
	 */
	public Buvarruha() {
	
	}

	/**
	 * A paraméterként kapott karakter használja a tárgyat a paraméterként kapott jégtáblán.
	 * Ha a karakter búvárruhát használ, nem éri viz, a vizben van attribútuma hamisra lesz állitva.
	 * Az egyetlen tárgy amit vizbe esett karakter tud használni.
	 */
	
	@Override
	public void hasznaljak(Karakter karakter, Jegtabla hol) {
        karakter.set_vizben_van(false);
	}
}
