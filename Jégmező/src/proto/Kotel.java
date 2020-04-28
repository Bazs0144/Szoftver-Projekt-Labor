package proto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Az kötél implementálásáért felelõs osztály a Kotel, a Targy leszármazottja.
 *
 */
public class Kotel extends Targy implements Serializable {

	/**
	 * A Kotel osztály konstruktora.
	 */
	public Kotel() {
		Name = "Kotel";
	}
	
	
	/**
	 * A paraméterként kapott karakter használja a tárgyat a paraméterként kapott jégtáblán, kimentve az összes karaktert a jégtábla szomszédságában.
	 * Csak akkor használható a kötél, ha a menekitó karakter nincs vizben.
	 */

	@Override
	public void hasznaljak(Karakter karakter, Jegtabla hol) {
		 if(karakter.vizben_van) return;
		try {
			ArrayList<Figura> fig=hol.getFigurak();
			//for(Jegtabla sz : hol.getSzomszedok())
			for (Figura f : fig) {
				if (f.vizben_van)
					karakter.menekit((Karakter) f);
			}
		} catch(Exception e) {
		}
	}
}
