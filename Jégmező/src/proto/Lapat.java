package proto;

import java.io.Serializable;

/**
 * Az lapat implementalasaert felelos osztaly a Lapat, a Targy leszarmazottja.
 *
 */
public class Lapat extends Targy implements Serializable {
	
	/**
	 * A Lapat osztaly konstruktora..
	 */
	public Lapat() {
		Name = "Lapat";
	}
	/**
	 * A parameterkent kapott karakter hasznalja a lapatot, hogy 2-t takaritson a jegtablan.
	 * A karakter csak akkor hasznalhatja a lapatot, ha nincs vizbe esve.
	 */
	@Override
	public void hasznaljak(Karakter karakter, Jegtabla hol) throws Exception{
        if(karakter.vizben_van) return;
		karakter.takarit(2);
	}
}
