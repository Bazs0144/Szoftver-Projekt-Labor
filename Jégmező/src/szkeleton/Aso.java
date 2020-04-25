package szkeleton;

public class Aso extends Targy {
	
	private int tartossag;
	/**
	 * A Lapat oszt�ly konstruktora, ki�r�s miatt lett implement�lva.
	 */
	public Aso() {
		Szkeleton.printFunction("-------> Aso() *konstruktor*", true, this);
		Szkeleton.printFunction("<------- Aso() *konstruktor*", false, this);
	}
	/**
	 * A param�terk�nt kapott karakter haszn�lja a lap�tot, hogy 2-t takar�tson a j�gt�bl�r�l.
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
