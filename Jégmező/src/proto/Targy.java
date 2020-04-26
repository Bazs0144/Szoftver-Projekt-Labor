package proto;

/**
 * Az tárgy implementálásáért felelõs osztály a Targy.
 *
 */

public class Targy {
	/**
	 * String név: a tárgy nevét tárolja
	 * Karalter k: a karakter akinek a tulajdonában található a tárgy. Amig be van fagyva a jégtáblába, az értéke null.
	 */
	
	private String nev;
	private Karakter k;
	
	/**
	 * A Targy osztály konstruktora.
	 */
	public Targy() {
	}
	
	/**
	 * A paraméterként kapott karakter használja a tárgyat a paraméterként kapott jégtáblán. Minden leszármazott osztály felülirja.
	 */
	
    public void hasznaljak(Karakter karakter, Jegtabla hol) {
    }

    /**
     *A paraméterként karakterhez állítja be, hogy nála van a tárgy
     */
    public void setKarakter(Karakter k) {
        this.k=k;
    }

    /**
     *Visszadja melyik karakternél van a tárgy
     */
    public Karakter getKarakter() {
        return k;
    }
}
