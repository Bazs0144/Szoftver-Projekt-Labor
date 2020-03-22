package szkeleton;

public class Buvarruha extends Targy {

	public Buvarruha() {
		System.out.println("-------> Buvarruha() *konstruktor*");
		System.out.println("<------- Buvarruha() *konstruktor*");
	}

	@Override
	public void hasznaljak(Karakter karakter, Jegtabla hol) {
        System.out.println("------->   hasznaljak(Karakter karakter, Jegtabla hol)");
        
		System.out.println("<-------  hasznaljak(Karakter karakter, Jegtabla hol)");
	}
}
