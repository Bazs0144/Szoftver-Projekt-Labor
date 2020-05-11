package proto;

import java.io.Serializable;

/**
 * Az étel implementálásáért felelõs osztály az Etel, a Targy leszármazottja.
 *
 */ 
public class Etel extends Targy implements Serializable {

	/**
	 * Az Etel osztály konstruktora.
	 */
	public Etel() {
		Name = "Etel";
	}
	/**
	 * A paraméterként kapott karakter használja az ételt, hogy megnövelje a hőmennyiségét.
	 * Ha a karakter vizben van, nem tudja használni az ételt.
	 * Az étel használatával megnő a karakter hőmennyisége.
	 * A használat után az ételt nem lehet újrahasználni, elhasználódik.
	 */
	@Override
	public void hasznaljak(Karakter karakter, Jegtabla hol) {
		if(karakter.vizben_van) return;
		karakter.ho_nov();
        karakter.targy_elhasznalasa(this);
        karakter.set_munkak_szama(karakter.get_munkakszama()-1);
	}
	
	public Poz getPoz() {
		return k.jegtabla.getPoz();
	}
}
