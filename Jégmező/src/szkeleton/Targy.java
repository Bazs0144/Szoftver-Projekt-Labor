package szkeleton;

public class Targy {
	/**
	 * String n�v: a t�rgy nev�t t�rolja
	 */
	
	private String nev;
	private Karakter k;
	
	/**
	 * A Targy oszt�ly konstruktora, ki�r�s miatt lett implement�lva.
	 */
	public Targy() {
		Szkeleton.printFunction("-------> Targy() *konstruktor*", true, this);
		Szkeleton.printFunction("<------- Targy() *konstruktor*", false, this);
	}
	
	/**
	 * A param�terk�nt kapott karakter haszn�lja a t�rgyat a param�terk�nt kapott j�gt�bl�n.
	 */
	
    public void hasznaljak(Karakter karakter, Jegtabla hol) {
		Szkeleton.printFunction("-------> hasznaljak(Karakter karakter, Jegtabla hol)", true, this);
		Szkeleton.printFunction("<------- hasznaljak(Karakter karakter, Jegtabla hol)", false, this);
    	return;
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
