package proto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Az kotel implementalasaert felelos osztaly a Kotel, a Targy leszarmazottja.
 *
 */
public class Kotel extends Targy implements Serializable {

	/**
	 * A Kotel osztaly konstruktora.
	 */
	public Kotel() {
		Name = "Kotel";
	}
	
	
	/**
	 * A parameterkent kapott karakter hasznalja a targyat a parameterkent kapott jegtablan, kimentve az osszes karaktert a jegtabla szomszedsagaban.
	 * Csak akkor hasznalhato a kotel, ha a menekito karakter nincs vizben.
	 */
	@Override
	public void hasznaljak(Karakter karakter, Jegtabla hol) {
		 if(karakter.vizben_van) return;
		try {
			for(Jegtabla sz : hol.getSzomszedok()) {
				ArrayList<Figura> fig=sz.getFigurak();
				for (Figura f : fig) {
					if (f.vizben_van)
						karakter.menekit((Karakter) f);
				}
			}
		} catch(Exception e) {
		}
	}
	
	public Poz getPoz() {
		return k.jegtabla.getPoz();
	}
}
