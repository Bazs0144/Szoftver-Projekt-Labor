package proto;

import java.io.Serializable;

/**
 * Az targy implementalasaert felelos osztaly a Targy.
 *
 */

public class Targy implements Serializable {
	/**
	 * String nev: a targy nevet tarolja
	 * Karalter k: a karakter akinek a tulajdonaban talalhato a targy. Amig be van fagyva a jegtablaba, az erteke null.
	 */
	private String nev;
	private Karakter k;
	public String Name = "Targy";
	
	/**
	 * A parameterkent kapott karakter hasznalja a targyat a parameterkent kapott jegtablan. Minden leszarmazott osztaly felulirja.
	 */
    public void hasznaljak(Karakter karakter, Jegtabla hol) throws Exception{
    }

    /**
     *A parameterkent karakterhez allitja be, hogy nala van a targy
     */
    public void setKarakter(Karakter k) {
        this.k=k;
    }

    /**
     *Visszadja melyik karakternel van a targy
     */
    public Karakter getKarakter() {
        return k;
    }
}
