package proto;

import java.io.Serializable;

/**
 * A stabil jégtábla implementálásáért felelõs osztály az Stabil, a Jegtabla leszármazottja.
 *
 */
public class Stabil extends Jegtabla implements Serializable {
	/**
	 * A Jegtabla osztály konstruktóra, amelyben beállitásra kerül ennek poziciója a jégmezőn.
	 */
	public Stabil(Poz p) {
		super(p);
		type = "Stabil";
		setKapacitas(100);
	}

	
	/**
	 * A Jegtabla osztályból öröklött ralepnek függvény felülirása:
	 * Az aktiv figura, amely egy szomszédos jégtábláról lép a jelenlegire, felkerül a jégtáblára (ennek nyilvántartásába).
	 * A figurának is beállitjuk az aktuális jégtábláját.
	 * Mivel a jégtábla stabil, nem szükségesek további ellenõrzések, a rajta álló figurák biztosan nem esnek vizbe. */
	@Override
	public void ralepnek(Figura f) {
		figurak.add(f);
		f.setJegtabla(this);
	}
}