package szkeleton;

public class Kotel extends Targy {
	
	@Override
	public void hasznaljak(Karakter karakter, Jegtabla hol) {
        System.out.println("------->   hasznaljak(Karakter karakter, Jegtabla hol)");
        
		System.out.println("<-------  hasznaljak(Karakter karakter, Jegtabla hol)");
	}
}
