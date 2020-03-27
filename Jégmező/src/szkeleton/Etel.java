package szkeleton;

public class Etel extends Targy {

	public Etel() {
		Szkeleton.printTabs(true);
		System.out.println("-------> Etel() *konstruktor* :"+Szkeleton.objects.get(this));
		Szkeleton.printTabs(false);
		System.out.println("<------- Etel() *konstruktor* :"+Szkeleton.objects.get(this));
	}
	@Override
	public void hasznaljak(Karakter karakter, Jegtabla hol) {
		Szkeleton.printTabs(true);
        System.out.println("------->   hasznaljak(Karakter karakter, Jegtabla hol) :"+Szkeleton.objects.get(this));
        karakter.ho_nov();
		Szkeleton.printTabs(false);
		System.out.println("<-------  hasznaljak(Karakter karakter, Jegtabla hol) :"+Szkeleton.objects.get(this));
	}
}
