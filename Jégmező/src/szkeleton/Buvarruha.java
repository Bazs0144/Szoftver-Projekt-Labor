package szkeleton;

public class Buvarruha extends Targy {

	public Buvarruha() {
		Szkeleton.printFunction("-------> Buvarruha() *konstruktor*", true, this);
		Szkeleton.printTabs(false);
		Szkeleton.printFunction("<------- Buvarruha() *konstruktor*", false, this);
	}

	@Override
	public void hasznaljak(Karakter karakter, Jegtabla hol) {
		Szkeleton.printFunction("------->   hasznaljak(Karakter karakter, Jegtabla hol)", true, this);
		Szkeleton.printFunction("<-------  hasznaljak(Karakter karakter, Jegtabla hol)", false, this);
	}
}
