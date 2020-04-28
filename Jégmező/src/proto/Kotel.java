package proto;

import java.io.Serializable;

/**
 * Az k�t�l implement�l�s��rt felel�s oszt�ly a Kotel, a Targy lesz�rmazottja.
 *
 */
public class Kotel extends Targy implements Serializable {

	/**
	 * A Kotel oszt�ly konstruktora.
	 */
	public Kotel() {
		Name = "Kotel";
	}
	
	
	/**
	 * A param�terk�nt kapott karakter haszn�lja a t�rgyat a param�terk�nt kapott j�gt�bl�n, kimentve az �sszes karaktert a j�gt�bla szomsz�ds�g�ban.
	 * Csak akkor haszn�lhat� a k�t�l, ha a menekit� karakter nincs vizben.
	 */

	@Override
	public void hasznaljak(Karakter karakter, Jegtabla hol) throws Exception{
		 if(karakter.vizben_van) return;
		for(Jegtabla sz : hol.getSzomszedok())
		for (Figura f : sz.getFigurak()) {
			if(f.vizben_van)
			karakter.menekit((Karakter)f);
		}
	}
}
