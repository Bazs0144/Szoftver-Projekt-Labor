package proto;

/**
 * Az lapát implementálásáért felelõs osztály a Lapat, a Targy leszármazottja.
 *
 */
public class Lapat extends Targy {
	
	/**
	 * A Lapat osztály konstruktora..
	 */
	public Lapat() {
		
	}
	/**
	 * A paraméterként kapott karakter használja a lapátot, hogy 2-t takaritson a jégtáblán.
	 * A karakter csak akkor használhatja a lapátot, ha nincs vizbe esve.
	 */
	@Override
	public void hasznaljak(Karakter karakter, Jegtabla hol) {
        if(karakter.vizben_van) return;
		karakter.takarit(2);
	}
}
