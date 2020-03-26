package szkeleton;

public class Targy {
	
	private String nev;
	private Karakter karakter;
    public void hasznaljak(Karakter karakter, Jegtabla hol) {
		Szkeleton.printTabs(true);
    	System.out.println("------->  hasznaljak(Karakter, Jegtabla)");
		Szkeleton.printTabs(false);
    	System.out.println("<-------  hasznaljak(Karakter, Jegtabla)");
    	return;
    }
    public void setKarakter(Karakter kar) {
		Szkeleton.printTabs(true);
    	System.out.println("------->  setKarakter(Karakter)");
    	karakter = kar;
		Szkeleton.printTabs(false);
     	System.out.println("<-------  setKarakter(Karakter)");
    }
    public Karakter getKarakter() {
		Szkeleton.printTabs(true);
     	System.out.println("------->  getKarakter()");
		Szkeleton.printTabs(false);
     	System.out.println("<-------  getKarakter()");
     	return karakter;
    }
}
