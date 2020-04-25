package szkeleton;

public class Aso extends Targy {
	
	private int tartossag;
	/**
	 * A Lapat osztály konstruktora, kiírás miatt lett implementálva.
	 */
	public Aso() {
		Szkeleton.printFunction("-------> Aso() *konstruktor*", true, this);
		Szkeleton.printFunction("<------- Aso() *konstruktor*", false, this);
	}
	/**
	 * A paraméterként kapott karakter használja a lapátot, hogy 2-t takarítson a jégtábláról.
	 */
	@Override
	public void hasznaljak(Karakter karakter, Jegtabla hol) {
		Szkeleton.printFunction("------->   hasznaljak(Karakter karakter, Jegtabla hol)", true, this);
        if(karakter.vizben_van) return;
        if(tartossag >= 3) return;
		karakter.takarit(2);
		tartossag++;
		Szkeleton.printFunction("<-------  hasznaljak(Karakter karakter, Jegtabla hol)", false, this);
	}
}
