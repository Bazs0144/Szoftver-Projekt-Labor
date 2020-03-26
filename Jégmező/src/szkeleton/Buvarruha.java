package szkeleton;

public class Buvarruha extends Targy {

	public Buvarruha() {
		Szkeleton.printTabs(true);
		System.out.println("-------> Buvarruha() *konstruktor*");
		Szkeleton.printTabs(false);
		System.out.println("<------- Buvarruha() *konstruktor*");
	}

	@Override
	public void hasznaljak(Karakter karakter, Jegtabla hol) {
		Szkeleton.printTabs(true);
        System.out.println("------->   hasznaljak(Karakter karakter, Jegtabla hol)");
		Szkeleton.printTabs(false);
		System.out.println("<-------  hasznaljak(Karakter karakter, Jegtabla hol)");
	}
}
