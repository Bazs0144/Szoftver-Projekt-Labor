package szkeleton;
import java.util.ArrayList;

public class Kotel extends Targy {

	public Kotel() {
		System.out.println("-------> Kotel() *konstruktor*");
		System.out.println("<------- Kotel() *konstruktor*");
	}

	@Override
	public void hasznaljak(Karakter karakter, Jegtabla hol) {
		System.out.println("------->   hasznaljak(Karakter karakter, Jegtabla hol)");
		//ArrayList<Karakter> mentendo = hol.getKarakterek();
		ArrayList<Karakter> mentendo = new ArrayList<>();
		for(Karakter karak : hol.getKarakterek()) mentendo.add(karak);
		for (Karakter kar : mentendo) {
			karakter.menekit(kar);
		}
		System.out.println("<-------  hasznaljak(Karakter karakter, Jegtabla hol)");
	}
}
