package proto;

public class Buvarruha extends Targy {
	
	/**
	 * A Buvarruha oszt�ly konstruktora, ki�r�s miatt lett implement�lva.
	 */

	public Buvarruha() {
		Szkeleton.printFunction("-------> Buvarruha() *konstruktor*", true, this);
		Szkeleton.printTabs(false);
		Szkeleton.printFunction("<------- Buvarruha() *konstruktor*", false, this);
	}

	/**
	 * A param�terk�nt kapott karakter haszn�lja a t�rgyat a param�terk�nt kapott j�gt�bl�n.
	 */
	
	@Override
	public void hasznaljak(Karakter karakter, Jegtabla hol) {
		Szkeleton.printFunction("------->  hasznaljak(Karakter karakter, Jegtabla hol)", true, this);
        karakter.set_vizben_van(false);
		Szkeleton.printFunction("<-------  hasznaljak(Karakter karakter, Jegtabla hol)", false, this);
	}
}
