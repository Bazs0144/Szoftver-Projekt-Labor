package szkeleton;

public class Etel extends Targy {

	public Etel() {
		Szkeleton.printTabs(true);
		System.out.println("-------> Etel() *konstruktor*");
		Szkeleton.printTabs(false);
		System.out.println("<------- Etel() *konstruktor*");
	}
	@Override
	public void hasznaljak(Karakter karakter, Jegtabla hol) {
		Szkeleton.printTabs(true);
        System.out.println("------->   hasznaljak(Karakter karakter, Jegtabla hol)");
        karakter.ho_nov();
		Szkeleton.printTabs(false);
		System.out.println("<-------  hasznaljak(Karakter karakter, Jegtabla hol)");
	}
}
