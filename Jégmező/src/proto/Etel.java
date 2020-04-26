package proto;

/**
 * Az étel implementálásáért felelõs osztály az Etel, a Targy leszármazottja.
 *
 */ 
public class Etel extends Targy {

	/**
	 * Az Etel osztály konstruktora.
	 */
	public Etel() {
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
	}
}
