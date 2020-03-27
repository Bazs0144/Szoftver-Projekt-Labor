package szkeleton;

public class Alkatresz extends Targy {
	private int id;

	public Alkatresz(int i) {
		Szkeleton.printFunction("-------> Alkatresz(int i) *konstruktor*", true, this);
		id = i;
		Szkeleton.printFunction("<------- Alkatresz(int i ) *konstruktor*", false,this);
	}
}
