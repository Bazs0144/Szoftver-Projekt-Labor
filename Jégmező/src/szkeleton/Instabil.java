package szkeleton;

import java.util.Scanner;


/**
 * Az instabil j�gt�bla implement�l�s��rt felel�s oszt�ly az Instabil, a Jegtabla lesz�rmazottja.
 *
 */
public class Instabil extends Jegtabla{
	/**
	 * Az Instabil oszt�ly karakterek_szama adattagja t�rolja az aktu�lisan a j�gt�bl�n �ll� karakterek sz�m�t.
	 */
	private int karakterek_szama;

	/**
	 * Az Instabil oszt�ly konstrukt�ra, csak a konstruktorhiv�s kiir�s�nak c�lj�b�l lett implement�lva */
	public Instabil() {
		Szkeleton.printFunction("-------> Instabil()  *konstruktor*", true, this);
		Szkeleton.printFunction("<------- Instabil()  *konstruktor*", false, this);
	}

	/**
	 * A Jegtabla oszt�lyb�l �r�kl�tt ralepnek f�ggv�ny fel�lir�sa:
	 * Az aktiv karakter, amely egy szomsz�dos j�gt�bl�r�l l�p a jelenlegire, felker�l a j�gt�bl�ra (ennek nyilv�ntart�s�ba).
	 * A karakternek is be�llitjuk az aktu�lis j�gt�bl�j�t.
	 * Ezut�n megviszg�lja ha az instabil j�gt�bl�n �ll� karakterek sz�ma meghaladja-e a kapacit�s�t. 
	 * Ha igen, az insatbil j�gt�bla meghivja a felfordul f�ggv�ny�t.*/
	@Override
	public void ralepnek(Karakter k) {
		Szkeleton.printFunction("------->ralepnek(Karakter k)", true, this);
		k.setJegtabla(this);
		karakterek.add(k);
		System.out.println("Tobb karakter van mint amennyi a kapacitas?");
		Scanner in = new Scanner(System.in);
		int I = in.nextInt();
		
		if(I == 1) {
			felfordul(k);
		}
		Szkeleton.printFunction("<-------ralepnek(Karakter k)", false, this);
	}
	

	/**
	 * Amikor az instabil j�gt�bla felfordul, a rajta �ll� karakter(ek) a vizbe esnek. A karakter vizbe_esik f�ggv�nye hiv�dik meg. */
	public void felfordul(Karakter k) {
		Szkeleton.printFunction("------->felfordul(Karakter k)", true, this);
		k.vizbe_esik();
		Szkeleton.printFunction("<-------felfordul(Karakter k)", false, this);
	}
}

