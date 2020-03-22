package szkeleton;

public class Etel extends Targy {

	public Etel() {
		System.out.println("-------> Etel() *konstruktor*");
		System.out.println("<------- Etel() *konstruktor*");
	}
	@Override
	public void hasznaljak(Karakter karakter, Jegtabla hol) {
        System.out.println("------->   hasznaljak(Karakter karakter, Jegtabla hol)");
        karakter.ho_nov();
		System.out.println("<-------  hasznaljak(Karakter karakter, Jegtabla hol)");
	}
}
