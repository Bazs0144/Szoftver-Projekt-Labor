package szkeleton;

public class Targy {
	/**
	 * String név: a tárgy nevét tárolja
	 */
	
	private String nev;
	
	/**
	 * A Targy osztály konstruktora, kiírás miatt lett implementálva.
	 */
	public Targy() {
		Szkeleton.printFunction("-------> Targy() *konstruktor*", true, this);
		Szkeleton.printFunction("<------- Targy() *konstruktor*", false, this);
	}
	
	/**
	 * A paraméterként kapott karakter használja a tárgyat a paraméterként kapott jégtáblán.
	 */
	
    public void hasznaljak(Karakter karakter, Jegtabla hol) {
		Szkeleton.printFunction("-------> hasznaljak(Karakter karakter, Jegtabla hol)", true, this);
		Szkeleton.printFunction("<------- hasznaljak(Karakter karakter, Jegtabla hol)", false, this);
    	return;
    }
}
