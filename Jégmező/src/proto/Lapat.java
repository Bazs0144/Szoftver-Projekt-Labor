package proto;

/**
 * Az lap�t implement�l�s��rt felel�s oszt�ly a Lapat, a Targy lesz�rmazottja.
 *
 */
public class Lapat extends Targy {
	
	/**
	 * A Lapat oszt�ly konstruktora..
	 */
	public Lapat() {
		
	}
	/**
	 * A param�terk�nt kapott karakter haszn�lja a lap�tot, hogy 2-t takaritson a j�gt�bl�n.
	 * A karakter csak akkor haszn�lhatja a lap�tot, ha nincs vizbe esve.
	 */
	@Override
	public void hasznaljak(Karakter karakter, Jegtabla hol) {
        if(karakter.vizben_van) return;
		karakter.takarit(2);
	}
}
