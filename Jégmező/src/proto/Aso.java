package proto;

import java.io.Serializable;

/**
 * Az �s� implement�l�s��rt felel�s oszt�ly az Aso, a Targy lesz�rmazottja.
 *
 */

public class Aso extends Targy implements Serializable {
	
	private int tartossag;
	/**
	 * Az Aso oszt�ly konstruktora.
	 */
	public Aso() {
		Name = "Aso";
		tartossag = 3;
	}
	/**
	 * A param�terk�nt kapott karakter haszn�lja az �s�t, hogy 2-t takar�tson a j�gt�bl�r�l.
	 * Ha a karakter vizben van, nem tudja haszn�lni az �s�t.
	 * Ha m�r h�romszor haszn�lta, akkor az �s� haszn�lhatatlan, ekkor nem megy v�gbe a takarit�s.
	 * Ha m�g haszn�lhat� az �s�, a tartoss�gi �rt�ke kisebb mint h�rom, az �s�t haszn�l� karakter takaritani kezd.
	 * Minden haszn�lat ut�n a tart�ss�g �rt�ke egyel n�vekszik.
	 */
	@Override
	public void hasznaljak(Karakter karakter, Jegtabla hol) {
        if(karakter.vizben_van) return;
		karakter.takarit(2);
        tartossag--;
        if(tartossag<=0) karakter.targy_elhasznalasa(this);
	}
}
