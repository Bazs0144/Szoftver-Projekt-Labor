package proto;

/**
 * Az t�rgy implement�l�s��rt felel�s oszt�ly a Targy.
 *
 */

public class Targy {
	/**
	 * String n�v: a t�rgy nev�t t�rolja
	 * Karalter k: a karakter akinek a tulajdon�ban tal�lhat� a t�rgy. Amig be van fagyva a j�gt�bl�ba, az �rt�ke null.
	 */
	
	private String nev;
	private Karakter k;
	
	/**
	 * A Targy oszt�ly konstruktora.
	 */
	public Targy() {
	}
	
	/**
	 * A param�terk�nt kapott karakter haszn�lja a t�rgyat a param�terk�nt kapott j�gt�bl�n. Minden lesz�rmazott oszt�ly fel�lirja.
	 */
	
    public void hasznaljak(Karakter karakter, Jegtabla hol) {
    }

    /**
     *A param�terk�nt karakterhez �ll�tja be, hogy n�la van a t�rgy
     */
    public void setKarakter(Karakter k) {
        this.k=k;
    }

    /**
     *Visszadja melyik karaktern�l van a t�rgy
     */
    public Karakter getKarakter() {
        return k;
    }
}
