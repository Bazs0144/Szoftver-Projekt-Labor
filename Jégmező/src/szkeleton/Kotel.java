package szkeleton;
import java.util.ArrayList;

public class Kotel extends Targy {

	/**
	 * A Kotel osztály konstruktora, kiírás miatt lett implementálva.
	 */
	public Kotel() {
		Szkeleton.printFunction("-------> Kotel() *konstruktor*", true, this);
		Szkeleton.printFunction("<------- Kotel() *konstruktor*", false, this);
	}
	
	
	/**
	 * A paraméterként kapott karakter használja a tárgyat a paraméterként kapott jégtáblán, kimentve az összes karaktert róla.
	 */

	@Override
	public void hasznaljak(Karakter karakter, Jegtabla hol) {
		Szkeleton.printFunction("------->   hasznaljak(Karakter karakter, Jegtabla hol)", true, this);
		 if(karakter.vizben_van) return;

		
		//ArrayList<Karakter> mentendo = new ArrayList<>();
		for(Jegtabla sz : hol.getSzomszedok())
		for (Figura f : sz.getFigurak()) {
			if(f.vizben_van)
			karakter.menekit((Karakter)f);
		}
		Szkeleton.printFunction("<-------  hasznaljak(Karakter karakter, Jegtabla hol)", false, this);
	}
}
