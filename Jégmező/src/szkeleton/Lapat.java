package szkeleton;

public class Lapat extends Targy {
	
	/**
	 * A Lapat osztály konstruktora, kiírás miatt lett implementálva.
	 */
	public Lapat() {
		Szkeleton.printFunction("-------> Lapat() *konstruktor*", true, this);
		Szkeleton.printFunction("<------- Lapat() *konstruktor*", false, this);
	}
	/**
	 * A paraméterként kapott karakter használja a lapátot, hogy 2-t takarítson a jégtábláról.
	 */
	@Override
	public void hasznaljak(Karakter karakter, Jegtabla hol) {
		Szkeleton.printFunction("------->   hasznaljak(Karakter karakter, Jegtabla hol)", true, this);
        if(karakter.vizben_van) return;
		karakter.takarit(2);
		Szkeleton.printFunction("<-------  hasznaljak(Karakter karakter, Jegtabla hol)", false, this);
	}
}
