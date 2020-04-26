package proto;

/**
 * Az luk implementálásáért felelős osztály a Luk, a Jegtabla leszármazottja.
 *
 */
public class Luk extends Jegtabla{

	/**
	 * A Luk osztály konstruktora, amelyben beállitásra kerül ennek poziciója a jégmezőn*/
	public Luk(Poz p) {
		super(p);
	}
	
	/**
	 * A Jegtabla osztályból öröklött ralepnek függvény felülirása.
	 * Az aktiv figura, amely egy szomszédos jégtábláról lép a jelenlegire, felkerül a jégtáblára (ennek nyilvántartásába).
	 * A figura is beállitjuk az aktuális jégtábláját.
	 * A luk jégtábla kapacitása nulla, ezért a figura aki rálép egyből vizbe esik. 
	 * Ez a figura vizbe_esik függvényével valósul majd meg.*/
	@Override
	public void ralepnek(Figura f) {
		figurak.add(f);
		f.setJegtabla(this);
		f.vizbe_esik();
	}
}