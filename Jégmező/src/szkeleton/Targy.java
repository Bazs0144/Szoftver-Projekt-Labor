package szkeleton;

public class Targy {
	
	private String nev;
	
    public void hasznaljak(Karakter karakter, Jegtabla hol) {
		Szkeleton.printFunction("------->  hasznaljak(Karakter, Jegtabla)", true, this);
		Szkeleton.printFunction("<-------  hasznaljak(Karakter, Jegtabla)", false, this);
    	return;
    }
}
