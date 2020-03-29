package szkeleton;

/**
 * Az luk implementálásáért felelõs osztály a Luk, a Jegtabla leszármazottja.
 *
 */
public class Luk extends Jegtabla{

	/**
	 * A Luk osztály konstruktóra, csak a konstruktorhivás kiirásának céljából lett implementálva */
	public Luk() {
		Szkeleton.printFunction("-------> Luk()  *konstruktor*", true, this);
		Szkeleton.printFunction("<------- Luk()  *konstruktor*", false, this);
	}
	
	/**
	 * A Jegtabla osztályból öröklött ralepnek függvény felülirása.
	 * Az aktiv karakter, amely egy szomszédos jégtábláról lép a jelenlegire (lukra), felkerül a jégtáblára (ennek nyilvántartásába).
	 * A karakternek is beállitjuk az aktuális jégtábláját.
	 * A luk jégtábla kapacitása nulla, ezért a karakter aki rálép egybõl vizbe esik. 
	 * Ez a karakter vizbe_esik függvényével valósul majd meg.*/
	@Override
	public void ralepnek(Karakter k) {
		Szkeleton.printFunction("------->ralepnek(Karakter k)", true, this);
		karakterek.add(k);
		k.setJegtabla(this);
		k.vizbe_esik();
		Szkeleton.printFunction("<-------ralepnek(Karakter k)", false, this);
	}
}