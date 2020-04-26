package proto;

/**
 * Az instabil jégtábla implementálásáért felelõs osztály az Instabil, a Jegtabla leszármazottja.
 *
 */
public class Instabil extends Jegtabla{
	/**
	 *@param figurak_szama: tárolja az aktuálisan a jégtáblán álló figurák számát.
	 *@param kapacitas: az instabil jégtábla max. ennyi figurát bir el.
	 */
	private int figurak_szama;
	private int kapacitas;

	/**
	 * Az Instabil osztály konstruktóra, amelyben beállitásra kerül ennek poziciója a jégmezőn.
	 * */
	public Instabil(Poz p) {
		super(p);
	}

	/**
	 * A Jegtabla osztályból öröklött ralepnek függvény felülirása:
	 * Az aktiv figura, amely egy szomszédos jégtábláról lép a jelenlegire, felkerül a jégtáblára (ennek nyilvántartásába).
	 * A figura is beállitjuk az aktuális jégtábláját.
	 * Ezután megviszgálja ha az instabil jégtáblán álló karakterek száma meghaladja-e a kapacitását. 
	 * Ha igen, az insatbil jégtábla meghivja a felfordul függvényét.*/
	@Override
	public void ralepnek(Figura f) {
		f.setJegtabla(this);
		figurak.add(f);
		if(figurak.size() > kapacitas) felfordul();
	}
	

	/**
	 * Amikor az instabil jégtábla felfordul, a rajta álló figurák összessége a vizbe esik. A figura vizbe_esik függvénye hivódik meg.
	 * Ha volt épitmény a jégtáblán, ez törlődik */
	public void felfordul() {
		for(int i = 0; i < figurak.size(); ++i) {
			figurak.get(i).vizbe_esik();
		}
		epitmenyTorles();
	}
}

