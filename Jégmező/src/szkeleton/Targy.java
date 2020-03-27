package szkeleton;

public class Targy {
	
	private String nev;
	private Karakter karakter;
    public void hasznaljak(Karakter karakter, Jegtabla hol) {
		Szkeleton.printFunction("------->  hasznaljak(Karakter, Jegtabla)", true, this);
		Szkeleton.printFunction("<-------  hasznaljak(Karakter, Jegtabla)", false, this);
    	return;
    }
    public void setKarakter(Karakter kar) {
		Szkeleton.printFunction("------->  setKarakter(Karakter)", true, this);
    	karakter = kar;
		Szkeleton.printFunction("<-------  setKarakter(Karakter)", false, this);
    }
    public Karakter getKarakter() {
		Szkeleton.printFunction("------->  getKarakter()", true, this);
		Szkeleton.printFunction("<-------  getKarakter()", false, this);
     	return karakter;
    }
}
