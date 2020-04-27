package proto;

import java.io.Serializable;

/**
 * A b�v�rruha implement�l�s��rt felel�s oszt�ly az Buvarruha, a Targy lesz�rmazottja.
 *
 */

public class Buvarruha extends Targy implements Serializable {
	
	/**
	 * A Buvarruha oszt�ly konstruktora.
	 */
	public Buvarruha() {
		Name = "Buvarruha";
	}

	/**
	 * A param�terk�nt kapott karakter haszn�lja a t�rgyat a param�terk�nt kapott j�gt�bl�n.
	 * Ha a karakter b�v�rruh�t haszn�l, nem �ri viz, a vizben van attrib�tuma hamisra lesz �llitva.
	 * Az egyetlen t�rgy amit vizbe esett karakter tud haszn�lni.
	 */
	
	@Override
	public void hasznaljak(Karakter karakter, Jegtabla hol) {
        karakter.set_vizben_van(false);
	}
}
