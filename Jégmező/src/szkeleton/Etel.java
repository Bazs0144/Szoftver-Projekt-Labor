package szkeleton;

public class Etel extends Targy {

	public Etel() {
		Szkeleton.printFunction("-------> Etel() *konstruktor*", true, this);
		Szkeleton.printFunction("<------- Etel() *konstruktor*", false, this);
	}
	@Override
	public void hasznaljak(Karakter karakter, Jegtabla hol) {
		Szkeleton.printFunction("------->   hasznaljak(Karakter karakter, Jegtabla hol)", true, this);
        karakter.ho_nov();
		Szkeleton.printFunction("<-------  hasznaljak(Karakter karakter, Jegtabla hol)", false, this);
	}
}
