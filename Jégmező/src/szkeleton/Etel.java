package szkeleton;

public class Etel extends Targy {

	/**
	 * Az Etel osztály konstruktora, mely kiírás miatt lett implementálva.
	 */
	public Etel() {
		Szkeleton.printFunction("-------> Etel() *konstruktor*", true, this);
		Szkeleton.printFunction("<------- Etel() *konstruktor*", false, this);
	}
	/**
	 * A paraméterként kapott karakter használja az ételt az adott jégtáblán. Jelen esetben ezzel eggyel növeli a testhõjét.
	 * Eltávolításra kerül az étel a zsebébõl.
	 */
	@Override
	public void hasznaljak(Karakter karakter, Jegtabla hol) {
		Szkeleton.printFunction("------->   hasznaljak(Karakter karakter, Jegtabla hol)", true, this);
		if(karakter.vizben_van) return;
		karakter.ho_nov();
        karakter.targy_elhasznalasa(this);
		Szkeleton.printFunction("<-------  hasznaljak(Karakter karakter, Jegtabla hol)", false, this);
	}
}
