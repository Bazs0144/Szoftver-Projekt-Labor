package szkeleton;
import java.util.ArrayList;

public class Kotel extends Targy {
	
	@Override
	public void hasznaljak(Karakter karakter, Jegtabla hol) {
        System.out.println("------->   hasznaljak(Karakter karakter, Jegtabla hol)");
        ArrayList<Karakter> mentendo = hol.getKarakterek();
		System.out.println("<-------  hasznaljak(Karakter karakter, Jegtabla hol)");
	}
}
