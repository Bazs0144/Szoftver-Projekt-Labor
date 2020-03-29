package szkeleton;

/**
 * A stabil jégtábla implementálásáért felelõs osztály az Stabil, a Jegtabla leszármazottja.
 *
 */
public class Stabil extends Jegtabla {
	
	/**
	 * A Stabil osztály konstruktóra, csak a konstruktorhivás kiirásának céljából lett implementálva */
	public Stabil() {
		Szkeleton.printFunction("-------> Stabil()  *konstruktor*", true,  this);
		Szkeleton.printFunction("<------- Stabil()  *konstruktor*", false, this);
	}
	
	/**
	 * A Jegtabla osztályból öröklött ralepnek függvény felülirása:
	 * Az aktiv karakter, amely egy szomszédos jégtábláról lép a jelenlegire, felkerül a jégtáblára (ennek nyilvántartásába).
	 * A karakternek is beállitjuk az aktuális jégtábláját.
	 * Mivel a jégtábla stabil, nem szükségesek további ellenõrzések, a rajta álló karakterek biztosan nem esnek vizbe. */
	@Override
	public void ralepnek(Karakter k) {
		Szkeleton.printFunction("------->ralepnek(Karakter k)", true, this);
		karakterek.add(k);
		k.setJegtabla(this);
		Szkeleton.printFunction("<-------ralepnek(Karakter k)", false, this);
	}
}