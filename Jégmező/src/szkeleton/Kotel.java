package szkeleton;
import java.util.ArrayList;

public class Kotel extends Targy {

	public Kotel() {
		Szkeleton.printFunction("-------> Kotel() *konstruktor*", true, this);
		Szkeleton.printFunction("<------- Kotel() *konstruktor*", false, this);
	}

	@Override
	public void hasznaljak(Karakter karakter, Jegtabla hol) {
		Szkeleton.printFunction("------->   hasznaljak(Karakter karakter, Jegtabla hol)", true, this);
		//ArrayList<Karakter> mentendo = hol.getKarakterek();
		ArrayList<Karakter> mentendo = new ArrayList<>();
		for(Karakter karak : hol.getKarakterek()) mentendo.add(karak);
		for (Karakter kar : mentendo) {
			karakter.menekit(kar);
		}
		Szkeleton.printFunction("<-------  hasznaljak(Karakter karakter, Jegtabla hol)", false, this);
	}
}
