package proto;

public class Buvarruha extends Targy {
	
	/**
	 * A Buvarruha osztály konstruktora, kiírás miatt lett implementálva.
	 */

	public Buvarruha() {
		Szkeleton.printFunction("-------> Buvarruha() *konstruktor*", true, this);
		Szkeleton.printTabs(false);
		Szkeleton.printFunction("<------- Buvarruha() *konstruktor*", false, this);
	}

	/**
	 * A paraméterként kapott karakter használja a tárgyat a paraméterként kapott jégtáblán.
	 */
	
	@Override
	public void hasznaljak(Karakter karakter, Jegtabla hol) {
		Szkeleton.printFunction("------->  hasznaljak(Karakter karakter, Jegtabla hol)", true, this);
        karakter.set_vizben_van(false);
		Szkeleton.printFunction("<-------  hasznaljak(Karakter karakter, Jegtabla hol)", false, this);
	}
}
