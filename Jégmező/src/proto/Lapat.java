package proto;

public class Lapat extends Targy {
	
	/**
	 * A Lapat oszt�ly konstruktora, ki�r�s miatt lett implement�lva.
	 */
	public Lapat() {
		Szkeleton.printFunction("-------> Lapat() *konstruktor*", true, this);
		Szkeleton.printFunction("<------- Lapat() *konstruktor*", false, this);
	}
	/**
	 * A param�terk�nt kapott karakter haszn�lja a lap�tot, hogy 2-t takar�tson a j�gt�bl�r�l.
	 */
	@Override
	public void hasznaljak(Karakter karakter, Jegtabla hol) {
		Szkeleton.printFunction("------->   hasznaljak(Karakter karakter, Jegtabla hol)", true, this);
        if(karakter.vizben_van) return;
		karakter.takarit(2);
		Szkeleton.printFunction("<-------  hasznaljak(Karakter karakter, Jegtabla hol)", false, this);
	}
}
