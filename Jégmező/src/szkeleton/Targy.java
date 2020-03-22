package szkeleton;

public class Targy {
	
	private String nev;
	private Karakter karakter;
    public void hasznaljak(Karakter karakter, Jegtabla hol) {
    	System.out.println("------->  hasznaljak(Karakter, Jegtabla)");
    	System.out.println("<-------  hasznaljak(Karakter, Jegtabla)");
    	return;
    }
    public void setKarakter(Karakter kar) {
    	System.out.println("------->  setKarakter(Karakter)");
    	karakter = kar;
     	System.out.println("<-------  setKarakter(Karakter)");
    }
    public Karakter getKarakter() {
     	System.out.println("------->  getKarakter()");
     	System.out.println("<-------  getKarakter()");
     	return karakter;
    }
}
