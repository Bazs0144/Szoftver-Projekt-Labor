package proto;

import java.io.Serializable;

/**
 * Az ásó implementálásáért felelõs osztály az Aso, a Targy leszármazottja.
 *
 */

public class Aso extends Targy implements Serializable {
	
	private int tartossag;
	/**
	 * Az Aso osztály konstruktora.
	 */
	public Aso() {
		Name = "Aso";
	}
	/**
	 * A paraméterként kapott karakter használja az ásót, hogy 2-t takarítson a jégtábláról.
	 * Ha a karakter vizben van, nem tudja használni az ásót.
	 * Ha már háromszor használta, akkor az ásó használhatatlan, ekkor nem megy végbe a takaritás.
	 * Ha még használható az ásó, a tartossági értéke kisebb mint három, az ásót használó karakter takaritani kezd.
	 * Minden használat után a tartósság értéke egyel növekszik.
	 */
	@Override
	public void hasznaljak(Karakter karakter, Jegtabla hol) {
        if(karakter.vizben_van) return;
        if(tartossag >= 3) return;
		karakter.takarit(2);
		tartossag++;
	}
}
