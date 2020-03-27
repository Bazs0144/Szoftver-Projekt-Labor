package szkeleton;

public class Luk extends Jegtabla{

	public Luk() {
		Szkeleton.printFunction("-------> Luk()  *konstruktor*", true, this);
		Szkeleton.printFunction("<------- Luk()  *konstruktor*", false, this);
	}
	
	@Override
	public void ralepnek(Karakter k) {
		Szkeleton.printFunction("------->ralepnek(Karakter k)", true, this);
		karakterek.add(k);
		k.setJegtabla(this);
		k.vizbe_esik();
		Szkeleton.printFunction("<-------ralepnek(Karakter k)", false, this);
	}
}
