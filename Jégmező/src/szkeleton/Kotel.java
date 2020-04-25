package szkeleton;
import java.util.ArrayList;

public class Kotel extends Targy {

	/**
	 * A Kotel oszt�ly konstruktora, ki�r�s miatt lett implement�lva.
	 */
	public Kotel() {
		Szkeleton.printFunction("-------> Kotel() *konstruktor*", true, this);
		Szkeleton.printFunction("<------- Kotel() *konstruktor*", false, this);
	}
	
	
	/**
	 * A param�terk�nt kapott karakter haszn�lja a t�rgyat a param�terk�nt kapott j�gt�bl�n, kimentve az �sszes karaktert r�la.
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
