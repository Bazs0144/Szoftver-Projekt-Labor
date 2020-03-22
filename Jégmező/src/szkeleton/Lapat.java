package szkeleton;

public class Lapat extends Targy {
	
	@Override
	public void hasznaljak(Karakter karakter, Jegtabla hol) {
        System.out.println("------->   hasznaljak(Karakter karakter, Jegtabla hol)");
        karakter.takarit(2);
		System.out.println("<-------  hasznaljak(Karakter karakter, Jegtabla hol)");
	}
}
