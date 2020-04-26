package proto;

/**
 * Az luk implement�l�s��rt felel�s oszt�ly a Luk, a Jegtabla lesz�rmazottja.
 *
 */
public class Luk extends Jegtabla{

	/**
	 * A Luk oszt�ly konstrukt�ra, csak a konstruktorhiv�s kiir�s�nak c�lj�b�l lett implement�lva */
	public Luk() {
		Szkeleton.printFunction("-------> Luk()  *konstruktor*", true, this);
		Szkeleton.printFunction("<------- Luk()  *konstruktor*", false, this);
	}
	
	/**
	 * A Jegtabla oszt�lyb�l �r�kl�tt ralepnek f�ggv�ny fel�lir�sa.
	 * Az aktiv karakter, amely egy szomsz�dos j�gt�bl�r�l l�p a jelenlegire (lukra), felker�l a j�gt�bl�ra (ennek nyilv�ntart�s�ba).
	 * A karakternek is be�llitjuk az aktu�lis j�gt�bl�j�t.
	 * A luk j�gt�bla kapacit�sa nulla, ez�rt a karakter aki r�l�p egyb�l vizbe esik. 
	 * Ez a karakter vizbe_esik f�ggv�ny�vel val�sul majd meg.*/
	@Override
	public void ralepnek(Figura f) {
		Szkeleton.printFunction("------->ralepnek(Karakter k)", true, this);
		figurak.add(f);
		f.setJegtabla(this);
		f.vizbe_esik();
		Szkeleton.printFunction("<-------ralepnek(Karakter k)", false, this);
	}
}