package proto;

/**
 * A stabil j�gt�bla implement�l�s��rt felel�s oszt�ly az Stabil, a Jegtabla lesz�rmazottja.
 *
 */
public class Stabil extends Jegtabla {
	/**
	 * A Jegtabla oszt�ly konstrukt�ra, csak a konstruktorhiv�s kiir�s�nak c�lj�b�l lett implement�lva
	 *
	 * @param p
	 */
	public Stabil(Poz p) {
		super(p);
	}

	/**
	 * A Stabil oszt�ly konstrukt�ra, csak a konstruktorhiv�s kiir�s�nak c�lj�b�l lett implement�lva */
/*	public Stabil() {
		Szkeleton.printFunction("-------> Stabil()  *konstruktor*", true,  this);
		Szkeleton.printFunction("<------- Stabil()  *konstruktor*", false, this);
	}

 */
	
	/**
	 * A Jegtabla oszt�lyb�l �r�kl�tt ralepnek f�ggv�ny fel�lir�sa:
	 * Az aktiv karakter, amely egy szomsz�dos j�gt�bl�r�l l�p a jelenlegire, felker�l a j�gt�bl�ra (ennek nyilv�ntart�s�ba).
	 * A karakternek is be�llitjuk az aktu�lis j�gt�bl�j�t.
	 * Mivel a j�gt�bla stabil, nem sz�ks�gesek tov�bbi ellen�rz�sek, a rajta �ll� karakterek biztosan nem esnek vizbe. */
	@Override
	public void ralepnek(Figura f) {
		Szkeleton.printFunction("------->ralepnek(Karakter k)", true, this);
		figurak.add(f);
		f.setJegtabla(this);
		Szkeleton.printFunction("<-------ralepnek(Karakter k)", false, this);
	}
}