package proto;

public class Etel extends Targy {

	/**
	 * Az Etel oszt�ly konstruktora, mely ki�r�s miatt lett implement�lva.
	 */
	public Etel() {
		Szkeleton.printFunction("-------> Etel() *konstruktor*", true, this);
		Szkeleton.printFunction("<------- Etel() *konstruktor*", false, this);
	}
	/**
	 * A param�terk�nt kapott karakter haszn�lja az �telt az adott j�gt�bl�n. Jelen esetben ezzel eggyel n�veli a testh�j�t.
	 * Elt�vol�t�sra ker�l az �tel a zseb�b�l.
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
