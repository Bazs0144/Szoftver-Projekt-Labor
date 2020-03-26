package szkeleton;

public class Lapat extends Targy {
	
	@Override
	public void hasznaljak(Karakter karakter, Jegtabla hol) {
		Szkeleton.printTabs(true);
        System.out.println("------->   hasznaljak(Karakter karakter, Jegtabla hol)");
        karakter.takarit(2);
		Szkeleton.printTabs(false);
		System.out.println("<-------  hasznaljak(Karakter karakter, Jegtabla hol)");
	}
}
